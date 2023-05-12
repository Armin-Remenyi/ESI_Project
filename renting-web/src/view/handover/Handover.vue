<template>
  <div>
    <main class="py-20">
      <div class="container mx-auto w-30">
        <div class="rounded-lg bg-gray-200 p-10 shadow-lg">
          <header class="pb-10">
            <div class="flex justify-between">
              <div class="container mx-auto w-30">
                <h1 class="text-3xl font-bold">Handover nr {{ this.$route.params.id }}</h1>
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
                      <TableHeaderCellElement value="Handover Id"/>
                      <TableHeaderCellElement value="Date"/>
                      <TableHeaderCellElement value="Keys"/>
                      <TableHeaderCellElement value="Cold water"/>
                      <TableHeaderCellElement value="Hot water"/>
                      <TableHeaderCellElement value="Status"/>
                      <TableHeaderCellElement value="Signatures"/>
                    </tr>
                    </thead>
                    <tbody class="bg-white divide-y divide-gray-200 dark:divide-gray-700 dark:bg-gray-900">
                    <tr>
                      <TableDataCellElement :value="handover.handoverid"/>
                      <TableDataCellElement :value="handover.date"/>
                      <TableDataCellElement :value="handover.keys"/>
                      <TableDataCellElement :value="handover.coldwater"/>
                      <TableDataCellElement :value="handover.hotwater"/>
                      <TableDataCellElement :value="handover.status"/>
                      <TableDataCellElement :value="handover.signatures"/>
                    </tr>
                    </tbody>
                  </table>
                </div>
                <button
                    type="button"
                    class="border border-gray-700 bg-gray-700 text-white rounded-md px-4 py-2 mt-2 uppercase transition duration-500 ease select-none hover:bg-gray-800 focus:outline-none focus:shadow-outline"
                    @click="this.update(handover.handoverid)">
                  change
                </button>
                <button
                    type="button"
                    class="border border-gray-700 bg-gray-700 text-white rounded-md px-4 py-2 ml-2 uppercase transition duration-500 ease select-none hover:bg-gray-800 focus:outline-none focus:shadow-outline"
                    @click="this.delete(handover.handoverid)">
                  delete
                </button>
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
  name: "HandoverView",
  data() {
    return {
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
  components: {
    TableDataCellElement,
    TableHeaderCellElement
  },
  methods: {
    fetchHandover() {
      fetch(`http://localhost:8083/api/handovers/` + this.$route.params.id)
          .then((response) => response.json())
          .then((data) => (this.handover = data))
          .catch((err) => console.log(err.message));
    },
    delete(id) {
      // TODO: delete handoverid from contract in backend
      fetch(`http://localhost:8083/api/handovers/${id}`, {
        method: "DELETE",
        headers: {
          "Content-Type": "application/json",
        },
      })
          .then(() => {
            this.$router.push("/api/allcontracts");
          })
          .catch((e) => {
            console.log(e);
          });
    },
    update(id) {
      this.$router.push("/api/updatehandover/" + id);
    },
  },
  mounted() {
    this.fetchHandover();
  },
};
</script>