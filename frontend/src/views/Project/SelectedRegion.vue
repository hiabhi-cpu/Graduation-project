<template>
    <div class="project">
      <button class="backButton" @click="back">Tillbaka</button>
      <div class="project__region" v-if="region">
        <h2>{{ region.name }}</h2>
        <img v-bind:src="'data:image/gif;base64,'+ region.image" />
        <p>{{ region.text }}</p>
      </div>
      <h4>Platser och sevärdheter</h4>
      <div v-for="location in locations" :key="location.id" class="location">
        <router-link class="project__locationLink" :to="{ name: 'SelectedLocation', params: { locationid: location.id }}">
          <h4 class="project__locationLink">{{ location.name }}  </h4>
        </router-link>
        <Tag :style="{'background-color':location.tag.color}" :tagname="location.tag.name"></Tag> 
      </div>
    </div>

</template>

<script>
  import Tag from '../../components/Tag.vue'


export default {
  props: ['regionid'],
  components: {
    Tag,
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
    fetch('http://localhost:8080/locationbyregion/' + this.regionid)
    .then(res => res.json())
    .then(data => this.locations = data)
    .then(err => console.log(err.message))
  },
  methods: {
    back() {
        this.$router.go(-1)
    }
  }
}
</script>


<style scoped>

  
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

  .location {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-bottom: 1rem;
    width: 10%;
    border-bottom: #9fabd4 solid 1px;
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
