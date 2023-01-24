<template>
    <div class="admin">
    <Backbutton>Tillbaka</Backbutton>
    <h2>Redigera plats</h2>
    <div v-if="location">
        <div class="admin_topContainer">
            <h3>{{ location.name }}</h3>
            <p>{{ location.text }}</p>
            <Tag :style="{'background-color':location.tag.color}" :tagname="location.tag.name"></Tag>
        </div> 
        
        <form @submit.prevent="uploadImage" enctype="multipart/form-data" class="image__form">
            <h4>Lägg till en bild eller skannad text</h4>
            <input v-model="text" placeholder="Text"/>
            <input v-model="source" placeholder="Source"/>
            <input type="file" placeholder="Image" @change="fileSelected"/>
            <div class="radio__container">
                <input type="radio" v-model="selectedType" value="image">Bild
                <input type="radio" v-model="selectedType" value="scannedtext">Skannadtext
            </div>
            <button type="submit">Ladda upp bild</button>
        </form>

        <h4>Bilder</h4>
        <div class="admin__container">
            <div v-for="image in location.images" v-bind:key="image.id" >
                <div class="admin__item ">
                    <img v-bind:src="'data:image/gif;base64,'+ image.imageData"/>
                    <span class="admin__item__delete" v-on:click="deleteImage(image.id)">X</span>
                    <p class="admin__imageContainer__text">{{ image.text }}</p>
                    <p class="admin__imageContainer__text"> Källa: {{ image.source }}</p>
                </div>
            </div>
         </div>
        <h4>Skannad text</h4>
        <div class="admin__container">
            <div v-for="image in location.scannedTexts" v-bind:key="image.id">
                <div class="admin__item ">
                    <img v-bind:src="'data:image/gif;base64,'+ image.imageData" v-on:click="openModal"/>
                    <span class="admin__item__delete" v-on:click="deleteImage(image.id)">X</span>
                    <p class="admin__imageContainer__text">{{ image.text }}</p>
                    <p class="admin__imageContainer__text"> Källa: {{ image.source }}</p>
                </div>
            </div>
        </div>
        </div>
    </div>
</template>


<script>
    import Backbutton from '../../components/BackButton.vue'
    import Tag from '../../components/Tag.vue'
    import axios from 'axios'

export default {
    props: ['locationid'],
    components: {
    Backbutton,
    Tag,

    },
    data() {
    return {
      location: null,
      text: "",
      source: "",
      image: null,
      selectedType: "image",
    }
  }, async mounted() {
    await fetch('http://localhost:8080/location/'+ this.locationid)
    .then(res => res.json())
    .then(data => this.location = data)
    .then(err => console.log(err.message))
  }, 
  methods: {
    fileSelected(e) {
        this.image = e.target.files[0];
    },
    async uploadImage() {
        const formData = new FormData();
        formData.append('text', this.text);
        formData.append('id', parseInt(this.location.id));
        formData.append('source', this.source);
        formData.append('file', this.image);
        const response = await axios.post('http://localhost:8080/' + this.selectedType, formData, {
            headers: {
                'content-type': 'multipart/form-data',
                Authorization: localStorage.getItem('token')
            }
            }
        )
        this.$router.go()
    },
    async deleteImage(event) {
        const response = await axios.delete('http://localhost:8080/image/' + event, {
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

.admin {
    display: flex;
    flex-direction: column;
    align-items: center;
    margin-bottom: 2rem;
  }

.admin__location {
    text-align: center;
    margin-bottom: 1rem;
    width: 80%;
    text-align: left;
}

form {
  display: flex;
  flex-direction: column;
  margin: 3rem auto;
  padding:30px;
  width:400px;
  height:auto;
  overflow:hidden;
  background: whitesmoke; 
  border: darkgray solid 1px; 
}

.image__form input {
    margin: 5px;
}

form button {
  width: 180px;
  margin-top: 1rem;
  padding: 5px;
  border: none;
  background-color: white;
  color:black;
  font-size:14px;
  box-shadow: 4px 2px 2px lightgray;
}

form button:hover {
  opacity:0.8;
  background-color: green;
  color:white; 
}

.admin__container {
    display: flex;
    flex-wrap: wrap;
    flex-direction: row;
    padding: auto;
    justify-content: center;
}

.admin__item {
  width: 400px;
  padding: 20px;
  position: relative;
}

.admin__item__delete {
    color: red;
    font-weight: 800;
    position: absolute;
    top: 0;
}

.admin__item__delete:hover {
    cursor: pointer;
    transform: scale(1.5, 1.5);
}


img{
    max-width: 100%;
}

.admin__container__item {
    width: 300px;
    height: 320px;
    padding: 15px;
}

.admin__imageContainer__text {
    font-size: 12px;
    padding: none;
    text-align: left;
}






</style>