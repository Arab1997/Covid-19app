package myway.covid_19app

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SymptomsAdapter(var symptomsList: ArrayList<SymptomsModel>) :
    RecyclerView.Adapter<SymptomsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SymptomsAdapter.ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return symptomsList.size
    }

    override fun onBindViewHolder(holder: SymptomsAdapter.ViewHolder, position: Int) {
        val symptomsModel = symptomsList[position]
        holder.bind(symptomsModel)
    }

    class ViewHolder(inflater: LayoutInflater, viewGroup: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_symptoms, viewGroup, false)) {
        fun bind(symptomsModel: SymptomsModel) {
            val symptomsText = itemView.findViewById<TextView>(R.id.txt_Symptoms)
            val symptomsTextDetail = itemView.findViewById<TextView>(R.id.txt_Symptoms_detail)
            symptomsText.text = symptomsModel.symptomsTextView
            symptomsTextDetail.text = symptomsModel.symptomsDetail
        }
    }
}