package com.jdojo.binding;

public class Coche {

    // CLASE COCHE DEL EJERCICIO 11 (CREACIÓN DE UNA CLASE COCHE CON PROPIEDADES)

    private String marca;
    private int velocidad;

    public Coche() {

    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void acelerar(int aumento) {
      velocidad = velocidad + aumento;



    }
}



/* Crea unha clase JavaBean chamada Coche que represente un vehículo. Esta clase debe ter as seguintes características:

1. Dous campos privados:
String marca: Para gardar a marca do coche.
int velocidade: Para gardar a velocidade actual do coche en km/h.
2. Métodos públicos para acceder e modificar estes campos, seguindo a convención de nomeado de JavaBeans:
Un getter e un setter para a propiedade marca.
Un getter e un setter para a propiedade velocidade.
3. Un construtor sen parámetros (construtor por defecto).
4. Crea un método acelerar(int aumento) que incremente a velocidade do coche na cantidade especificada.
5. No método main da clase Principal (que terás que crear ti), realiza o seguinte:
Crea unha nova instancia da clase Coche.
Usa o setter para establecer a marca en "Ford".
Usa o getter para obter e imprimir a marca na consola.
Usa o setter para establecer a velocidade inicial en 50 km/h.
Usa o método acelerar para aumentar a velocidade en 20 km/h.
Usa o getter para obter e imprimir a velocidade final do coche na consola. */
