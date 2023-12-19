package com.example.foodiepal_culinarycompanion

import android.net.Uri
import java.net.URI

data class Recipe(val name: String, val ingredients: String, val instructions: String, val imageUrl: Uri)
