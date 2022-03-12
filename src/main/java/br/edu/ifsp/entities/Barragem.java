package br.edu.ifsp.entities;

import java.util.ArrayList;
import java.util.List;

public class Barragem {
    private String nome;
    private String cidade;
    private int contadorDeSismo;

    private SensorDeSismo sensorDeSismo;
    private SensorDeSismoComAlarme sensorDeSismoComAlarme;
    private AlarmeDeColapso alarmeDeColapso;

    private List<Dispositivo> dispositivos = new ArrayList<>();

    public Barragem() {
    }

    public Barragem(String nome, String cidade) {
        this.nome = nome;
        this.cidade = cidade;
    }

    public void aumentarContador(){
        contadorDeSismo++;
    }

    public void diminuirContador(){
        contadorDeSismo--;
    }

    public String notificarDispositivos(){
        for (Dispositivo dispositivo : dispositivos) {
            return dispositivo.dispararAlarme(contadorDeSismo);
        }
        return "";
    }

    public void addDispositivo(Dispositivo dispositivo){
        dispositivos.add(dispositivo);
        if (dispositivo instanceof SensorDeSismo){
            if (((SensorDeSismo) dispositivo).isAbaloSismico()){
                aumentarContador();
            }
        }
        if (dispositivo instanceof SensorDeSismoComAlarme){
            if (((SensorDeSismoComAlarme) dispositivo).getNivelDoAbalo() >= ((SensorDeSismoComAlarme) dispositivo).getLimiarDeSeguranca()){
                aumentarContador();
            }
        }
    }

    public void rmDispositivo(Dispositivo dispositivo){
        if (dispositivo != null) {
            dispositivos.remove(dispositivo);
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCidade() {
        return cidade;
    }

    public int getContadorDeSismo() {
        return contadorDeSismo;
    }

    @Override
    public String toString() {
        return "Barragem " + nome +
                " | " + cidade +
                " | Notificações de abalo: " + contadorDeSismo +
                " | Estado da barragem: " + notificarDispositivos();
    }
}
