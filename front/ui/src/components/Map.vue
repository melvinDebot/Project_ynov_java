<template>
  <div id="mycontainer">
    <MglMap
      :accessToken="accessToken"
      :mapStyle="mapStyle"
      :zoom="zoom"
      :center="center"
      ref="map"
      class="default-map-xl"
    >
    </MglMap>
  </div>
</template>

<style scoped>
.default-map-xl {
  width: 100% !important;
  height: 100vh !important;
}

</style>

<script>
import { MglMap } from "vue-mapbox";

export default {
  name: "MapExample",

  components: {
    MglMap
  },

  data() {
    return {
      accessToken:
        "pk.eyJ1IjoibWVsdmluZGJ0NzciLCJhIjoiY2wxcTNsbXkwMGR5NjNrcHRncDFvaWFucCJ9.1eYVlTojCwal_wGT5g2afQ",
      mapStyle: "mapbox://styles/mapbox/streets-v11",
      zoom: 8.5,
      center: [-84.1774784, 9.9678728],
      selectedFeature: {
        name: "San José",
      },
      containerElement: null
    };
  },  
  mounted() {
    this.containerElement = document.getElementById('mycontainer')
  }
};
</script>