package br.edu.ifsp.entities;

public class AlarmeDeColapso extends Dispositivo {

    private Barragem barragem;

    public AlarmeDeColapso() {
    }

    public AlarmeDeColapso(String id, Barragem barragem) {
        super(id, barragem);
    }

    @Override
    public String dispararAlarme(int contadorDeSismo) {
        if (contadorDeSismo >= 6){
            return "Alerta de evacuação! Corra para as colinas...";
        }
        return "Não há registro de abalos na barragem! Keep going...";
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
