package com.jdojo.binding; 


import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class Account {

    // CLASE ACCOUNT DEL EJERCICIO 14 (BINDING ENTRE PROPIEDADES)

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

/* Imos crear unha clase Account que representa unha conta bancaria cun saldo (balance) representado por unha propiedade JavaFX (DoubleProperty). Ademais, imos comprobar o comportamento das ligazóns entre propiedades e os eventos xerados cando cambian os valores.

Instruccións:

1. Clase Account:

Deberá ter unha propiedade privada balance do tipo DoubleProperty a que se lle proporcionará o bean, un nome descriptivo da propiedade e un valor inicial facendo uso dos constructores das propiedades.
Implementará métodos públicos para:
Acceder ao valor do saldo (getBalance()).
Modificar o valor do saldo (setBalance()).
Acceder á propiedade JavaFX (balanceProperty()).

2. No método main:

Crea dúas contas: acc1 e acc2.
Fai que o saldo de acc2 estea sempre ligado ao de acc1 usando o método bind(). Deste xeito, acc2 sempre reflectirá o saldo de acc1.
Engade un InvalidationListener á propiedade balance de acc2 que imprima unha mensaxe indicando que a propiedade está invalidada cada vez que o seu valor cambia e non foi aínda validado.
Engade un ChangeListener á propiedade balance de acc2 que imprima unha mensaxe con valores antigo e novo cada vez que o saldo cambie efectivamente.
Modifica o saldo de acc1 varias veces usando o método setBalance().
Entre cambios, chama ao método getBalance() de acc2 para validar a propiedade.
Observa a saída para comprender cando se xeran eventos de invalidación e de cambio.




Consellos e pistas: 
Usa SimpleDoubleProperty para crear a propiedade.
Os listeners pódense engadir co método addListener().
No InvalidationListener, usa unha expresión lambda con argumento Observable en vez dunha referencia a método como se fixo nos contidos.
No ChangeListener, usa unha expresión lambda con argumentos (obs, oldVal, newVal).
Lembra que bind() impide modificar directamente a propiedade ligada.
Observa que cando modificas a propiedade e logo chamas ao método get() esta valida a propiedade. */