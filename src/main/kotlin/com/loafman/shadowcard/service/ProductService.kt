package com.loafman.shadowcard.service

import com.loafman.shadowcard.mapper.ProductMapper
import com.loafman.shadowcard.model.Product
import org.springframework.stereotype.Service

@Service
class ProductService(private val productMapper: ProductMapper) {
    fun getAllProducts(): List<Product> {
        return productMapper.findAll()
    }
}
