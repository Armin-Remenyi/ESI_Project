<template>
  <div>
    <div>
      <main class="py-20">
        <div class="container mx-auto w-30">
          <form class="rounded-lg bg-gray-200 p-10 shadow-lg">
            <header class="pb-10">
              <div class="container mx-auto w-30">
                <h1 class="text-3xl font-bold">Update handover with id {{ this.handover.handoverid }}</h1>
              </div>
            </header>
            <div v-if="this.showError" class="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded relative"
                 role="alert">
              <strong class="font-bold">Error!</strong>
              <span class="block sm:inline"> Please fill all handover information</span>
            </div>
            <div class="my-5 text-sm">
              <label for="handoverid" class="block text-black">Handover Id</label>
              <input type="number" autofocus id="handoverid"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-200 w-full" placeholder="handoverid"
                     :disabled="true"
                     v-model="handover.handoverid"/>
            </div>

            <div class="my-5 text-sm">
              <label for="date" class="block text-black">Date</label>
              <input type="text" autofocus id="date"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-200 w-full" placeholder="date"
                     :disabled="true"
                     v-model="handover.date"/>
            </div>

            <div class="my-5 text-sm">
              <label for="keys" class="block text-black">Keys</label>
              <input type="text" autofocus id="keys"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="keys"
                     v-model="handover.keys"/>
            </div>
            <div class="my-5 text-sm">
              <label for="coldwater" class="block text-black">Cold water</label>
              <input type="text" autofocus id="coldwater"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="coldwater"
                     v-model="handover.coldwater"/>
            </div>
            <div class="my-5 text-sm">
              <label for="hotwater" class="block text-black">Hot water</label>
              <input type="text" autofocus id="hotwater"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="hotwater"
                     v-model="handover.hotwater"/>
            </div>

            <div class="my-5 text-sm">
              <label for="status" class="block text-black">Status</label>
              <input type="text" autofocus id="status"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-200 w-full" placeholder="status"
                     :disabled="true"
                     v-model="handover.status"/>
            </div>

            <div class="my-5 text-sm">
              <label for="signatures" class="block text-black">Signatures</label>
              <input type="text" autofocus id="signatures"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-200 w-full" placeholder="signatures"
                     :disabled="true"
                     v-model="handover.signatures"/>
            </div>

            <button
                type="button"
                class="border border-gray-700 bg-gray-700 text-white rounded-md px-4 py-2 m-2 uppercase transition duration-500 ease select-none hover:bg-gray-800 focus:outline-none focus:shadow-outline"
                @click="this.update(handover.handoverid)">
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
  name: "UpdateHandover",
  data() {
    return {
      showError: false,
      handover: {
        handoverid: "",
        date: "",
        keys: "",
        coldwater: "",
        hotwater: "",
        status: "",
        signatures: "",
      },
    };
  },
  methods: {
    fetchHandover() {
      fetch(`http://localhost:8083/api/handovers/` + this.$route.params.id)
          .then((response) => response.json())
          .then((data) => (this.handover = data))
          .catch((err) => console.log(err.message));
    },
    cancel() {
      this.$router.push("/api/handover/" + this.$route.params.id);
    },
    update(id) {

      if (
          !this.handover.keys
          || !this.handover.coldwater
          || !this.handover.hotwater
      ) {
        this.showError = true;
        return;
      } else {
        this.showError = false;
      }

      fetch(`http://localhost:8083/api/handovers/${id}`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(this.handover),
      })
          .then(() => {
            this.$router.push("/api/handover/" + this.$route.params.id);
          })
          .catch((e) => {
            console.log(e);
          });
    },
  },
  mounted() {
    this.fetchHandover();
  },
};
</script>