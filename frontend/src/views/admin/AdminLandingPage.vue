
<template>
    <div class="admin">
    <h2>Välkommen tillbaka</h2>
    <h3>
        <a href="http://localhost:8081/admin/newlocation" class="admin__link">Skapa ny plats</a>
    </h3>
    <h3>Redigera plats utifrån område</h3>
    <div class="admin__regionLinkContainer">
    <div v-for="region in regions" :key="region.id" class="region">
        <router-link class="admin__link" :to="{ name: 'AdminChooseLocation', params: { regionid: region.id }}">
          <h4 class="admin__link">{{ region.name }}</h4>
        </router-link>
      </div>
    </div>
</div>
</template>
<script>

export default {
    components: {
    },
    data() {
    return {
      regions: [],
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

    .admin {
    display: flex;
    flex-direction: column;
    align-items: center;
  }

  .admin__regionLinkContainer {
    width: 80%;
    display: flex;
    justify-content: center;
  }

    .admin__link {
    text-decoration: none;
    color: black;
    padding: 0 25px;
  }

  .admin__link:hover {
    text-decoration: underline;
    transform: scale(1.1, 1.1);
  }
</style>
