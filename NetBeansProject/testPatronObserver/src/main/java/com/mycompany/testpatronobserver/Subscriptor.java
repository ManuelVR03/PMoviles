/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.testpatronobserver;

/**
 *
 * @author verde
 */
public class Subscriptor implements Observer {
    private String cliente;

    public Subscriptor(String cliente) {
        this.cliente = cliente;
    }

    @Override
    public void update(String producto, int cantidad) {
        System.out.println("Notificacion para " + cliente + ": El stock de " + producto + " ha cambiado a " + cantidad);
    }
}

