<template>
    <div>
      <main class="py-20">
        <div class="container mx-auto w-30">
          <div class="rounded-lg bg-gray-200 p-10 shadow-lg">
            <header class="pb-10">
              <div class="flex justify-between">
                <div class="container mx-auto w-30">
                  <h1 class="text-3xl font-bold">All candidacies</h1>
                </div>
                <div class="text-right">
                  <button
                      type="button"
                      class="border border-gray-700 bg-gray-700 text-white rounded-md px-4 py-2 m-2 uppercase transition duration-500 ease select-none hover:bg-gray-800 focus:outline-none focus:shadow-outline"
                      @click="this.all()">
                    All candidacies
                  </button>
                </div>
              </div>
            </header>
            <div class="flex flex-col">
              <div class="-mx-4 -my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
                <div class="inline-block min-w-full py-2 align-middle md:px-6 lg:px-8">
                  <div class="overflow-hidden border border-gray-200 dark:border-gray-700 md:rounded-lg">
                    <table class="min-w-full divide-y divide-gray-200 dark:divide-gray-700">
                      <thead class="bg-gray-50 dark:bg-gray-800">
                      <tr>
                        <TableHeaderCellElement value="Candidacy Id"/>
                        <TableHeaderCellElement value="User Id"/>
                        <TableHeaderCellElement value="Property"/>
                        <TableHeaderCellElement value="Date"/>
                        <TableHeaderCellElement value="Status"/>
                        <TableHeaderCellElement value=""/>
                        <TableHeaderCellElement value=""/>
                        <TableHeaderCellElement value=""/>
                      </tr>
                      </thead>
                      <tbody class="bg-white divide-y divide-gray-200 dark:divide-gray-700 dark:bg-gray-900">
                      <tr>
                        <TableDataCellElement :value="candidacy.candidacyid"/>
                        <TableDataCellElement :value="candidacy.userid"/>
                        <TableDataCellElement :value="candidacy.property"/>
                        <TableDataCellElement :value="candidacy.date"/>
                        <TableDataCellElement :value="candidacy.status"/>
                        <td class="px-4 py-4 text-md font-medium font-bold text-gray-500 text-left dark:text-gray-300 whitespace-nowrap">
                          <button
                              type="button"
                              class="border border-gray-700 bg-gray-700 text-white rounded-md px-4 py-2 m-2 uppercase transition duration-500 ease select-none hover:bg-gray-800 focus:outline-none focus:shadow-outline"
                              @click="this.update(candidacy.candidacyid)">
                            change
                          </button>
                        </td>
                        <td class="px-4 py-4 text-md font-medium font-bold text-gray-500 text-left dark:text-gray-300 whitespace-nowrap">
                          <button
                              type="button"
                              class="border border-gray-700 bg-gray-700 text-white rounded-md px-4 py-2 m-2 uppercase transition duration-500 ease select-none hover:bg-gray-800 focus:outline-none focus:shadow-outline"
                              @click="this.delete(candidacy.candidacyid)">
                            delete
                          </button>
                        </td>
                      </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </main>
    </div>
  </template>
  
  <script>
  
  import TableHeaderCellElement from "@/Components/TableHeaderCellElement";
  import TableDataCellElement from "@/Components/TableDataCellElement";
  
  export default {
    name: "CandidacyView",
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
    props: {
      id: {
        type: Number,
        required: true
      }
    },
    components: {
      TableDataCellElement,
      TableHeaderCellElement
    },
    methods: {
        fetchCandidacy() {
        console.log('222222', this.$route.params.id)
        fetch(`http://localhost:8081/api/candidacies/` + this.$route.params.id)
            .then((response) => response.json())
            .then((data) => (this.listing = data))
            .catch((err) => console.log(err.message));
      },
      delete(id) {
        console.log("id", id)
        fetch(`http://localhost:8081/api/candidacies/${id}`, {
          method: "DELETE",
          headers: {
            "Content-Type": "application/json",
          },
        })
            .then(() => {
              this.all()
            })
            .catch((e) => {
              console.log(e);
            });
      },
      update(id) {
        this.$router.push("/api/updatecandidacy/" + id);
      },
      all() {
        this.$router.push("/api/allcandidacies");
      },
    },
    mounted() {
      this.fetchCandidacy();
    },
  };
  </script>