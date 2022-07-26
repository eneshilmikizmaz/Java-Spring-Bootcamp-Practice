package com.logo.DAO;

import java.util.List;

public interface ConnectionFactory<T,Integer>  {
    T create(T t);
    List<T> getAll();
    T updateById (int id, T t);
    String deleteById(int id);
}
