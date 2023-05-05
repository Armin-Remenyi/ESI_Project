<template>
    <div>
      <div>
        <main class="py-20">
          <div class="container mx-auto w-30">
            <form class="rounded-lg bg-gray-200 p-10 shadow-lg">
              <header class="pb-10">
                <div class="container mx-auto w-30">
                  <h1 class="text-3xl font-bold">Create new candidacy</h1>
                </div>
              </header>
              <div class="my-5 text-sm">
                <label for="candidacyid" class="block text-black">Candidacy Id</label>
                <input type="number" autofocus id="candidacyid"
                       class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="candidacyid"
                       v-model="candidacy.candidacyid"/>
              </div>
  
              <div class="my-5 text-sm">
                <label for="userid" class="block text-black">User Id</label>
                <input type="number" autofocus id="userid"
                       class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="userid"
                       v-model="candidacy.userid"/>
              </div>
  
              <div class="my-5 text-sm">
                <label for="property" class="block text-black">Property</label>
                <input type="number" autofocus id="property"
                       class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="property"
                       v-model="candidacy.property"/>
              </div>
  
              <div class="my-5 text-sm">
                <label for="date" class="block text-black">Date</label>
                <input type="number" autofocus id="date"
                       class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="date"
                       v-model="candidacy.date"/>
              </div>
  
              <div class="my-5 text-sm">
                <label for="status" class="block text-black">Status</label>
                <input type="status" autofocus id="status"
                       class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="status"
                       v-model="candidacy.status"/>
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
    name: "CreateCandidacy",
    data() {
      return {
        candidacy: {
          candidacyid: "",
          userid: "",
          property: "",
          date: "",
          status: "",
        },
      };
    },
    methods: {
      cancel() {
        this.$router.push("/api/allcandidacies");
      },
      create() {
        fetch(`http://localhost:8081/api/candidacies`, {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(this.candidacy),
        })
            .then(() => {
              this.$router.push("/api/candidacies/" + this.candidacy.candidacyid);
            })
            .catch((e) => {
              console.log(e);
            });
  
      },
    },
  };
  </script>