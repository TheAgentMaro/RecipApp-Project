package com.supinfo.recipapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.supinfo.recipapp.data.remote.api.ApiService
import com.supinfo.recipapp.data.remote.repository.RecipeRepository
import com.supinfo.recipapp.ui.adapter.RecipeListAdapter
import com.supinfo.recipapp.ui.screens.recipeDetails.RecipeDetailsActivity
import com.supinfo.recipapp.ui.viewmodels.RecipeListViewModel
import com.supinfo.recipapp.ui.viewmodels.RecipeListViewModelFactory
import com.supinfo.recipapp.util.Constants.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : ComponentActivity() {

    private val apiService = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(OkHttpClient())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiService::class.java)

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RecipeListAdapter
    private val viewModel: RecipeListViewModel by viewModels {
        RecipeListViewModelFactory(RecipeRepository(apiService))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recipeRecyclerView)
        adapter = RecipeListAdapter(emptyList()) { recipe ->
            val intent = Intent(this, RecipeDetailsActivity::class.java)
            intent.putExtra("recipe", recipe)
            intent.putExtra("imageResId", recipe.imageUrl)
            startActivity(intent)
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Setup search functionality
        val searchView = findViewById<SearchView>(R.id.searchView)
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                // Perform search when user submits query
                if (!query.isNullOrBlank()) {
                    viewModel.searchRecipes("1", query!!)
                }
                return true
            }


            override fun onQueryTextChange(newText: String?): Boolean {
                if (!newText.isNullOrBlank()) {
                    viewModel.searchRecipes("1", newText)
                } else {
                    // If the search query is empty, you may want to show the initial data or clear the search results
                    viewModel.searchRecipes("1", "pizza")
                }
                return true
            }
        })

        viewModel.recipes.observe(this, Observer { recipes ->
            adapter.updateData(recipes)
        })

        // Fetch recipe data when activity is created
        viewModel.searchRecipes("1","pizza")
    }
}