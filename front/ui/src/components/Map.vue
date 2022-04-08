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
      <MglMarker 
      v-for="(coordinate,key) in coordinateMap"
      :key="key"
      :coordinates="[coordinate.coordinates.longitude,coordinate.coordinates.altitude]" 
      >
        <img :src="imgPlane" alt="" slot="marker" class="img-plane"/>
      </MglMarker>
    </MglMap>
  </div>
</template>

<script>
import { MglMap, MglMarker } from "vue-mapbox";
import plane from "../assets/plane.svg";

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
      containerElement: null,
      imgPlane : plane,
      coordinateMap : [
      {
        coordinates : {
          altitude : 48.889359,
          longitude: 2.220344
        }
      },
      {
        coordinates : {
          altitude : 48.889415,
          longitude: 2.226700
        }
      },
      {
        coordinates : {
          altitude : 48.895757,
          longitude: 2.206070
        }
      }
    ]
    };
  }, 
  mounted() {
    this.coordinateMap.forEach((stat) => {
      console.log('state', stat)
    })
    this.containerElement = document.getElementById('mycontainer')
  }
};
</script>

<style scoped>
.default-map-xl {
  width: 100% !important;
  height: 100vh !important;
}
.img-plane{
  width: 50px
}

</style>