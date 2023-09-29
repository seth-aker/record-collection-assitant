<template>
  <div>
    <!-- First artist section -->
    <div class="popular-artist-container">
      <h1>POPULAR ARTISTS</h1>
    </div>
    <div class="artist-section">
      <div class="album-cover">
        <img src="sgtPepper.jpg" alt="Album Cover" />
      </div>
      <div class="artist-info">
        <h2>THE BEATLES</h2>
        <p>IN 15987 COLLECTIONS</p>
        <p>17 DIFFERENT ALBUMS</p>
        <p>-VIEW COLLECTIONS-</p>
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
        <p>-VIEW COLLECTIONS-</p>
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
  padding: 5px;
  text-align: center;
  display: flex;
  align-items: center;
  justify-content: center;
  margin-top: 80px;
}

h1 {
  font-family: 'KEEPT___', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  font-size: 50px;
  color: #eff13f;
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
  width: 50%;
  display: flex;
  justify-content: space-around;
}

.artist-info {
  flex: 1;
  padding-left: 0px;
  font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  color: #40c5a4;
  text-align: center;
  display: flex;
  flex-direction: column;

  
  
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
</style>