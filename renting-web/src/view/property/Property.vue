<template>
  <div>
    <main class="py-20">
      <div class="container mx-auto w-30">
        <div class="rounded-lg bg-gray-200 p-10 shadow-lg">
          <header class="pb-10">
            <div class="flex justify-between">
              <div class="container mx-auto w-30">
                <h1 class="text-3xl font-bold">Property nr {{ this.$route.params.id }}</h1>
              </div>
              <div class="text-right">
                <button
                    type="button"
                    class="border border-gray-700 bg-gray-700 text-white rounded-md px-4 py-2 m-2 uppercase transition duration-500 ease select-none hover:bg-gray-800 focus:outline-none focus:shadow-outline"
                    @click="this.all()">
                  All properties
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
                      <TableHeaderCellElement value="Property Id"/>
                      <TableHeaderCellElement value="Size"/>
                      <TableHeaderCellElement value="Balcony"/>
                      <TableHeaderCellElement value="Address"/>
                      <TableHeaderCellElement value="Floor"/>
                      <TableHeaderCellElement value="Rooms"/>
                      <TableHeaderCellElement value="Parking"/>
                      <TableHeaderCellElement value=""/>
                      <TableHeaderCellElement value=""/>
                      <TableHeaderCellElement value=""/>
                    </tr>
                    </thead>
                    <tbody class="bg-white divide-y divide-gray-200 dark:divide-gray-700 dark:bg-gray-900">
                    <tr>
                      <TableDataCellElement :value="property.propertyid"/>
                      <TableDataCellElement :value="property.size"/>
                      <TableDataCellElement :value="property.balcony"/>
                      <TableDataCellElement :value="property.address"/>
                      <TableDataCellElement :value="property.floor"/>
                      <TableDataCellElement :value="property.rooms"/>
                      <TableDataCellElement :value="property.parking"/>
                      <td class="px-4 py-4 text-md font-medium font-bold text-gray-500 text-left dark:text-gray-300 whitespace-nowrap">
                        <button
                            type="button"
                            class="border border-gray-700 bg-gray-700 text-white rounded-md px-4 py-2 m-2 uppercase transition duration-500 ease select-none hover:bg-gray-800 focus:outline-none focus:shadow-outline"
                            @click="this.update(property.propertyid)">
                          change
                        </button>
                      </td>
                      <td class="px-4 py-4 text-md font-medium font-bold text-gray-500 text-left dark:text-gray-300 whitespace-nowrap">

                        <button
                            v-if="!property.contractId"
                            type="button"
                            class="border border-gray-700 bg-gray-700 text-white rounded-md px-4 py-2 m-2 uppercase transition duration-500 ease select-none hover:bg-gray-800 focus:outline-none focus:shadow-outline"
                            @click="this.createListing(property.propertyid)">
                          create listing
                        </button>
                      </td>
                      <td class="px-4 py-4 text-md font-medium font-bold text-gray-500 text-left dark:text-gray-300 whitespace-nowrap">
                        <button
                            type="button"
                            class="border border-gray-700 bg-gray-700 text-white rounded-md px-4 py-2 m-2 uppercase transition duration-500 ease select-none hover:bg-gray-800 focus:outline-none focus:shadow-outline"
                            @click="this.delete(property.propertyid)">
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
  name: "PropertyView",
  data() {
    return {
      property: {
        propertyid: "",
        size: "",
        balcony: "",
        address: "",
        floor: "",
        rooms: "",
        parking: "",
      },
    };
  },
  components: {
    TableDataCellElement,
    TableHeaderCellElement
  },
  methods: {
    fetchProperty() {
      fetch(`http://localhost:8084/api/properties/` + this.$route.params.id)
          .then((response) => response.json())
          .then((data) => (this.property = data))
          .catch((err) => console.log(err.message));
    },
    delete(id) {
      fetch(`http://localhost:8084/api/properties/${id}`, {
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
      this.$router.push("/api/updateproperty/" + id);
    },
    all() {
      this.$router.push("/api/allproperties");
    },
    createListing(id) {
      this.$router.push("/api/createlisting/" + id);
    },
    openContract(id) {
      this.$router.push("/api/contract/" + id);
    },
  },
  mounted() {
    this.fetchProperty();
  },
};
</script>