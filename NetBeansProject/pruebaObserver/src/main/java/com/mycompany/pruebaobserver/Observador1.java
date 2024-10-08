package com.mycompany.pruebaobserver;

/**
 *
 * @author Enrique
 *
 */
public class Observador1 implements IObserver {

    @Override
    public void update(Object o, Object arg) {

        int n = (int) arg;
        if (n <= 100)
            System.out.println(n);

    }

}
