<template>
    <div class="admin">
    <Backbutton>Tillbaka</Backbutton>
    <h2>Välj en plats att redigera</h2>
    <div v-for="location in locations" :key="location.id" class="location">
        <router-link class="admin__link" :to="{ name: 'AdminEditLocation', params: { locationid: location.id }}">
          <h4 class="admin__link">{{ location.name }}</h4>
        </router-link>
      </div>
    </div>
</template>
<script>
    import Backbutton from '../../components/BackButton.vue'
export default {
    props: ['regionid'],
    components: {
    Backbutton,
    },
    data() {
    return {
        locations: [],
    }
  }, mounted() {
    console.log("hej")
    fetch('http://localhost:8080/location/byregion/' + this.regionid)
    .then(res => res.json())
    .then(data => this.locations = data)
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
    .admin__link {
    text-decoration: none;
    color: black;
  }

  .admin__link:hover {
    text-decoration: underline;
    transform: scale(1.1, 1.1);
  }
</style>