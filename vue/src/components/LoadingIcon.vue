<template>
  <div class="loading-background">
      <div class="loading">
        <img src="../assets/RecordSpinningGif.gif" alt="loading">
        <p>Loading...</p>
      </div>
      
  </div>
</template>

<script>
export default {
    name: "loading-icon",
}
</script>

<style scoped>
.loading-background {
    width: 100%;
    height: 100%;
    background-color: rgba(128, 128, 128, 0.521);
    position: absolute;
    top: 0;
    left: 0;
}

.loading {
    position: relative;
    top: calc(50vh - (75px/2));
    left: calc(50vw - (75px/2));
    z-index: 10;
}

img {
    width: 75px;
    height: 75px;
}

p { 
     font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
     margin: 5px;
}
</style>