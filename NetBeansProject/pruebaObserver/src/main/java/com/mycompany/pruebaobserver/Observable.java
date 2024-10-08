package com.mycompany.pruebaobserver;

import java.util.ArrayList;

/**
 *
 * @author Enrique
 *
 */
public class Observable implements IObservable {

    private ArrayList<IObserver> observadores = new ArrayList<>();

    private int numero = 0;

    public Observable() {

    }

    public void inicio() {

        while (true) {

            numero++;
            if (numero % 2 == 0) {
                this.notifyObservers();
            }
        }
    }

    @Override
    public void addObserver(IObserver o) {
        observadores.add(o);
    }

    @Override
    public void removeObserver(IObserver o) {

        observadores.remove(o);

    }

    @Override
    public void notifyObservers() {

        for (IObserver o : observadores) {

            o.update(this, numero);

        }

    }

}
