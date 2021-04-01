package com.example.firstone.expand;

import com.example.firstone.config.RedissonConfig;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

//@Component
public class SpringExpand implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory configurableListableBeanFactory) throws BeansException {
        GenericBeanDefinition redissonson = (GenericBeanDefinition) configurableListableBeanFactory.getBeanDefinition("redisson");
        redissonson.setBeanClass(RedissonConfig.class);
    }
}
