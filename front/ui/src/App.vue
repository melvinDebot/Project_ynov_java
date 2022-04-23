<template>
  <div id="app">
    <div id="nav">
      <router-link to="/">MAPS AIRLINE</router-link> 
      <router-link to="/history">Historiques</router-link>
    </div>
    <router-view/>
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  width: 100%;
  height: 100vh;
}

#nav {
  height: 70px;
  display: flex;
  padding: 0px 10px;
  justify-content: space-between;
  align-items: center;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
  text-decoration: none;
}

#nav a.router-link-exact-active {
  color: #42b983;
}

body{
  margin: 0; 
  padding: 0;
}

canvas{
  position: inherit !important;
}
</style>
