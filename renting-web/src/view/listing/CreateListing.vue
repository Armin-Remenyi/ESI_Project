<template>
  <div>
    <div>
      <main class="py-20">
        <div class="container mx-auto w-30">
          <form class="rounded-lg bg-gray-200 p-10 shadow-lg">
            <header class="pb-10">
              <div class="container mx-auto w-30">
                <h1 class="text-3xl font-bold">Create new listing</h1>
              </div>
            </header>

            <div v-if="this.showError" class="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded relative"
                 role="alert">
              <strong class="font-bold">Error!</strong>
              <span class="block sm:inline"> Please fill all listing information</span>
            </div>
            <div class="my-5 text-sm">
              <label for="listingId" class="block text-black">Listing Id</label>
              <input type="number" autofocus id="listingId"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-200 w-full" placeholder="listingId"
                     :disabled="true"
                     v-model="listing.listingId"/>
            </div>

            <div class="my-5 text-sm">
              <label for="propertyId" class="block text-black">Property Id</label>
              <input type="number" autofocus id="propertyId"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-200 w-full" placeholder="propertyId"
                     :disabled="true"
                     v-model="listing.propertyId"/>
            </div>

            <div class="my-5 text-sm">
              <label for="price" class="block text-black">Price</label>
              <input type="number" autofocus id="price"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="Price"
                     v-model="listing.price"/>
            </div>

            <div class="my-5 text-sm">
              <label for="size" class="block text-black">Size</label>
              <input type="size" autofocus id="size"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="Size"
                     v-model="listing.size"/>
            </div>

            <div class="my-5 text-sm">
              <label for="status" class="block text-black">Status</label>
              <input type="status" autofocus id="status"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="status"
                     v-model="listing.status"/>
            </div>

            <div class="my-5 text-sm">
              <label for="description" class="block text-black">Description</label>
              <input type="description" autofocus id="description"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="description"
                     v-model="listing.description"/>
            </div>

            <button
                type="button"
                class="border border-gray-700 bg-gray-700 text-white rounded-md px-4 py-2 m-2 uppercase transition duration-500 ease select-none hover:bg-gray-800 focus:outline-none focus:shadow-outline"
                @click="this.create()">
              Create
            </button>

            <button
                type="button"
                class="border border-gray-700 bg-gray-700 text-white rounded-md px-4 py-2 m-2 uppercase transition duration-500 ease select-none hover:bg-gray-800 focus:outline-none focus:shadow-outline"
                @click="this.cancel()">
              Cancel
            </button>

          </form>
        </div>
      </main>
    </div>
  </div>
</template>

<script>

export default {
  name: "CreateListing",
  data() {
    return {
      showError: false,
      listing: {
        listingId: "",
        propertyId: "",
        contractId: null,
        price: "",
        size: "",
        status: "",
        description: "",
      },
    };
  },
  methods: {
    cancel() {
      this.$router.push("/api/alllistings");
    },
    fetchProperty() {
      fetch(`http://localhost:8084/api/properties/` + this.$route.params.id)
          .then((response) => response.json())
          .then((data) => {
            this.listing.listingId = Math.floor(Math.random() * 100) + 1
            this.listing.propertyId = this.$route.params.id
            this.listing.price = data.price
            this.listing.size = data.size
            this.listing.status = "ACTIVE"
          })
          .catch((err) => console.log(err.message));
    },
    create() {
      if (
          !this.listing.listingId
          || !this.listing.propertyId
          || !this.listing.price
          || !this.listing.size
          || !this.listing.status
          || !this.listing.description
      ) {
        this.showError = true;
        return;
      } else {
        this.showError = false;
      }
      fetch(`http://localhost:8087/api/listing`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(this.listing),
      })
          .then(() => {
            this.$router.push("/api/listing/" + this.listing.listingId);
          })
          .catch((e) => {
            console.log(e);
          });

    },
  },
  mounted() {
    this.fetchProperty();
  },
};
</script>