package rickykuang.com.unum_dogs

import android.content.Context
import android.util.Log
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONObject

class DogAPIHelper {

    fun getDogBreeds(context: Context, myDataset: ArrayList<String>, myAdapter: MyAdapter) {
        val queue = Volley.newRequestQueue(context)
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

    private fun saveToDataSet(breeds: JSONObject, myDataset: ArrayList<String>, myAdapter: MyAdapter) {
        val iter: Iterator<String> = breeds.keys()
        while (iter.hasNext()) {
            val breed: String = iter.next()
            myDataset.add(breed)
            myAdapter.notifyDataSetChanged()
        }
    }
}