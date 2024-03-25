// Interface DAO pour la gestion des recettes en local

package com.supinfo.recipapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.supinfo.reciapp.data.model.Recipe

@Dao
interface RecipeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRecipes(recipes: List<Recipe>)

    @Query("SELECT * FROM Recipe")
    suspend fun getAllRecipes(): List<Recipe>

    @Query("SELECT * FROM Recipe WHERE id = :id")
    suspend fun getRecipeById(id: Int): Recipe?
}