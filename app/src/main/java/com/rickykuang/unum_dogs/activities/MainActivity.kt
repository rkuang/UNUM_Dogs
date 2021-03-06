package rickykuang.com.unum_dogs.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import com.bumptech.glide.RequestManager
import rickykuang.com.unum_dogs.classes.Breed
import rickykuang.com.unum_dogs.classes.DogAPIHelper
import rickykuang.com.unum_dogs.classes.GlideApp
import rickykuang.com.unum_dogs.R
import rickykuang.com.unum_dogs.adapters.MyAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: MyAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var myDataset: ArrayList<Breed>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myDataset = ArrayList()

        viewManager = GridLayoutManager(this, 3)

        val glide: RequestManager = GlideApp.with(this)
        viewAdapter = MyAdapter(myDataset, glide)

        recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view).apply {
            setHasFixedSize(true)
            layoutManager = viewManager
            adapter = viewAdapter
        }

        DogAPIHelper.getDogBreeds(this, myDataset, viewAdapter)
    }
}
