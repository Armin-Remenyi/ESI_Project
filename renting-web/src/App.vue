<template>
  <nav class="bg-white border-gray-200 dark:bg-gray-900">
    <div class="max-w-screen-xl flex flex-wrap items-center justify-between mx-auto p-4">
      <a href="http://localhost:8080/" class="flex items-center">
        <img src="https://flowbite.com/docs/images/logo.svg" class="h-8 mr-3" alt="Flowbite Logo"/>
        <span class="self-center text-2xl font-semibold whitespace-nowrap dark:text-white">Renting</span>
      </a>
      <div class="hidden w-full md:block md:w-auto" id="navbar-default">
        <ul class="font-medium flex flex-col p-4 md:p-0 mt-4 border border-gray-100 rounded-lg bg-gray-50 md:flex-row md:space-x-8 md:mt-0 md:border-0 md:bg-white dark:bg-gray-800 md:dark:bg-gray-900 dark:border-gray-700">

          <NavBarButtonElement v-if="inSession" value="Properties Page" link="/api/allproperties"/>
          <NavBarButtonElement v-if="inSession" value="Listings Page" link="/api/alllistings"/>
          <NavBarButtonElement v-if="inSession" value="Contract Page" link="/api/allcontracts"/>
          <NavBarButtonElement v-if="inSession" value="My User Profile" link="/api/user"/>
          <li>
            <a href="#"
               class="block py-2 pl-3 pr-4 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white md:dark:text-white"
               aria-current="page"
               v-if="!inSession"
               @click="redirectToLogin"
            >
              Login
            </a>
          </li>
          <li>
            <a href="#"
               class="block py-2 pl-3 pr-4 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white md:dark:text-white"
               aria-current="page"
               v-if="!inSession"
               @click="redirectToSignUp"
            >
              Signup
            </a>
          </li>

          <li>
            <a
                class="block py-2 pl-3 pr-4 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white md:dark:text-gray-300"
                v-if="checkRoles('TENANT')">
              Welcome, {{ authUser.username }} (Tenant)
            </a>
            <a
                class="block py-2 pl-3 pr-4 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white md:dark:text-gray-300"
                v-if="checkRoles('LANDLORD')">
              Welcome, {{ authUser.username }} (Landlord)
            </a>
          </li>

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
      authUser: {
        roles: '',
        username: ''
      },
    }
  },

  components: {
    NavBarButtonElement
  },
  methods: {
    checkRoles: (roles) => {
      return auth.hasARoleOf(roles);
    },
    redirectToLogin() {
      this.$router.push("/api/login");
    },
    redirectToSignUp() {
      this.$router.push("/api/signup");
    },
    logout() {
      auth.logout();
      this.$router.go()
    }
  },
  async mounted() {
    const authResult = await auth.authenticated();
    if (authResult) {
      this.inSession = true
    }
    const authUser = auth.getUser()

    console.log("authUser", authUser)

    if (authUser) {
      this.authUser = authUser
    }
  }
}


</script>
