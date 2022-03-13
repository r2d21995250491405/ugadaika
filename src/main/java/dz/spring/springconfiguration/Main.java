package dz.spring.springconfiguration;

import jdk.dynalink.support.SimpleRelinkableCallSite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.MessageSource;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.util.Locale;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        ApplicationContext context = new ClassPathXmlApplicationContext("conf.xml");
        SpringEventPublisher publisher = context.getBean(SpringEventPublisher.class);

        Locale locale =Locale.getDefault();
        Scanner sc = new Scanner(System.in);
        System.out.println(context.getMessage("hello",null, locale));
        int number = (int) (Math.random() * 10);
        System.out.println(context.getMessage("try",null, locale));

        int enteredNum = sc.nextInt();

        while (number != enteredNum) {
            publisher.publishEvent(number, enteredNum);
            enteredNum = sc.nextInt();
        }
        System.out.println(context.getMessage("gotme",new Object[]{number}, locale));

    }
}
