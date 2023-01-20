<template>
    <div class="project">
      <BackButton>Tillbaka</BackButton>
      <div class="project__region" v-if="region">
        <h2>{{ region.name }}</h2>
        <img v-bind:src="'data:image/png;base64,'+ region.imageData" />
        <p>{{ region.text }}</p>
      </div>
      <h3>Platser och sevärdheter</h3>
      <div class="region__container">
      <div v-for="location in locations" :key="location.id">
        <div class="location__item">
        <router-link class="project__locationLink" :to="{ name: 'SelectedLocation', params: { locationid: location.id }}">
          <h4 class="project__locationLink">{{ location.name }}  </h4>
        </router-link>
        <Tag :style="{'background-color':location.tag.color}" :tagname="location.tag.name" class="importedTag"></Tag> 
      </div>
      </div>
    </div>
    </div>
</template>

<script>
  import Tag from '../../components/Tag.vue'
  import BackButton from '../../components/BackButton.vue'


  export default {
    props: ['regionid'],
    components: {
      Tag,
      BackButton,
    },
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
      fetch('http://localhost:8080/location/byregion/' + this.regionid)
      .then(res => res.json())
      .then(data => this.locations = data)
      .then(err => console.log(err.message))
    }
  }
</script>


<style scoped>

.project {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-bottom: 2rem;
    justify-content: center;
  }
  .project__regionText {
    width: 40%;
  }

  .project__region {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-bottom: 1rem;
    width: 40%;
    border-bottom: #9fabd4 solid 1px;
    text-align: left;
  }

img {
  max-height: 400px;
}

.region__container {
  display: flex;
  flex-wrap: wrap;
  flex-direction: row;
  padding: auto;
  justify-content: center;
}

.location__item {
  width: 200px;
  padding: 20px;
}

  .project__locationLink {
    text-decoration: none;
    color: black;
  }

  .project__locationLink:hover {
    text-decoration: underline;
    transform: scale(1.05, 1.05);
  }

</style>
