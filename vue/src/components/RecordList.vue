<template>
  <div class="record-list">
    <h2>Records</h2>
    <ul>
      <li v-for="record in records" :key="record.id">
        <div class="record-info">
          <img :src="record.coverImageUrl" alt="Album Cover">
          <div class="record-details">
            <h3>{{ record.title }}</h3>
            <p>{{ record.artist }}</p>
            <p>{{ record.genre }}</p>
            <p>{{ record.year }}</p>
          </div>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  props: {
    records: {
      type: Array,
      required: true,
    },
  },
};
</script>

<style scoped>
.record-list {
  margin-top: 20px;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  margin-bottom: 20px;
  border: 1px solid #ddd;
  padding: 10px;
  display: flex;
  align-items: center;
  background-color: #f9f9f9;
}

.record-info {
  display: flex;
  align-items: center;
}

img {
  width: 80px;
  height: 80px;
  margin-right: 20px;
}

.record-details {
  flex: 1;
}

h2 {
  font-size: 24px;
}

h3 {
  font-size: 18px;
  margin: 0;
}

p {
  margin: 5px 0;
}
</style>