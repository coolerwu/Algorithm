package vip.wulang.test.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class EnHeHaHaBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Resource
    private Class aClass;

    public EnHeHaHaBeanFactoryPostProcessor() {
    }

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        beanFactory.registerSingleton("11111", new Object());
    }
}
