<template>
    <div class="project">
      <h1>Projektet</h1>
      <div class="project__textBox">
        <p class="project__textBox__text">
        Kartnavigationen fungerar för tillfället inte, så navigera utifrån ett område för att hitta platser och sevärdheter eller klicka 
        <a class="project__link" href="search">här</a> för att komma till sökfunktionen. 
      </p>
      </div>
      <h2>Områden</h2>
      <div v-for="region in regions" :key="region.id" class="region">
        <router-link class="project__regionlink" :to="{ name: 'SelectedRegion', params: { regionid: region.id }}">
          <h4 class="project__regionlink">{{ region.name }}</h4>
        </router-link>

      </div>
    </div>
  </template>


<script>
export default {
  data() {
    return {
      regions: []
    }
  }, mounted() {
    fetch('http://localhost:8080/region')
    .then(res => res.json())
    .then(data => this.regions = data)
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

  .project__link {
    font-size: 18px;
    color: black;
  }

  .project__textBox {
    text-align: center;
    width: 40%;
  }

  .project__textBox__text {
    text-align: left;
  }

  .project__regionlink {
    text-decoration: none;
    color: black;
  }

  .project__regionlink:hover {
    text-decoration: underline;
    transform: scale(1.1, 1.1);
  }

</style>


  