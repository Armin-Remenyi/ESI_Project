<template>
  <div>
    <div>
      <main class="py-20">
        <div class="container mx-auto w-30">
          <form class="rounded-lg bg-gray-200 p-10 shadow-lg">
            <header class="pb-10">
              <div class="container mx-auto w-30">
                <h1 class="text-3xl font-bold">Update listing with id {{ this.listing.listingId }}</h1>
              </div>
            </header>
            <div class="my-5 text-sm">
              <label for="propertyId" class="block text-black">Property Id</label>
              <input type="number" autofocus id="propertyId"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-200 w-full" placeholder="Username"
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
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="Size"
                     v-model="listing.status"/>
            </div>

            <div class="my-5 text-sm">
              <label for="description" class="block text-black">Description</label>
              <input type="description" autofocus id="description"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="Size"
                     v-model="listing.description"/>
            </div>

            <button
                type="button"
                class="border border-gray-700 bg-gray-700 text-white rounded-md px-4 py-2 m-2 uppercase transition duration-500 ease select-none hover:bg-gray-800 focus:outline-none focus:shadow-outline"
                @click="this.update(listing.listingId)">
              Update
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
  name: "UpdateListing",
  data() {
    return {
      listing: {
        listingId: "",
        propertyId: "",
        price: "",
        size: "",
        status: "",
        description: "",
      },
    };
  },
  methods: {
    fetchListing() {
      fetch(`http://localhost:8087/api/listing/` + this.$route.params.id)
          .then((response) => response.json())
          .then((data) => (this.listing = data))
          .catch((err) => console.log(err.message));
    },
    cancel() {
      this.$router.push("/api/listing/" + this.$route.params.id);
    },
    update(id) {
      fetch(`http://localhost:8087/api/listing/${id}`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(this.listing),
      })
          .then(() => {
            this.$router.push("/api/listing/" + id);
          })
          .catch((e) => {
            console.log(e);
          });

    },
  },
  mounted() {
    this.fetchListing();
  },
};
</script>