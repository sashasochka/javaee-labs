package dao;

import data.Identifiable;

import java.util.List;

// Interface for generic CRUD operations on DB data models
public interface GenericDAO<T extends Identifiable> {
    // Create
    void insert(T obj);

    // Read
    T findById(int id);

    List<T> getAll();

    // Update
    void update(T obj);

    // Delete
    boolean deleteById(int id);

    boolean delete(T obj);
}
