<template>
  <div>
    <main class="py-20">
      <div class="container mx-auto w-30">
        <div class="rounded-lg bg-gray-200 p-10 shadow-lg">
          <header class="pb-10">
            <div class="flex justify-between">
              <div class="container mx-auto w-30">
                <h1 class="text-3xl font-bold">Listing nr {{ this.$route.params.id }}</h1>
              </div>
              <div class="text-right">
                <button
                    type="button"
                    class="border border-gray-700 bg-gray-700 text-white rounded-md px-4 py-2 m-2 uppercase transition duration-500 ease select-none hover:bg-gray-800 focus:outline-none focus:shadow-outline"
                    @click="this.all()">
                  All listings
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
                      <TableHeaderCellElement value="Contract Id"/>
                      <TableHeaderCellElement value="Price"/>
                      <TableHeaderCellElement value="Size"/>
                      <TableHeaderCellElement value="Status"/>
                      <TableHeaderCellElement value="Description"/>
                    </tr>
                    </thead>
                    <tbody class="bg-white divide-y divide-gray-200 dark:divide-gray-700 dark:bg-gray-900">
                    <tr>
                      <TableDataCellElement :value="listing.listingId"/>
                      <TableDataCellElement :value="listing.propertyId"/>
                      <TableDataCellElement :value="listing.contractId"/>
                      <TableDataCellElement :value="listing.price"/>
                      <TableDataCellElement :value="listing.size"/>
                      <TableDataCellElement :value="listing.status"/>
                      <TableDataCellElement :value="listing.description"/>
                    </tr>
                    </tbody>
                  </table>
                </div>
                <button
                    type="button"
                    class="border border-gray-700 bg-gray-700 text-white rounded-md px-4 py-2 mt-2 uppercase transition duration-500 ease select-none hover:bg-gray-800 focus:outline-none focus:shadow-outline"
                    @click="this.update(listing.listingId)">
                  change
                </button>
                <button
                    type="button"
                    class="border border-gray-700 bg-gray-700 text-white rounded-md px-4 py-2 ml-2 uppercase transition duration-500 ease select-none hover:bg-gray-800 focus:outline-none focus:shadow-outline"
                    @click="this.delete(listing.listingId)">
                  delete
                </button>
              </div>
            </div>
          </div>
          <header class="pb-10 pt-10">
            <div class="flex justify-between">
              <div class="container mx-auto w-30">
                <h1 class="text-3xl font-bold">Related contracts</h1>
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
                      <TableHeaderCellElement value="Contract Id"/>
                      <TableHeaderCellElement value="Tenant Id"/>
                      <TableHeaderCellElement value="Landlord id"/>
                      <TableHeaderCellElement value="Property id"/>
                      <TableHeaderCellElement value="Handover id"/>
                      <TableHeaderCellElement value="Listing id"/>
                      <TableHeaderCellElement value="Pets"/>
                      <TableHeaderCellElement value="Rent amount"/>
                      <TableHeaderCellElement value="Status"/>
                      <TableHeaderCellElement value="Signing"/>
                    </tr>
                    </thead>
                    <tbody class="bg-white divide-y divide-gray-200 dark:divide-gray-700 dark:bg-gray-900"
                           v-for="contract in relatedContracts" :key="contract.contractid">
                    <tr>
                      <TableDataCellElement :value="contract.contractid"/>
                      <TableDataCellElement :value="contract.tenantid"/>
                      <TableDataCellElement :value="contract.landlordid"/>
                      <TableDataCellElement :value="contract.propertyid"/>
                      <TableDataCellElement :value="contract.handoverid"/>
                      <TableDataCellElement :value="contract.listingid"/>
                      <TableDataCellElement :value="contract.pets"/>
                      <TableDataCellElement :value="contract.price"/>
                      <TableDataCellElement :value="contract.status"/>
                      <TableDataCellElement :value="contract.signing"/>
                    </tr>
                    </tbody>
                  </table>
                </div>
                <button
                    v-if="!listing.contractId"
                    type="button"
                    class="border border-gray-700 bg-gray-700 text-white rounded-md px-4 py-2 mt-2 uppercase transition duration-500 ease select-none hover:bg-gray-800 focus:outline-none focus:shadow-outline"
                    @click="this.createContract(listing.listingId)">
                  create contract
                </button>
                <button
                    v-else
                    type="button"
                    class="border border-gray-700 bg-gray-700 text-white rounded-md px-4 py-2 mt-2 uppercase transition duration-500 ease select-none hover:bg-gray-800 focus:outline-none focus:shadow-outline"
                    @click="this.openContract(listing.contractId)">
                  open contract
                </button>
              </div>
            </div>
          </div>
          <header class="pb-10 pt-10">
            <div class="flex justify-between">
              <div class="container mx-auto w-30">
                <h1 class="text-3xl font-bold">Applied candidates</h1>
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
                      <TableHeaderCellElement value="Candidate Id"/>
                      <TableHeaderCellElement value="User Id"/>
                      <TableHeaderCellElement value="Candidacy date"/>
                      <TableHeaderCellElement value="Status"/>
                    </tr>
                    </thead>
                    <tbody class="bg-white divide-y divide-gray-200 dark:divide-gray-700 dark:bg-gray-900"
                           v-for="candidate in relatedCandidates" :key="candidate.contractid">
                    <tr>
                      <TableDataCellElement :value="candidate.candidacyid"/>
                      <TableDataCellElement :value="candidate.userid"/>
                      <TableDataCellElement :value="candidate.date"/>
                      <TableDataCellElement :value="candidate.status"/>
                    </tr>
                    </tbody>
                  </table>
                </div>
                <button
                    type="button"
                    class="border border-gray-700 bg-gray-700 text-white rounded-md px-4 py-2 mt-2 uppercase transition duration-500 ease select-none hover:bg-gray-800 focus:outline-none focus:shadow-outline"
                    @click="this.apply(listing.listingId)">
                  apply
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
  name: "ListingView",
  data() {
    return {
      relatedCandidates: [],
      relatedContracts: [],
      listing: {
        listingId: "",
        propertyId: "",
        contractId: "",
        price: "",
        size: "",
        status: "",
        description: "",
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
    fetchListing() {
      fetch(`http://localhost:8087/api/listing/` + this.$route.params.id)
          .then((response) => response.json())
          .then((data) => {
            this.listing = data
            this.fetchAllContractRelatedToListing();
          })
          .catch((err) => console.log(err.message));
    },
    fetchAllContractRelatedToListing() {
      if (!this.listing.contractId) return;

      const url = `http://localhost:8082/api/contracts/` + this.listing.contractId;
      console.log("url", url)
      fetch(url)
          .then((response) => response.json())
          .then((respose) => {
            console.log("respose", respose)
            return respose;
          })
          .then((data) => (this.relatedContracts = [data]))
          .catch((err) => console.log(err.message));
    },
    fetchListingCandidates() {
      fetch(`http://localhost:8081/api/candidacies/listing/` + this.$route.params.id)
          .then((response) => response.json())
          .then((response) => {
            console.log("response", response)
            return response;
          })
          .then((data) => this.relatedCandidates = data)
          .catch((err) => console.log(err.message));
    },
    delete(id) {
      console.log("id", id)
      fetch(`http://localhost:8087/api/listing/${id}`, {
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
      this.$router.push("/api/updatelisting/" + id);
    },
    apply(id) {
      this.$router.push("/api/createcandidate/" + id);
    },
    all() {
      this.$router.push("/api/alllistings");
    },
    createContract(id) {
      this.$router.push("/api/createcontract/" + id);
    },
    openContract(id) {
      this.$router.push("/api/contract/" + id);
    },
  },
  mounted() {
    this.fetchListing();
    this.fetchListingCandidates();
  },
};
</script>