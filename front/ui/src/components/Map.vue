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
      <MglMarker :coordinates="[2.254950,48.923050]" color="blue" />
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
import { MglMap, MglMarker } from "vue-mapbox";

export default {
  name: "MapExample",

  components: {
    MglMap,
    MglMarker,
  },

  data() {
    return {
      accessToken:
        "pk.eyJ1IjoibWVsdmluZGJ0NzciLCJhIjoiY2wxcTNsbXkwMGR5NjNrcHRncDFvaWFucCJ9.1eYVlTojCwal_wGT5g2afQ",
      mapStyle: "mapbox://styles/mapbox/streets-v11",
      zoom: 10,
 
      center: [2.254950,48.923050 ],
      containerElement: null
    };
  },  
  mounted() {

    this.containerElement = document.getElementById('mycontainer')
  }
};
</script>