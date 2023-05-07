<template>
  <div>
    <div>
      <main class="py-20">
        <div class="container mx-auto w-30">
          <form class="rounded-lg bg-gray-200 p-10 shadow-lg">
            <header class="pb-10">
              <div class="container mx-auto w-30">
                <h1 class="text-3xl font-bold">Update contract nr {{ this.contract.contractid }}</h1>
              </div>
            </header>
            <div class="my-5 text-sm">
              <label for="contractid" class="block text-black">Contract Id</label>
              <input type="number" autofocus id="contractid"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-200 w-full" placeholder="contractid"
                     :disabled="true"
                     v-model="contract.contractid"/>
            </div>
            <div class="my-5 text-sm">
              <label for="tenantid" class="block text-black">Tenant Id</label>
              <input type="number" autofocus id="tenantid"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-200 w-full" placeholder="tenantid"
                     :disabled="true"
                     v-model="contract.tenantid"/>
            </div>
            <div class="my-5 text-sm">
              <label for="landlordid" class="block text-black">Landlord Id</label>
              <input type="number" autofocus id="landlordid"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-200 w-full" placeholder="landlordid"
                     :disabled="true"
                     v-model="contract.landlordid"/>
            </div>

            <div class="my-5 text-sm">
              <label for="propertyid" class="block text-black">Property Id</label>
              <input type="number" autofocus id="propertyid"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-200 w-full" placeholder="propertyid"
                     :disabled="true"
                     v-model="contract.propertyid"/>
            </div>

            <div class="my-5 text-sm">
              <label for="listingid" class="block text-black">Listing Id</label>
              <input type="number" autofocus id="listingid"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-200 w-full" placeholder="listingid"
                     :disabled="true"
                     v-model="contract.listingid"/>
            </div>
            <div class="my-5 text-sm">
              <label for="handoverid" class="block text-black">Handover Id</label>
              <input type="number" autofocus id="handoverid"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-200 w-full" placeholder="handoverid"
                     :disabled="true"
                     v-model="contract.handoverid"/>
            </div>

            <div class="my-5 text-sm">
              <label for="pets" class="block text-black">Pets</label>
              <input type="text" autofocus id="pets"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="pets"
                     v-model="contract.pets"/>
            </div>

            <div class="my-5 text-sm">
              <label for="price" class="block text-black">Rent amount</label>
              <input type="number" autofocus id="price"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="price"
                     v-model="contract.price"/>
            </div>
            <div class="my-5 text-sm">
              <label for="status" class="block text-black">Status</label>
              <input type="text" autofocus id="status"
                     class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-200 w-full" placeholder="status"
                     :disabled="true"
                     v-model="contract.handoverid"/>
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
                @click="this.update(contract.contractid)">
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
  name: "UpdateContract",
  data() {
    return {
      contract: {
        contractid: "",
        tenantid: "",
        landlordid: "",
        propertyid: "",
        listingid: "",
        handoverid: "",
        pets: "",
        status: "",
        signing: "",
        price: ""
      },
    };
  },
  methods: {
    fetchContract() {
      fetch(`http://localhost:8082/api/contracts/` + this.$route.params.id)
          .then((response) => response.json())
          .then((data) => (this.contract = data))
          .catch((err) => console.log(err.message));
    },
    cancel() {
      this.$router.push("/api/allcontracts");
    },
    update(id) {
      fetch(`http://localhost:8082/api/contracts/${id}`, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(this.contract),
      })
          .then(() => {
            this.$router.push("/api/contract/" + id);

          })
          .catch((e) => {
            console.log(e);
          });

    },
  },
  mounted() {
    this.fetchContract();
  },
};
</script>