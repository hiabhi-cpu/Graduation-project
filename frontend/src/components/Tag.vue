<template>
    <span class="tag">
        {{ tagname }}
    </span>
</template>

<script>
export default {
    props: ['tagname']
}
</script>

<style scoped>
.tag {
  background: #eee;
  color: #fff;
  display: inline-block;
  height: 26px;
  line-height: 26px;
  padding: 0 20px 0 23px;
  position: relative;
  margin: 0 10px 10px 10px;
  box-shadow: 4px 2px 2px lightgray;
}

.tag::before {
  background: #fff;
  border-radius: 10px;
  content: '';
  height: 6px;
  left: 10px;
  position: absolute;
  width: 6px;
  top: 10px;
}
</style>