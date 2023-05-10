package com.example.demo3.controller;

import com.example.demo3.service.ProductServiceImpl;
import com.example.demo3.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@CrossOrigin("*") // CORS Error
@RestController // http 방식의 경로 규칙에 맞게 호출하도록
@RequestMapping("/api") // 어떤 경로로 사용자의 요청을 받을지
// Service의 요청을 받는 부분: Controller
public class ProductController {

    @Autowired
    ProductServiceImpl productService; // Service의 요청을 받기 때문에

    @GetMapping("/products/{id}") // 이 방법을 통해 Read액션(조회)을 실행시킬 수 있음
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable("id") long id) {
        try {
            return ResponseEntity.ok(productService.findById(id)); // http의 상태가 ok(정상적인 호출)이면, id값을 넘겨줌
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PostMapping("/products") // 이 방법을 통해 Create액션을 실행시킬 수 있음
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        // @RequestBody 실제로 만들 Product를 전달하는 부분
        try {
            ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(productService.save(product));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @PutMapping("/products/{id}") // 이 방법을 통해 Update액션을 실행시킬 수 있음
    public ResponseEntity<Product> updateProduct(
            @PathVariable("id") long id, // 주소 옆에 붙은 {id}값을 어떤 형태로 집어넣겠느냐
            @RequestBody Product product
    ) {
        try {
            ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(productService.update(id, product));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @DeleteMapping("/products/{id}") // 이 방법을 통해 Delete액션을 실행시킬 수 있음
    public ResponseEntity<HttpStatus> deleteProduct(@PathVariable("id") long id) {
        try {
            productService.delete(id);
            ResponseEntity.noContent(); // noContent(): 이제 그 객체가 없다는 http 상태 값
        } catch (Exception e) {
            e.printStackTrace();
        } return null;
    }
}
