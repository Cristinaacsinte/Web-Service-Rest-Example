package it.euris.academy.webservicerest.service;

import it.euris.academy.webservicerest.data.entity.Product;

import java.util.List;

public interface ProductService {

  public List<Product> findAll();

  Product insert(Product product);

  Product update(Product product);

  Boolean deleteById(Integer id);

}
