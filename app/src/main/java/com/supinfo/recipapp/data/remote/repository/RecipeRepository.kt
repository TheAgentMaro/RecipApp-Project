// Classe Repository pour la gestion des recettes

package com.supinfo.recipapp.data.remote.repository

import com.supinfo.reciapp.data.model.Recipe
import com.supinfo.recipapp.data.model.SearchResult
import com.supinfo.recipapp.data.remote.api.ApiService

class RecipeRepository(private val apiService: ApiService) {

    suspend fun searchRecipes(page: String, query: String): SearchResult {
        return apiService.searchRecipes(page, query)
    }

    suspend fun getRecipeById(id: Int): Recipe {
        return apiService.getRecipeById(id)
    }
}