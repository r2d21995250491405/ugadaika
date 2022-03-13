package dz.spring.springconfiguration;

import org.springframework.context.ApplicationEvent;

public class SpringEvent extends ApplicationEvent {

    private int number;
    private int enteredNumber;

    public SpringEvent(int number, int enteredNumber) {
        super(number);
        this.number = number;
        this.enteredNumber = enteredNumber;
    }

    public int getNumber() {
        return number;
    }

    public int getEnteredNumber() {
        return enteredNumber;
    }
}
