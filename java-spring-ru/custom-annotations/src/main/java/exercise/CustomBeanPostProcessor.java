package exercise;

import java.lang.reflect.Proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// BEGIN
@Component
public class CustomBeanPostProcessor implements BeanPostProcessor {

    private final Logger LOGGER = LoggerFactory.getLogger(CustomBeanPostProcessor.class);
    private static final Map<Object, String> logBeans = new HashMap<>();

    @Override
    // Метод вызывается перед инициализацией бина
    // Принимает сам бин и имя бина
    // Должен вернуть бин
    public Object postProcessBeforeInitialization(Object bean, String beanName)
            throws BeansException {

        Inspect inspect = bean.getClass().getAnnotation(Inspect.class);
        if (inspect != null) {
            String levelLog = bean.getClass().getAnnotation(Inspect.class).level();
            logBeans.put(bean, levelLog);
        }
        return bean;
    }

    @Override
    // Метод вызывается после инициализацией бина
    // Должен вернуть бин
    public Object postProcessAfterInitialization(Object bean, String beanName)
            throws BeansException {
        if (logBeans.containsKey(bean)) {
            return Proxy.newProxyInstance(
                    bean.getClass().getClassLoader(),
                    bean.getClass().getInterfaces(),
                    (proxy, method, args) -> {
                        if (method.getName().equals("sum") || method.getName().equals("mult")) {
                            String message = "Was called method: " + method.getName() + "() with arguments: "
                                    + Arrays.toString(args);
                            if(logBeans.get(bean).equalsIgnoreCase("info")) {
                                LOGGER.info(message);
                            } else {
                                LOGGER.debug(message);
                            }
                            return  method.invoke(bean, args);
                        } else {
                            throw new UnsupportedOperationException(
                                    "Unsupported method: " + method.getName());
                        }
                    }
            );
        }
        return bean;
    }

}
// END
