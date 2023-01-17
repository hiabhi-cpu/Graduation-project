<template>
    <div class="location">
        <div v-if="location">
        <h1>{{ location.name }}</h1>
        <p>{{ location.text }}</p>
        <img v-bind:src="'data:image/gif;base64,'+ location.images[0].image" />
        <span class="tag" :style="{'background-color':location.tag.color}">{{ location.tag.name }}</span> 
      </div>
      </div>
</template>

<script>
export default {
  props: ['regionid', 'locationid'],
  data() {
    return {
      location: null,
    }
  },
  mounted() {
    fetch('http://localhost:8080/location/' + this.locationid)
    .then(res => res.json())
    .then(data => this.location = data)
    .then(err => console.log(err.message))
  }
}
</script>

<style scoped>
</style>>


