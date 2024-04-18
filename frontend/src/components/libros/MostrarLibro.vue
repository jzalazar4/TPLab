<template>
  <div class="container">
    <div class="row">
      <div clas="col-12 mb-2">
        <nav class="navbar navbar-light bg-light">
          <router-link to="/crearLibro" class="btn btn-success">Nuevo</router-link>
            <form class="d-flex justify-content-center">
               
                <input class="form-control mr-sm-2" type="search" 
              placeholder="Buscar título, autor, género o fecha" aria-label="Search" @input="filtroTabla" 
              v-model="filtro">
            
            </form>
        </nav> 
      </div>
      <div style="margin-bottom: 20px;"></div>
      <div class="col-12">
        <div class="bg-primary text-white">
          <div class="table-responsive">
            <table class="table table-bordered">
                <thead>
                  <tr>
                    <th>COD</th>
                    <th>Título</th>
                    <th>Autor</th>
                    <th>Género</th>
                    <th>Páginas</th>
                    <th>Sinopsis</th>
                    <th>Fecha publicación</th>
                    <th>Estado</th>
                    <th></th>
                  </tr>
                </thead>
              <tbody>
                <tr v-for="libro in librosFiltrados">
                  <td>{{ libro.lid }}</td>
                  <td>{{ libro.titulo }}</td>
                  <td>{{ libro.autor }}</td>
                  <td>{{ libro.genero }}</td>
                  <td>{{ libro.pag }}</td>
                  <td>{{ libro.sinopsis }}</td>
                  <td>{{ formatFecha(libro.fecha) }}</td>
                  <td>{{ libro.estado }}</td>
                  <td>
                    <div class="d-grid gap-6 d-md-block">
                      <a class="btn btn-info me-md-2"  @click="modLibro(libro.lid)"
                      type="button">Editar</a>
                      <a class="btn btn-danger" @click="borrarLibro(libro.lid)" 
                      type="button">Borrar</a>
                
                    </div> 
                 </td>
                </tr>
              </tbody>
             
            </table>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import { RouterLink } from "vue-router";
import CrearLibro from "./CrearLibro.vue";
import axios from 'axios';
export default {
  name: "libros",
  data() {
    return {
      libros: [],
      filtro:''
    };
  },
  mounted() {
    this.mostrarLibros();
  },
  computed: {
  librosFiltrados() {
    return this.libros.filter(libro =>
        libro.titulo.toLowerCase().includes(this.filtro.toLowerCase()) ||
        libro.autor.toLowerCase().includes(this.filtro.toLowerCase()) ||
        libro.genero.toLowerCase().includes(this.filtro.toLowerCase())||
        libro.fecha.includes(this.filtro)
      );
  }
},

  methods: {
    formatFecha(fecha) {
      return new Date(fecha).toLocaleDateString('es-ES', { day: '2-digit', month: '2-digit', year: 'numeric' });
    },
    async mostrarLibros() {
      
      await axios.get("http://localhost:8082/libros/ver")
        .then(response => {
          this.libros = response.data;
        })
        .catch(error => {
          this.libro = [];
        });
    },
    borrarLibro(lid) {
      if (confirm("¿Desea eliminar este libro?")) {
        console.log(lid);
        axios.delete(`http://localhost:8082/libros/delete/${lid}`)
          .then(response => {
            console.log("Libro eliminado correctamente");
            this.mostrarLibros();
          })
          .catch(error => {
            console.log(error)
          });
      }
    },
   modLibro(lid) {
      this.$router.push(`/editLibro/${lid}`);
    },
    filtroTabla(){},
   
  },
   
};
</script>

<!--
   <button class="btn btn-outline-success my-2 my-sm-0" type="submit" @click="buscar">Buscar</button>
  v-for="libro in libros" :key="libro.lid" 
 async buscar(){
      try {
        const response = await axios.get('http://localhost:8082/libros/buscar', {
          params: {
            titulo: this.titulo,
            autor: this.autor,
            genero: this.genero
          },
          
        });
        
        this.resultados = response.data;
        console.log(resultados);
      } catch (error) {
        console.error('Error al buscar libros:', error);
      }
    
    }
    
<router-link v-if="typeof post !== 'undefined'"></router-link>
    <router-link :to="{ name: 'editLibro', params: { id: libro.id } }" 
                    class="btn btn-info"
                    v-if="typeof post !== 'undefined'">Editar</router-link>


<template>
  <div>
    <h2>Listado de Libros</h2>
    <ul>
      <li v-for="libro in libros" :key="libro.id">
        {{ libro.titulo }} - {{ libro.autor }}
      </li>
    </ul>
  </div>
</template>

<script>
import axios from 'axios';

export default {
  data() {
    return {
      libros: []
    };
  },
  mounted() {

    this.axios.get('http://localhost:8082/libros/ver')
      .then(response => {
        this.libros = response.data;
      })
      .catch(error => {
        console.error('Error al obtener los libros:', error);
      });
  }
};
</script>-->
