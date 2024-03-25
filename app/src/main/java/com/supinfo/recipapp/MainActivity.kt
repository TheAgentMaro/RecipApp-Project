package com.supinfo.recipapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.supinfo.recipapp.data.remote.api.ApiService
import com.supinfo.recipapp.data.remote.repository.RecipeRepository
import com.supinfo.recipapp.ui.adapter.RecipeListAdapter
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
            // Handle item click
        }
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.recipes.observe(this, Observer { recipes ->
            adapter.updateData(recipes)
        })

        // Fetch recipe data when activity is created
        viewModel.searchRecipes("pizza") // Example initial query
    }
}
