<template>
  <div class="home">
    <Map />
  </div>
</template>



<script>
import Map from "../components/Map.vue"

export default {
  name: "Home",

  components: {
    Map
  },

};
</script>

<style scoped>
  .home{
    width: 100%;
    height: 100vh;
  }
</style>