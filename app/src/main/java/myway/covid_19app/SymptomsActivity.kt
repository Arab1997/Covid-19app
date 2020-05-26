package myway.covid_19app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_symptoms.*

class SymptomsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_symptoms)



        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)
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
        symptomsList.add(
            Model(
                R.drawable.sorethroat,
                "sore throat",
                "Lorem Ipsum has been the industry\\'s standard dummy text ever since the 1500s,"
            )
        )


        val symptomsAdapter = SymptomsAdapter(symptomsList)

        recyclerView.adapter = symptomsAdapter

    }
}
