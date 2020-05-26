package myway.covid_19app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_precautions.*

class PrecautionsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_precautions)

        recyclerView.layoutManager =
            LinearLayoutManager(this, LinearLayout.VERTICAL, false)
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
    }
}
