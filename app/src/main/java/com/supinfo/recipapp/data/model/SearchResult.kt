package com.supinfo.recipapp.data.model

import com.google.gson.annotations.SerializedName
import com.supinfo.reciapp.data.model.Recipe

data class SearchResult(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<Recipe>
)