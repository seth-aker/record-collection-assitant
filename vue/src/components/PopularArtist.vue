<template>
  <div>
    <!-- First artist section -->
    <div class="popular-artist-container">
      <h1>RECENTLY ADDED</h1>
    </div>
    <div class="artist-section">
      <div class="album-cover">
        <img src="sgtPepper.jpg" alt="Album Cover" />
      </div>
      <div class="artist-info">
        <h2>THE BEATLES</h2>
        <p>IN 15987 COLLECTIONS</p>
        <p>17 DIFFERENT ALBUMS</p>
        <!-- Link to Collections.vue -->
        <a href="/collections.vue" class="view-collections-link">-VIEW COLLECTIONS-</a>
      </div>
    </div>

    <!-- Second identical artist section with thin bars -->
    <div class="artist-section">
      <div class="album-cover">
        <img src="theWho.jpg" alt="Album Cover" />
      </div>
      <div class="artist-info">
        <h2>THE WHO</h2>
        <p>IN 12794 COLLECTIONS</p>
        <p>12 DIFFERENT ALBUMS</p>
        <!-- Link to Collections.vue -->
        <a href="/collections.vue" class="view-collections-link">-VIEW COLLECTIONS-</a>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'PopularArtist',
};
</script>

<style scoped>
.popular-artist-container {
  background-color: #40c5a4;
  opacity: 90%;
  padding: 5px;
  text-align: center;
  display: flex;
  align-items: center;
  justify-content: center;
  margin-top: 60px;
}

h1 {
  font-family: 'KEEPT___', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  font-size: 60px;
  color: #eff13f;
  -webkit-text-stroke:0.8px #E00A86;
  
}

.artist-section {
  display: flex;
  align-items: center;
  justify-content: space-around;
  margin-top: 50px;
  
}

.album-cover {
  flex: 1;
  text-align: center;
  display: flex;
  justify-content: center;
  
}

.album-cover img {
  width: 40%;
  display: flex;
  justify-content: space-around;
}

.artist-info {
  flex: 1;
  padding-left: 0px;
   font-family: 'KEEPT___', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  color: #eff13f;
  text-align: center;
  display: flex;
  flex-direction: column;
  -webkit-text-stroke:0.1px #40c5a4;

  
  
}

/*  thin bars above and below the artist info */
.artist-info::before,
.artist-info::after {
  content: '';
  display: block;
  height: 2px;
  background-color: #40c5a4;
  margin-bottom: 40px;
  
  left: 0;
  right: 0;
}

.artist-info::before {
  top: 0;
}

.artist-info::after {
  bottom: 0;
}

h2 {
  font-size: 50px;
  margin-bottom: 10px;
  
}

p {
  font-size: 25px;
}
.view-collections-link {
  text-decoration: none; 
  color: #40c5a4; 
  font-weight: bold; 
  font-size: 20px; 
  transition: color 0.3s; 
  -webkit-text-stroke:0.1px #E00A86;


 
  padding: 5px 10px;
  background-color: #eff13f;
  border-radius: 5px;
}

.view-collections-link:hover {
  color: white; 
  background-color: #40c5a4; 
}


</style>