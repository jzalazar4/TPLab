
<template>
<main>
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
  <div class="container-fluid">
  <router-link v-if="typeof post !== 'undefined'"></router-link>

    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" 
    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <router-link exact-active-class="active"  class="nav-link active" to="/" 
          aria-current="page">Inicio</router-link>
        </li>
  
                                    <!--LIBROS-->

          <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button"
             data-bs-toggle="dropdown" aria-expanded="false">
              Libros
            </a>
            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
             <li><router-link to="/crearLibro" class="dropdown-item">Nuevo libro</router-link></li>

              <li><router-link to="/verLibros" class="dropdown-item">Ver todos</router-link></li>

            </ul>
          </li>
        </ul>
      </div>  
      
                                      <!--USUARIOS-->
      <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" 
              data-bs-toggle="dropdown" aria-expanded="false">
                Usuarios
              </a>
              <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                <li><router-link to="/crearUser" class="dropdown-item">Nuevo usuario</router-link></li>
                <li><router-link to="/mostrarUser" class="dropdown-item">Ver todos</router-link></li>
                
            
              </ul>
          </li>
        </ul>
      </div> 
                                         <!--PRESTAMO-->
       <div class="collapse navbar-collapse" id="navbarNav">
        <ul class="navbar-nav">
          <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" 
              data-bs-toggle="dropdown" aria-expanded="false">
                Préstamo
              </a>
              <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                <li><router-link to="/crearP" class="dropdown-item">Nuevo préstamo</router-link></li>
                <li><router-link to="/mostrarP" class="dropdown-item">Préstamos activos</router-link></li>
                <li><router-link to="/mostrarPfin" class="dropdown-item">Préstamos finalizados</router-link></li>
                
              </ul>
          </li>
        </ul>
      </div> 
      </ul>
      
    </div>
  </div>
</nav>
<div class="container mt-5">
  <router-view></router-view>
</div>
</main>
</template>

<script>
import MostrarLibro from './components/libros/MostrarLibro.vue'
import EditarLibro from './components/libros/EditarLibro.vue'
import CrearLibro from './components/libros/CrearLibro.vue'

import CrearUser from './components/user/CrearUser.vue'
import MostrarUser from './components/user/MostrarUser.vue'
import EditarUser from './components/user/EditarUser.vue'

import CrearPrestamo from './components/prestamo/CrearPrestamo.vue'
import EditarPrestamo from './components/prestamo/EditarPrestamo.vue'
import MostrarPrestamo from './components/prestamo/MostrarPrestamo.vue'
import PrestamoFin from './components/prestamo/PrestamoFin.vue'
import PrestamoFinForm from './components/prestamo/PrestamoFinForm.vue'

  export default {
    components:{
      MostrarLibro,
      CrearLibro,
      EditarLibro,
      CrearUser,
      MostrarUser,
      EditarUser,
      CrearPrestamo,
      EditarPrestamo,
      MostrarPrestamo,
      PrestamoFin,
      PrestamoFinForm
    }
  }
</script>
