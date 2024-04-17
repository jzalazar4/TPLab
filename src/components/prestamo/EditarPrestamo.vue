<template>
    <div class="row">
        <div class="col-12">
            <div class="card-header">
                <h4>Editar préstamo</h4>
            </div>
            <div class="card-body">
            
                <form @submit.prevent="actualizar">
                    <div class="row">
                        <div class="col-12 mb-2">
                            <div class="form-group">
                                <label for="libros">Libros</label>
                            <select class="form-select" aria-label="Default select example"  v-model="libroElegido">
                              <option value="" disabled selected>Seleccione una opción</option>
                              <option v-if="libroSeleccionado" :value="libroSeleccionado" >{{ libroSeleccionado }} </option>
                                <option v-for="libro in librosDisponibles" :key="libro.lid"
                                 :value="libro.lid">{{ libro.titulo }} - {{ libro.autor }}</option>
                            </select>

                            <label for="usuario">Usuario</label>
                            <select class="form-select" aria-label="Default select example" v-model="userElegido">
                                <option value="" disabled selected>Seleccione una opción</option>
                               
                                <option v-for="user in users" :key="user.uid"
                                 :value="user.uid">{{ user.nom }} {{ user.ape }}</option>
                            </select>
                           
                            <div class="form-group">
                                <label>Fecha préstamo</label>
                                    <input type="date" class="form-control" v-model="prestamo.finicio">
                            </div>
                          
                            </div>
                            </div>
                        

                            <div style="margin-bottom: 20px;"></div>
                            
                            <div class="col-12">
                                <button type="submit" class="btn btn-primary">Guardar</button>
                            </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</template>
<script>
import axios from 'axios'
import { format } from 'date-fns'
export default {
    name:"editarP",
    data() {
        return {
            prestamo: {
                id_user: "",
                id_libro:"",
                finicio: "",
               
              
            },

          users:[],
          librosDisponibles: [],
          libros:[],
          libroSeleccionado: null,
          libroElegido: null,
          userElegido: null,
        }
    },
    async mounted() {
      await this.mostrarPrestamo();
        
    }, 
   
    methods:{  
      
  
      async  mostrarPrestamo() {
      try {

            this.obtenerDatos();
            
            const pid = this.$route.params.pid;
            const response = await axios.get(`http://localhost:8082/prestamo/getone/${pid}`);
            const {id_user, id_libro, finicio } = response.data;

            this.libroElegido = id_libro;
            this.userElegido = id_user;
            this.prestamo.finicio = finicio;

            //this.prestamo = { id_user, id_libro, finicio};

      } catch (error) {
        console.log('Error al obtener los datos:', error);
      }
    },
     async obtenerDatos() {
          try {
            const [librosResponse, usersResponse] = await Promise.all([
              axios.get('http://localhost:8082/libros/ver'),
              axios.get('http://localhost:8082/user/ver')
            ]);

        this.libros = librosResponse.data;
        this.librosDisponibles = this.libros.filter(libro => libro.estado === 'Disponible');
       // this.libroElegido = this.libros.find(libro => libro.lid === prestamo.id_libro);
        //?.titulo + ' - ' + this.libros.find(libro => libro.lid === this.libroElegido)?.autor;
       // this.libroSeleccionado = this.libros.find(libro => this.libroElegido.titulo === )
          // Buscar el libro seleccionado en la lista completa de libros
        const libroSeleccionado = this.libros.find(libro => libro.lid === this.libroElegido);
        if (libroSeleccionado) {
          this.libroSeleccionado = `${libroSeleccionado.titulo} - ${libroSeleccionado.autor}`;
        }
        this.users = usersResponse.data;
      } catch (error) {
        console.error('Error al obtener los datos:', error);
      }
    },
    async actualizar() {
      try {
        const pid = this.$route.params.pid;
        console.log(pid);
        await axios.put(`http://localhost:8082/prestamo/update/${pid}`, this.prestamo);
        this.$router.push({ name: "mostrarP" });
      } catch (error) {
        console.log(error);
      }
    }},
}
</script>