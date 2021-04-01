package com.example.firstone;

import com.example.firstone.impl.TestServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "eureka-service",fallback = TestServiceFallback.class)
public interface OneTestService {
    @GetMapping("/two/{name}")
    String test(@PathVariable("name") String name);
}
