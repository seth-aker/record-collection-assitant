<template>
  <footer class="footer">
    <div class="container">
      <p>&copy; {{ currentYear }} Sleeves - Your Record Collection</p>
    </div>
  </footer>
</template>

<script>
export default {
  data() {
    return {
      currentYear: new Date().getFullYear(),
    };
  },
};
</script>

<style scoped>

</style>