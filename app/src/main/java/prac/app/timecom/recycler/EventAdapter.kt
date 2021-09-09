package prac.app.timecom.recycler

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import prac.app.timecom.R
import prac.app.timecom.model.CalendarDateModel
import java.text.SimpleDateFormat
import java.util.*

class EventAdapter  : RecyclerView.Adapter<EventAdapter.ViewHolder> {
    private var TAG = "EventAdapter"

    private lateinit var AddrInfo: List<CalendarDateModel>
    private lateinit var mInflater : LayoutInflater
    private lateinit var mData : List<String>
    //private lateinit var mClickListener : ItemClickListener

    constructor(context : Context, data: List<String>) : super() {
        this.mInflater = LayoutInflater.from(context)
        this.mData = data
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventAdapter.ViewHolder {
        var itemView: View = mInflater.inflate(R.layout.cal_events_item, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var test = mData[position]
        //holder.tv_test.setText(test)
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    public class ViewHolder : RecyclerView.ViewHolder, View.OnClickListener {
        private lateinit var tv_test: TextView

        constructor(itemView: View) : super(itemView) {
            tv_test = itemView.findViewById(R.id.tv_text)

            itemView.setOnClickListener{this}
        }

        override fun onClick(view : View) {
            //onItemClick(view, getAdapterPosition());
        }
    }

    public fun getItem(id : Int) : String{
        return mData[id]
    }

    public fun onItemClick(view : View, position : Int){
        Log.i(TAG, "You clicked number " + getItem(position).toString() + ", which is at cell position " + position)
    }

}