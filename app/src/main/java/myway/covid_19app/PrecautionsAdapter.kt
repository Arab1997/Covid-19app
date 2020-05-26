package myway.covid_19app

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PrecautionsAdapter(var precautionsList: ArrayList<Model>) :
    RecyclerView.Adapter<PrecautionsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PrecautionsAdapter.ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return precautionsList.size
    }

    override fun onBindViewHolder(holder: PrecautionsAdapter.ViewHolder, position: Int) {
        val symptomsModel = precautionsList[position]
        holder.bind(symptomsModel)
    }

    class ViewHolder(inflater: LayoutInflater, viewGroup: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_symptoms, viewGroup, false)) {
        fun bind(precautionsModel: Model) {
            val symptomsText = itemView.findViewById<TextView>(R.id.txt_Symptoms)
            val symptomsTextDetail = itemView.findViewById<TextView>(R.id.txt_Symptoms_detail)
            val imageView = itemView.findViewById<ImageView>(R.id.imageView_symptoms)

            imageView.setImageResource(precautionsModel.imageView)
            symptomsText.text = precautionsModel.symptomsTextView
            symptomsTextDetail.text = precautionsModel.symptomsDetail
        }
    }
}