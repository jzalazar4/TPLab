<template>
    <div class="row">
        <div class="col-12">
            <div class="card-header">
                <h4>Editar usuario</h4>
            </div>
            <div class="card-body">
            
                <form @submit.prevent = "actualizar">
                    <div class="row">
                        <div class="col-12 mb-2">
                            <div class="form-group">
                                <label>Nombre</label>
                                 <input type="text" class="form-control" v-model="user.nom">
                            </div>
                        </div>
                        <div class="col-12 mb-2">
                            <label>Apellido</label>
                               
                                <input class="form-control" type="text" v-model="user.ape">
                                
                        </div>
                        <div class="form-group">
                                <label>Email</label>
                                    <input type="email" class="form-control" v-model="user.email">
                            </div>
                                <div class="form-group">
                                    <label>Teléfono</label>
                                        <input type="tel" class="form-control" v-model="user.tel">
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
    name:"editarUser",
    data() {
        return {
            user: {
                nom: "",
                ape:"",
                email:"",
                tel:""
               
            }
        }
    },
    async mounted() {
      await this.mostrarUser();
        
    }, 
    
    methods: {
        async  mostrarUser() {
      try {
        const uid = this.$route.params.uid;
        const response = await axios.get(`http://localhost:8082/user/getone/${uid}`);
        const { nom, ape, tel, email } = response.data;
        this.user = { nom, ape, tel, email };
      } catch (error) {
        console.log(error);
      }
    },
    async actualizar() {
      try {
        const uid = this.$route.params.uid;
        await axios.put(`http://localhost:8082/user/update/${uid}`, this.user);
        this.$router.push({ name: "mostrarUser" });
      } catch (error) {
        console.log(error);
      }
    }
  }
}
</script>