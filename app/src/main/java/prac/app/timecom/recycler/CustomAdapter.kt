package prac.app.timecom.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import prac.app.timecom.R

data class Data(val date:String)

class CustomViewHolder(v : View) : RecyclerView.ViewHolder(v) {
    val calendarDay = itemView.findViewById<TextView>(R.id.tv_day)
    val calendarDate = itemView.findViewById<TextView>(R.id.tv_date)
    val calendarview = itemView.findViewById<RecyclerView>(R.id.rv_day)

    fun bind(room: Data, context: Context){
        calendarDay?.text = room.date
        calendarDate?.text = room.date
    }
}

class CustomAdapter(val DataList:ArrayList<Data>) : RecyclerView.Adapter<CustomViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val cellForRow = LayoutInflater.from(parent.context).inflate(R.layout.cal_days_item, parent, false)

        return CustomViewHolder(cellForRow)
    }

    override fun getItemCount() = DataList.size

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.calendarDate.text = DataList[position].date
    }
}