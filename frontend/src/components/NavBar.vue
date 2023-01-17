<template>
    <div>
        <header class="header">
            <div class="header__logo">
                <img class="logo" src="../assets/loggoTest.jpg"/>
            </div>
                <nav class="header__navigation">
                    <router-link class="header__navigation__link" to="/">Hem</router-link> 
                    <router-link class="header__navigation__link" to="/project">Projekt</router-link> 
                    <router-link class="header__navigation__link" to="/search">Sök</router-link> 
                    <router-link class="header__navigation__link" to="/about">Om oss</router-link> 
                    <router-link class="header__navigation__link" to="/contact">Kontakt</router-link> 
                </nav>
        </header>
    </div>
</template>

<style>

.header {
    margin-top: 2rem;
    display: flex;
    justify-content: left;
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
    margin-right: 5%;
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