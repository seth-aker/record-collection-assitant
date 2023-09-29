<template>
  <div class="right-section">
    <div class="container">
      <h2>TRENDING COLLECTIONS</h2>
      <div class="album-art">
        <!-- Placeholder images for album art with text boxes -->
        <div class="album-placeholder">
          <img src="theWho.jpg" alt="Album 1" />
          <div class="album-title">
            <div class="album-title-text">Album title 1</div>
          </div>
        </div>
        <div class="album-placeholder">
          <img src="neilYoung.jpg" alt="Album 2" />
          <div class="album-title">
            <div class="album-title-text">Album Title 2</div>
          </div>
        </div>

        <div class="album-placeholder">
          <img src="funk.jpg" alt="Album 3" />
          <div class="album-title">
            <div class="album-title-text">Album Title 3</div>
          </div>
        </div>
        <div class="album-placeholder">
          <img src="sgtPepper.jpg" alt="Album 4" />
          <div class="album-title">
            <div class="album-title-text">Album Title 4</div>
          </div>
        </div>
        <div class="album-placeholder">
          <img src="rem.jpg" alt="Album 5" />
          <div class="album-title">
            <div class="album-title-text">Album Title 5</div>
          </div>
        </div>
        <div class="album-placeholder">
          <img src="theWho.jpg" alt="Album 6" />
          <div class="album-title">
            <div class="album-title-text">Album Title 6</div>
          </div>
        </div>
        <div class="album-placeholder">
          <img src="mj.jpg" alt="Album 7" />
          <div class="album-title">
            <div class="album-title-text">Album Title 7</div>
          </div>
        </div>
           <div class="album-placeholder">
          <img src="foals.jpg" alt="Album 8" />
          <div class="album-title">
            <div class="album-title-text">Album Title 8</div>
          </div>
        </div>
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
  padding: 0px;

  text-align: center;
}

h2 {
  font-family: 'KEEPT___', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  font-size: 50px;
  color: #40c5a4;
}

.album-art {
  text-align: center;
  margin-top: 20px;
  display: flex;
  flex-wrap: wrap;
  justify-content: center;
}

.album-placeholder {
  width: 280px; /* Increase the width to make the images bigger */
  margin: 30px; /* Increase the margin to keep them spread apart */
  padding: 10px;
  text-align: center;
  display: flex;
  flex-direction: column;
  align-items: center;
}

.album-placeholder img {
  width: 100%; 
}

.album-title {
  margin-top: 10px;
  font-weight: bold;
  color: #40c5a4;
}

.album-title-text {
  font-size: 14px;
  color: #40c5a4;
}


.right-section {
  padding: 100px;
  padding-top: 0px;
  font-family: Arial, sans-serif;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

@font-face {
  font-family: 'KEEPT___';
  src: url('@/assets/fonts/KEEPT___.TTF') format('truetype');
}
</style>