<template>
    <div class="project">
        <BackButton>Tillbaka</BackButton>
        <div v-if="location" class="project__location">
        <h1> {{ location.name }}</h1>
        <p>{{ location.text }}</p>
        <Tag :style="{'background-color':location.tag.color}" :tagname="location.tag.name"></Tag> 
        
        <h4>Bilder</h4>
        <div class="location__imageContainer">
            <div v-for="image in location.images" v-bind:key="image.id" class="location__imageContainer__image">
            <img v-bind:src="'data:image/gif;base64,'+ image.imageData" />
            <p class="location__imageContainer__text">{{ image.text }}</p>
            <p class="location__imageContainer__text"> Källa: {{ image.source }}</p>
        </div>
        </div>
        <h4>Skannad text</h4>
        <div class="location__imageContainer">
            <div v-for="image in location.scannedTexts" v-bind:key="image.id" class="location__imageContainer__image">
            <img v-bind:src="'data:image/gif;base64,'+ image.imageData" />
            <p class="location__imageContainer__text">{{ image.text }}</p>
            <p class="location__imageContainer__text"> Källa: {{ image.source }}</p>
        </div>
        </div>
        </div>
      </div>
</template>

<script>

    import Tag from '../../components/Tag.vue'
    import BackButton from '../../components/BackButton.vue'

export default {
  props: ['regionid', 'locationid'],
  components: {
    Tag,
    BackButton,
  },
  data() {
    return {
      location: null,
    }
  },
  mounted() {
    fetch('http://localhost:8080/location/' + this.locationid)
    .then(res => res.json())
    .then(data => this.location = data)
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
  }

.project__location {
    display: flex;
    flex-direction: column;
    align-items: center;
    text-align: center;
    margin-bottom: 1rem;
    width: 80%;
    text-align: left;
}

.location__imageContainer__image {
    display: flex;
    flex-direction: column;
    min-width: 31%;
    float: left;
}

img {
    max-width: 400px;
}

.location__imageContainer__text {
    font-size: 12px;
    padding: none;
}

</style>>


