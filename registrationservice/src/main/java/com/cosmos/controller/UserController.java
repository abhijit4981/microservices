package com.cosmos.controller;

import com.cosmos.entity.User;
import com.cosmos.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@Slf4j
public class UserController {

    @Autowired
    private UserService service;
    @GetMapping
    public User getDummyUser() {
        User user = new User();
        user.setMobileNumber(9003049525L);
        user.setPassword("Admin#123");
        log.info("Going to return dummy user :"+user);
        return user;
    }
    @PostMapping("/register")
    public User addUser(@RequestBody User user) {
        log.info("Going to save user :"+user);
        return service.saveUser(user);
    }
    @GetMapping("/user")
    public List<User> getAllUsers() {
        return service.getUsers();
    }


    @PostMapping("/validate")
    public ResponseEntity validateUser(@RequestBody User user) {
        log.info("Going to validate user :"+user);
        return service.validateUser(user);
    }

   /* @PostMapping("/addProducts")
    public List<Product> addProducts(@RequestBody List<Product> products) {
        return service.saveProducts(products);
    }

    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return service.getProducts();
    }

    @GetMapping("/productById/{id}")
    public Product findProductById(@PathVariable int id) {
        return service.getProductById(id);
    }

    @GetMapping("/product/{name}")
    public Product findProductByName(@PathVariable String name) {
        return service.getProductByName(name);
    }

    @PutMapping("/update")
    public Product updateProduct(@RequestBody Product product) {
        return service.updateProduct(product);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteProduct(@PathVariable int id) {
        return service.deleteProduct(id);
    }*/
}
