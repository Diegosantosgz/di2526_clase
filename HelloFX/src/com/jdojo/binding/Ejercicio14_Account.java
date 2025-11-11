package com.jdojo.binding; 

public class Ejercicio14_Account {

    // BINDING ENTRE PROPIEDADES

    public static void main(String[] args) {

        // Se crean dos objetos de tipo Account (dos cuentas bancarias)
        Account acc1 = new Account();
        Account acc2 = new Account();

        // Se enlaza (bind) la propiedad balance de acc2 con la de acc1.
        // Esto significa que el saldo (balance) de acc2 siempre será igual al de acc1.
        // Cada vez que acc1 cambie su saldo, acc2 se actualizará automáticamente.
        acc2.balanceProperty().bind(acc1.balanceProperty());
       
        // Se establece el saldo inicial de acc1 en 2000.0
        acc1.setBalance(2000.0);

        // Se imprimen los saldos iniciales de ambas cuentas.
        // Como acc2 está enlazada a acc1, ambas mostrarán el mismo valor: 2000.0
        System.out.println("Saldo inicial: " + acc1.getBalance());
        System.out.println("Saldo inicial: " + acc2.getBalance());

        // Se añade un "listener" (escuchador) a la propiedad balance de acc2.
        // Este listener se activa cuando la propiedad es invalidada,
        // es decir, cuando el sistema detecta que su valor está a punto de cambiar.
        acc2.balanceProperty().addListener(i -> {
            System.out.println("Ha sido invalidado");
        });

        // Se añade otro listener a la propiedad balance de acc2.
        // Este es un ChangeListener, que se ejecuta cuando el valor de la propiedad
        // realmente cambia (no solo se invalida).
        // Imprime un mensaje y muestra el valor antiguo y el nuevo.
        acc2.balanceProperty().addListener((observable, valorViejo, valorNuevo) -> {
            System.out.println("Ha cambiado la propiedad");
            System.out.println("Valor antiguo: " + valorViejo);
            System.out.println("Valor Nuevo: " + valorNuevo);
        });

        // Se cambia el saldo de acc1 a 1200.0
        // Como acc2 está enlazada, su saldo también cambiará automáticamente.
        // Esto activará los listeners agregados anteriormente.
        acc1.setBalance(1200.0);

        // Se accede al saldo de acc2 (opcional, solo para mantener la referencia actualizada)
        acc2.getBalance();

        // Se cambia nuevamente el saldo de acc1, ahora a 9009.0
        // Nuevamente, acc2 se actualizará automáticamente y se ejecutarán los listeners.
        acc1.setBalance(9009.0);

        // Se accede al saldo de acc2 (sin imprimirlo, solo por consistencia)
        acc2.getBalance();
    }

}
