<template>
    <div class="search">
      <h1>This is the search page</h1>
      <div v-for="tag in tags" :key="tag.id" class="tag">
        <Tag :style="{'background-color':tag.color}" :tagname="tag.name"></Tag> 
      </div>
    </div>
  </template>

  <script>
  import Tag from '../components/Tag.vue'

  export default {
    components: {
    Tag
    },
    data() {
      return {
        tags: []
      }
    }, mounted() {
      fetch('http://localhost:8080/tag')
      .then(res => res.json())
      .then(data => this.tags = data)
      .then(err => console.log(err.message))
    }
  }
  </script>