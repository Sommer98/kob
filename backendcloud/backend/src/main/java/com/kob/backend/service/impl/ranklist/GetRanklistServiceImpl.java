package com.kob.backend.service.impl.ranklist;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.kob.backend.mapper.UserMapper;
import com.kob.backend.pojo.User;
import com.kob.backend.service.ranklist.GetRanklistService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;
import java.util.List;


@Service
public class GetRanklistServiceImpl implements GetRanklistService {

    @Autowired
    private UserMapper userMapper;


    @Override
    public JSONObject getList(Integer page) {
        IPage<User> userIPage = new Page(page, 10);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("rating");
        List<User> users = userMapper.selectPage(userIPage, queryWrapper).getRecords();
        JSONObject resp = new JSONObject();
        for (User user : users) user.setPassword("");
        resp.put("users", users);
        resp.put("users_count", userMapper.selectCount(null));
        return resp;
    }

    @Test
    public void test() {
//        Map<String, List<String>> res = new HashMap<>();
//        List<String> ss = new ArrayList<>();
//        ss.add("ss");
//        ss.add("aa");
//        res.put("name",ss);
//        res.get("name").add("pp");
//        for (String t: res.get("name")
//             ) {
//            System.out.println(t);
//        }
        System.out.println(Double.parseDouble(String.format("0.0f", 2.22)));
        String name = " ";
        Class<GetRanklistServiceImpl> clazz = GetRanklistServiceImpl.class;
        try {
            Method method = clazz.getMethod("ref" + "MethodTest", String.class);

            name = (String) method.invoke(clazz.newInstance(), "帅帅");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error");
        }
        System.out.println(name);
    }

    public String refMethodTest(String name) {
        System.out.println(name + "...");
        return name;
    }
}
