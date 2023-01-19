<template>
    <div class="search">
      <p>Hitta platser genom att antingen skriva in ett sökord eller hämta utifrån typ genom att klicka på t.ex. Gruva</p>
      <div v-for="tag in tags" :key="tag.id" class="tag">
        <Tag :style="{'background-color':tag.color}" :tagname="tag.name"></Tag> 
      </div>
        <input type="text" @input="handleInput" placeholder="Sök på platser"/>
        <div v-for="location in locations" :key="location.id" class="location">
        <router-link :to="{ name: 'SelectedLocation', params: { locationid: location.id, regionid: location.region.id }}">
          <h4>{{ location.name }}  </h4>
        </router-link>
      </div>
    </div>
  </template>

  <script>
  import Tag from '../components/Tag.vue'

  export default {
    props: ['regionid', 'locationid'],
    components: {
    Tag
    },
    data() {
      return {
        tags: [],
        locations: []
      }
    }, mounted() {
      fetch('http://localhost:8080/tag')
      .then(res => res.json())
      .then(data => this.tags = data)
      .then(err => console.log(err.message))
    },
    methods: {
      handleInput(event) {
          const keyword = event.target.value;
          let url = new URL('http://localhost:8080/location/search');
          const params = { keyword: keyword };
          url.search = new URLSearchParams(params);
          fetch(url)
          .then(res => res.json())
          .then(data => this.locations = data)
          .then(err => console.log(err.message))
        }
    }
  }
  </script>

  <style scoped>

  input {
  display: block;
  width: 350px;
  margin: 20px auto;
  padding: 10px 45px;
  font-size: 16px;
  border: none;
  border-radius: 5px;
  box-shadow: rgba(50, 50, 93, 0.25) 0px 2px 5px -1px,
    rgba(0, 0, 0, 0.3) 0px 1px 3px -1px;
}

.item {
  width: 350px;
  margin: 0 auto 10px auto;
  padding: 10px 20px;
  color: white;
  border-radius: 5px;
  box-shadow: rgba(0, 0, 0, 0.1) 0px 1px 3px 0px,
    rgba(0, 0, 0, 0.06) 0px 1px 2px 0px;
}


</style>