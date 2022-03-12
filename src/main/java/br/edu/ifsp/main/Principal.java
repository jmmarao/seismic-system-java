package br.edu.ifsp.main;

import br.edu.ifsp.entities.*;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Principal principal = new Principal();

        principal.inserirBarragemESensores();
        principal.inserirSensorDeSismoComAlarme(principal);
        principal.removerAlarmeDeColapso(principal);
        principal.consultarDispositivo(principal);
        principal.listarTodos();

    }

    private void inserirBarragemESensores() {
        Barragem barragem = new Barragem("Itupararanga", "Sorocaba");

        DAO<Barragem, String> daoBarragem = new BarragemDAO();
        daoBarragem.insert(barragem);

        Random random = new Random();
        SensorDeSismo sensorDeSismo1 = new SensorDeSismo("SS01", barragem, random.nextBoolean());
        SensorDeSismo sensorDeSismo2 = new SensorDeSismo("SS02", barragem, random.nextBoolean());
        SensorDeSismo sensorDeSismo3 = new SensorDeSismo("SS03", barragem, random.nextBoolean());
        SensorDeSismoComAlarme sensorDeSismoComAlarme1 = new SensorDeSismoComAlarme("SA01", barragem, random.nextFloat() * 10);
        SensorDeSismoComAlarme sensorDeSismoComAlarme2 = new SensorDeSismoComAlarme("SA02", barragem, random.nextFloat() * 10);
        AlarmeDeColapso alarmeDeColapso1 = new AlarmeDeColapso("AC01", barragem);
        AlarmeDeColapso alarmeDeColapso2 = new AlarmeDeColapso("AC02", barragem);
        AlarmeDeColapso alarmeDeColapso3 = new AlarmeDeColapso("AC03", barragem);
        AlarmeDeColapso alarmeDeColapso4 = new AlarmeDeColapso("AC04", barragem);

        barragem.addDispositivo(sensorDeSismo1);
        barragem.addDispositivo(sensorDeSismo2);
        barragem.addDispositivo(sensorDeSismo3);
        barragem.addDispositivo(sensorDeSismoComAlarme1);
        barragem.addDispositivo(sensorDeSismoComAlarme2);

        DAO<Dispositivo, String> daoDispositivo = new DispositivoDAO();
        daoDispositivo.insert(sensorDeSismo1);
        daoDispositivo.insert(sensorDeSismo2);
        daoDispositivo.insert(sensorDeSismo3);
        daoDispositivo.insert(sensorDeSismoComAlarme1);
        daoDispositivo.insert(sensorDeSismoComAlarme2);
        daoDispositivo.insert(alarmeDeColapso1);
        daoDispositivo.insert(alarmeDeColapso2);
        daoDispositivo.insert(alarmeDeColapso3);
        daoDispositivo.insert(alarmeDeColapso4);
    }

    private void inserirSensorDeSismoComAlarme(Principal principal) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Identificação: ");
        String id = scanner.nextLine();
        System.out.println();

        BarragemDAO daoBarragem = new BarragemDAO();
        Barragem barragem = daoBarragem.readOne("Itupararanga");
        Random random = new Random();
        SensorDeSismoComAlarme sensorDeSismoComAlarme = new SensorDeSismoComAlarme(id, barragem, random.nextFloat() * 10);
        barragem.addDispositivo(sensorDeSismoComAlarme);
        DAO<Dispositivo, String> daoDispositivo = new DispositivoDAO();
        daoDispositivo.insert(sensorDeSismoComAlarme);
        scanner.close();
    }

    private void removerAlarmeDeColapso(Principal principal) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Identificação: ");
        String id = scanner.nextLine();
        System.out.println();
        Dispositivo dispositivoARemover = principal.buscarDispositivo(id);
        if (dispositivoARemover != null) {
            BarragemDAO daoBarragem = new BarragemDAO();
            Barragem barragem = daoBarragem.readOne("Itupararanga");
            barragem.rmDispositivo(dispositivoARemover);
            DAO<Dispositivo, String> daoDispositivo = new DispositivoDAO();
            daoDispositivo.removeByKey(id);
        }
        scanner.close();
    }

    private void consultarDispositivo(Principal principal) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Identificação: ");
        String id = scanner.nextLine();
        System.out.println();
        Dispositivo dispositivoAConsultar = principal.buscarDispositivo(id);
        if (dispositivoAConsultar != null) {
            System.out.println(dispositivoAConsultar);
        }
        else{
            System.out.println("Dispositivo não encontrado");
        }
        scanner.close();
    }

    private Dispositivo buscarDispositivo(String id){
        DispositivoDAO dao = new DispositivoDAO();
        return dao.readOne(id);
    }

    public void listarTodos(){
        BarragemDAO daoBarragem = new BarragemDAO();
        List<Barragem> todasBarragens = daoBarragem.readAll();
        for (Barragem barragem : todasBarragens) {
            System.out.println("############# " + barragem);
        }

        DispositivoDAO daoDispositivo = new DispositivoDAO();
        List<Dispositivo> todosSensores = daoDispositivo.readAll();
        for (Dispositivo sensor : todosSensores) {
            System.out.println(sensor);
        }
        System.out.println("------------------------------------");
    }
}
