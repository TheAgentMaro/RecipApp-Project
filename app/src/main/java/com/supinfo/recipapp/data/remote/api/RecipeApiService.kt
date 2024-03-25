// Interface Retrofit pour les appels à l'API Food2Fork

package com.supinfo.recipapp.data.remote.api

import com.supinfo.reciapp.data.model.Recipe
import com.supinfo.recipapp.data.model.SearchResult
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface ApiService {

    @GET("recipe/search/")
    suspend fun searchRecipes(
        @Query("page") page: String,
        @Query("query") query: String,
        @Header("Authorization") token: String = "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"
    ): SearchResult

    @GET("recipe/get/")
    suspend fun getRecipeById(
        @Query("id") id: Int,
        @Header("Authorization") token: String = "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"
    ): Recipe
}