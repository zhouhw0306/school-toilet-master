<template>
  <div>
    <comment :foreignId="101"></comment>
  </div>

</template>


<script>
import Comment from "../components/Comment";

export default {
  name: 'remark',
  components: {
    Comment
  },
  mixins: [mixin],

}

</script>
