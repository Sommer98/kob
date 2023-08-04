<template>
  <!-- 两个大括号调用变量 -->
  <!-- <div>Bot昵称：{{ bot_name }}</div> -->
  <NavBar />
  <router-view></router-view>
</template>

<script>
//import $ from 'jquery';//导入js
//import { ref } from 'vue';//导入vue中变量
import NavBar from './components/NavBar.vue'//导入组件【组件一般放在components中】
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap/dist/js/bootstrap"
// import $ from 'jquery'


export default {
  // name: "App",
  // //js的起始读入的函数
  // setup: () => {
  //   let bot_name = ref("");
  //   let bot_rating = ref("");

  //   $.ajax({
  //     url:"http://127.0.0.1:3000/pk/getbotinfo/",
  //     type:"get",
  //     success: resp => {
  //       //获取成功后返回的参数：resp
  //       bot_name.value = resp.name;
  //       bot_rating.value = resp.rating;
  //     }
  //   });

  //   return{
  //     bot_name,
  //     bot_rating
  //   }
    
  // }
  components: {
    NavBar
  },

  setup() {
      

      // $.ajax({
      //   url: "http://127.0.0.1:3000/user/account/register/",
      //   type: "post",
      //   data: {
      //     username: "gmr2",
      //     password: "123456",
      //     confirmedPassword: "123456",
      //   },
      //   success(resp) {
      //     console.log(resp);
      //   },
      //   error(resp) {
      //     console.log(resp);
      //   }
      // });


    
  }

}

</script>



<style>
body {
  background-image: url("./assets/images/background.jpg");
  background-size: cover;
}

</style>
