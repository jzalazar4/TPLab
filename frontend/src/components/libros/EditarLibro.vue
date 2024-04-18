<template>
    <div class="row">
        <div class="col-12">
            <div class="card-header">
                <h4>Editar libro</h4>
            </div>
            <div class="card-body">
            
                <form @submit.prevent = "actualizar">
                    <div class="row">
                        <div class="col-12 mb-2">
                            <div class="form-group">
                                <label>Título</label>
                                 <input type="text" class="form-control" v-model="libro.titulo">
                            </div>
                        </div>
                        <div class="col-12 mb-2">
                            <label>Autor</label>
                               
                                <input class="form-control" type="text" v-model="libro.autor">
                                
                        </div>

                            <div class="form-group">
                                <label>Género</label>
                                <div>
                                    <select id="genero" v-model="libro.genero" required>
                                    <option value="Aventura">Aventura</option>
                                    <option value="Ciencia Ficción">Ciencia Ficción</option>
                                    <option value="Comedia">Comedia</option>
                                    <option value="Cuento">Cuento</option>
                                    <option value="Drama">Drama</option>
                                    <option value="Ficción">Ficción</option>
                                    <option value="JUvenil">Juvenil</option>
                                    <option value="Literatura Clásica">Literatura Clásica</option>
                                    <option value="Novela">Novela</option>
                                    <option value="No Ficción">No Ficción</option>
                                    <option value="Poema">Poema</option>
                                    <option value="Romance">Romance</option>
                                    <option value="Suspenso">Suspenso</option>
                                    </select>
                                    
                                </div>
                            </div>
                        

                            <div class="form-group">
                                <label>Páginas</label>
                                    <input type="number" min="1" max="3000" class="form-control" v-model="libro.pag">
                            </div>

                            <div class="form-group">
                                <label>Sinopsis</label>
                                    <input type="text" maxlength="200" class="form-control" v-model="libro.sinopsis">
                            </div>

                            <div class="form-group">
                                <label>Fecha de publicación</label>
                                    <input type="date" class="form-control" v-model="libro.fecha">
                            </div>

                            <div class="form-group">
                                <label>Estado</label>
                                <div>
                                    <select id="estado" v-model="libro.estado" required>
                                    <option value="Disponible">Disponible</option>
                                    <option value="No disponible">No Disponible</option>
                                    </select>
                                    
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
export default {
    name:"editarLibro",
    data() {
        return {
            libro: {
                titulo: "",
                autor:"",
                genero:"",
                sinopsis:"",
                fecha:"",
                pag:"",
                estado:""
            }
        }
    },
    async mounted() {
      await this.mostrarLibro();
        
    }, 
    
    methods: {
        async  mostrarLibro() {
      try {
        const lid = this.$route.params.lid;
        const response = await axios.get(`http://localhost:8082/libros/getone/${lid}`);
        const { titulo, autor, estado, genero, pag, sinopsis, fecha } = response.data;
        this.libro = { titulo, autor, estado, genero, pag, sinopsis, fecha };
      } catch (error) {
        console.log(error);
      }
    },
    async actualizar() {
      try {
        const lid = this.$route.params.lid;
        await axios.put(`http://localhost:8082/libros/update/${lid}`, this.libro);
        this.$router.push({ name: "mostrarLibros" });
      } catch (error) {
        console.log(error);
      }
    }
  }
}
</script>
<!--  mostrarLibro(){
    const lid = this.$route.params.lid;
        console.log(lid);
        await axios.get(`http://localhost:8082/libros/getone/${lid}`)
            .then(response => {
                const {titulo,autor,stock,genero,pag,isbn} = response.data
                    this.libro.titulo = titulo,
                    this.libro.autor = autor,
                    this.libro.stock = stock,
                    this.libro.isbn = isbn,
                    this.libro.genero = genero,
                    this.libro.pag = pag
        })
        .catch(error => {
            console.log(error)
        })
},
   
        async actualizar() {
            const lid = this.$route.params.lid;
            await axios.put(`http://localhost:8082/libros/update/${lid}`,this.libro)
                .then(response => {
                    this.$router.push({name:"mostrarLibros"})
                })
                .catch(error => {
                    console.log(error)
                })
        }
    }
-->