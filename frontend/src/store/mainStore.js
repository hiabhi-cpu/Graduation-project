import router from "@/router";
import { defineStore } from "pinia";

export const useStore = defineStore('main', {
    state: () => ({
        authUser: null,
    }),
    getters: {
        user: (state) => state.authUser,
    },
    actions: {
        login(input) {
            this.authUser = true;
            localStorage.setItem('token', input);
            router.push('/admin');
        },
        logout() {
            this.authUser = false;
            localStorage.removeItem('token');
            router.push('/secretlogin');
        }
    }
})