package com.hka.bloodrecommendationapp
import java.util.ArrayList
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hka.bloodrecommendationapp.Model.ProductList

class ProductAdapter(private val productList: List<ProductList>):RecyclerView.Adapter<ProductAdapter.ProductViewHolder> (){

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //val productImage: ImageView = itemView.findViewById(R.id.product_image)
        val productName: TextView = itemView.findViewById(R.id.product_name)
        val productPrice: TextView = itemView.findViewById(R.id.product_price)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        //holder.productImage.setImageResource(R.drawable.product_placeholder) // Setze das Bild hier entsprechend
        holder.productName.text = product.name
        holder.productPrice.text = product.pr.toString()
    }

    override fun getItemCount(): Int {
        return productList.size
    }
}
