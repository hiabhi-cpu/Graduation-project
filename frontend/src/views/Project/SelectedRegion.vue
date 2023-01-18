<template>
    <div class="project">
      <div v-if="region">
        <h2>{{ region.name }}</h2>
        <img v-bind:src="'data:image/gif;base64,'+ region.image" />
        <p>{{ region.text }}</p>
      </div>
      <h4>Platser och sevärdheter</h4>
      <div v-for="location in locations" :key="location.id" class="location">
        <router-link class="project__locationLink" :to="{ name: 'SelectedLocation', params: { locationid: location.id }}">
          <h4 class="project__locationLink">{{ location.name }}  </h4>
        </router-link>
        <span class="tag" :style="{'background-color':location.tag.color}">{{ location.tag.name }}</span> 
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


<style scoped>


  .projekt {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-bottom: 2rem;
    width: 20%;
  }

  .location {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-bottom: 1rem;
  }

  .project__locationLink {
    text-decoration: none;
    color: black;
  }


  .project__locationLink:hover {
    text-decoration: underline;
    transform: scale(1.1, 1.1);
  }

</style>
