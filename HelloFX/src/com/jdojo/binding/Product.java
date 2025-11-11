package com.jdojo.binding;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class Product {

    // CLASE PRODUCT DEL EJERCICIO 12 (CREACIÓN DE UNA CLASE JAVABEAN)

    private String name;
    private double price;

    private PropertyChangeSupport pcs = new PropertyChangeSupport(this);

    public Product() {
        this.name = "Maria Dolores";
        this.price = 1000.0;
    }
    public Product(String name, double price){
        this.name = name;
        this.price = price;
    } 

    public void addPropertyChangeListener(PropertyChangeListener listener){
        pcs.addPropertyChangeListener(listener);
    }
    public void removePropertyChangeListener(PropertyChangeListener listener){
        pcs.removePropertyChangeListener(listener);
    }

    @Override
    public String toString() {
        return "name = " + name + ", price = " + price;
    }
    

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double newPrice) {
        double oldPrice = this.price;
        this.price = newPrice;
        pcs.firePropertyChange("price", oldPrice, newPrice);

    }

    public Double getPrice() {
        return price;
    }

    public void setPcs(PropertyChangeSupport pcs) {
        this.pcs = pcs;
    }

    public PropertyChangeSupport getPcs() {
        return pcs;
    }

}
