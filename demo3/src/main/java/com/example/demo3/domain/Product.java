package com.example.demo3.domain;

import javax.persistence.*;

@Entity // product라고 하는 객체를 인식해서 테이블에 쓸 준비를 함
@Table(name="products")
public class Product {
    @Id // 각각의 객체를 구분한 수 있는 고유한 정보
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "product_name") // 실제로 어떤식으로 데이터베이스의 항목이름에 쓸지
    private String productName;

    @Column(name = "price")
    private int price;

    public Product() {} // 빈생성자 만들어주기
    // Alt+insert 단축키
    public Product(String productName, int price) { // 이렇게 public을 붙여야만 외부의 클래스에서 활용할 수 있음
        this.productName = productName;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
