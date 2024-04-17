<template>
    <div class="container">
      <div class="row">
        <div clas="col-12 mb-2">
          <nav class="navbar navbar-light bg-light">
            <router-link to="/crearP" class="btn btn-success">Nuevo</router-link>
             
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
                      <th>ID Libro</th>
                      <th>ID User</th>
                      <th>Fecha de préstamo</th>
                      <th>Estado</th>
    
                      <th></th>
                    </tr>
                  </thead>
                <tbody>
                  <tr v-for="prestamo in prestamosDisponibles" >
                    <td>{{ prestamo.pid }}</td>
                    <td> {{ prestamo.id_libro }} </td>
                    <td>{{ prestamo.id_user }}</td>

                    <td>{{ formatFecha(prestamo.finicio) }}</td>
                    <td>{{ prestamo.estado }}</td>
                 
                    <td>
                      <div class="d-grid gap-6 d-md-block">
                        <button class="btn btn-info me-md-2"  v-if="prestamo.estado === 'Activo'"
                         
                         @click="modPrestamo(prestamo.pid)">Editar</button>
                         
                        <a class="btn btn-danger" @click="borrarPrestamo(prestamo.pid)" 
                        type="button">Borrar</a>

                        <a class="btn btn-info me-md-2"   v-if="prestamo.estado === 'Activo'"
                        @click="devolver(prestamo.pid)" type="button">Devolver</a>
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

import axios from 'axios';
export default {
    name: "prestamos",
    data() {
      return {
        prestamos: [],
        prestamosDisponibles: [],

      };
    
  },
  mounted() {
      this.mostrarPrestamos();
    },
  methods: {

    formatFecha(finicio) {
      return new Date(finicio).toLocaleDateString('es-ES', { day: '2-digit', month: '2-digit', year: 'numeric' });
    },
      async mostrarPrestamos() {
        
        await axios.get("http://localhost:8082/prestamo/ver")
          .then(response => {
            this.prestamos = response.data;
            this.prestamosDisponibles = this.prestamos.filter(prestamo => prestamo.estado === 'Activo');

          })
          .catch(error => {
            this.prestamo = [];
          });
      },
      borrarPrestamo(pid) {
        if (confirm("¿Desea eliminar el préstamo?")) {
          console.log(pid);
          axios.delete(`http://localhost:8082/prestamo/delete/${pid}`)
            .then(response => {
              console.log("Préstamo eliminado correctamente");
              this.mostrarPrestamos();
            })
            .catch(error => {
              console.log(error)
            });
        }
      },
     modPrestamo(pid) {
        this.$router.push(`/editP/${pid}`);
      },
      devolver(pid) {
  
        if(confirm ('¿Desea registrar la devolución de este libro?')){
          axios.put(`http://localhost:8082/prestamo/devolver/${pid}`, this.prestamo)  
          .then(response => {
            alert("Libro devuelto.");
            axios.delete(`http://localhost:8082/prestamo/delete/${pid}`);
            this.$router.push({name: "/mostrarP"});
            })
            .catch(error => {
          
              console.error('Error al devolver el libro:', error);
            });
        
      }
    },
  },

};
</script>