<template>
  <div class="container">
    <h3>Search for the aircraft's overflight area </h3>
    <input type="text" placeholder="Filter by flag" v-model="filter">
  <table>
    <thead>
      <tr>
        <th @click="sort('flag')">FLAG ↕️</th>
        <th>COUNTRIES ZONE</th>
        <th>LONGITUDE</th>
        <th>ALTITUDE</th>
        <th>DATA</th>
      </tr>
    </thead>
    <tbody>
      <tr v-for="(row, index) in sortedRow" :key="index">
        <td>{{row.flag}}</td>
        <td>{{convertIsoToCountries(row.latitude, row.longitude)}}</td>
        <td>
          {{ row.longitude }}
        </td>
        <td>
          {{ row.latitude }}
        </td>
        <td>
          {{ row.date }}
        </td>
      </tr>
    </tbody>
  </table>
  <p>
  <button @click="prevPage"> ⬅️ </button> 
  <button @click="nextPage">➡️</button>
  </p>
  </div>
</template>

<script>
import axios from "axios"

const countries = require('i18n-iso-countries')
countries.registerLocale(require('i18n-iso-countries/langs/en.json'))

const { lookUp } = require("geojson-places");
const list = countries.getNames('en', { select: 'official' })

export default {
  name : 'History',
  data(){
    return {
      currentSort:'name',
      currentSortDir:'asc',
      pageSize:15,
      currentPage:1,
      filter:'',
      rows : [],
      listIso : []
    }
  },
  methods : {
    sort(s){
      if(s === this.currentSort) {
        this.currentSortDir = this.currentSortDir==='asc'?'desc':'asc';
      }
      this.currentSort = s;
    },
    nextPage(){
      if((this.currentPage*this.pageSize) < this.filteredRow.length) this.currentPage++;
    },
    prevPage(){
      if(this.currentPage > 1) this.currentPage--;
    },
    convertIsoToCountries(altitude, longitude){
      // sorting of the planes on which country it flies over
      const result = lookUp(altitude, longitude);
      let countryName = list[result?.continent_code] || 'not found country'
      return countryName
    },
    convertTimeStamp(timestamp){
      let date = new Date(timestamp);
      return date
    }
  },
  watch: {
    filter() {
      console.log('reset to p1 due to filter');
      this.currentPage = 1;
    }
  },
  computed: {
    filteredRow() {
      return this.rows.filter(c => {
        if(this.filter == '') return true;
        return c.flag?.toLowerCase().indexOf(this.filter.toLowerCase()) >= 0;
      })
    },
    sortedRow(){
      return this.filteredRow.slice().sort((a,b) => {
        let modifier = 1;
        if(this.currentSortDir === 'desc') modifier = -1;
        if(a[this.currentSort] < b[this.currentSort]) return -1 * modifier;
        if(a[this.currentSort] > b[this.currentSort]) return 1 * modifier;
        return 0;
      }).filter((row, index) => {
        let start = (this.currentPage-1)*this.pageSize;
        let end = this.currentPage*this.pageSize;
        if(index >= start && index < end) return true;
      })
    }
  },
  mounted(){
    console.log('list', list)
    axios.get("http://localhost:8000/history").then((response) => {
      this.rows = response.data
    })
  }
}
</script>

<style>
.container{
  width: 100%;
  height: 100vh;
}
input[type=text] {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
  margin-top: 25px;
}
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

th {
  background-color: #dddddd;
}

button {
  width:  60px;
  height: 60px;
  margin: 5px;
  text-align: center;
  line-height: 60px;
  border: none;
  font-weight: bold;
  background: #44BB84;
  color: white;

}
</style>