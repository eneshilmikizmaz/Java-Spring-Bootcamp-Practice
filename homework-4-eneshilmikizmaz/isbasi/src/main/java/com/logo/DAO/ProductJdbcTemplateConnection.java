package com.logo.DAO;

import com.logo.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class ProductJdbcTemplateConnection implements ConnectionFactory<Product, Integer> {
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public Product create(Product product) {
        String query = "Insert INTO product (id,name,price) VALUES(?,?,?)";
        jdbcTemplate.update(query, product.getId(), product.getName(), product.getPrice());
        return product;
    }

    @Override
    public List<Product> getAll() {
        return jdbcTemplate.query("Select * From product", BeanPropertyRowMapper.newInstance(Product.class));
    }

    @Override
    public Product updateById(int id, Product product) {
        String query = "Update product set name = ? , price = ? where id = ?";
        jdbcTemplate.update(query, product.getName(),product.getPrice(), id);
        return product;
    }

    @Override
    public String deleteById(int id) {
        String query = "DELETE FROM product WHERE id = ?";
        jdbcTemplate.update(query, id);
        return "deleted " + id;
    }
}
