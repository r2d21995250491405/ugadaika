package dz.spring.springconfiguration;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class SpringEventListener implements ApplicationListener<SpringEvent>, ApplicationContextAware {

    ApplicationContext context;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.context = applicationContext;
    }

    @Override
    public void onApplicationEvent(SpringEvent event) {

        Locale locale = Locale.getDefault();

        if (event.getNumber() > event.getEnteredNumber()) {
            System.out.println(context.getMessage("less", null, locale));
        } else {
            System.out.println(context.getMessage("more", null, locale));
        }
    }


}
