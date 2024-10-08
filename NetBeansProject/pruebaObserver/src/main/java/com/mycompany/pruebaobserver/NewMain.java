package com.mycompany.pruebaobserver;

/**
 *
 * @author Enrique
 *
 */
public class NewMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Observable observable = new Observable();
        Observador1 obs1 = new Observador1();
        Observador2 obs2 = new Observador2();
        Observador3 obs3 = new Observador3();

        //suscribo a obs1 a la lista de observadores
        observable.addObserver(obs1);
        observable.addObserver(obs2);
        observable.addObserver(obs3);

        observable.inicio();

    }

}
