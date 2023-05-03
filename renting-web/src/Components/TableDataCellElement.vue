<template>
  <td class="px-4 py-4 text-md font-medium font-bold text-gray-500 text-left dark:text-gray-300 whitespace-nowrap">
    {{ value }}
  </td>
</template>

<script>
export default {
  name: "TableDataCellElement",
  props: {
    value: {
      type: String,
    },
  },
}
</script>