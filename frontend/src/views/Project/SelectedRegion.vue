<template>
    <div class="project">
      <div v-if="region">
        <h1>{{ region.name }}</h1>
        <p>{{ region.text }}</p>
        <img v-bind:src="'data:image/gif;base64,'+ region.image" />
      </div>
      <div v-for="location in locations" :key="location.id" class="location">
          <h2>{{ location.name }}</h2>
      </div>
    </div>

</template>

<script>
export default {
  props: ['id'],
  data() {
    return {
      region: null,
      location: null
    }
  },
  mounted() {
    fetch('http://localhost:8080/region/' + this.id)
    .then(res => res.json())
    .then(data => this.region = data)
    .then(err => console.log(err.message))
    fetch('http://localhost:8080/locationbyregion/' + this.id)
    .then(res => res.json())
    .then(data => this.location = data)
    .then(err => console.log(err.message))
  }
}
</script>
