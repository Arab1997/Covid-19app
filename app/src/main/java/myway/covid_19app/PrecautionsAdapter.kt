package myway.covid_19app

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class PrecautionsAdapter(var precautionsList: ArrayList<PrecautionsModel>) :
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
        RecyclerView.ViewHolder(inflater.inflate(R.layout.item_precautions, viewGroup, false)) {
        fun bind(precautionsModel: PrecautionsModel) {
            val precautionsText = itemView.findViewById<TextView>(R.id.textView_precautions)
            precautionsText.text = precautionsModel.precautionsTextView
        }
    }
}