import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodiepal_culinarycompanion.R
import com.example.foodiepal_culinarycompanion.Recipe

class RecipeAdapter(private val recipes: List<Recipe>) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {
        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(itemView)
        }

        class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
                // Define views inside the item layout
                val recipeName: TextView = itemView.findViewById(R.id.textViewRecipeName)
                val recipeIngredients: TextView = itemView.findViewById(R.id.textViewIngredients)
                val recipeInstructions: TextView = itemView.findViewById(R.id.textViewInstructions)
                val imageRecipe: ImageView = itemView.findViewById(R.id.imageRecipeMain)
        }


        override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val currentRecipe = recipes[position]

        // Set data to views inside the ViewHolder
        holder.recipeName.text = currentRecipe.name
        holder.recipeIngredients.text = currentRecipe.ingredients
        holder.recipeInstructions.text = currentRecipe.instructions
        holder.imageRecipe.setImageURI(currentRecipe.imageUrl)
        }

        override fun getItemCount(): Int {
        return recipes.size
        }
}
