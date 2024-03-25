package com.supinfo.recipapp.ui.screens.recipeList

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.supinfo.recipapp.R
import com.supinfo.recipapp.data.remote.api.ApiService
import com.supinfo.recipapp.data.remote.api.RetrofitInstance
import com.supinfo.recipapp.data.remote.repository.RecipeRepository
import com.supinfo.recipapp.ui.adapter.RecipeListAdapter
import com.supinfo.recipapp.ui.viewmodels.RecipeListViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class RecipeListActivity : AppCompatActivity() {

    private lateinit var viewModel: RecipeListViewModel
    private lateinit var adapter: RecipeListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_list)

        // Initialize RecyclerView
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewRecipes)
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = RecipeListAdapter(emptyList()) { recipe -> /* Handle item click */ }
        recyclerView.adapter = adapter

        // Initialize ViewModel
        val apiService = RetrofitInstance.create()
        val repository = RecipeRepository(apiService)
        viewModel = RecipeListViewModel(repository)

        // Observe ViewModel LiveData
        viewModel.recipes.observe(this) { recipes ->
            adapter.updateData(recipes)
        }

        // Fetch recipes
        CoroutineScope(Dispatchers.Main).launch {
            viewModel.searchRecipes("pizza") // Initial query example
        }
    }
}