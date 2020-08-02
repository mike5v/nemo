package com.theapache64.nemo.data.remote

import com.theapache64.nemo.utils.flow.Resource
import com.theapache64.retrosheet.core.SheetQuery
import kotlinx.coroutines.flow.Flow
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by theapache64 : Jul 17 Fri,2020 @ 22:33
 * Copyright (c) 2020
 * All rights reserved
 */
interface NemoApi {

    @GET("config")
    fun getConfig(): Flow<Resource<Config>>

    @SheetQuery("SELECT * LIMIT :products_per_page OFFSET :offset")
    @GET("products")
    fun getProducts(
        @Query("products_per_page") productsPerPage: Int,
        @Query("offset") offset: Int
    ): Flow<Resource<List<Product>>>

    @SheetQuery("SELECT * WHERE id = :productId")
    @GET("products")
    fun getProduct(
        @Query("productId") productId: Int
    ): Flow<Resource<Product>>
}