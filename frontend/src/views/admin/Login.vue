<template>
    <div class="login__container">
        <form @submit.prevent="login" class="login__form">
            <input v-model="username" placeholder="Användarnamn"/>
            <input v-model="password" type="password" placeholder="Lösenord"/>
            <button type="submit">Logga in</button>
        </form>
    </div>
</template>

<script>
    import axios from 'axios';

export default {
    data: () => {
        return {
            username: "",
            password: "",
        };
    },
    methods: {
        async login() {
            const response = await axios.post('http://localhost:8080/authenticate', {
                username: this.username,
                password: this.password
            });
            localStorage.setItem('token', response.headers.get("Authorization"));
            this.$router.push('/admin');
        }
    }
}
</script>

<style scoped>
    .login__container {
        display: flex;
        flex-direction: column;
        align-items: center;
        margin-bottom: 2rem;
    }

    .login__form {
        display: flex;
        flex-direction: column;
        align-items: center;
        margin-bottom: 2rem;
    }

    input {
        padding: 5px;
        margin: 5px;
    }

</style>>

