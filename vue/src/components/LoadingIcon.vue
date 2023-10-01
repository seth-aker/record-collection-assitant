<template>
  <div class="loading">
      <img src="../assets/RecordSpinningGif.gif" alt="loading">
      <p>Loading...</p>
  </div>
</template>

<script>
export default {
    name: "loading-icon",
}
</script>

<style scoped>
.loading {
    width: 100%;
    height: 100%;
    background-color: rgba(128, 128, 128, 0.521);
    position: absolute;
    top: 0;
    left: 0;
    display: flex;
    align-items: center;
    justify-content: center;
    flex-direction: column;
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