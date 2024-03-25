package com.supinfo.recipapp.ui.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.supinfo.reciapp.data.model.Recipe
import com.supinfo.recipapp.R
import com.supinfo.recipapp.databinding.ItemRecipeBinding

class RecipeListAdapter(
    var recipes: List<Recipe>,
    private val onItemClick: (Recipe) -> Unit
) : RecyclerView.Adapter<RecipeListAdapter.RecipeViewHolder>() {

    fun updateData(newRecipes: List<Recipe>) {
        recipes = newRecipes
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val binding = ItemRecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecipeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipes[position]
        holder.bind(recipe)
    }

    override fun getItemCount(): Int = recipes.size

    inner class RecipeViewHolder(private val binding: ItemRecipeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(recipe: Recipe) {
            binding.root.setOnClickListener { onItemClick(recipe) }
            binding.textRecipeTitle.text = recipe.title
            // Load recipe image using Glide or any other image loading library
            Glide.with(binding.root.context)
                .load(recipe.imageUrl)
                .placeholder(R.drawable.image_logo)
                .into(binding.imageRecipe)
        }
    }
}