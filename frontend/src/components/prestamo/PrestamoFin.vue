<template>
    <div class="container">
      <div class="row">
        <div clas="col-12 mb-2">
          <nav class="navbar navbar-light bg-light"></nav> 
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
                      <th>Fecha préstamo</th>
                      <th>Fecha devolución</th>
                      <th>Estado</th>
    
                      <th></th>
                    </tr>
                  </thead>
                <tbody>
                  <tr v-for="prestamofin in prestamos" >
                    <td>{{ prestamofin.id }}</td>
                    <td> {{ prestamofin.id_libro }} </td>
                    <td>{{ prestamofin.id_user }}</td>
                    <td>{{formatFecha(prestamofin.finicio )}}</td>
                    <td>{{ formatFecha(prestamofin.ffin )}}</td>
                    <td>{{ prestamofin.estado }}</td>
                 
                    <td>
                      <div class="d-grid gap-6 d-md-block">
              
                        <a class="btn btn-danger" @click="borrarPrestamo(prestamofin.id)" 
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

import axios from 'axios';
export default {
    name: "prestamos",
    data() {
      return {
        prestamos: [],

      };
    
  },
  mounted() {
      this.mostrarPrestamos();
    },
  methods: {
    formatFecha(fecha) {
      return new Date(fecha).toLocaleDateString('es-ES', { day: '2-digit', month: '2-digit', year: 'numeric' });
    },
      async mostrarPrestamos() {
        
        await axios.get("http://localhost:8082/pfin/ver")
          .then(response => {
            this.prestamos = response.data;

          })
          .catch(error => {
            this.prestamo = [];
          });
      },
      borrarPrestamo(id) {
        if (confirm("¿Desea eliminar el préstamo?")) {
          console.log(id);
          axios.delete(`http://localhost:8082/pfin/delete/${id}`)
            .then(response => {
              console.log("Préstamo eliminado correctamente");
              this.mostrarPrestamos();
            })
            .catch(error => {
              console.log(error)
            });
        }
      },
    
  },

};
</script>