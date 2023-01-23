<template>
    <div class="AdminNewLocation">
      <h3>Skapa ny plats</h3>
      <div class="admin__regionContainer">
        <div v-for="region in regions" :key="region.id" class="tag" @click="handleRegion(region.id)">
          <h4 class="admin__region" :class="{active: selectedRegion == region.id}" >{{ region.name }}</h4>
      </div>
      </div>
      <form @submit.prevent="createNewLocation" class="location__form">
            <input v-model="name" placeholder="Namn"/>
            <input v-model="text" placeholder="Text"/>

      <div class="admin__tagContainer">
        <div v-for="tag in tags" :key="tag.id" class="tag" @click="handleTag(tag.id)">
          <Tag :style="{'background-color':tag.color}" :tagname="tag.name" ></Tag> 
      </div>
      </div>
      <button type="submit">Skapa ny plats</button>
        </form>
    </div>
  </template>

  <script>
    import axios from 'axios'
    import Tag from '../../components/Tag.vue'

  export default {
    components: {
    Tag,
    },
    data() {
      return {
        tags: [],
        regions: [],
        selectedTag: "",
        selectedRegion: "",
        name: "", 
        text: ""
      }
    }, mounted() {
      fetch('http://localhost:8080/tag')
      .then(res => res.json())
      .then(data => this.tags = data)
      .then(err => console.log(err.message))
      fetch('http://localhost:8080/region')
        .then(res => res.json())
        .then(data => this.regions = data)
        .then(err => console.log(err.message))
    },
    methods: {
        handleTag(event) {
            this.selectedTag = event; 
        },
        handleRegion(event) {
            this.selectedRegion = event; 
        },
        async createNewLocation(e) {
            const formData = new FormData();
            formData.append('name', this.name);
            formData.append('text', this.text);
            formData.append('id', this.selectedRegion);
            formData.append('tagId', this.selectedTag);
            const response = await axios.post('http://localhost:8080/location', formData, {
                headers: {
                    Authorization: localStorage.getItem('token')
                }
                }
            )
            console.log(response);
        }
    }
    
  }
  </script>

  <style scoped>

  .AdminNewLocation {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-bottom: 2rem;
  }

  .location__form {
        display: flex;
        flex-direction: column;
        align-items: center;
    }

   .active {
    color: green;
    text-decoration: underline;
   }

  .admin__regionContainer {
    width: 80%;
    display: flex;
    justify-content: center;
  }

  .admin__region {
    padding: 25px;
  }

  .admin__tagContainer {
    width: 80%;
    display: flex;
    justify-content: center;
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