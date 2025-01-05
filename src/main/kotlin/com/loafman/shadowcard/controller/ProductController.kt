package com.loafman.shadowcard.controller

import com.loafman.shadowcard.model.Product
import com.loafman.shadowcard.service.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/products")
class ProductController(private val productService: ProductService) {

    @GetMapping
    fun getProducts(): List<Product> {
        return productService.getAllProducts()
    }
}
