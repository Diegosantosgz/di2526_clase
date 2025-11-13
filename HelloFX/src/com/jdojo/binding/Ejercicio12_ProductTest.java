package com.jdojo.binding;

import java.beans.PropertyChangeEvent;

public class Ejercicio12_ProductTest {

    // CREACION DE UNA CLASE JAVABEAN

//   private final static double descuento = 20;
//   private static double total;

    public static void handlePropertyChange(PropertyChangeEvent e) {
        String propertyName = e.getPropertyName();
        if ("price".equals(propertyName)) {
            System.out.print("O precio cambiou");
            System.out.print(" Anterior: " + e.getOldValue());
            System.out.println(", Novo: " + e.getNewValue());
            computeTax((Double) e.getNewValue());
        }
    }

    public static void computeTax(double price) {
        final double TAX_PERCENT = 20.0;
        double tax = price * TAX_PERCENT / 100.0;
    //  double precioFinal = price - TAX_PERCENT;
        System.out.println("Precio: " + price + ", Imposto: " + tax);
    }

    public static void main(String[] args) {

        final Product p1 = new Product("Maria Dolores", 2000.0);

        computeTax(p1.getPrice());

        p1.addPropertyChangeListener(Ejercicio12_ProductTest::handlePropertyChange);

        p1.setPrice(3000.0);
        p1.setPrice(3000.0);
        p1.setPrice(6000.0);

   /*   Product producto = new Product();
        producto.setPrice(50.0);
        total = descuento - producto.getPrice();
        System.out.println("El precio del producto: " + producto.getPrice() + " con el descuento: " + descuento + " es: " + total); */

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