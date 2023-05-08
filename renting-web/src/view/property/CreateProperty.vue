<template>
  <div>
    <div>
      <main class="py-20">
        <div class="container mx-auto w-30">
          <form class="rounded-lg bg-gray-200 p-10 shadow-lg">
            <header class="pb-10">
              <div class="container mx-auto w-30">
                <h1 class="text-3xl font-bold">Create new property</h1>
              </div>
            </header>

            <div v-if="this.showError" class="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded relative"
                 role="alert">
              <strong class="font-bold">Error!</strong>
              <span class="block sm:inline"> Please fill all property information</span>
            </div>
            <div class="my-5 text-sm">
              <label for="propertyid" class="block text-black">Property Id</label>
              <input type="number" autofocus id="propertyid"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-200 w-full" placeholder="propertyid"
                     :disabled="true"
                     v-model="property.propertyid"/>
            </div>

            <div class="my-5 text-sm">
              <label for="size" class="block text-black">Size</label>
              <input type="number" autofocus id="size"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="size"
                     v-model="property.size"/>
            </div>

            <div class="my-5 text-sm">
              <label for="balcony" class="block text-black">Balcony</label>
              <input type="text" autofocus id="balcony"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="balcony"
                     v-model="property.balcony"/>
            </div>

            <div class="my-5 text-sm">
              <label for="address" class="block text-black">Address</label>
              <input type="text" autofocus id="address"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="address"
                     v-model="property.address"/>
            </div>

            <div class="my-5 text-sm">
              <label for="floor" class="block text-black">Floor</label>
              <input type="number" autofocus id="floor"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="floor"
                     v-model="property.floor"/>
            </div>

            <div class="my-5 text-sm">
              <label for="rooms" class="block text-black">Number of rooms</label>
              <input type="number" autofocus id="rooms"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="rooms"
                     v-model="property.rooms"/>
            </div>

            <div class="my-5 text-sm">
              <label for="parking" class="block text-black">Parking</label>
              <input type="text" autofocus id="parking"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="parking"
                     v-model="property.parking"/>
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
  name: "CreateProperty",
  data() {
    return {
      showError: false,
      property: {
        propertyid: Math.floor(Math.random() * 100) + 1,
        size: "",
        balcony: "",
        address: "",
        floor: "",
        rooms: "",
        parking: "",
      },
    };
  },
  methods: {
    cancel() {
      this.$router.push("/api/allproperties");
    },
    create() {

      if (
          !this.property.propertyid
          || !this.property.size
          || !this.property.balcony
          || !this.property.address
          || !this.property.floor
          || !this.property.rooms
          || !this.property.parking
      ) {
        this.showError = true;
        return;
      } else {
        this.showError = false;
      }

      fetch(`http://localhost:8084/api/properties`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(this.property),
      })
          .then(() => {
            this.$router.push("/api/property/" + this.property.propertyid);
          })
          .catch((e) => {
            console.log(e);
          });

    },
  },
};
</script>