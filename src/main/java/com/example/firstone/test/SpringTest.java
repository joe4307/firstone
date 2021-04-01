package com.example.firstone.test;

import com.example.firstone.FirstoneApplication;
import com.example.firstone.entity.User;
import com.example.firstone.mapper.UserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootVersion;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.SpringVersion;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FirstoneApplication.class)
public class SpringTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisTemplate<String,String> redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Test
    public void contextLoads() {
        redisTemplate.opsForValue().set("joe","30");
        stringRedisTemplate.opsForValue().set("joe1","31");
        String joe = redisTemplate.opsForValue().get("joe");
        System.out.println(joe);
        User user = userMapper.selectById(1);
        System.out.println(user);

        String version = SpringVersion.getVersion();
        String version1 = SpringBootVersion.getVersion();
        System.out.println(version);
        System.out.println(version1);
    }



}
