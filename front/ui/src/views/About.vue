<template>
  <div class="container">
    <input type="text" placeholder="Filter by countries" v-model="filter" />
    <table>
      <thead>
        <tr>
          <th>HEX</th>
          <th>COUNTRIES</th>
          <th>STATUE</th>
        </tr>
      </thead>
      <tbody>
        <tr
          v-for="(row, index) in filteredRows" :key="`test${index}`"
        >
        <td
          v-html="highlightMatches(row.hex)"
        ></td>
        <td
        >
          {{ convertIsoToCountries(row.flag)  }}
        </td>
        <td
          v-html="highlightMatches(row.status)"
        ></td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import fakeData from "../components/data.json"
import axios from "axios"

const countries = require('i18n-iso-countries')
countries.registerLocale(require('i18n-iso-countries/langs/en.json'))

export default {
  name : "Historiques",
  data(){
    return {
      filter : "",
      rows : []
    }
  },
  methods : {
    highlightMatches(text){
      const matchExists = text.toLowerCase().includes(this.filter.toLowerCase());
      if (!matchExists) return text;
      const re = new RegExp(this.filter, "ig");
      return text.replace(re, matchedText => `<strong>${matchedText}</strong>`);
    },
    convertIsoToCountries(iso){
      const list = countries.getNames('en', { select: 'official' })
      let foundCountryCode = iso;
      let countryName = list[foundCountryCode] || iso
      return countryName
    }
  },
  computed : {
    filteredRows(){
      return this.rows.filter(row => {
        const flag = row.flag.toLowerCase();
        const hex = row.hex.toLowerCase();
        const searchTerm = this.filter.toLowerCase();
        return(
          hex.includes(searchTerm) || flag.includes(searchTerm)
        )
      })
    }
    
  },
  mounted(){
    axios.get("localhost:8000/flights").then(()=> {
      // this.rows = response.data.response
    })
    this.rows = fakeData
  }
}
</script>

<style scoped>
.container{
  width: 100%;
  height: 100vh;
}
input[type=text], select {
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
</style>
