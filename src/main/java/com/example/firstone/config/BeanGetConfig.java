package com.example.firstone.config;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

/**
 * @author : wangjun
 * @version 2.0
 * @ClassName: BeanGetConfig
 * @Description: TODO
 * @date : 2021/04/01 9:25
 */
//@Component
public class BeanGetConfig implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory factory) throws BeansException {
        BeanFactory parentBeanFactory = factory.getParentBeanFactory();
    }
}
