<template>
  <div class="search-box">
    <input type="text" id="search-input" placeholder="Search by genre, artist, or song...">
    <button id="search-button">Search</button>
    <div class="upload-counter">
    </div>
  </div>
</template>

<script>

</script>


<style scoped>
.search-box {
    text-align: center;
    margin-top: 20px;
}

#search-input {
    padding: 10px;
    width: 30%;
    border: 1px solid #ccc;
    border-radius: 5px;
    font-size: 16px;
}

#search-button {
    padding: 10px 20px;
    background-color: #333;
    color: #fff;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    font-size: 16px;
}

#search-button:hover {
    background-color: #555;
}


</style>