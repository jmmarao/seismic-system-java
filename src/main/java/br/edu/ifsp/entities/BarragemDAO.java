package br.edu.ifsp.entities;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class BarragemDAO implements DAO<Barragem, String>{
    private static Map<String, Barragem> bdBarragem = new LinkedHashMap<>();

    public BarragemDAO() {
    }
    @Override
    public boolean insert(Barragem barragem) {
        if (barragem == null) {
            throw new IllegalArgumentException("Barragem não pode ser nula");
        }
        if (!bdBarragem.containsKey(barragem.getNome())){
            bdBarragem.put(barragem.getNome(), barragem);
            return true;
        }
        return false;
    }

    @Override
    public Barragem readOne(String nome) {
        if (nome != null) {
            return bdBarragem.get(nome);
        }
        return null;
    }

    @Override
    public List<Barragem> readAll() {
        return new ArrayList<>(bdBarragem.values());
    }

    @Override
    public boolean update(Barragem barragem) {
        if (barragem != null) {
            return bdBarragem.replace(barragem.getNome(), barragem) != null;
        }
        return false;
    }

    @Override
    public boolean remove(Barragem barragem) {
        if (barragem != null) {
            return removeByKey(barragem.getNome());
        }
        return false;
    }

    @Override
    public boolean removeByKey(String nome) {
        if (nome != null) {
            return bdBarragem.remove(nome) != null;
        }
        return false;
    }

}
