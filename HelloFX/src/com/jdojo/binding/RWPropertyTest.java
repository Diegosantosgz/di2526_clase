package com.jdojo.binding;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public class RWPropertyTest {

    public static void main(String[] args) {

        IntegerProperty counter = new SimpleIntegerProperty(1);
        int counterValue = counter.get();

        System.out.println("Counter:" + counterValue);
        counter.set(2);

        counterValue = counter.get();
        System.out.println("Counter:" + counterValue);
    }
}