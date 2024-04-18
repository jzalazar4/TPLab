<template>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-header"><h4>Nuevo préstamo</h4></div>
                    <div class="card-body">
                        <form @submit.prevent="crear">
                            <router-link v-if="typeof post !== 'undefined'"></router-link>
                          
                            <label for="libros">Libros</label>
                            <select class="form-select" aria-label="Default select example"  v-model="libroElegido">
                                <option value="" disabled selected>Seleccione una opción</option>
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

                            <div style="margin-bottom: 20px;"></div>
                            <div class="col-12">
                                <button type="submit" class="btn btn-primary">Guardar</button>
                            </div>


                        </form>

                    </div>

                </div>
            </div>
        </div>

    </div>
</template>
<script>
import MostrarUser from '../user/MostrarUser.vue'
import MostrarLibro from '../libros/MostrarLibro.vue'
import axios from 'axios'
import { format } from 'date-fns'
export default{
    name: "crearPrestamo",
data() {
        return {
          prestamo : {
            id_libro: null,
            id_user:  null,
            finicio: "",
          },

          users:[],
          librosDisponibles: [],
          libros:[],
          libroElegido: null,
          userElegido: null,
          usersDisponibles: null
       
        };
      
    },

    methods: {

      async crear(){
       
        this.prestamo.id_libro = this.libroElegido;
        this.prestamo.id_user = this.userElegido;
        
       
        await axios.post('http://localhost:8082/prestamo/save', this.prestamo).then(response => {
                        this.$router.push({name: "mostrarP"})
                    }).catch(error => {
                        console.log(error)
                    })
    },
      async obtenerDatos() {
          try {
            const [librosResponse, usersResponse] = await Promise.all([
              axios.get('http://localhost:8082/libros/ver'),
              axios.get('http://localhost:8082/user/ver')
            ]);

        this.libros = librosResponse.data;
        this.librosDisponibles = this.libros.filter(libro => libro.estado === 'Disponible');

        this.users = usersResponse.data;
       // this.usersDisponibles = this.users.filter(user => this.prestamo.id_user !== this.users.uid);
      } catch (error) {
        console.error('Error al obtener los datos:', error);
      }
    }
  },
  mounted() {
    this.obtenerDatos();
    
  }
    
   
}


</script>