package com.logo.DAO;

import com.logo.model.Product;

import java.util.List;

public class ProductJdbcConnection implements ConnectionFactory<Product,Integer> {


    @Override
    public Product create(Product product) {

        return null;
    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Product updateById(int id, Product product) {
        return null;
    }

    @Override
    public String deleteById(int id) {
        return null;
    }
}
