package prac.app.timecom.recycler

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.resident_adapter.view.*
import prac.app.timecom.R
import prac.app.timecom.model.JsonObj
import prac.app.timecom.model.Memberlist
import prac.app.timecom.model.Mystar

class practiceAdapter(private val dataSet : JsonObj) : RecyclerView.Adapter<practiceAdapter.ViewHolder>(){
/*    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val imageView : ImageView
        val textView : TextView
        val iv_member_option : ImageView

        init {
            textView = view.findViewById(R.id.tv_member_name)
            imageView = view.findViewById(R.id.iv_member_pic)
            iv_member_option = view.findViewById(R.id.iv_member_option)
        }
    }*/


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): practiceAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.resident_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: practiceAdapter.ViewHolder, position: Int) {
        holder?.bindItems(dataSet.result[position])
        /*holder.textView.text = dataSet.get(position).name

        val context = holder.iv_member_option.context
        holder.iv_member_option.setOnClickListener {
            val myUri = Uri.parse("tel:${ArrayList<Memberlist>().get(position).phone}")
            var intent = Intent(Intent.ACTION_DIAL, myUri)
            context.startActivity(intent)
        }*/
    }

    override fun getItemCount(): Int {
        return dataSet.result.count()
    }

    inner class ViewHolder(val view : View) : RecyclerView.ViewHolder(view){

        fun bindItems(data : Mystar) {
            if(data.emp_dept.equals("이종민")) {
                view.iv_member_pic.setImageResource(R.mipmap.ljm)
            } else if(data.emp_dept.equals("박유현")){
                view.iv_member_pic.setImageResource(R.mipmap.pyh)
            } else if(data.emp_dept.equals("김성우")){
                view.iv_member_pic.setImageResource(R.mipmap.ksw)
            }
            view.tv_member_name.text = data.emp_name
            view.tv_member_phone.text = data.emp_phone
            view.iv_member_option.setOnClickListener {
                val myUri = Uri.parse("tel:${data.emp_phone}")
                var intent = Intent(Intent.ACTION_DIAL, myUri)
                view.context.startActivity(intent)
            }
        }

    }
}