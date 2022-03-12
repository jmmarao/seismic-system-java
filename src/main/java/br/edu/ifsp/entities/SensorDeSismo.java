package br.edu.ifsp.entities;

public class SensorDeSismo extends Dispositivo {
    public boolean abaloSismico;
    private Barragem barragem;

    public SensorDeSismo() {
    }

    public SensorDeSismo(String id, Barragem barragem, boolean abaloSismico) {
        super(id, barragem);
        this.abaloSismico = abaloSismico;
    }

    public boolean isAbaloSismico() {
        return abaloSismico;
    }

    public void setAbaloSismico(boolean abaloSismico) {
        this.abaloSismico = abaloSismico;
    }

    @Override
    public String dispararAlarme(int contadorDeSismo) {
        if (contadorDeSismo <= 2){
            return "Cuidado! Luzes piscando...";
        }
        return "Não há registro de abalos na barragem! Keep going...";
    }

    @Override
    public String toString() {
        return super.toString() + abaloSismico + " | ";
    }

}
