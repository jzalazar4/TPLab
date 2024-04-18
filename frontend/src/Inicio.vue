<template>
    <div class="container">
     <h1 align="center">Estadísticas</h1>
    <div class="row">

	<div class="four col-md-3">
		<div class="counter-box colored">
			<i class="fa fa-thumbs-o-up"></i>
			<span class="counter">{{ numLibros }}</span>
			<p>Libros</p>
		</div>
	</div>
	<div class="four col-md-3">
		<div class="counter-box">
			<i class="fa fa-group"></i>
			<span class="counter">{{ numUsers }}</span>
			<p>Usuarios</p>
		</div>
	</div>
	<div class="four col-md-3">
		<div class="counter-box">
			<i class="fa  fa-shopping-cart"></i>
			<span class="counter">{{ numPactivos }}</span>
			<p>Préstamos activos </p>
		</div>
	</div>
	<div class="four col-md-3">
		<div class="counter-box">
			<i class="fa  fa-user"></i>
			<span class="counter">{{ numPfin }}</span>
			<p>Préstamos finalizados</p>
		</div>
	</div>
  </div>	
</div>
    
</template>
  
<script>
import axios from 'axios';
  export default {
    data() {
  return {
    libros: [], 
    users: [], 
    pactivos: [],
    pfin: [], 
  };
},
computed: {
  numLibros() {
    return this.libros.length;
  },
  numUsers() {
    return this.users.length;
  },
  numPactivos() {
    return this.pactivos.length;
  },
  numPfin() {
    return this.pfin.length;
  }
},
methods: {
    async obtenerLibros() {
      try {
        const response = await axios.get('http://localhost:8082/libros/ver');
        this.libros = response.data;
      } catch (error) {
        console.error('Error al obtener la lista de libros:', error);
      }
    },
			// usuarios
	async obtenerUsers() {
      try {
        const response = await axios.get('http://localhost:8082/user/ver');
        this.users = response.data;
      } catch (error) {
        console.error('Error al obtener la lista de usuarios:', error);
      }
    },		
	async obtenerPactivos() {
      try {
        const response = await axios.get('http://localhost:8082/prestamo/ver');
        this.pactivos = response.data;
      } catch (error) {
        console.error('Error al obtener la lista de préstamos activos:', error);
      }
    },
	async obtenerPfin() {
      try {
        const response = await axios.get('http://localhost:8082/pfin/ver');
        this.pfin = response.data;
      } catch (error) {
        console.error('Error al obtener la lista de préstamos finalizados:', error);
      }
    },
},
mounted() {
	this.obtenerLibros();
	this.obtenerPactivos();
	this.obtenerPfin();
	this.obtenerUsers();
}

  };
</script>
<style>
.container{
    margin-top:100px;
}

.counter-box {
	display: block;
	background: #f6f6f6;
	padding: 40px 20px 37px;
	text-align: center
}

.counter-box p {
	margin: 5px 0 0;
	padding: 0;
	color: #909090;
	font-size: 18px;
	font-weight: 500
}

.counter-box i {
	font-size: 30px;
	margin: 0 0 15px;
	color: #d2d2d2
}

.counter { 
	display: block;
	font-size: 30px;
	font-weight: 700;
	color: #666;
	line-height: 28px
}

.counter-box.colored {
      background: #3acf87;
}

.counter-box.colored p,
.counter-box.colored i,
.counter-box.colored .counter {
	color: #fff
}
</style>
