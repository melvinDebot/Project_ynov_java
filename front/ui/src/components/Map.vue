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
      :style="`transform: rotate(${coordinate.direction}deg) !important`"
      >
        <img :src="imgPlane" alt="" slot="marker" class="img-plane" />
        <MglPopup :coordinates="[coordinate.lng,coordinate.lat]" anchor="top">
          <div><strong>flight number </strong>{{ coordinate.flightNumber }}</div>
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
    this.getDataApi()
  },
  methods : {
    getDataApi() {
      // Aircraft movement in real time
      this.intervalData = setInterval(function(){
        this.positionPlane = []
        axios.get("http://localhost:8000/history").then((response) => {
          let i = 0;
          response.data.forEach(element => {
            if (i < 1000) {
              this.positionPlane.push({ lat: element.latitude, lng: element.longitude, direction: element.dir, flightNumber : element.flag })
              i += 1
            }
          });
          console.log('the positions of the planes have been modified')
        }).catch((error) => {
          console.log(error)
        })}
      .bind(this), 5000);
    }
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