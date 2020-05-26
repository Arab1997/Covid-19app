package myway.covid_19app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.HORIZONTAL, false)
        val symptomsList = ArrayList<Model>()
        symptomsList.add(
            Model(
                R.drawable.cough,
                "Dry cough",
                "Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s,"
            )
        )
        symptomsList.add(
            Model(
                R.drawable.fever,
                "Fever",
                "Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s,"
            )
        )
        symptomsList.add(
            Model(
                R.drawable.headache,
                "Head Ache",
                "Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s,"
            )
        )

        val symptomsAdapter = SymptomsAdapter(symptomsList)

        recyclerView.adapter = symptomsAdapter






        recyclerViewPrecautions.layoutManager =
            LinearLayoutManager(this, LinearLayout.HORIZONTAL, false)
        val precautionsList = ArrayList<Model>()
        precautionsList.add(
            Model(
                R.drawable.soap,
                "Hand Wash",
                "Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s,"
            )
        )
        precautionsList.add(
            Model(
                R.drawable.hone,
                "Stay Home",
                "Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s,"
            )
        )
        precautionsList.add(
            Model(
                R.drawable.distance,
                "Social distance",
                "Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s,"
            )
        )
        precautionsList.add(
            Model(
                R.drawable.clean,
                "Clean Object & Surface",
                "Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s,"
            )
        )
        precautionsList.add(
            Model(
                R.drawable.cover,
                "Avoid Touching",
                "Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s,"
            )
        )


        val precautionsAdapter = PrecautionsAdapter(precautionsList)

        recyclerViewPrecautions.adapter = precautionsAdapter


        txt_ViewAll_symptoms.setOnClickListener {
            var intent = Intent(this@MainActivity, SymptomsActivity::class.java)
            startActivity(intent)
        }





        txt_ViewAll_precautions.setOnClickListener {
            var intent = Intent(this@MainActivity, PrecautionsActivity::class.java)
            startActivity(intent)
        }




        btn_moreInfo.setOnClickListener {
            var intent = Intent(this@MainActivity, KnowMoreActivity::class.java)
            startActivity(intent)
        }

        getGlobalData()
    }

    fun getGlobalData() {
        val url: String = "https://disease.sh/v2/all"

        val stringRequest: StringRequest =
            StringRequest(Request.Method.GET, // REquset ->from volley
                url,
                Response.Listener<String> {
                    var jsonObject = JSONObject(it.toString())

                    //now set values in textView
                    txt_infected.text = jsonObject.getString("cases")
                    txt_recovered.text = jsonObject.getString("recovered")
                    txt_deceased.text = jsonObject.getString("deaths")
                },

                Response.ErrorListener {
                    Toast.makeText(this@MainActivity, "Something went wrong ", Toast.LENGTH_LONG)
                        .show()
                    txt_infected.text = "-"
                    txt_recovered.text = "-"
                    txt_deceased.text = "-"
                })

        var requestQueue = Volley.newRequestQueue(this@MainActivity)
        requestQueue.add(stringRequest)
    }
}
