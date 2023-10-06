<template>
  <!-- Container for the entire slideshow -->
  <div class="slideshow" >
    <!-- Container for the green box -->
    <div class="green-box">
      <!-- Heading for the slideshow -->
      <h2>{{name}}</h2>
    </div>
    <!-- Container for the carousel and navigation buttons -->
    <div class="carousel-container">
      <!-- Left arrow button for navigating to previous images -->
      <button @click="slideLeft" class="arrow left-arrow">&lt;</button>
      <!-- Container for the slides -->
      <div class="slides" :style="`transform: translateX(-${currentIndex * 20}%)`">
        <!-- Iterate through items to display each image and title -->
        <div class="slide" v-for="(item, index) in items" :key="index">
            <!-- display for link to trending collections-->
           <router-link v-if="name === 'TRENDING COLLECTIONS'" :to="{name: 'collection-view', params: {collectionId: item.id}}"><img :src="item.imgUrl" :alt="item.name" class="image"/></router-link>
           <router-link v-if="name === 'TOP 25 RECORDS'" :to="{name: 'record-page', params: {recordId: item.id}}"><img :src="item.imgUrl" :alt="item.name" class="image"/></router-link>
          <!-- Container for the album title text -->
          <div class="album-title">
            <!-- Display the album title text -->
            <div class="album-title-text">{{ item.name }}</div>
          </div>
        </div>
      </div>
      <!-- Right arrow button for navigating to next images -->
      <button @click="slideRight" class="arrow right-arrow">&gt;</button>
    </div>
  </div>
</template>

<script>

export default {
  components: {  },
  name: 'SlideShow',
  props: ['items',
            'name'
  ],

        
  data() {
    return {
     
      // An array of objects representing items with images and titles
      // Current index to keep track of which images are displayed
      currentIndex: 0,
     
    };
  },
  created() {
    
  },
  computed: {
    // Calculate the maximum index based on the number of items
    maxIndex() {
      return this.items.length - 1;
    },
  },
   methods: {
    // Method to slide to the left and display previous images
    slideLeft() {
      if (this.currentIndex > 0) {
        this.currentIndex--;
      } else {
        // Wrap around to the end if at the beginning
        this.currentIndex = this.maxIndex;
      }
    },
    // Method to slide to the right and display next images
    slideRight() {
      if (this.currentIndex < this.maxIndex) {
        this.currentIndex++;
      } else {
        // Wrap around to the beginning if at the end
        this.currentIndex = 0;
      }
    },
    
  },
};
</script>

<style scoped>
/* Your existing styles for the slideshow go here */

.carousel-container {
  /* Flex container to center and hide overflowing content */
  display: flex;
  align-items: center;
  justify-content: center;
  position: relative;
  overflow: hidden;
}

.slides {
  /* Flex container for sliding images with a transition effect */
  display: flex;
  transition: transform 0.5s ease-in-out;
}

.slide {
  /* Style for each individual slide */
  flex: 0 0 20%; /* Adjust the width to display 5 images at a time */
  padding: 10px;
  box-sizing: border-box;
  text-align: center;
  overflow: hidden; /* Hide overflowing content */
  position: relative;
  transition: transform 0.5s ease-in-out; /* Add sliding transition */
}

.image {
  /* Style for images within slides */
  width: 100%; /* Ensure all images have the same width */
  max-height: 100%; /* Maintain aspect ratio */
  object-fit: cover; /* Cover the container */
  transition: transform 0.5s ease-in-out; /* Add sliding transition */
}

.arrow {
  /* Style for navigation arrow buttons */
  font-size: 70px;
  background-color: transparent;
  border: none;
  color: white;
  cursor: pointer;
  position: absolute;
  top: 50%;
  transform: translateY(-50%);
  padding: 10px;
  z-index: 1;
}

.left-arrow {
  /* Style for the left arrow button */
  left: 10px;
  color: #E00A86;
   background: linear-gradient(180deg, rgba(239,241,63,0.7455357142857143) 37%, rgba(224,10,134,0.7231267507002801) 100%);
  border-radius: 50px;
 
}

.right-arrow {
  /* Style for the right arrow button */
  right: 10px;
  color: #E00A86;
 background: linear-gradient(180deg, rgba(239,241,63,0.7455357142857143) 37%, rgba(224,10,134,0.7231267507002801) 100%);
  border-radius: 50px;
}
h2 {
      font-family: 'KEEPT___', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  font-size: 50px;
  color: #40c5a4;
  margin-top: 230px;
  -webkit-text-stroke:1.5px #E00A86;
}

.green-box {
  background-color: #40c5a4;
  padding: 20px; /* Add padding for spacing */
  text-align: center; /* Center the text horizontally */
  margin-bottom: 10px;
  opacity: 90%;
}

/* Style for the white text (h2) */
.green-box h2 {
  font-family: 'KEEPT___', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  font-size: 60px;
  color: #eff13f;
  margin: 0; 
  -webkit-text-stroke:0.8px #E00A86;
}

.album-title-text {
  font-family: 'KEEPT___', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  color: #eff13f;
}


</style>