<template>
  <nav class="bg-white border-gray-200 dark:bg-gray-900">
    <div class="max-w-screen-xl flex flex-wrap items-center justify-between mx-auto p-4">
      <a href="http://localhost:8080/" class="flex items-center">
        <img src="https://flowbite.com/docs/images/logo.svg" class="h-8 mr-3" alt="Flowbite Logo"/>
        <span class="self-center text-2xl font-semibold whitespace-nowrap dark:text-white">Renting</span>
      </a>
      <div class="hidden w-full md:block md:w-auto" id="navbar-default">
        <ul class="font-medium flex flex-col p-4 md:p-0 mt-4 border border-gray-100 rounded-lg bg-gray-50 md:flex-row md:space-x-8 md:mt-0 md:border-0 md:bg-white dark:bg-gray-800 md:dark:bg-gray-900 dark:border-gray-700">

          <NavBarButtonElement value="Properties Page" link="/api/allproperties"/>
          <NavBarButtonElement value="Listings Page" link="/api/alllistings"/>
          <NavBarButtonElement value="Contract Page" link="/api/allcontracts"/>
          <NavBarButtonElement value="My User Profile" link="/api/user"/>

          <li>
            <a href="#"
               class="block py-2 pl-3 pr-4 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white md:dark:text-white"
               aria-current="page" v-if="inSession" value="Logout" @click="this.logout()">
              Logout
            </a>
          </li>

        </ul>
      </div>
    </div>
  </nav>
  <router-view/>
</template>

<script>
import NavBarButtonElement from "@/Components/NavBarButtonElement";
import auth from "@/auth";

export default {
  data() {
    return {
      inSession: false,
    }
  },
  components: {
    NavBarButtonElement
  },

  methods: {
    logout() {
      auth.logout();
      this.$router.go()
    }
  },
  async mounted() {
    let authResult = await auth.authenticated();
    if (authResult) {
      this.inSession = true
    }
  }
}


</script>
