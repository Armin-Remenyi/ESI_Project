<template>
  <li>
    <a href="#"
       class="block py-2 pl-3 pr-4 text-white bg-blue-700 rounded md:bg-transparent md:text-blue-700 md:p-0 dark:text-white md:dark:text-blue-500"
       aria-current="page">
      <router-link :to="link">{{ value }}</router-link>
    </a>
  </li>
</template>

<script>
export default {
  name: "NavBarButtonElement",
  props: {
    value: {
      type: String,
      required: true,
    },
    link: {
      type: String,
      required: true,
    },
  },
}
</script>