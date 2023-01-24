<template>
    <div class="search">
      <h3>Sök</h3>
      <p>Hitta platser och sevärdheter klicka på en kategori eller genom att skriva in ett sökord. </p>
      <div class="search__tagContainer">
        <div v-for="tag in tags" :key="tag.id" class="tag" @click="handleTag(tag.id)">
          <div :class="{activeTag: selectedTag == tag.id}">
            <Tag :style="{'background-color':tag.color}" :tagname="tag.name"></Tag> 
        </div>
      </div>
      </div>
        <input type="text" @input="handleInput" placeholder="Sök på platser"/>
        <div v-for="location in locations" :key="location.id" class="location">
        <router-link :to="{ name: 'SelectedLocation', params: { locationid: location.id, regionid: location.region.id }}">
          <h4 class="searchResult">{{ location.name }} </h4>
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
        locations: [],
        selectedTag: ""
      }
    }, mounted() {
      fetch('http://localhost:8080/tag')
      .then(res => res.json())
      .then(data => this.tags = data)
      .then(err => console.log(err.message))
    },
    methods: {
      handleInput(event) {
          this.selectedTag = "";
          const keyword = event.target.value;
          let url = new URL('http://localhost:8080/location/search');
          const params = { keyword: keyword };
          url.search = new URLSearchParams(params);
          fetch(url)
          .then(res => res.json())
          .then(data => this.locations = data)
          .then(err => console.log(err.message))
        },
        handleTag(event) {
          this.selectedTag = event; 
          console.log(event)
          fetch('http://localhost:8080/location/bytag/' + event)
          .then(res => res.json())
          .then(data => this.locations = data)
          .then(err => console.log(err.message))
        }
    }
  }
  </script>

  <style scoped>

  .search {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-bottom: 2rem;
  }

  .search__tagContainer {
    width: 80%;
    display: flex;
    justify-content: center;
    padding: 5px
  }

  .activeTag {
    transform: scale(1.25,1.25);
  }

  .tag:hover {
    cursor: pointer;
  }

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

.searchResult {
  text-decoration: none;
  color: black;
}


</style>