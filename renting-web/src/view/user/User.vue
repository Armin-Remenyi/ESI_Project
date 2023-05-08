<template>
    <div>
      <main class="py-20">
        <div class="container mx-auto w-30">
          <div class="rounded-lg bg-gray-200 p-10 shadow-lg">
            <header class="pb-10">
              <div class="flex justify-between">
                <div class="container mx-auto w-30">
                  <h1 class="text-3xl font-bold">User nr {{ this.$route.params.id }}</h1>
                </div>
                <div class="text-right">
                  <!-- <button
                      type="button"
                      class="border border-gray-700 bg-gray-700 text-white rounded-md px-4 py-2 m-2 uppercase transition duration-500 ease select-none hover:bg-gray-800 focus:outline-none focus:shadow-outline"
                      @click="this.all()">
                    All users
                  </button> -->
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
                        <TableHeaderCellElement value="User Id"/>
                        <TableHeaderCellElement value="First Name"/>
                        <TableHeaderCellElement value="Last Name"/>
                        <TableHeaderCellElement value="Phone number"/>
                        <TableHeaderCellElement value="Email"/>
                        <TableHeaderCellElement value="Created On"/>
                        <TableHeaderCellElement value=""/>
                        <TableHeaderCellElement value=""/>
                        <TableHeaderCellElement value=""/>
                      </tr>
                      </thead>
                      <tbody class="bg-white divide-y divide-gray-200 dark:divide-gray-700 dark:bg-gray-900">
                      <tr>
                        <TableDataCellElement :value="user.userid"/>
                        <TableDataCellElement :value="user.firstName"/>
                        <TableDataCellElement :value="user.lastName"/>
                        <TableDataCellElement :value="user.phoneNumber"/>
                        <TableDataCellElement :value="user.email"/>
                        <TableDataCellElement :value="user.created"/>
                        <td class="px-4 py-4 text-md font-medium font-bold text-gray-500 text-left dark:text-gray-300 whitespace-nowrap">
                          <button
                              type="button"
                              class="border border-gray-700 bg-red-700 text-white rounded-md px-4 py-2 m-2 uppercase transition duration-500 ease select-none hover:bg-gray-800 focus:outline-none focus:shadow-outline"
                              @click="this.update(user.userid)">
                            Update
                          </button>
                        </td>
                        <td class="px-4 py-4 text-md font-medium font-bold text-gray-500 text-left dark:text-gray-300 whitespace-nowrap">
                          <!-- <button
                              v-if="!user.userId"
                              type="button"
                              class="border border-gray-700 bg-red-700 text-white rounded-md px-4 py-2 m-2 uppercase transition duration-500 ease select-none hover:bg-gray-800 focus:outline-none focus:shadow-outline"
                              @click="this.createUser(user.userid)">
                            create user
                          </button> -->
                        </td>
                        <td class="px-4 py-4 text-md font-medium font-bold text-gray-500 text-left dark:text-gray-300 whitespace-nowrap">
                          <button
                              type="button"
                              class="border border-gray-700 bg-red-700 text-white rounded-md px-4 py-2 m-2 uppercase transition duration-500 ease select-none hover:bg-gray-800 focus:outline-none focus:shadow-outline"
                              @click="this.delete(user.userid)">
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
    name: "UserView",
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
    components: {
      TableDataCellElement,
      TableHeaderCellElement
    },
    methods: {
      fetchUser() {
        fetch(`http://localhost:8086/api/users/` + this.$route.params.id)
            .then((response) => response.json())
            .then((data) => (this.property = data))
            .catch((err) => console.log(err.message));
      },
      delete(id) {
        fetch(`http://localhost:8086/api/users/${id}`, {
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
        this.$router.push("/api/updateuser/" + id);
      },
      createUser(id) {
        this.$router.push("/api/createuser/" + id);
      },
    },
    mounted() {
      this.fetchUser();
    },
  };
  </script>