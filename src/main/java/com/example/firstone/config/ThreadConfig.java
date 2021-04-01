package com.example.firstone.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.concurrent.*;

@Configuration
public class ThreadConfig {

    @Bean
    public ExecutorService getThread(){
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,10,60,
                TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(10),new ThreadPoolExecutor.CallerRunsPolicy());
//        threadPoolExecutor.execute();
        threadPoolExecutor.submit(() ->{
            System.out.println(Thread.currentThread().getName());
        });
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                HashMap map = new HashMap();
            }
        });




        return executorService;
    }

    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5,10,60,
                TimeUnit.MILLISECONDS,new ArrayBlockingQueue<>(10),new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i=0;i < 100;i++)   {
            threadPoolExecutor.submit(() ->{
                try {
                    Thread.sleep(3000);
                    System.out.println(Thread.currentThread().getName()+ "........");
                }catch (Exception e){

                }
            });
        }
    }
}
