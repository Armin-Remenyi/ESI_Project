<template>
  <div class="AllListings">
    <div id="listings-list">
      <h1>All Listings</h1>
      <ul>
        <div class="item" v-for="listing in listings" :key="listing.id">
          <a class="singleproduct" :href="'/api/listing/' + listing.id">
            <span class="code"> <b>Code:</b> {{ listing.listingId }} </span><br/>
            <span class="name"> <b>Name:</b> {{ listing.propertyId }} </span> <br/>
            <span class="price"> <b>Price:</b> {{ listing.price }} </span> <br/>
            <span class="description"> <b>Description:</b> {{ listing.description }} </span> <br/>
            <span class="name"> <b>Name:</b> {{ listing.size }} </span> <br/>
            <span class="name"> <b>Name:</b> {{ listing.status }} </span> <br/>
          </a>
        </div>
      </ul>
    </div>
  </div>
</template>


<script>
export default {
  name: "AllListings",
  data() {
    return {
      listings: [],
    };
  },
  methods: {
    fetchProducts() {
      fetch(`http://localhost:8087/api/listing`)
          .then((response) => response.json())
          .then((data) => (this.listings = data))
          .catch((err) => console.log(err.message));
    },
  },
  mounted() {
    this.fetchProducts();
    console.log("mounted");
  },
};
</script>

<style scoped>
h1 {
  font-size: 20px;
}

a {
  text-decoration: none;
}

a:hover {
  text-decoration: underline;
}

.item {
  background: rgb(189, 212, 199);
  margin-bottom: 5px;
  padding: 3px 5px;
  border-radius: 10px;
}

#post-list {
  background: #6e8b97;
  box-shadow: 1px 2px 3px rgba(0, 0, 0, 0.2);
  margin-bottom: 30px;
  padding: 10px 20px;
  margin: auto;
  width: 50%;
  border-radius: 20px;
}

#post-list ul {
  padding: 0;
}

#post-list li {
  display: inline-block;
  margin-right: 10px;
  margin-top: 10px;
  padding: 20px;
  background: rgba(255, 255, 255, 0.7);
}
</style>