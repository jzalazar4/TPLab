import { createRouter, createWebHistory } from 'vue-router'
import Inicio from '../components/Inicio.vue'

        // LIBROS
import CrearLibro from '../components/libros/CrearLibro.vue'
import MostrarLibro from '../components/libros/MostrarLibro.vue'
import EditarLibro from '../components/libros/EditarLibro.vue'

        // USUARIOS
import CrearUser from '../components/user/CrearUser.vue'
import MostrarUser from '../components/user/MostrarUser.vue'
import EditarUser from '../components/user/EditarUser.vue'

        // PRESTAMO
import CrearPrestamo from '../components/prestamo/CrearPrestamo.vue'
import EditarPrestamo from '../components/prestamo/EditarPrestamo.vue'
import MostrarPrestamo from '../components/prestamo/MostrarPrestamo.vue'


const routes = [
    {
        path: '/',
        name: 'Inicio',
        component: Inicio
    },
        // LIBROS
    {
        name: 'crear-Libro',
        path: '/crearLibro',
        component: CrearLibro
    },
    {
        name: 'mostrarLibros',
        path: '/verLibros',
        component: MostrarLibro
    },
    {
        name: 'editLibro',
        path: '/editLibro/:lid',
        component: EditarLibro
    },
        // USUARIOS
    {
        name: 'crearUser',
        path: '/crearUser',
        component: CrearUser
    },
    {
        name: 'mostrarUser',
        path: '/mostrarUser',
        component: MostrarUser
    },
    {
        name: 'editUser',
        path: '/editUser/:uid',
        component: EditarUser
    },
        // PRESTAMO
    {
        name: 'crearP',
        path: '/crearP',
        component: CrearPrestamo
    },
    {
        name: 'editP',
        path: '/editP/:pid',
        component: EditarPrestamo
    },
    {
        name: 'mostrarP',
        path: '/mostrarP',
        component: MostrarPrestamo
    },


]
const router = createRouter({ history: createWebHistory(), routes })
export default router