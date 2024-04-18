<template>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-header"><h4>Registrar devolución</h4></div>
                    <div class="card-body">
                        <form @submit.prevent="crear" >
                            <router-link v-if="typeof post !== 'undefined'"></router-link>
                            <div class="row">
                                <div class="form-group">
                                    <label>ID Prestamo</label><br>
                                    <input type="text" v-model="prestamofin.id_prestamo" 
                                     readonly>
                                </div>
                                <div class="form-group">
                                    <label>ID Libro</label><br>
                                    <input type="text" v-model="prestamo.id_libro" 
                                     readonly>
                                </div>
                                <div class="form-group">
                                    <label>ID User</label><br>
                                    <input type="text" v-model="prestamo.id_user" 
                                     readonly>
                                </div>
                                <div class="form-group">
                                    <label>Fecha préstamo</label><br>
                                    <input type="date" v-model="prestamofin.finicio" 
                                     readonly>
                                </div>
                                <div class="form-group">
                                    <label>Estado</label><br>
                                    <input type="text" v-model="prestamo.estado" 
                                     readonly>
                                </div>
                                <div class="form-group">
                                    <label>Fecha de devolución</label>
                                    <input type="date" class="form-control" :min="prestamofin.finicio"
                                     v-model="prestamofin.ffin">
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

import axios from 'axios'
import moment from "moment";
export default{
    name: "form",
    data() {
        return {
            prestamofin: {
                ffin:"",
                finicio:"",
                id_prestamo:"",
                estado:"",
                id_user:"",
                id_libro:"",
            },
            prestamo:[],
         
        };
    },     
    async mounted() {
      await this.mostrarPrestamo();
        
    }, 
    methods: {
        
        
        async  mostrarPrestamo() {
      try {
        const pid = this.$route.params.pid;
        const response = await axios.get(`http://localhost:8082/prestamo/getone/${pid}`);
        const {  id_libro, id_user, finicio, estado } = response.data;
        this.prestamo = { id_libro, id_user, finicio, estado };
        this.prestamofin.id_prestamo = pid;
        this.prestamofin.finicio = finicio;
        
      } catch (error) {
        console.log(error);
      }
    },
        async crear() {
        
            await axios.post('http://localhost:8082/pfin/save', this.prestamofin).then(response => {
                    this.$router.push({name: "mostrarPfin"});
                    alert("Se ha eliminado el préstamo activo");
                    axios.delete(`http://localhost:8082/prestamo/delete/${this.prestamofin.id_prestamo}`);

                }).catch(error => {
                    console.log(error)
                })
        },

   
    }
}
</script>