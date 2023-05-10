package com.example.demo3.service;

import com.example.demo3.domain.Product;
import com.example.demo3.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

// ProductService를 실제로 구현하는 클래스

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository; // 인터페이스 불러옴

    @Override
    public Product save(Product product) { // C: Create
        try {
            return productRepository.save(new Product(
                    product.getProductName(),
                    product.getPrice()
                    )
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<Product> findById(Long id) { // R: Read
        try {
            Optional<Product> productData = productRepository.findById(id);
            // 사용자가 넘겨주는 Id값을 통해 조회가 가능하도록
            if (productData.isPresent()) { // 이 조건문에 사용된 식은 Optional에서 제공하는 기능
                return productData;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product update(Long id, Product product) { // U: update (Update를 하기 위해서는, 조회에 오는 id가 필요)
        try { // 일단 update를 하려면, 조회를 하는 과정이 필요
            Optional<Product> productData = productRepository.findById(id);
            if(productData.isPresent()) { // _product: 새로 덮어쓸 product를 나타냄
                Product _product = productData.get();
                _product.setProductName(product.getProductName()); 
                // setProductName을 통해서 새로운 값으로 덮어쓰기. 그 새로운 값은 product.getProductName()으로 해결
                _product.setPrice(product.getPrice());
                productRepository.save(_product); // 새로운 데이터 객체를 save
                return _product;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } return null;
    }

    @Override
    public void delete(Long id) {
        try {
            productRepository.deleteById(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
