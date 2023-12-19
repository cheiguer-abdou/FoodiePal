package com.example.foodiepal_culinarycompanion

import BlogAdapter
import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class Blog : Fragment() {
    private val blogList = mutableListOf<BlogData>()
    lateinit var blogAdapter:  BlogAdapter
    private var dialogView: View? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_blog, container, false)

        // Find the FloatingActionButton by ID using the inflated view
        val recyclerView: RecyclerView = view.findViewById(R.id.recyclerView)
        blogAdapter = BlogAdapter(blogList)
        recyclerView.adapter = blogAdapter
        val fabButton: FloatingActionButton = view.findViewById(R.id.fabButton)

        // Set a click listener for the FloatingActionButton
        fabButton.setOnClickListener {
            // Call the function to show the Add Recipe dialog
            showAddRecipeDialog()
        }


        val inflater = layoutInflater
        val builder = AlertDialog.Builder(requireActivity())
        dialogView = inflater.inflate(R.layout.dialog_add_blog, null)
        builder.setView(dialogView)
        return view
    }

    // Function to show the Add Recipe dialog
    private fun showAddRecipeDialog() {
        val builder = AlertDialog.Builder(requireActivity())
        val inflater = layoutInflater
        dialogView = inflater.inflate(R.layout.dialog_add_blog, null)
        builder.setView(dialogView)

        val alertDialog = builder.create()

        // Handle button click inside the dialog
        dialogView!!.findViewById<Button>(R.id.btnAddBlog).setOnClickListener {
            val blogName = dialogView!!.findViewById<EditText>(R.id.editTextBlogName).text.toString()
            val blogDescription = dialogView!!.findViewById<EditText>(R.id.editTextBlogDescription).text.toString()
            val blogAuthor = dialogView!!.findViewById<EditText>(R.id.editTextBlogAuthor).text.toString()

            // Add the new recipe to the list
            val newRecipe = BlogData(blogName, blogDescription, blogAuthor)
            blogList.add(newRecipe)

            // Notify the adapter that the data set has changed
            blogAdapter.notifyDataSetChanged()

            alertDialog.dismiss() // Close the dialog
        }

        dialogView!!.findViewById<Button>(R.id.btnCancel).setOnClickListener {
            alertDialog.dismiss()
        }

        alertDialog.show()
    }
}