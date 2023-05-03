<template>
  <div>
    <main class="py-20">
      <div class="container mx-auto w-30">
        <div class="rounded-lg bg-gray-200 p-10 shadow-lg">
          <header class="pb-10">
            <div class="flex justify-between">
              <div class="container mx-auto w-30">
                <h1 class="text-3xl font-bold">All listings</h1>
              </div>
              <div class="text-right">
                <button
                    type="button"
                    class="border border-gray-700 bg-gray-700 text-white rounded-md px-4 py-2 m-2 uppercase transition duration-500 ease select-none hover:bg-gray-800 focus:outline-none focus:shadow-outline"
                    @click="this.create()">
                  new
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
                      <TableHeaderCellElement value="Listing Id"/>
                      <TableHeaderCellElement value="Property Id"/>
                      <TableHeaderCellElement value="Price"/>
                      <TableHeaderCellElement value="Size"/>
                      <TableHeaderCellElement value="Status"/>
                      <TableHeaderCellElement value="Description"/>
                      <TableHeaderCellElement value=""/>
                      <TableHeaderCellElement value=""/>
                      <TableHeaderCellElement value=""/>
                    </tr>
                    </thead>
                    <tbody class="bg-white divide-y divide-gray-200 dark:divide-gray-700 dark:bg-gray-900"
                           v-for="listing in listings" :key="listing.listingId">
                    <tr>
                      <TableDataCellElement :value="listing.listingId"/>
                      <TableDataCellElement :value="listing.propertyId"/>
                      <TableDataCellElement :value="listing.price"/>
                      <TableDataCellElement :value="listing.size"/>
                      <TableDataCellElement :value="listing.status"/>
                      <TableDataCellElement :value="listing.description"/>
                      <td class="px-4 py-4 text-md font-medium font-bold text-gray-500 text-left dark:text-gray-300 whitespace-nowrap">
                        <button
                            type="button"
                            class="border border-gray-700 bg-gray-700 text-white rounded-md px-4 py-2 m-2 uppercase transition duration-500 ease select-none hover:bg-gray-800 focus:outline-none focus:shadow-outline"
                            @click="this.open(listing.listingId)">
                          open
                        </button>
                      </td>
                      <td class="px-4 py-4 text-md font-medium font-bold text-gray-500 text-left dark:text-gray-300 whitespace-nowrap">
                        <button
                            type="button"
                            class="border border-gray-700 bg-gray-700 text-white rounded-md px-4 py-2 m-2 uppercase transition duration-500 ease select-none hover:bg-gray-800 focus:outline-none focus:shadow-outline"
                            @click="this.update(listing.listingId)">
                          change
                        </button>
                      </td>
                      <td class="px-4 py-4 text-md font-medium font-bold text-gray-500 text-left dark:text-gray-300 whitespace-nowrap">
                        <button
                            type="button"
                            class="border border-gray-700 bg-gray-700 text-white rounded-md px-4 py-2 m-2 uppercase transition duration-500 ease select-none hover:bg-gray-800 focus:outline-none focus:shadow-outline"
                            @click="this.delete(listing.listingId)">
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
import TableDataCellElement from "@/Components/TableDataCellElement";
import TableHeaderCellElement from "@/Components/TableHeaderCellElement";

export default {
  name: "AllListings",
  data() {
    return {
      listings: [],
    };
  },
  components: {
    TableDataCellElement,
    TableHeaderCellElement
  },
  methods: {
    fetchListings() {
      fetch(`http://localhost:8087/api/listing`)
          .then((response) => response.json())
          .then((data) => (this.listings = data))
          .catch((err) => console.log(err.message));
    },
    delete(id) {
      fetch(`http://localhost:8087/api/listing/${id}`, {
        method: "DELETE",
        headers: {
          "Content-Type": "application/json",
        },
      })
          .then(() => {
            this.fetchListings();
          })
          .catch((e) => {
            console.log(e);
          });
    },
    open(id) {
      this.$router.push("/api/listing/" + id);
    },
    update(id) {
      this.$router.push("/api/updatelisting/" + id);
    },
    create() {
      this.$router.push("/api/createlisting");
    },
  },
  mounted() {
    this.fetchListings();
    console.log("mounted");
  },
};
</script>