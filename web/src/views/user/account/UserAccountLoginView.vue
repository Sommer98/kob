 <template>

    <ContentField v-if="!$store.state.user.getting_info">
        <div class="row justify-content-md-center">
            <div class="clo-3">

                <form @submit.prevent="login">
                    <div class="mb-3">
                        <label for="username" class="form-label">用户名</label>
                        <input v-model="username" type="text" class="form-control" id="username" placeholder="请输入用户名">
                     </div>
                     <div class="mb-3">
                        <label for="password" class="form-label">密码</label>
                        <input v-model="password" type="password" class="form-control" id="password" placeholder="请输入密码">
                     </div>
                     <div class="error-message">{{ error_message }}</div>
                     <button type="submit" class="btn btn-primary">登录</button>

                </form>

            </div>


        </div>


    </ContentField>

 </template>




 <script>
 import ContentField from '../../../components/ContentField.vue'
 import { useStore } from 'vuex'
 import { ref } from 'vue'
 import router from '../../../router/index'

 export default {
    components: { 
        ContentField
    },
    setup() {
        const store = useStore();
        let username = ref('');
        let password = ref('');
        let error_message = ref('');
        

        const jwt_token = localStorage.getItem("jwt_token");
        if(jwt_token) {
            store.commit("updateToken", jwt_token);
            store.dispatch("getinfo", {
                success() {
                    router.push({ name: "home"});
                    store.commit("updateGettingInfo", false);
                },
                error() {
                    //获取信息结束
                    store.commit("updateGettingInfo", false);
                }
            })
        }else {
            //获取信息结束
            store.commit("updateGettingInfo", false);
        }

        const login = () => {
            error_message.value = "";
            // 若调用userStore中actions里定义的函数，需要用dispatch调用 -->
            store.dispatch("login", {
                username: username.value,
                password: password.value,
                success() {
                    //console.log(resp);
                    //登录成功，获取用户信息
                    store.dispatch("getinfo", {
                        success() {
                            router.push({ name: 'home'});
                        }
                    })
                },
                error(resp) {
                    if(resp.error_message === "1") {
                        error_message.value = "该用户不存在，请先注册"
                    }else {
                        error_message.value = "用户名或密码错误"
                    }
                },
            }) 

        }

        return {
            username,
            password,
            error_message,
            login,
        }


    }

 }

 </script>
 

 <style scoped>
    button {
        width: 100%;
    }
    
    div.error-message {
        color: red;
    }
 
 </style>