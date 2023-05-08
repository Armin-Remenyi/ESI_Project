<template>
  <div>
    <div>
      <main class="py-20">
        <div class="container mx-auto w-30">
          <form class="rounded-lg bg-gray-200 p-10 shadow-lg">
            <header class="pb-10">
              <div class="container mx-auto w-30">
                <h1 class="text-3xl font-bold">Create new contract with id {{ this.contract.contractid }} from listing
                  with id {{ this.$route.params.id }}</h1>
              </div>
            </header>

            <div v-if="this.showError" class="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded relative"
                 role="alert">
              <strong class="font-bold">Error!</strong>
              <span class="block sm:inline"> Please fill rent amount, pets and select tenant</span>
              <span class="absolute top-0 bottom-0 right-0 px-4 py-3">
      <svg class="fill-current h-6 w-6 text-red-500" xmlns="http://www.w3.org/2000/svg"
           viewBox="0 0 20 20">
        <title>Close</title>
        <path
            d="M14.348 5.652a1 1 0 00-1.414 0L10 8.586 6.066 4.652a1 1 0 00-1.414 1.414L8.586 10l-3.934 3.934a1 1 0 101.414 1.414L10 11.414l3.934 3.934a1 1 0 001.414-1.414L11.414 10l3.934-3.934a1 1 0 000-1.414z"
            clip-rule="evenodd" fill-rule="evenodd"></path>
      </svg>
    </span>
            </div>

            <div class="my-5 text-sm">
              <label for="price" class="block text-black">Rent amount</label>
              <input type="number" autofocus id="price"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="price"
                     v-model="contract.price"/>
            </div>

            <div class="my-5 text-sm">
              <label for="pets" class="block text-black">Pets</label>
              <input type="text" autofocus id="pets"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="pets"
                     v-model="contract.pets"/>
            </div>
            <div class="my-5 text-sm">
              <label for="propertyid" class="block text-black">Property Id</label>
              <input type="number" autofocus id="propertyid"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-200 w-full" placeholder="propertyid"
                     :disabled="true"
                     v-model="contract.propertyid"/>
            </div>

            <div class="my-5 text-sm">
              <label for="tenantid" class="block text-black">Tenant Id</label>
              <input type="number" autofocus id="tenantid"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-200 w-full" placeholder="tenantid"
                     :disabled="true"
                     v-model="contract.tenantid"/>
            </div>
            <div class="flex flex-col">
              <div class="-mx-4 -my-2 overflow-x-auto sm:-mx-6 lg:-mx-8">
                <div class="inline-block min-w-full py-2 align-middle md:px-6 lg:px-8">
                  <div class="overflow-hidden border border-gray-200 dark:border-gray-700 md:rounded-lg">
                    <table class="min-w-full divide-y divide-gray-200 dark:divide-gray-700">
                      <thead class="bg-gray-50 dark:bg-gray-800">
                      <tr>
                        <TableHeaderCellElement value="Candidate Id"/>
                        <TableHeaderCellElement value="User Id"/>
                        <TableHeaderCellElement value="Candidacy date"/>
                        <TableHeaderCellElement value="Status"/>
                        <TableHeaderCellElement value=""/>
                      </tr>
                      </thead>
                      <tbody class="bg-white divide-y divide-gray-200 dark:divide-gray-700 dark:bg-gray-900"
                             v-for="candidate in candidates" :key="candidate.candidacyid">
                      <tr>
                        <TableDataCellElement :value="candidate.candidacyid"/>
                        <TableDataCellElement :value="candidate.userid"/>
                        <TableDataCellElement :value="candidate.date"/>
                        <TableDataCellElement :value="candidate.status"/>
                        <td class="px-4 py-4 text-md font-medium font-bold text-gray-500 text-left dark:text-gray-300 whitespace-nowrap">
                          <button
                              v-if="candidate.status === 'APPROVED'"
                              type="button"
                              class="border border-gray-700 bg-gray-700 text-white rounded-md px-4 py-2 m-2 uppercase transition duration-500 ease select-none hover:bg-gray-800 focus:outline-none focus:shadow-outline"
                              @click="this.selectTenant(candidate.userid)">
                            select as tenant
                          </button>
                        </td>
                      </tr>
                      </tbody>
                    </table>
                  </div>
                </div>
              </div>
            </div>
            <div class="my-5 text-sm">
              <label for="listingid" class="block text-black">Listing Id</label>
              <input type="number" autofocus id="listingid"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-200 w-full" placeholder="listingid"
                     :disabled="true"
                     v-model="contract.listingid"/>
            </div>

            <div class="my-5 text-sm">
              <label for="status" class="block text-black">Status</label>
              <input type="text" autofocus id="status"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-200 w-full" placeholder="status"
                     :disabled="true"
                     v-model="contract.status"/>
            </div>

            <div class="my-5 text-sm">
              <label for="signing" class="block text-black">Signing</label>
              <input type="text" autofocus id="signing"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-200 w-full" placeholder="signing"
                     :disabled="true"
                     v-model="contract.signing"/>
            </div>


            <button
                type="button"
                class="border border-gray-700 bg-gray-700 text-white rounded-md px-4 py-2 m-2 uppercase transition duration-500 ease select-none hover:bg-gray-800 focus:outline-none focus:shadow-outline"
                @click="this.create()">
              Create contract
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

import TableDataCellElement from "@/Components/TableDataCellElement";
import TableHeaderCellElement from "@/Components/TableHeaderCellElement";

export default {
  name: "AllContract",
  data() {
    return {
      showError: false,
      candidates: [],
      listing: {
        listingId: "",
        propertyId: "",
        contractId: "",
        price: "",
        size: "",
        status: "",
        description: "",
      },
      contract: {
        tenantid: "",
        landlordid: "",
        propertyid: "",
        listingid: "",
        handoverid: null,
        pets: "",
        status: "",
        signing: "",
        price: ""
      },
    };
  },
  components: {
    TableDataCellElement,
    TableHeaderCellElement
  },
  methods: {
    selectTenant(userid) {
      this.contract.tenantid = userid;
    },
    fetchListingCandidates() {
      fetch(`http://localhost:8081/api/candidacies/listing/` + this.$route.params.id)
          .then((response) => response.json())
          .then((response) => {
            console.log("response", response)
            return response;
          })
          .then((data) => this.candidates = data)
          .catch((err) => console.log(err.message));
    },
    fetchListing() {
      fetch(`http://localhost:8087/api/listing/` + this.$route.params.id)
          .then((response) => response.json())
          .then((data) => {
            this.contract.landlordid = (Math.floor(Math.random() * 100) + 1) // TODO: change to auth user id.
            this.contract.propertyid = data.propertyId // NOTE: in Listing 'propertyId' where 'Id' with upper case.
            this.contract.listingid = Number(this.$route.params.id)
            this.contract.pets = "NO"
            this.contract.status = "DRAFT"
            this.contract.signing = "NOT_SIGNED"
            this.contract.price = Number(data.price)

            this.listing = data;
          })
          .catch((err) => console.log(err.message));
    },
    cancel() {
      this.$router.push("/api/allcontracts");
    },
    create() {
      if (!this.contract.tenantid || !this.contract.pets || !this.contract.price) {
        this.showError = true;
        return;
      } else {
        this.showError = false;
      }

      console.log("JSON.stringify(this.contract)", JSON.stringify(this.contract))

      fetch(`http://localhost:8082/api/contracts`, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(this.contract),
      })
          .then(async (test) => {
            const contractid = await test.json();
            this.listing.contractId = contractid

            fetch(`http://localhost:8087/api/listing/${this.$route.params.id}`, {
              method: "PUT",
              headers: {
                "Content-Type": "application/json",
              },
              body: JSON.stringify(this.listing),
            })
                .then(() => {
                  this.$router.push("/api/contract/" + contractid);
                })
                .catch((e) => {
                  console.log(e);
                });
          })
          .catch((e) => {
            console.log(e);
          });

    },
  },
  mounted() {
    this.fetchListing();
    this.fetchListingCandidates();
  },
};
</script>