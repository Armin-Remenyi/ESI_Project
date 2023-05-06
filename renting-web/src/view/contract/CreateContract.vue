<template>
    <div>
      <div>
        <main class="py-20">
          <div class="container mx-auto w-30">
            <form class="rounded-lg bg-gray-200 p-10 shadow-lg">
              <header class="pb-10">
                <div class="container mx-auto w-30">
                  <h1 class="text-3xl font-bold">Create new contract</h1>
                </div>
              </header>
              <div class="my-5 text-sm">
                <label for="contractId" class="block text-black">Contract Id</label>
                <input type="number" autofocus id="contractId"
                       class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="contractId"
                       v-model="contract.contractId"/>
              </div>
  
              <div class="my-5 text-sm">
                <label for="propertyId" class="block text-black">Property Id</label>
                <input type="number" autofocus id="propertyId"
                       class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="Username"
                       v-model="contract.propertyId"/>
              </div>
  
              <div class="my-5 text-sm">
                <label for="price" class="block text-black">Tenant Id</label>
                <input type="number" autofocus id="price"
                       class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="Price"
                       v-model="contract.price"/>
              </div>
  
              <div class="my-5 text-sm">
                <label for="size" class="block text-black">Landlord Id</label>
                <input type="size" autofocus id="size"
                       class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="Size"
                       v-model="contract.size"/>
              </div>
  
              <div class="my-5 text-sm">
                <label for="status" class="block text-black">Status</label>
                <input type="status" autofocus id="status"
                       class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="Size"
                       v-model="contract.status"/>
              </div>
  
              <div class="my-5 text-sm">
                <label for="description" class="block text-black">Signing</label>
                <input type="description" autofocus id="description"
                       class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="Size"
                       v-model="contract.description"/>
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
    name: "Createcontract",
    data() {
      return {
        contract: {
          contractId: "",
          propertyId: "",
          tenantid: "",
          handoverid: "",
          status: "",
          signing: "",
        },
      };
    },
    methods: {
      cancel() {
        this.$router.push("/api/allcontracts");
      },
      create() {
        fetch(`http://localhost:8082/api/contract`, {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(this.contract),
        })
            .then(() => {
              this.$router.push("/api/contract/" + this.contract.contractId);
            })
            .catch((e) => {
              console.log(e);
            });
  
      },
    },
  };
  </script>