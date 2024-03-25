// Classe de base de données Room pour les recettes
package com.supinfo.recipapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.supinfo.reciapp.data.model.Recipe
import com.supinfo.recipapp.data.local.dao.RecipeDao

@Database(entities = [Recipe::class], version = 1, exportSchema = false)
abstract class RecipeDatabase : RoomDatabase() {
    abstract fun recipeDao(): RecipeDao
}