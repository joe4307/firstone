package com.example.firstone.controller;

import com.alibaba.excel.EasyExcel;
import com.example.firstone.OneTestService;
import com.example.firstone.entity.User;
import com.example.firstone.mapper.UserMapper;
import com.example.firstone.util.SnowflakeUtils;
import com.example.firstone.vo.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
public class testController {
    @Autowired
    private OneTestService oneTestService;

    @Autowired
    private UserMapper userMapper;

//    @Autowired
//    Redisson  redisson;

//    @GetMapping("test")
//    public String test(){
////        RLock xxx = redisson.getLock("xxx");
//        RReadWriteLock xxx = redisson.getReadWriteLock("xxx");
//        RLock rLock = xxx.readLock();
//        rLock.lock();
////        rLock.lock(30, TimeUnit.SECONDS);
//        return "hello brother!!";
//    }

    @GetMapping("/test")
//    @UpmLogger(category = LogCategory.LOGIN,operation = "测试")
    public String test(@RequestParam String name) {
        String test = oneTestService.test(name);
        System.out.println(test);
        return name;
    }

    @GetMapping("/id")
    public String idGet() {

        System.out.println(SnowflakeUtils.genId());
        return "OK";
    }

    @GetMapping("/download")
    private void download(HttpServletResponse response) {
        List<User> list = userMapper.list();
        System.out.println("xxxxxxxxx");

        // 写法1
        String fileName = System.currentTimeMillis() + ".xlsx";
        try {

            response.setContentType("application/vnd.ms-excel;charset=utf-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName + ".xls");
            ServletOutputStream out = response.getOutputStream();

            EasyExcel.write(response.getOutputStream(), UserVo.class)
                    .sheet("sheet")
                    .doWrite(list);

        } catch (IOException e) {

            throw new RuntimeException("导出文件失败！");
        }

    }
}
