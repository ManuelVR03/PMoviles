package com.mycompany.pruebaobserver;

/**
 *
 * @author Enrique
 *
 */
public class Observador3 implements IObserver {

    @Override
    public void update(Object o, Object arg) {

        int n = (int) arg;
        for (int i = 0; i < n; i++)
            if (n == 100)
                System.out.println("Se han mostrado " + i + " numeros");

    }

}
