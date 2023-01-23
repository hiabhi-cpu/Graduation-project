import { createRouter, createWebHistory } from 'vue-router'
import Home from '../views/Home.vue'
import About from '../views/About.vue'
import Contact from '../views/Contact.vue'
import Search from '../views/Search.vue'
import ProjectStart from '../views/project/ProjectStart.vue'
import SelectedRegion from '../views/project/SelectedRegion.vue'
import SelectedLocation from '../views/project/SelectedLocation.vue'
import NotFound from '../views/NotFound.vue'
import Login from '../views/admin/Login.vue'
import AdminLandingPage from '../views/admin/AdminLandingPage.vue'
import AdminNewLocation from '../views/admin/AdminNewLocation.vue'

const routes = [
  {
    path: '/',
    name: 'home',
    component: Home
  },
  {
    path: '/about',
    name: 'about',
    component: About
  },
  {
    path: '/contact',
    name: 'contact',
    component: Contact
  },
  {
    path: '/search',
    name: 'search',
    component: Search
  },
  {
    path: '/project',
    name: 'project',
    component: ProjectStart
  },
  {
    path: '/project/:regionid',
    name: 'SelectedRegion',
    component: SelectedRegion,
    props: true
  },
  {
    path: '/project/:regionid/:locationid',
    name: 'SelectedLocation',
    component: SelectedLocation,
    props: true
  }, {
    path: '/:catchAll(.*)',
    name: 'NotFound',
    component: NotFound
  },
  {
    path: '/secretlogin',
    name: 'Login',
    component: Login
  },
  {
    path: '/admin',
    name: 'AdminLandingPage',
    component: AdminLandingPage
  },
  {
    path: '/admin/newLocation',
    name: 'AdminNewLocation',
    component: AdminNewLocation
  }


]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router
