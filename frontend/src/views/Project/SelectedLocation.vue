<template>
    <div class="project">
        <BackButton>Tillbaka</BackButton>
        <div v-if="location">
            <div class="location_topContainer">
            <h1> {{ location.name }}</h1>
            <p>{{ location.text }}</p>
            <Tag :style="{'background-color':location.tag.color}" :tagname="location.tag.name"></Tag>
        </div> 
        <h4>Bilder</h4>
        <div class="location__container">
            <div v-for="image in location.images" v-bind:key="image.id" >
                <img v-bind:src="'data:image/gif;base64,'+ image.imageData" />
                <p class="location__imageContainer__text">{{ image.text }}</p>
                <p class="location__imageContainer__text"> Källa: {{ image.source }}</p>
            </div>
         </div>
        <h4>Skannad text</h4>
        <div class="location__container">
            <div v-for="image in location.scannedTexts" v-bind:key="image.id">
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
    text-align: center;
    margin-bottom: 1rem;
    width: 80%;
    text-align: left;
}

.location__container {
    display: flex;
    gap: 1em;
}

.location__container > * {
    flex-basis: 100%;
}

img{
    max-width: 100%;
    width: 240px;
}

.location__container__item {
    width: 300px;
    height: 320px;
    padding: 15px;
}


.location__imageContainer__text {
    font-size: 12px;
    padding: none;
}

</style>>


