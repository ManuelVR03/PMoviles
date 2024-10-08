/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.testpatronobserver;

/**
 *
 * @author verde
 */
public interface Observable {
    void registerObserver(Observer observador);
    void removeObserver(Observer observador);
    void notifyObservers();
}

