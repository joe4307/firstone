package com.example.firstone.impl;

import com.example.firstone.OneTestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author : wangjun
 * @version 2.0
 * @ClassName: TestService
 * @Description: TODO
 * @date : 2021/03/31 23:31
 */
@Component
@Slf4j
public class TestServiceFallback implements OneTestService {
    @Override
    public String test(String name) {
        // TODO 记录调用失败日志采取补偿机制
        return null;
    }
}
