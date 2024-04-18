<template>
    <div class="container">
        <div class="row">
            <div class="col-12">
                <div class="card">
                    <div class="card-header"><h4>Nuevo usuario</h4></div>
                    <div class="card-body">
                        <form @submit.prevent="crear" >
                            <router-link v-if="typeof post !== 'undefined'"></router-link>
                            <div class="row">
                                <div class="form-group">
                                    <label>Nombre</label>
                                    <input type="text" class="form-control" v-model="user.nom">
                                </div>
                                <div class="form-floating"> 
                                <div class="form-group">
                                    <label>Apellido</label>
                                    <input type="text" class="form-control" v-model="user.ape">
                                </div>
                            </div>
                           
                                <div class="form-group">
                                    <label>Email</label>
                                    <input type="email" class="form-control" v-model="user.email">
                            </div>
                                <div class="form-group">
                                    <label>Teléfono</label>
                                    <input type="tel" class="form-control" v-model="user.tel">
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
export default{
    name: "crearUser",
    data() {
        return {
            user: {
                nom:"",
                ape:"",
                email:"",
                tel:""     
            },
        };
    },
    methods: {
        async crear() {
           await axios.post('http://localhost:8082/user/save', this.user).then(response => {
                    this.$router.push({name: "mostrarUser"})
                }).catch(error => {
                    console.log(error)
                })
        }
   
    }
}
</script>