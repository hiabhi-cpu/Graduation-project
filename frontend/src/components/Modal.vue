<template>
    <div class="backdrop" @click="closeModal">
        <div class="modal">
             <img class="modal__image" v-bind:src= "image"/>
        </div>
    </div>
</template>


<script>
export default {
    props: ['image'],
    methods: {
        closeModal() {
            this.$emit('close');
        }
    }
}
</script>

<style scoped>

.backdrop {
    position: fixed;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    z-index: 97;
    background-color: rgba(0, 0, 0, 0.8);

    display: flex;
    align-items: center;
    justify-content: center;
}

.modal {
    width: auto;
    height: auto;
    object-fit: contain;
    z-index: 98;
}

.modal__image {
    max-width: 100%;
    max-height: 100%;
}

</style>>

