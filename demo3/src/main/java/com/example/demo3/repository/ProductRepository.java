package com.example.demo3.repository;


import com.example.demo3.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // 데이터베이스에 스프링의 요청을 직접적으로 전달해서 데이터베이스의 처리들을 도맡아서 함
public interface ProductRepository extends JpaRepository<Product, Long> {
}
