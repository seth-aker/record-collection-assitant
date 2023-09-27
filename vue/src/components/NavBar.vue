<template>
  <header>
    <!-- Left side menu section -->
    <nav id="menu">
      <ul>
        <li><a href="#">HOME</a></li>

      </ul>
    </nav>
  </header>
</template>

<script>

</script>

<style scoped>
.left-container {
    position: fixed;
    top: 0;
    left: 0;
    width: 250px; 

    background-color: #333;
    color: #fff;
    padding: 20px;
    box-sizing: border-box;
    overflow-y: auto;
}

/* navigation menu items */
#menu ul {
    list-style: none;
    padding: 0;
}

#menu ul li {
    margin-bottom: 40px;
}

#menu ul li a {
    text-decoration: none;
    color: #fff;
    font-weight: bold;
}
#menu {
    position: absolute;
    left: 0;
    top: 250px; 
  
    width: 200px; 
    background-color: #333;
    color: #fff;
    padding: 20px;
    box-sizing: border-box;
    overflow-y: hidden;
    z-index: 1000;
   
 
}

</style>