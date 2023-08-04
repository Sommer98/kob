const AC_GAME_OBJECTS = [];

export class AcGameObject {

    constructor() {
        AC_GAME_OBJECTS.push(this);

        this.timedelta = 0;
        this.has_called_start = false;

    }

    start() { //只执行依次


    }

    update() { //每一帧执行一次，第一帧除外

    }

    on_destroy() { // 删除之前执行

    }

    destroy() {

        this.on_destroy();
        for(let i in AC_GAME_OBJECTS) {
            const obj = AC_GAME_OBJECTS[i];
            if(obj === this){
                AC_GAME_OBJECTS.splice(i);//如果是obj是当前对象，就利用splice()从数组中删除一个元素 
                break;
            }
        }

    }


}

let last_timestamp; // 上一次执行的时刻
const step = timestamp => { //该函数传个timestamp参数，表示当前执行的时间
     
    for(let obj of AC_GAME_OBJECTS) {
        if(!obj.has_called_start){
            obj.has_called_start = true;
            obj.start();
        }else {
            obj.timedelta = timestamp - last_timestamp;
            obj.update();
        }
    }

    last_timestamp = timestamp;
    requestAnimationFrame(step)

}

requestAnimationFrame(step);