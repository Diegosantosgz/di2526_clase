package com.jdojo.binding; 


import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Account {

    // Creamos una propiedad observable llamada 'balance'.
    // El constructor de SimpleDoubleProperty que usas tiene 3 parámetros:
    //  this → referencia al objeto propietario (esta instancia de Account)
    //  "balance" → nombre descriptivo de la propiedad (útil para depuración o introspección)
    //  100 → valor inicial del saldo
    // En resumen, cada nueva cuenta se creará con un saldo inicial de 100.0
    private DoubleProperty balance = new SimpleDoubleProperty(this, "balance", 100);

    // Método para establecer (cambiar) el valor del saldo.
    // Al hacerlo, la propiedad 'balance' notificará a cualquier listener o binding que tenga.
    public void setBalance(Double balance) {
        this.balance.set(balance);
    }

    // Método para obtener el valor actual del saldo (balance) de la cuenta.
    public Double getBalance() {
        return balance.get();
    }

    // Método para obtener la propiedad completa 'balanceProperty'.
    // Esto permite hacer cosas como:
    // - Enlazar esta propiedad con otra (bind o bindBidirectional)
    // - Añadir listeners que reaccionen a los cambios del saldo.
    public DoubleProperty balanceProperty() {
        return balance;
    }

}

