package com.mycompany.testpatronobserver;

/**
 *
 * @author verde
 */

import java.util.ArrayList;

public class Producto implements Observable {
    private ArrayList<Observer> observadores;
    private String producto;
    private int cantidad;

    public Producto(String producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        observadores = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer) {
        observadores.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observadores.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observador : observadores) {
            observador.update(producto, cantidad);
        }
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        notifyObservers();
    }
}
