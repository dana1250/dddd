package prac.app.timecom.recycler

import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import prac.app.timecom.R
import prac.app.timecom.model.Memberlist

class pracAdapter(context : Context, private val dataSet : ArrayList<Memberlist>) : RecyclerView.Adapter<pracAdapter.ViewHolder>(){
    inner class ViewHolder(view : View) : RecyclerView.ViewHolder(view){
        val imageView : ImageView
        val textView : TextView
        val iv_member_option : ImageView

        init {
            textView = view.findViewById(R.id.tv_member_name)
            imageView = view.findViewById(R.id.iv_member_pic)
            iv_member_option = view.findViewById(R.id.iv_member_option)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): pracAdapter.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.resident_adapter, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: pracAdapter.ViewHolder, position: Int) {
        holder.textView.text = dataSet.get(position).name

        Log.d(TAG, "tt >>>>>>>> "+dataSet.get(position).toString())

        val context = holder.iv_member_option.context
        holder.iv_member_option.setOnClickListener {
            val myUri = Uri.parse("tel:${ArrayList<Memberlist>().get(position).phone}")
            var intent = Intent(Intent.ACTION_DIAL, myUri)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }

}