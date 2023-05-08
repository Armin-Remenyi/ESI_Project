<template>
    <div>
      <div>
        <main class="py-20">
          <div class="container mx-auto w-30">
            <form class="rounded-lg bg-gray-200 p-10 shadow-lg">
              <header class="pb-10">
                <div class="container mx-auto w-30">
                  <h1 class="text-3xl font-bold">Create new user</h1>
                </div>
              </header>
  
              <div v-if="this.showError" class="bg-red-100 border border-red-400 text-red-700 px-4 py-3 rounded relative"
                   role="alert">
                <strong class="font-bold">Error!</strong>
                <span class="block sm:inline"> Please fill all user information</span>
              </div>
              <div class="my-5 text-sm">
                <label for="userid" class="block text-black">User Id</label>
                <input type="number" autofocus id="userid"
                       class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-200 w-full" placeholder="propertyid"
                       :disabled="true"
                       v-model="user.userid"/>
              </div>
  
              <div class="my-5 text-sm">
                <label for="lastName" class="block text-black">Last Name</label>
                <input type="lastName" autofocus id="lastName"
                       class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="size"
                       v-model="user.lastName"/>
              </div>
  
              <div class="my-5 text-sm">
                <label for="firstName" class="block text-black">First Name</label>
                <input type="firstName" autofocus id="firstName"
                       class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="balcony"
                       v-model="user.firstName"/>
              </div>
  
              <div class="my-5 text-sm">
                <label for="phoneNumber" class="block text-black">Phone Number</label>
                <input type="phoneNumber" autofocus id="phoneNumber"
                       class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="address"
                       v-model="user.phoneNumber"/>
              </div>
  
              <div class="my-5 text-sm">
                <label for="email" class="block text-black">Email</label>
                <input type="email" autofocus id="email"
                       class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="floor"
                       v-model="user.email"/>
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
    name: "CreateUser",
    data() {
      return {
        showError: false,
        user: {
          userid: Math.floor(Math.random() * 100) + 1,
          firstName: "",
          lastName: "",
          phoneNumber: "",
          email: "",
          created: "",
        },
      };
    },
    methods: {
    //   cancel() {
    //     this.$router.push("/api/allproperties");
    //   },
      create() {
  
        if (
            !this.user.userid
            || !this.user.lastName
            || !this.user.firstName
            || !this.user.phoneNumber
            || !this.user.email
            || !this.user.created
        ) {
          this.showError = true;
          return;
        } else {
          this.showError = false;
        }
  
        fetch(`http://localhost:8086/api/users`, {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(this.user),
        })
            .then(() => {
              this.$router.push("/api/user/" + this.user.userid);
            })
            .catch((e) => {
              console.log(e);
            });
  
      },
    },
  };
  </script>