<template>
  <div class="footer-wrapper">
    <footer>
      <div class="footer-content">
        <p>&copy; 2023 Sleeves - Your Record Collection</p>
        <ul class="footer-links">
          <li><a href="#">Privacy Policy</a></li>
          <li><a href="#">Terms of Service</a></li>
          <li><a href="#">Contact Us</a></li>
        </ul>
      </div>
    </footer>
  </div>
</template>

<script>

</script>

<style scoped>
.footer-wrapper {

  
  display: flex;
  flex-direction: column;
}



footer {
  background-color: #333;
  color: #fff;
  text-align: center;
  width: 100%;
}

.footer-content {
  display: flex;
  flex-direction: column;
  align-items: center;
  
}

.footer-links {
  list-style: none;
  padding: 0;
  margin-top: 10px;
}

.footer-links li {
  display: inline;
  margin: 0 10px;
}

.footer-links a {
  color: #fff;
  text-decoration: none;

}


</style>