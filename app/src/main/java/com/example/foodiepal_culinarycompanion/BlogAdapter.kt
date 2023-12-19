import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodiepal_culinarycompanion.BlogData
import com.example.foodiepal_culinarycompanion.Meal
import com.example.foodiepal_culinarycompanion.R

class BlogAdapter(private val blogs: MutableList<BlogData>) : RecyclerView.Adapter<BlogAdapter.BlogViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BlogViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_blog, parent, false)
        return BlogViewHolder(itemView)
    }

    class BlogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Define views inside the item layout
        val name: TextView = itemView.findViewById(R.id.blogName)
        val description: TextView = itemView.findViewById(R.id.blogDescription)
        val author: TextView = itemView.findViewById(R.id.blogAuthor)
    }


    override fun onBindViewHolder(holder: BlogViewHolder, position: Int) {
        val currentRecipe = blogs[position]

        // Set data to views inside the ViewHolder
        holder.name.text = currentRecipe.name
        holder.description.text = currentRecipe.description
        holder.author.text = currentRecipe.author
    }

    override fun getItemCount(): Int {
        return blogs.size
    }
}
