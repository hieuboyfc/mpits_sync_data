package com.fps.mpits.util;

import com.fps.mpits.exception.ResourceNotFoundException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

/**
 * @author HieuDT28 (Hiếu Boy) - 19/05/2020
 */

@Service
public class BeanUtil implements ApplicationContextAware {

    private static ApplicationContext context;

    private static ApplicationContext getContext() {
        return context;
    }

    private static void setContext(ApplicationContext context) {
        BeanUtil.context = context;
    }

    @Override
    public void setApplicationContext(ApplicationContext context) {
        setContext(context);
    }

    public static <T> T getBean(Class<T> beanClass) {
        if (getContext() == null)
            throw new ResourceNotFoundException(BeanUtil.class.getName(), ApplicationContext.class.getName(),
                    beanClass.getName());
        return getContext().getBean(beanClass);
    }

}
