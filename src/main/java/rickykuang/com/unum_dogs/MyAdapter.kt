package rickykuang.com.unum_dogs

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.RequestManager
import com.bumptech.glide.request.RequestOptions

class MyAdapter(private val myDataSet : ArrayList<Breed>, private val glide : RequestManager) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(val v : View):  RecyclerView.ViewHolder(v)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.my_recycler_view_item, parent,false) as View
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val textView = holder.v.findViewById<TextView>(R.id.textView)
        val imageView = holder.v.findViewById<ImageView>(R.id.imageView)
        textView.setText(myDataSet[position].breed)
        glide.load(myDataSet[position].imageURL)
                .apply(RequestOptions().override(350).centerCrop())
                .into(imageView)

    }

    override fun getItemCount() = myDataSet.size

}
