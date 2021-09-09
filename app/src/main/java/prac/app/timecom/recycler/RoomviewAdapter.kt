package prac.app.timecom.recycler

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import prac.app.timecom.R
import prac.app.timecom.model.RoomVo

class RoomViewAdapter(val context: Context, private val RoomData: ArrayList<RoomVo>): RecyclerView.Adapter<RoomViewAdapter.ViewHolder>(){
//RoomData: 바인딩 될 데이터 객체 배열

    inner class ViewHolder(view: View?) : RecyclerView.ViewHolder(view!!){
        //데이터가 바인딩 당할 Item XML 내부의 elements들
        val day = view?.findViewById<TextView>(R.id.tv_day)
        val date = view?.findViewById<TextView>(R.id.tv_date)

        fun bind(room: RoomVo, context: Context){
            day?.text = room.day
            date?.text = room.date
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.cal_days_item, parent, false)
        //바인딩 당할 Item XML 파일명 지정 --R.layout.item_room
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //데이터를 순서대로 바인딩 --포지션(인덱스)값을 활용 가능. 현재는 모든 값 바인딩
        holder.bind(RoomData[position], context)
    }

    override fun getItemCount() = RoomData.size //어탭터로 바인딩된 아이템 개수 반환

}