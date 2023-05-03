<template>
  <th scope="col"
      class="py-3.5 px-4 text-md font-medium font-bold text-left text-gray-500 dark:text-gray-400">
    {{ value }}
  </th>
</template>

<script>
export default {
  name: "TableHeaderCellElement",
  props: {
    value: {
      type: String,
    },
  },
}
</script>