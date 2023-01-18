<template>
    <div class="project">
        <div v-if="location" class="project__location">
        <h1> {{ location.name }}</h1>
        <p>{{ location.text }}</p>
        <span class="tag" :style="{'background-color':location.tag.color}">{{ location.tag.name }}</span> 
        
        <h4>Bilder</h4>
        <div class="location__imageContainer">
            <div v-for="image in location.images" v-bind:key="image.id" class="location__imageContainer__image">
            <img v-bind:src="'data:image/gif;base64,'+ image.image" />
            <p class="location__imageContainer__text">{{ image.text }}</p>
            <p class="location__imageContainer__text"> Källa: {{ image.source }}</p>
        </div>
        </div>
        <h4>Skannad text</h4>
        <div class="location__imageContainer">
            <div v-for="image in location.scannedTexts" v-bind:key="image.id" class="location__imageContainer__image">
            <img v-bind:src="'data:image/gif;base64,'+ image.image" />
            <p class="location__imageContainer__text">{{ image.text }}</p>
            <p class="location__imageContainer__text"> Källa: {{ image.source }}</p>
        </div>
        </div>
        </div>
      </div>
</template>

<script>
export default {
  props: ['regionid', 'locationid'],
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

<style>

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

.location__imageContainer__text {
    font-size: 12px;
    padding: none;
}

.tag {
  background: #eee;
  color: #fff;
  display: inline-block;
  height: 26px;
  line-height: 26px;
  padding: 0 20px 0 23px;
  position: relative;
  margin: 0 10px 10px 10px;
  box-shadow: 4px 2px 2px lightgray;
}

.tag::before {
  background: #fff;
  border-radius: 10px;
  content: '';
  height: 6px;
  left: 10px;
  position: absolute;
  width: 6px;
  top: 10px;
}

</style>>


