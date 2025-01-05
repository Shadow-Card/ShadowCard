package com.loafman.shadowcard.mapper

import com.loafman.shadowcard.model.Product
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Select

@Mapper
interface ProductMapper {
    @Select("SELECT * FROM products")
    fun findAll(): List<Product>
}
