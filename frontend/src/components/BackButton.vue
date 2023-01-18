<template>
    <button @click="back">
    <slot>Button</slot>
    </button>
</template>

<script>
export default {
  props: ['buttontext'],
  methods: {
    back() {
        this.$router.go(-1)
    }
  }
}
</script>

<style scoped>

 button {
  display: inline-block;
  border: none;
  cursor: pointer;
  font-weight: 900;
  background: #007a5a;
  padding: 8px 14px 9px;
  border-radius: 4px;
  color: #fff;
  height: 36px;
  transition: all 75ms ease-in-out;
  margin-bottom: 2rem;
}

button:hover {
  box-shadow: 0 1px 4px rgb(0 0 0 / 30%);
  background: #fff;
  color: #007a5a;
}       
                
</style>