<template>
    <div class="admin">
    <Backbutton>Tillbaka</Backbutton>
    <h2>Redigera plats</h2>
    <div v-if="location">
            <div class="admin_topContainer">
            <h1> {{ location.name }}</h1>
            <p>{{ location.text }}</p>
            <Tag :style="{'background-color':location.tag.color}" :tagname="location.tag.name"></Tag>
        </div> 
        <h4>Bilder</h4>
        <div class="admin__container">
            <div v-for="image in location.images" v-bind:key="image.id" >
                <div class="admin__item ">
                    <img v-bind:src="'data:image/gif;base64,'+ image.imageData" v-on:click="openModal"/>
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
export default {
    props: ['locationid'],
    components: {
    Backbutton,
    },
    data() {
    return {
      location: null,
    }
  }, mounted() {
    fetch('http://localhost:8080/location/'+ this.locationid)
    .then(res => res.json())
    .then(data => this.location = data)
    .then(err => console.log(err.message))
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