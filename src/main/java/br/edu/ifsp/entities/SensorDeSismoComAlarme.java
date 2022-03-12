package br.edu.ifsp.entities;

public class SensorDeSismoComAlarme extends Dispositivo {
    private float nivelDoAbalo;
    public final int LIMIAR_DE_SEGURANCA = 7;

    private Barragem barragem;

    public SensorDeSismoComAlarme() {
    }

    public SensorDeSismoComAlarme(String id, Barragem barragem, float nivelDoAbalo) {
        super(id, barragem);
        this.nivelDoAbalo = nivelDoAbalo;
    }

    public float getNivelDoAbalo() {
        return nivelDoAbalo;
    }

    public void setNivelDoAbalo(float nivelDoAbalo) {
        this.nivelDoAbalo = nivelDoAbalo;
    }

    public int getLimiarDeSeguranca() {
        return LIMIAR_DE_SEGURANCA;
    }

    @Override
    public String dispararAlarme(int contadorDeSismo) {
        if (contadorDeSismo <= 5){
            return "Perigo eminente! Alerta sonoro...";
        }
        return "Não há registro de abalos na barragem! Keep going...";
    }

    @Override
    public String toString() {
        return super.toString() + nivelDoAbalo + " | ";
    }

}
