package rickykuang.com.unum_dogs

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class DogAPIHelper {
    private lateinit var queue: RequestQueue

    fun getDogBreeds(context: Context, myDataset: ArrayList<Breed>, myAdapter: MyAdapter) {
        queue = Volley.newRequestQueue(context)
        val url = "https://dog.ceo/api/breeds/list/all"

        val stringRequest = StringRequest(Request.Method.GET, url,
                Response.Listener<String> { response ->
                    Log.d("API", response.substring(0, 150))
                    val breeds = JSONObject(response).getJSONObject("message")
                    saveToDataSet(breeds, myDataset, myAdapter)
                },
                Response.ErrorListener { Log.d("API", "failed") } )

        queue.add(stringRequest)
    }

    private fun saveToDataSet(breeds: JSONObject, myDataset: ArrayList<Breed>, myAdapter: MyAdapter) {
        val iter: Iterator<String> = breeds.keys()
        while (iter.hasNext()) {
            val breed: String = iter.next()

            val url = "https://dog.ceo/api/breed/$breed/images/random"
            val stringRequest = StringRequest(Request.Method.GET, url,
                    Response.Listener<String> { response ->
                        val imageURL = JSONObject(response).getString("message")
                        Log.d("API", imageURL)
                        myDataset.add(Breed(breed, imageURL))
                        myAdapter.notifyDataSetChanged()
                    },
                    Response.ErrorListener { Log.d("API", "failed") } )

            queue.add(stringRequest)
        }
    }
}