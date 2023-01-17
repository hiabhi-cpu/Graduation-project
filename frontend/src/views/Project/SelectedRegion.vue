<template>
    <div class="project">
      <div v-if="region">
        <img v-bind:src="'data:image/gif;base64,'+ region.image" />
        <h1>{{ region.name }}</h1>
        <p>{{ region.text }}</p>
      </div>
      <h4>Platser och sevärdheter</h4>
      <div v-for="location in locations" :key="location.id" class="location">
        <router-link :to="{ name: 'SelectedLocation', params: { locationid: location.id }}">
          <h2>{{ location.name }}</h2>
        </router-link>
      </div>
    </div>

</template>

<script>
export default {
  props: ['regionid'],
  data() {
    return {
      region: null,
      locations: []
    }
  },
  mounted() {
    fetch('http://localhost:8080/region/' + this.regionid)
    .then(res => res.json())
    .then(data => this.region = data)
    .then(err => console.log(err.message))
    fetch('http://localhost:8080/locationbyregion/' + this.regionid)
    .then(res => res.json())
    .then(data => this.locations = data)
    .then(err => console.log(err.message))
  }
}
</script>
