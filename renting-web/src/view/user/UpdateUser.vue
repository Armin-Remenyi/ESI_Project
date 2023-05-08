<template>
    <div>
      <div>
        <main class="py-20">
          <div class="container mx-auto w-30">
            <form class="rounded-lg bg-gray-200 p-10 shadow-lg">
              <header class="pb-10">
                <div class="container mx-auto w-30">
                  <h1 class="text-3xl font-bold">Update user with id {{ this.user.userid }}</h1>
                </div>
              </header>
              <div class="my-5 text-sm">
                <label for="userid" class="block text-black">User Id</label>
                <input type="userid" autofocus id="userid"
                       class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="User Id"
                       v-model="user.userid"/>
              </div>
  
              <div class="my-5 text-sm">
                <label for="lastName" class="block text-black">Last Name</label>
                <input type="lastName" autofocus id="lastName"
                       class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="Last Name"
                       v-model="user.lastName"/>
              </div>
  
              <div class="my-5 text-sm">
                <label for="firstName" class="block text-black">First Name</label>
                <input type="firstName" autofocus id="firstName"
                       class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="First Name"
                       v-model="user.firstName"/>
              </div>
  
              <div class="my-5 text-sm">
                <label for="phoneNumber" class="block text-black">Phone Number</label>
                <input type="phoneNumber" autofocus id="phoneNumber"
                       class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="Phone Number"
                       v-model="user.phoneNumber"/>
              </div>

              <div class="my-5 text-sm">
                <label for="email" class="block text-black">Email</label>
                <input type="email" autofocus id="email"
                       class="rounded-sm px-4 py-3 mt-3 focus:outline-none bg-gray-100 w-full" placeholder="Email"
                       v-model="user.email"/>
              </div>
  
              <button
                  type="button"
                  class="border border-gray-700 bg-gray-700 text-white rounded-md px-4 py-2 m-2 uppercase transition duration-500 ease select-none hover:bg-gray-800 focus:outline-none focus:shadow-outline"
                  @click="this.update(user.userid)">
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
    name: "UpdateUser",
    data() {
        return {
        user: {
          userid: "",
          firstName: "",
          lastName: "",
          phoneNumber: "",
          email: "",
          created: "",
        },
      };
    },
    methods: {
        fetchUser() {
        fetch(`http://localhost:8086/api/users/` + this.$route.params.id)
            .then((response) => response.json())
            .then((data) => (this.listing = data))
            .catch((err) => console.log(err.message));
      },
      //Todo: What should happen with cancel?
    //   cancel() {
    //     this.$router.push("/api/alllistings");
    //   },
      update(id) {
        fetch(`http://localhost:8086/api/users/${id}`, {
          method: "PUT",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(this.user),
        })
            .then(() => {
              this.$router.push("/api/user/" + id);
            })
            .catch((e) => {
              console.log(e);
            });
  
      },
    },
    mounted() {
      this.fetchUser();
    },
  };
  </script>