<template>
    <div class="container">
      <div class="row">
        <div clas="col-12 mb-2">
          <router-link to="/crearUser" class="btn btn-success">Nuevo</router-link>
        </div>
        <div style="margin-bottom: 20px;"></div>
        <div class="col-12">
          <div class="bg-primary text-white">
            <div class="table-responsive">
              <table class="table table-bordered">
                <thead>
                  <tr>
                    <th>COD</th>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>Email</th>
                    <th>Teléfono</th>
                  
                    <th>          </th>
                  </tr>
                </thead>
                <tbody>
                  <tr v-for="user in users" :key="user.uid" >
                    <td>{{ user.uid }}</td>
                    <td>{{ user.nom }}</td>
                    <td>{{ user.ape }}</td>
                    <td>{{ user.email }}</td>
                    <td>{{ user.tel }}</td>
                    <td>
                  
                      <div class="d-grid gap-6 d-md-block">
                      <button class="btn btn-info me-md-2"  @click="modUser(user.uid)" 
                      type="button">Editar</button>

                      <button class="btn btn-danger" @click="borrarUser(user.uid)"
                      type="button">Eliminar</button>
                
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
  import CrearUser from "./CrearUser.vue";
  import axios from 'axios';
  export default {
    name: "users",
    data() {
      return {
        users: [],
      };
    },
    mounted() {
      this.mostrarUsers();
    },
    methods: {
      async mostrarUsers() {
        
        await axios.get("http://localhost:8082/user/ver")
          .then(response => {
            this.users = response.data;
          })
          .catch(error => {
            this.user = [];
          });
      },
      borrarUser(uid) {
        if (confirm("¿Desea eliminar este usuario?")) {
          console.log(uid);
          axios.delete(`http://localhost:8082/user/delete/${uid}`)
            .then(response => {
              console.log("Usuario eliminado correctamente");
              this.mostrarUsers();
            })
            .catch(error => {
              console.log(error)
            });
        }
      },
     modUser(uid) {
        this.$router.push(`/editUser/${uid}`);
      }
    },
     
  };
  </script>