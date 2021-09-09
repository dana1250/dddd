package prac.app.timecom.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import prac.app.timecom.R
import prac.app.timecom.model.CalendarDateModel
import java.text.SimpleDateFormat
import java.util.*

//https://velog.io/@yeji/Retrofit2-Open-API
//https://medium.com/@Biliator/horizontal-calendar-with-recyclerview-130b7f964e7a

class DayAdapter : RecyclerView.Adapter<DayAdapter.ViewHolder> {
    private lateinit var AddrInfo: List<CalendarDateModel>

    constructor(AddrInfo: List<CalendarDateModel>) : super() {
        this.AddrInfo = AddrInfo
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayAdapter.ViewHolder {
        var itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.cal_days_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: DayAdapter.ViewHolder, position: Int) {
        var item: CalendarDateModel = AddrInfo.get(position)
        holder.setItem(item)
    }

    override fun getItemCount(): Int {
        return AddrInfo.size
    }

    inner class ViewHolder : RecyclerView.ViewHolder {
        private lateinit var tv_day: TextView
        private lateinit var tv_date: TextView

        constructor(itemView: View) : super(itemView) {
            tv_day = itemView.findViewById(R.id.tv_day)
            tv_date = itemView.findViewById(R.id.tv_date)
        }

        fun setItem(item: CalendarDateModel) {
            val sdf_date = SimpleDateFormat("dd", Locale.KOREA)
            val sdf_day = SimpleDateFormat("E", Locale.KOREA)

            tv_day.setText(sdf_day.format(item.data))
            tv_date.setText(sdf_date.format(item.data))
        }

        init{
            itemView.setOnClickListener {

            }
        }
    }
}