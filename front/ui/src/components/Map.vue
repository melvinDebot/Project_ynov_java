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
      v-for="(coordinate,key) in positionPlane"
      :key="key"
      :coordinates="[coordinate.lng,coordinate.lat]" 
      >
        <img :src="imgPlane" alt="" slot="marker" class="img-plane"/>
        <MglPopup :coordinates="[coordinate.lng,coordinate.lat]" anchor="top">
          <div>flight number{{ coordinate.flight_number }}</div>
    </MglPopup>
      </MglMarker>
    </MglMap>
  </div>
</template>

<script>
import { MglMap, MglMarker, MglPopup } from "vue-mapbox";
import plane from "../assets/plane.svg";
import axios from "axios"

export default {
  name: "MapExample",

  components: {
    MglMap,
    MglMarker,
    MglPopup
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
      positionPlane : [],
    };
  }, 
  mounted() {
    this.containerElement = document.getElementById('mycontainer')
    axios.get("https://airlabs.co/api/v9/flights?api_key=537a34ad-98f0-4616-adae-ec9a3f8e1da1").then((response)=> {
      this.positionPlane = response.data.response
    })
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