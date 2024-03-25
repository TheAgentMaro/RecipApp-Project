package com.supinfo.recipapp.ui.screens.recipeDetails

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.supinfo.recipapp.R
import com.supinfo.reciapp.data.model.Recipe

class RecipeDetailsActivity : AppCompatActivity() {

    private lateinit var textRecipeTitle: TextView
    private lateinit var textUpdateTime: TextView
    private lateinit var textIngredients: TextView
    private lateinit var imageRecipe: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_details)

        textRecipeTitle = findViewById(R.id.textRecipeTitle)
        textUpdateTime = findViewById(R.id.textLastUpdateTime)
        textIngredients = findViewById(R.id.textIngredients)
        imageRecipe = findViewById(R.id.image_recipe)

        val recipe: Recipe? = intent.getParcelableExtra<Recipe>("recipe")
        val imageUrl: String? = intent.getStringExtra("imageResId")

        populateRecipeDetails(recipe, imageUrl)
    }

    private fun populateRecipeDetails(recipe: Recipe?, imageUrl: String?) {
        recipe?.let {
            textRecipeTitle.text = it.title
            textUpdateTime.text = it.dateUpdated ?: "No update time available"
            textIngredients.text = it.ingredients?.joinToString("\n") ?: "No ingredients available"
        }

        imageUrl?.let {
            Glide.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.image_logo) // Placeholder image while loading
                .error(R.drawable.image_logo) // Error image if Glide fails to load the image
                .centerCrop()
                .into(imageRecipe)
        }
    }
}