<template>
    <div class="AdminNewLocation">
        <Backbutton>Tillbaka</Backbutton>
      <h2>Skapa ny plats</h2>
      <div class="admin__regionContainer">
        <div v-for="region in regions" :key="region.id" class="tag" @click="handleRegion(region.id)">
          <h3 class="admin__region" :class="{activeRegion: selectedRegion == region.id}" >{{ region.name }}</h3>
      </div>
      </div>
      <form @submit.prevent="createNewLocation" class="location__form">
            <input v-model="name" placeholder="Namn"/>
            <textarea v-model="text" placeholder="Text"/>

      <div class="admin__tagContainer">
        <div v-for="tag in tags" :key="tag.id" class="tag" @click="handleTag(tag.id)">
            <div :class="{activeTag: selectedTag == tag.id}">
          <Tag :style="{'background-color':tag.color}" :tagname="tag.name" ></Tag> 
        </div>
      </div>
      </div>
      <button type="submit">Skapa ny plats</button>
        </form>
    </div>
  </template>

  <script>
    import axios from 'axios'
    import Tag from '../../components/Tag.vue'
    import Backbutton from '../../components/BackButton.vue'

  export default {
    components: {
    Tag,
    Backbutton,
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
            this.$router.push('editLocation/' + response.data.id)
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

    form label {
	font-size:14px;
	color:black;
	cursor:pointer;
}

form input {
	margin:15px 0;
	padding:15px 10px;
	width:100%;
	outline:none;
	border:1px solid #bbb;
	display:inline-block;
	box-sizing:border-box;
	transition:0.2s ease all;
}

form textarea {
    margin:15px 0;
	padding:15px 10px;
	width:100%;
	outline:none;
	border:1px solid #bbb;
	display:inline-block;
	box-sizing:border-box;
	transition:0.2s ease all;
    font-size: 16px;
    font-family: sans-serif;
}

   .activeRegion {
    color: green;
    text-decoration: underline;
    text-shadow: 0px 0px 1px green;
    transform: scale(1.2,1.2);
   }

   .activeTag {
    transform: scale(1.25,1.25);
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
    padding: 15px;
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

form button {
  width: 120px;
  padding: 10px;
  border: black solid 1px;
  background-color: whitesmoke;
  color:black;
  font-size:14px;
  box-shadow: 4px 2px 2px lightgray;
}

form button:hover {
  opacity:0.8;
  background-color: green;
  color:white; 
}


</style>