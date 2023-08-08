import $ from 'jquery'

export default {
    state: {
        id: "",
        username: "",
        photo: "",
        token: "",
        is_login: false,
        getting_info: true, // 是否正在获取信息
    },
    mutations: { // 存放同步操作的函数
        updateUser(state, user) {
            state.id = user.id;
            state.username = user.username;
            state.photo = user.photo;
            state.is_login = user.is_login;
        },
        updateToken(state, token) {
            state.token = token;
        },
        logout(state) {
            state.id = "",
            state.username = "",
            state.photo = "",
            state.token = "",
            state.is_login = false;
        },
        updateGettingInfo(state, getting_info) {
            state.getting_info = getting_info;
        }
        
    },
    actions: { // 存放异步操作的函数
        login(context, data) {
            $.ajax({
                url: "http://127.0.0.1:3000/user/account/token/",
                // url: "https://app3584.acapp.acwing.com.cn/api/user/account/token/",
                // url: "https://www.kodbrook.com/api/user/account/token/",
                type: "post",
                data: {
                  username: data.username,
                  password: data.password,
                },
                success(resp) {
                    if(resp.error_message === "success") {
                        //持久化登录，利用localStorage，防止页面刷新，退出登录
                        localStorage.setItem("jwt_token", resp.token);
                        context.commit("updateToken", resp.token); // 调用mutations中函数：通过commit.("函数名")的方式调用 
                        data.success(resp);
                    }else {
                        data.error(resp);
                    }
                },
                error(resp) {
                    data.error(resp);
                }
              });

        },
        getinfo(context, data) {
            $.ajax({
                url: "http://127.0.0.1:3000/user/account/info/",
                // url: "https://app3584.acapp.acwing.com.cn/api/user/account/info/",
                // url: "https://www.kodbrook.com/api/user/account/info/",
                type: "get",
                headers: {
                  Authorization: "Bearer " + context.state.token,
                },
                success(resp) {
                    if(resp.error_message === "success") {
                        
                        context.commit("updateUser", {
                            ...resp,
                            is_login: true,
                        });
                        data.success(resp);
                    }else {
                        data.error(resp);
                    }
                    
                },
                error(resp) {
                    data.error(resp);
                },
              });

        },
        logout(context) {
            localStorage.removeItem("jwt_token");
            context.commit("logout");
        }
    },
    modules: {
    }
}