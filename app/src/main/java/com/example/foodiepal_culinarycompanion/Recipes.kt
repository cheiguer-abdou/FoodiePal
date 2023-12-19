package com.example.foodiepal_culinarycompanion

import RecipeAdapter
import android.Manifest
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.github.dhaval2404.imagepicker.ImagePicker
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Recipes : Fragment() {
    // Define a list of recipes
    private val recipeList = mutableListOf<Recipe>()
    lateinit var recipeAdapter:  RecipeAdapter
    private val PERMISSION_CODE = 1001
    private var dialogView: View? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Check and request permissions if needed
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.READ_EXTERNAL_STORAGE
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            // Request permission
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                PERMISSION_CODE
            )
        }
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_recipes, container, false)

        // Find the FloatingActionButton by ID using the inflated view
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        recipeAdapter = RecipeAdapter(recipeList)
        recyclerView.adapter = recipeAdapter
        val fabButton: FloatingActionButton = view.findViewById(R.id.fabButton)

        // Set a click listener for the FloatingActionButton
        fabButton.setOnClickListener {
            // Call the function to show the Add Recipe dialog
            showAddRecipeDialog()
        }


        val inflater = layoutInflater
        val builder = AlertDialog.Builder(requireActivity())
        dialogView = inflater.inflate(R.layout.dialog_add_recipe, null)
        builder.setView(dialogView)

        return view
    }



    // Function to show the Add Recipe dialog
    private fun showAddRecipeDialog() {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = layoutInflater
        dialogView = inflater.inflate(R.layout.dialog_add_recipe, null)
        builder.setView(dialogView)

        val alertDialog = builder.create()

        // Find the "Select Image" button by ID using the inflated view
        val btnSelectImage: Button = dialogView!!.findViewById(R.id.btnSelectImage)

        // Set a click listener for the "Select Image" button
        btnSelectImage.setOnClickListener {
//            Toast.makeText(requireContext(), "Select Image button clicked", Toast.LENGTH_SHORT).show()
            ImagePicker.with(this)
                .crop()	    			//Crop image(Optional), Check Customization for more option
                .compress(1024)			//Final image size will be less than 1 MB(Optional)
                .maxResultSize(1080, 1080)	//Final image resolution will be less than 1080 x 1080(Optional)
                .start()
        }
        // Handle button click inside the dialog
        dialogView!!.findViewById<Button>(R.id.btnAddBlog).setOnClickListener {
            val recipeName = dialogView!!.findViewById<EditText>(R.id.editTextBlogName).text.toString()
            val ingredients = dialogView!!.findViewById<EditText>(R.id.editTextBlogDescription).text.toString()
            val instructions = dialogView!!.findViewById<EditText>(R.id.editTextBlogAuthor).text.toString()
            val imageUrl = dialogView!!.findViewById<ImageView>(R.id.imageRecipe).tag as Uri

            // Add the new recipe to the list
            val newRecipe = Recipe(recipeName, ingredients, instructions, imageUrl)
            recipeList.add(newRecipe)

            // Notify the adapter that the data set has changed
            recipeAdapter.notifyDataSetChanged()

            alertDialog.dismiss() // Close the dialog
        }

        dialogView!!.findViewById<Button>(R.id.btnCancel).setOnClickListener {
            alertDialog.dismiss()
        }

        alertDialog.show()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

            val uri: Uri? = data?.data
            if (uri != null) {

                dialogView?.findViewById<ImageView>(R.id.imageRecipe)?.setImageURI(uri)
                dialogView?.findViewById<ImageView>(R.id.imageRecipe)?.tag = uri
                val s = dialogView?.findViewById<ImageView>(R.id.imageRecipe)?.toString()
        }
    }


}
