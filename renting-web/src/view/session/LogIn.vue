<template>

  <div class=" h-screen overflow-hidden flex items-center justify-center">
    <div class="bg-white lg:w-5/12 md:6/12 w-10/12 shadow-3xl">
      <form class="p-12 md:p-24">
        <div class="flex items-center text-lg mb-6 md:mb-8">
          <svg class="absolute ml-3" width="24" viewBox="0 0 24 24">
            <path
                d="M20.822 18.096c-3.439-.794-6.64-1.49-5.09-4.418 4.72-8.912 1.251-13.678-3.732-13.678-5.082 0-8.464 4.949-3.732 13.678 1.597 2.945-1.725 3.641-5.09 4.418-3.073.71-3.188 2.236-3.178 4.904l.004 1h23.99l.004-.969c.012-2.688-.092-4.222-3.176-4.935z"/>
          </svg>
          <input :required="true" v-model="username" type="text" id="username"
                 class="bg-gray-200 pl-12 py-2 md:py-4 focus:outline-none w-full" placeholder="Username"/>
        </div>
        <div class="flex items-center text-lg mb-6 md:mb-8">
          <svg class="absolute ml-3" viewBox="0 0 24 24" width="24">
            <path
                d="m18.75 9h-.75v-3c0-3.309-2.691-6-6-6s-6 2.691-6 6v3h-.75c-1.24 0-2.25 1.009-2.25 2.25v10.5c0 1.241 1.01 2.25 2.25 2.25h13.5c1.24 0 2.25-1.009 2.25-2.25v-10.5c0-1.241-1.01-2.25-2.25-2.25zm-10.75-3c0-2.206 1.794-4 4-4s4 1.794 4 4v3h-8zm5 10.722v2.278c0 .552-.447 1-1 1s-1-.448-1-1v-2.278c-.595-.347-1-.985-1-1.722 0-1.103.897-2 2-2s2 .897 2 2c0 .737-.405 1.375-1 1.722z"/>
          </svg>
          <input :required="true" v-model="password" type="password" id="password"
                 class="bg-gray-200 pl-12 py-2 md:py-4 focus:outline-none w-full" placeholder="Password"/>
        </div>
        <button @click.prevent="LogIn"
                class="bg-gradient-to-b from-gray-700 to-gray-900 font-medium p-2 md:p-4 text-white uppercase w-full">
          Login
        </button>
        <button @click='this.$router.push("/signup")'
                class="bg-gradient-to-b from-gray-700 to-gray-900 font-medium p-2 md:p-4 text-white uppercase w-full">
          Signup
        </button>
      </form>
    </div>
  </div>
</template>

<script>
import jwt_decode from 'jwt-decode';

export default {
  name: "LogIn",

  data: function () {
    return {
      username: 'Ingmar',
      password: 'Ingmar'
    }
  },
  methods: {
    async LogIn() {
      const data = {
        firstName: this.username,
        password: this.password
      };

      // using Fetch - post method - send an HTTP post request to the specified URI with the defined body
      await fetch("http://localhost:8086/api/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        credentials: 'include',
        body: JSON.stringify(data),
      })
          .then(response => response.text())
          .then(response => {
            // saving the jwt returned in the response into the token variable
            this.token = response;

            //checking if a jwt token is retuned, all jwt tokes start with "ey"
            if (this.token.startsWith("ey")) {
              // decoding the jwt and save it in the decodedToken variable
              this.decodedToken = jwt_decode(this.token);
              // saving the returned user role into the roles variable
              this.roles = this.decodedToken.roles
              // saving the token into the windows local storage
              localStorage.setItem('jwtToken', this.token);
              localStorage.setItem('firstName', data.firstName);
              this.$router.push("/api/alllistings");
            }
          })
          .catch((e) => {
            console.log(e);
            console.log("error");
          });
    },
  },
}

</script>