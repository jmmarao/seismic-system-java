package br.edu.ifsp.entities;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class DispositivoDAO implements DAO<Dispositivo, String>{

    private static Map<String, Dispositivo> bdDispositivo = new LinkedHashMap<>();

    public DispositivoDAO() {
    }

    @Override
    public boolean insert(Dispositivo dispositivo) {
        if (dispositivo == null) {
            throw new IllegalArgumentException("Dispositivo não pode ser nulo");
        }
        if (!bdDispositivo.containsKey(dispositivo.getId())){
            bdDispositivo.put(dispositivo.getId(), dispositivo);
            return true;
        }
        return false;
    }

    @Override
    public Dispositivo readOne(String id) {
        if (id != null) {
            return bdDispositivo.get(id);
        }
        return null;
    }

    @Override
    public List<Dispositivo> readAll() {
        return new ArrayList<>(bdDispositivo.values());
    }

    @Override
    public boolean update(Dispositivo dispositivo) {
        if (dispositivo != null) {
            return bdDispositivo.replace(dispositivo.getId(), dispositivo) != null;
        }
        return false;
    }

    @Override
    public boolean remove(Dispositivo dispositivo) {
        if (dispositivo != null) {
            return removeByKey(dispositivo.getId());
        }
        return false;
    }

    @Override
    public boolean removeByKey(String id) {
        if (id != null) {
            return bdDispositivo.remove(id) != null;
        }
        return false;
    }
}
