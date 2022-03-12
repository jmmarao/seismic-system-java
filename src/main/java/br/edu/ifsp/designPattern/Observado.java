package br.edu.ifsp.designPattern;

import java.util.ArrayList;
import java.util.List;

public abstract class Observado {

    //Observado = Barragem

    private List<Observador> observadores = new ArrayList<>();
    //private ArrayList<Observador> observadores = new ArrayList<Observador>();

    public void addDispositivo(Observador observador){
        if (observador != null) {
            this.observadores.add(observador);
        }
    }
    public void rmDispositivo(Observador observador){
        if (observador != null) {
            observador.dispararAlarme();
            this.observadores.remove(observador);
        }
    }

    public void notificarDispositivos(){
        for (Observador observador : observadores) {
            observador.dispararAlarme();
        }
    }
}
