package com.mycompany.pruebaobserver;

/**
 *
 * @author Enrique
 *
 */
public class Observador2 implements IObserver {

    @Override
    public void update(Object o, Object arg) {

        int n = (int) arg;
        if (n == 100 && n%2 == 0)
            System.out.println("Todos los numeros son pares");

    }

}
