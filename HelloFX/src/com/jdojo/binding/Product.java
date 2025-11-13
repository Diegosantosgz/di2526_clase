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

/* Imos crear unha clase JavaBean Product que representa un produto dunha tenda online. Este produto terá dúas propiedades:
name
price

1. Crea a clase Product
Deberá ter o campos privados name e price String e Double respectivamente.
As propiedades públicas dacordo a convención JavaBean.
A propiedade price debe estar ligada usando a clase PropertyChangeSupport
Lembra os métodos para engadir e eliminar escoitadores.
2. Crea unha clase ProductTest:
Instancia un produto cun prezo inicial.
Mostra o prezo e o desconto calculado.
Engadimos un listerner que escoitará se o prezo cambiou e no caso de cambiar amose o valor anterior o novo e mais o novo desconto.
Modifica o prezo tres veces, incluíndo unha repetición do mesmo valor para comprobar que non se lanza notificación. */