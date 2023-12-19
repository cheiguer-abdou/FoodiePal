import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.foodiepal_culinarycompanion.Meal
import com.example.foodiepal_culinarycompanion.R

class MealAdapter(private val meals: MutableList<Meal>) : RecyclerView.Adapter<MealAdapter.MealViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_meal, parent, false)
        return MealViewHolder(itemView)
    }

    class MealViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // Define views inside the item layout
        val name: TextView = itemView.findViewById(R.id.mealName)
        val day: TextView = itemView.findViewById(R.id.mealDay)
        val time: TextView = itemView.findViewById(R.id.mealTime)
    }


    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        val currentRecipe = meals[position]

        // Set data to views inside the ViewHolder
        holder.name.text = currentRecipe.name
        holder.day.text = currentRecipe.day
        holder.time.text = currentRecipe.time
    }

    override fun getItemCount(): Int {
        return meals.size
    }
}
