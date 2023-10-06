<template>
  <!-- Container for the entire slideshow -->
  <div class="slideshow">
    <!-- Container for the green box -->
    <div class="green-box">
      <!-- Heading for the slideshow -->
      <h2>TOP GENRES</h2>
    </div>
    <!-- Container for the carousel and navigation buttons -->
    <div class="carousel-container">
      <!-- Left arrow button for navigating to previous images -->
      <button @click="slideLeft" class="arrow left-arrow">&lt;</button>
      <!-- Container for the slides -->
      <div class="slides" :style="`transform: translateX(-${currentIndex * 20}%)`">
        <!-- Iterate through items to display each colored square with text -->
        <div class="slide" v-for="(item, index) in items" :key="index" >
          <!-- Display the colored square with text -->
          <div class="colored-square" @click="searchByGenre(item.title)" >
            <div class="square-text">{{ item.title }}</div>
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
  name: 'TopGenreSlideshow',
  data() {
    return {
      // An array of objects representing items with titles
      items: [
        { title: 'ROCK' },
        
        { title: 'JAZZ' },
        { title: 'CLASSICAL' },
        { title: 'BLUES' },
        { title: 'POP' },
        { title: 'COUNTRY' },
        { title: 'CLASSIC ROCK' },
        { title: 'WORLD' },
        { title: 'INDIE' },
        { title: 'ALTERNATIVE' },
        // Add more genre titles as needed
      ],
      // Current index to keep track of which genres are displayed
      currentIndex: 0,
    };
  },
  computed: {
    // Calculate the maximum index based on the number of items
    maxIndex() {
      return this.items.length - 1;
    },
  },
   methods: {
    // Method to slide to the left and display previous genres
    slideLeft() {
      if (this.currentIndex > 0) {
        this.currentIndex--;
      } else {
        // Wrap around to the end if at the beginning
        this.currentIndex = this.maxIndex;
      }
    },
    // Method to slide to the right and display next genres
    slideRight() {
      if (this.currentIndex < this.maxIndex) {
        this.currentIndex++;
      } else {
        // Wrap around to the beginning if at the end
        this.currentIndex = 0;
      }
    },
    searchByGenre(genre) {
      this.$store.commit('SET_GENRE_SEARCH', genre)
      this.$router.push({name: 'search-page', query: {q: this.$store.state.sr.search,
                                                      type: this.$store.state.sr.searchType,
                                                      per_page: this.$store.state.sr.resultsPerPage,
                                                      genre: this.$store.state.sr.genre}
                        }).catch(error => {
                            if (error.name !== 'NavigationDuplicated' &&
                                !error.message.includes('Avoided redundant navigation to current location')
                                ) {
                                  console.log(error)
                                }
                            });
    }
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
  /* Flex container for sliding genres with a transition effect */
  display: flex;
  transition: transform 0.5s ease-in-out;
}

.slide {
  /* Style for each individual slide */
  flex: 0 0 18%; /* Adjust the width to display 5 squares at a time */
  padding: 10px;
  box-sizing: border-box;
  text-align: center;
  overflow: hidden; /* Hide overflowing content */
  position: relative;
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

/* Style for the green box */
.green-box {
  background-color: #40c5a4;
  padding: 20px; /* Add padding for spacing */
  text-align: center; /* Center the text horizontally */
  opacity: 90%;
  
}

.green-box h2 {
  font-family: 'KEEPT___', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
  font-size: 60px;
  color: #eff13f;
  margin: 0; 
  color: #eff13f;
  -webkit-text-stroke:0.8px #E00A86;
  
}
.colored-square {
  /* Style for the colored square with text */
  cursor: pointer;
  box-sizing: border-box;
  text-align: center;

  position: relative;
  transition: transform 0.5s ease-in-out; /* Add sliding transition */
  background-color: #40c5a4; /* Background color for the square */
  color: #fff; /* Text color */
  display: flex;
  justify-content: center;
  align-items: center;
  height: 400px; /* Set a fixed height for the square */
  font-size: 50px; /* Text font size */
}

.square-text {
  /* Style for the text inside the colored square */
  margin: 0;
   font-family: 'KEEPT___', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
    color: #eff13f;
    -webkit-text-stroke:1.5px #E00A86;
}

</style>