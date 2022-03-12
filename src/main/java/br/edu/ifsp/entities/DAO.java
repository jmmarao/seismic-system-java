package br.edu.ifsp.entities;

import java.util.List;

public interface DAO <T, K> {
    boolean insert(T type);
    T readOne(K key);
    List<T> readAll();
    boolean update(T type);
    boolean removeByKey(K key);
    boolean remove(T type);
}
