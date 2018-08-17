package rickykuang.com.unum_dogs

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class MyAdapter(private val myDataSet : ArrayList<String>) : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(val v : View):  RecyclerView.ViewHolder(v)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context)
                .inflate(R.layout.my_recycler_view_item, parent,false) as View
        return ViewHolder(v);
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val textView = holder.v.findViewById<TextView>(R.id.textView)
        textView.setText(myDataSet[position])
    }

    override fun getItemCount() = myDataSet.size

}
