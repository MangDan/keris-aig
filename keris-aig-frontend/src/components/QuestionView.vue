<template></template>
<script>
export default {
  data() {
    return {
      selcount: 0
    };
  },
  created() {
    MathJax.Hub.Config({
      showMathMenu: false,
      tex2jax: { displayMath: [["$$", "$$"]] }
    });
  }
};
</script>