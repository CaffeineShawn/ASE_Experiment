<template>
  <div id="app">
    <router-view></router-view>
  </div>
</template>

<script>

</script>

<style>
.html,body, #app, .el-container.is-vertical{
  /* margin: 0;
  border: 0; */
  padding: 0;
  margin: 0;
  height: 100%;
  /* width: 100%; */
}
#app {
    position: absolute;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
  }
@media screen and (width: 1080px) {
  .el-aside {
    height: 93vh;
    background-color: #F0F6F6
  }
}
.el-aside {
  height: 90.95vh;
  background-color: #F0F6F6
}
.el-main {
  height: 90.95vh;

}
body::-webkit-scrollbar {
  width: 0px;
  height: 0px;
}


</style>
