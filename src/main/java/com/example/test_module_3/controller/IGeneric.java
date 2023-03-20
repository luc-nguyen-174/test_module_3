package com.example.test_module_3.controller;

import java.util.List;

public interface IGeneric<T> {
    List<T> findAll();

    void save(T generic);

    T findById(int id);

    boolean update(int id, T generic);

    boolean remove(int id);
}
