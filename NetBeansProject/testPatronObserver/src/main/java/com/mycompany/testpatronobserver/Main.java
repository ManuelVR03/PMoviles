package com.mycompany.testpatronobserver;

/**
 *
 * @author verde
 */

public class Main {
    
    public static void main(String[] args) {
        Producto pd1 = new Producto("Portatil ASUS", 10);
        
        Subscriptor cliente1 = new Subscriptor("Juan");
        Subscriptor cliente2 = new Subscriptor("Maria");

        pd1.registerObserver(cliente1);
        pd1.notifyObservers();
        pd1.setCantidad(5);
        pd1.registerObserver(cliente2);
        pd1.removeObserver(cliente1);
        pd1.setCantidad(2);
    }
}

