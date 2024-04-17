<template>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-header"><h4>Nuevo libro</h4></div>
                    <div class="card-body">
                        <form @submit.prevent="crear" >
                            <router-link v-if="typeof post !== 'undefined'"></router-link>
                            <div class="row">
                                <div class="form-group">
                                    <label>Título</label>
                                    <input type="text" class="form-control" v-model="libro.titulo">
                                </div>
                                <div class="form-floating"> 
                                <div class="form-group">
                                    <label>Autor</label>
                                    <input type="text" class="form-control" v-model="libro.autor">
                                </div>
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
                                    <option value="Poema">Poesía</option>
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
                                    <input type="text" maxlength="250"  class="form-control" v-model="libro.sinopsis">
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
import MostrarLibro from './MostrarLibro.vue'
import axios from 'axios'
export default{
    name: "crear-Libro",
    data() {
        return {
            libro: {
                titulo:"",
                autor:"",
                genero:"",
                sinopsis:"",
                fecha:"",
                pag:"",
                estado:""
            },
        };
    },
    methods: {
        async crear() {
           await axios.post('http://localhost:8082/libros/save', this.libro).then(response => {
                    this.$router.push({name: "mostrarLibros"})
                }).catch(error => {
                    console.log(error)
                })
        }
   
    }
}
</script>
<!--   estado(nuevoEstado, estadoAnterior) {
                // Enviar el nuevo estado a Spring Boot cuando cambie
                this.actualizarEstadoLibro(nuevoEstado);
                }-->