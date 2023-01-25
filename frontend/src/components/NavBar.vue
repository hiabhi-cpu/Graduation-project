<template>
    <div>
        <header class="header">
            <div class="header__logo">
                <img class="logo" src="../assets/loggoTest.jpg"/>
            </div>
                <nav class="header__navigation">
                    <div v-if="!store.user">
                        <router-link class="header__navigation__link" to="/">Hem</router-link> 
                        <router-link class="header__navigation__link" to="/project">Projekt</router-link> 
                        <router-link class="header__navigation__link" to="/search">Sök</router-link> 
                        <router-link class="header__navigation__link" to="/about">Om oss</router-link> 
                        <router-link class="header__navigation__link" to="/contact">Kontakt</router-link> 
                    </div>
                    <div v-if="store.user">
                        <router-link class="header__navigation__link" to="/admin">Hem</router-link> 
                        <router-link class="header__navigation__link" to="/admin/newregion">Skapa nytt område</router-link> 
                        <router-link class="header__navigation__link" to="/admin/newlocation">Skapa ny plats</router-link> 
                        <span class="header__navigation__logout" @click="logout">Logga ut</span>
                    </div>
                </nav>
        </header>
    </div>
</template>

<script>
    import { useStore } from '../store/mainStore';

export default {
   data: () => {
        return {
            store: useStore(),
        };
    },
    methods: {
        logout() {
            this.store.logout();
        }
    }
}
</script>

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

.header__navigation__logout {
    margin-left: 150px;
    font-weight: bold;
    text-decoration: underline;
}

.header__navigation__logout:hover {
    cursor: pointer;
    color: #42b983;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a:hover {
    color: #42b983;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>