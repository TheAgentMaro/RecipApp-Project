package com.supinfo.recipapp.ui.screens.recipeDetails

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.supinfo.recipapp.R
import com.supinfo.reciapp.data.model.Recipe

class RecipeDetailsActivity : AppCompatActivity() {

    private lateinit var textRecipeTitle: TextView
    private lateinit var textRecipeDescription: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_details)

        textRecipeTitle = findViewById<TextView>(R.id.textRecipeTitle)
        textRecipeDescription = findViewById<TextView>(R.id.textRecipeDescription)

        val recipe: Recipe? = intent.getParcelableExtra<Recipe>("recipe")

        populateRecipeDetails(recipe)
    }

    private fun populateRecipeDetails(recipe: Recipe?) {
        recipe?.let {
            textRecipeTitle.text = it.title
            textRecipeDescription.text = it.description ?: "No description available"
        }
    }
}
