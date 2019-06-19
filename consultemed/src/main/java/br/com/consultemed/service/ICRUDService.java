package br.com.consultemed.service;

public interface ICRUDService<T> {

    void cadastrar(T t);
    T buscarPorID(Long id);

}
