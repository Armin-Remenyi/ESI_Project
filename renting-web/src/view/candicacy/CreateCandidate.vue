<template>
  <div>
    <div>
      <main class="py-20">
        <div class="container mx-auto w-30">
          <form class="rounded-lg bg-gray-200 p-10 shadow-lg">
            <header class="pb-10">
              <div class="container mx-auto w-30">
                <h1 class="text-3xl font-bold">Apply as candidate to listing nr {{ this.$route.params.id }}</h1>
              </div>
            </header>

            <div v-if="this.showError" class="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded relative"
                 role="alert">
              <strong class="font-bold">Error!</strong>
              <span class="block sm:inline"> Please fill all candidate information</span>
            </div>
            <div class="my-5 text-sm">
              <label for="candidacyid" class="block text-black">Candidate Id</label>
              <input type="number" autofocus id="candidacyid"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-200 w-full" placeholder="candidacyid"
                     :disabled="true"
                     v-model="candidate.candidacyid"/>
            </div>
            <div class="my-5 text-sm">
              <label for="userid" class="block text-black">User Id</label>
              <input type="number" autofocus id="userid"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-200 w-full" placeholder="userid"
                     :disabled="true"
                     v-model="candidate.userid"/>
            </div>
            <div class="my-5 text-sm">
              <label for="date" class="block text-black">Date</label>
              <input type="text" autofocus id="date"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-200 w-full" placeholder="date"
                     :disabled="true"
                     v-model="candidate.date"/>
            </div>

            <div class="my-5 text-sm">
              <label for="status" class="block text-black">Status</label>
              <input type="text" autofocus id="status"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-200 w-full" placeholder="status"
                     :disabled="true"
                     v-model="candidate.status"/>
            </div>
            <button
                type="button"
                class="border border-gray-700 bg-gray-700 text-white rounded-md px-4 py-2 m-2 uppercase transition duration-500 ease select-none hover:bg-gray-800 focus:outline-none focus:shadow-outline"
                @click="this.apply()">
              Apply
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
  name: "CreateCandidate",
  data() {
    return {
      showError: false,
      candidate: {
        candidacyid: Math.floor(Math.random() * 100) + 1,
        userid: Math.floor(Math.random() * 5) + 1, // TODO: Change to user under session
        property: "House",
        listingid: this.$route.params.id,
        date: "2023-12-20",
        status: "APPROVED",  // TODO: Change hardcore to background
      },
    };
  },
  methods: {
    cancel() {
      this.$router.push("/api/listing/" + this.$route.params.id);
    },
    apply() {
      if (
          !this.candidate.candidacyid
          || !this.candidate.userid
          || !this.candidate.property
          || !this.candidate.listingid
          || !this.candidate.date
          || !this.candidate.status
      ) {
        this.showError = true;
        return;
      } else {
        this.showError = false;
      }

      fetch(`http://localhost:8081/api/candidacies`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(this.candidate),
      })
          .then(() => {
            this.$router.push("/api/listing/" + this.$route.params.id);
          })
          .catch((e) => {
            console.log(e);
          });

    },
  },
};
</script>