package com.loafman.shadowcard.controller

import com.loafman.shadowcard.model.Product
import com.loafman.shadowcard.service.ProductService
import jakarta.annotation.security.PermitAll
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/products")
class ProductController(private val productService: ProductService) {

    @GetMapping
    @PermitAll
    fun getProducts(): List<Product> {
        return productService.getAllProducts()
    }
}
