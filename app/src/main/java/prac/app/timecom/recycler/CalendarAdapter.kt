package prac.app.timecom.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import prac.app.timecom.R
import prac.app.timecom.model.CalendarDateModel
import prac.app.timecom.model.CalendarDateModell


class CalendarAdapter(private val listener: (calendarDateModell: CalendarDateModell, position: Int) -> Unit) :
    RecyclerView.Adapter<CalendarAdapter.ViewHolder>() {
    private val list = ArrayList<CalendarDateModell>()

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(calendarDateModell: CalendarDateModell) {
            val calendarDay = itemView.findViewById<TextView>(R.id.tv_day)
            val calendarDate = itemView.findViewById<TextView>(R.id.tv_date)
            val calendarview = itemView.findViewById<RecyclerView>(R.id.rv_day)

            if (calendarDateModell.isSelected) {
                calendarDay.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.white
                    )
                )
                calendarDate.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.white
                    )
                )
                calendarview.setBackgroundColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.mainco_1
                    )
                )
            } else {
                calendarDay.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.black
                    )
                )
                calendarDate.setTextColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.black
                    )
                )
                calendarview.setBackgroundColor(
                    ContextCompat.getColor(
                        itemView.context,
                        R.color.white
                    )
                )
            }

            calendarDay.text = calendarDateModell.calendarDay
            calendarDate.text = calendarDateModell.calendarDate
            calendarview.setOnClickListener {
                listener.invoke(calendarDateModell, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarAdapter.ViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.cal_days_item, parent, false)
        return ViewHolder(view)
    }


    override fun onBindViewHolder(holder: CalendarAdapter.ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(calendarList: ArrayList<CalendarDateModel>) {
        list.clear()
        //list.addAll(calendarList)
        notifyDataSetChanged()
    }
}