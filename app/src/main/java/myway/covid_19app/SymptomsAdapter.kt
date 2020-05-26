package myway.covid_19app

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SymptomsAdapter(var list: ArrayList<Model>) :
    RecyclerView.Adapter<SymptomsAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SymptomsAdapter.ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(inflater, parent)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SymptomsAdapter.ViewHolder, position: Int) {
        val symptomsModel = list[position]
        holder.bind(symptomsModel)
    }

    class ViewHolder(inflater: LayoutInflater, viewGroup: ViewGroup) :
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_symptoms, viewGroup, false)) {
        fun bind(model: Model) {
            val symptomsText = itemView.findViewById<TextView>(R.id.txt_Symptoms)
            val symptomsTextDetail = itemView.findViewById<TextView>(R.id.txt_Symptoms_detail)
            val imageView = itemView.findViewById<ImageView>(R.id.imageView_symptoms)

            imageView.setImageResource(model.imageView)
            symptomsText.text = model.symptomsTextView
            symptomsTextDetail.text = model.symptomsDetail
        }
    }
}