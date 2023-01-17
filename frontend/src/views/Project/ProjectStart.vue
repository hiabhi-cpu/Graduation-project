<template>
    <div class="project">
      <h1>This is the first project page</h1>
      <div v-for="region in regions" :key="region.id" class="region">
        <router-link :to="{ name: 'SelectedRegion', params: { id: region.id }}">
          <h2>{{ region.name }}</h2>
        </router-link>

      </div>
    </div>
  </template>


<script>
export default {
  data() {
    return {
      regions: []
    }
  }, mounted() {
    fetch('http://localhost:8080/region')
    .then(res => res.json())
    .then(data => this.regions = data)
    .then(err => console.log(err.message))
  }
}
</script>
  