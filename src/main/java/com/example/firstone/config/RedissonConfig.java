package com.example.firstone.config;

import org.redisson.Redisson;
import org.redisson.config.Config;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//@Configuration
public class RedissonConfig {
//    @Bean
    public Redisson redisson() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:6379").setPassword("xxx").setDatabase(0);

        /**
         * 哨兵
         */
        //config.useSentinelServers().addSentinelAddress("");

        /**
         * 集群
         */
//        config.useClusterServers().addNodeAddress("redis://111.229.53.45:6379");
        return (Redisson) Redisson.create(config);
    }

    public static void main(String[] args) {
        HashMap map= new HashMap();
        map.put("xxx",1);
        map.put(null,null);
        map.put(null,null);
        List list = new ArrayList();
        list.add(2);
    }
}
