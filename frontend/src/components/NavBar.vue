<template>
    <div>
        <header class="header">
            <div class="header__logo">
                <img class="logo" src="../assets/logotest.jpg"/>
            </div>
                <nav class="header__navigation">
                    <router-link class="header__navigation__link" to="/">Hem</router-link> 
                    <router-link class="header__navigation__link" to="/Project">Projekt</router-link> 
                    <router-link class="header__navigation__link" to="/search">Sök</router-link> 
                    <router-link class="header__navigation__link" to="/about">Om oss</router-link> 
                    <router-link class="header__navigation__link" to="/contact">Kontakta oss</router-link> 
                </nav>
        </header>
    </div>
</template>

<style>

.header {
    margin-top: 2rem;
    display: flex;
    justify-content: space-around;
    align-items: center;
    height: 3rem;
}

.logo {
    height: auto;
    width: auto;
    max-height: 100px;
}

.header__logo {
    object-fit: contain;
}

.header__navigation {
    margin-top: 1.1rem;

}

.header__navigation__link {
    margin: 22px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>