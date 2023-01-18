<template>
    <div class="location">
        <div v-if="location">
        <h1>{{ location.name }}</h1>
        <p>{{ location.text }}</p>
        <img v-bind:src="'data:image/gif;base64,'+ location.images[0].image" />
        <span class="tag" :style="{'background-color':location.tag.color}">{{ location.tag.name }}</span> 
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


