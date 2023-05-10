package com.example.demo3.service;

import com.example.demo3.domain.Product;

import java.util.Optional;

public interface ProductService { // 실제로 데이터 처리하는 파트

    public Product save(Product product);
    // 어떠한 고유한 id를 가지고 객체를 찾았을때 그것이 null값 이더라도 객체를 알아서 찾을 수 있도록
    public Optional<Product> findById(Long id);
    public Product update(Long id, Product product);
    public void delete(Long id);

}
