<template>
  <nav>
    <router-link to="/">Hem</router-link> |
    <router-link to="/Project">Projekt</router-link> |
    <router-link to="/search">Sök</router-link> |
    <router-link to="/about">Om oss</router-link> |
    <router-link to="/contact">Kontakta oss</router-link> 

  </nav>
  <router-view/>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
