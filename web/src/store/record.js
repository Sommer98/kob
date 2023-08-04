

export default {
    state: {
       is_record: false,
       a_steps: "",
       b_steps: "",
       record_loser: "", 
        
    },
    mutations: { // 存放同步操作的函数
        updateIsRecord(state, is_record) {
            state.is_record = is_record;
        },
        updateSteps(state, data) {
            state.a_steps = data.a_steps;
            state.b_steps = data.b_steps;
        },
        updateRecordLoser(state, loser) {
            state.record_loser = loser;
        }

         
        
    },
    actions: { // 存放异步操作的函数
    },
    modules: {
    }
}