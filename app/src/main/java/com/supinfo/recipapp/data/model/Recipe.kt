package com.supinfo.reciapp.data.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import java.util.ArrayList

data class Recipe(
    @SerializedName("pk") val id: Int,
    val title: String?,
    val publisher: String?,
    @SerializedName("featured_image") val imageUrl: String?,
    val rating: Int,
    @SerializedName("source_url") val sourceUrl: String?,
    val description: String?,
    @SerializedName("cooking_instructions") val cookingInstructions: String?,
    val ingredients: ArrayList<String>?,
    @SerializedName("date_added") val dateAdded: String?,
    @SerializedName("date_updated") val dateUpdated: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.createStringArrayList(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(title)
        parcel.writeString(publisher)
        parcel.writeString(imageUrl)
        parcel.writeInt(rating)
        parcel.writeString(sourceUrl)
        parcel.writeString(description)
        parcel.writeString(cookingInstructions)
        parcel.writeStringList(ingredients)
        parcel.writeString(dateAdded)
        parcel.writeString(dateUpdated)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Recipe> {
        override fun createFromParcel(parcel: Parcel): Recipe {
            return Recipe(parcel)
        }

        override fun newArray(size: Int): Array<Recipe?> {
            return arrayOfNulls(size)
        }
    }
}