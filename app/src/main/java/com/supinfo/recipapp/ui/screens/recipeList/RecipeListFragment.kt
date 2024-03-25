package com.supinfo.recipapp.ui.screens.recipeList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.supinfo.recipapp.ui.adapter.RecipeListAdapter
import com.supinfo.recipapp.R
import com.supinfo.recipapp.ui.viewmodels.RecipeListViewModel
import com.supinfo.recipapp.databinding.FragmentRecipeListBinding

class RecipeListFragment : Fragment() {

    private lateinit var binding: FragmentRecipeListBinding
    private lateinit var viewModel: RecipeListViewModel
    private lateinit var recipeListAdapter: RecipeListAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRecipeListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(RecipeListViewModel::class.java)
        recipeListAdapter = RecipeListAdapter(emptyList()) { /* Handle item click */ }

        binding.recyclerViewRecipes.adapter = recipeListAdapter
        observeViewModel()
    }

    private fun observeViewModel() {
        // Observe LiveData from ViewModel and update UI accordingly
        viewModel.recipes.observe(viewLifecycleOwner) { recipes ->
            recipeListAdapter.recipes = recipes
            recipeListAdapter.notifyDataSetChanged()
        }

        viewModel.isLoading.observe(viewLifecycleOwner) { isLoading ->
            // Show/hide loading indicator
        }
    }
}