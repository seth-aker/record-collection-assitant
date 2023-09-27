<template>
  <div class="right-section">
    <div class="container">
      <h2>TRENDING COLLECTIONS</h2>
      <div class="album-art">
        <!-- Placeholder images for album art -->
        <div class="album-placeholder"></div>
        <div class="album-placeholder"></div>
        <div class="album-placeholder"></div>
         <div class="album-placeholder"></div>
        <div class="album-placeholder"></div>
         <div class="album-placeholder"></div>
        <div class="album-placeholder"></div>
         <div class="album-placeholder"></div>
        <div class="album-placeholder"></div>
        
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'AboutSection',
};
</script>

<style scoped>
.container {
  margin-top: 200px; 
  padding: 20px; 
  background-color: rgba(255, 255, 255, 0.8);
  box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
  text-align: center; 
}

h2 {
  font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
}

.album-art {
  text-align: center;
  margin-top: 10px;
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}

.album-placeholder {
  width: 150px; 
  height: 150px;
  margin: 10px;
  background-color: #ddd; 
  
}

.right-section {
  padding: 100px;
  padding-top: 70px;
  font-family: Arial, sans-serif;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}
</style>
