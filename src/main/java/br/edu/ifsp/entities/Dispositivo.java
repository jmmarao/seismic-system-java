package br.edu.ifsp.entities;

import java.util.Objects;

public abstract class Dispositivo {
    private String id;
    private Barragem barragem;

    public Dispositivo() {
    }

    public Dispositivo(String id, Barragem barragem) {
        this.id = id;
        this.barragem = barragem;
    }

    public abstract String dispararAlarme(int contadorDeSismo);

    public String getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID " + id + " | ";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dispositivo that = (Dispositivo) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
