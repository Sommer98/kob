 <template>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
  <div class="container">
    <!-- <a class="navbar-brand" href="#">King Of Bots</a> vue提供<router-link>标签，使这种前端点击不刷新界面 -->
    <router-link class="navbar-brand" :to="{name: 'home'}">King Of Bots</router-link>
    <div class="collapse navbar-collapse" id="navbarText">
      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
        <li class="nav-item">
          <!-- <a class="nav-link" aria-current="page" href="/pk/">对战</a> -->
          <router-link :class="route_name == 'pk_index' ? 'nav-link active' : 'nav-link'" :to="{name: 'pk_index'}">对战</router-link>
        </li>
        <li class="nav-item">
          <!-- <a class="nav-link" href="/record/">对局列表</a> -->
          <router-link :class="route_name == 'record_index' ? 'nav-link active' : 'nav-link'" :to="{name: 'record_index'}">对局列表</router-link>
        </li>
        <li class="nav-item">
          <!-- <a class="nav-link" href="/ranklist/">排行榜</a> -->
          <router-link :class="route_name == 'ranklist_index' ? 'nav-link active' : 'nav-link'" :to="{name: 'ranklist_index'}">排行榜</router-link>
        </li>
      </ul>
      <ul class="navbar-nav" v-if="$store.state.user.is_login">
        <li class="nav-item dropdown">
          <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
            {{ $store.state.user.username }}
          </a>
          <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
            <li>
                <!-- <a class="dropdown-item" href="/user/bot/">我的Bot</a> -->
                <router-link class="dropdown-item" :to="{name: 'user_bot_index'}">我的Bot</router-link>
            </li>
            <li><a class="dropdown-item" href="#" @click="logout">退出</a></li>
          </ul >
        </li>
      </ul>
      <ul class="navbar-nav" v-else-if="!$store.state.user.getting_info">
        <li class="nav-item">
          <router-link class="nav-link" :to="{name: 'user_account_login'}"  role="button">
            登录
          </router-link>
        </li>
        <li class="nav-item">
          <router-link class="nav-link" :to="{name: 'user_account_register'}"   role="button">
            注册
          </router-link>
        </li>

      </ul>



    </div>
  </div>
</nav>

 </template>




 <script>
 import { useRoute } from 'vue-router'
 import { computed } from 'vue'
 import { useStore } from 'vuex'

 export default {

    setup() {
        // 取出当前的route 
        const route = useRoute(); 
        const store = useStore();

        //实时计算route的名字
        let route_name = computed(() => route.name);

        const logout = () => {
          store.dispatch("logout");
        };
        return {
            route_name,
            logout
        }

    }


 } 


 </script>
 

 <style scoped>
 
 </style>