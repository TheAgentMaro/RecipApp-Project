package com.supinfo.recipapp.data.local

import com.supinfo.reciapp.data.model.Recipe
import com.supinfo.recipapp.data.local.dao.RecipeDao

class RecipeCache(private val recipeDao: RecipeDao) {

    suspend fun insertRecipes(recipes: List<Recipe>) {
        recipeDao.insertRecipes(recipes)
    }

    suspend fun getAllRecipes(): List<Recipe> {
        return recipeDao.getAllRecipes()
    }

    suspend fun getRecipeById(id: Int): Recipe? {
        return recipeDao.getRecipeById(id)
    }
}