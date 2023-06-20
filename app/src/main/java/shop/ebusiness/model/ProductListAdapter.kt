class ProductListAdapter (context: Context, ListOfProducts: List<ProductList>)  : BaseAdapter() {

    private var listOfProducts: List<ProductList>
    private val mInflator: LayoutInflater

    init {
        this.listOfProducts = ListOfProducts
        this.mInflator = LayoutInflater.from(context)
    }
    fun updateList(newList:ArrayList<ProductList>){
        listOfProducts=newList
        notifyDataSetChanged()
    }
    override fun getCount(): Int {
        return listOfProducts.size
    }

    override fun getItem(position: Int): Any {
        return listOfProducts[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val viewHolder: ViewHolder

        if (convertView == null) {
            view = mInflator.inflate(R.layout.product_item, parent, false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = convertView.tag as ViewHolder
        }

        val product = listOfProducts[position]
        viewHolder.bind(product)

        return view
    }

    inner class ViewHolder(itemView: View) {
        private val productName: TextView = itemView.findViewById(R.id.product_name)
        private val productPrice: TextView = itemView.findViewById(R.id.product_price)

        fun bind(product: ProductList) {
            productName.text = product.name
            productPrice.text = product.pr.toString()
        }
    }
}
