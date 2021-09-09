package prac.app.timecom.recycler

import android.content.Context
import android.media.Image
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.extensions.LayoutContainer
import prac.app.timecom.R
import prac.app.timecom.model.Model


class Adapter(val list: MutableList<Model>, val layout:Int, val context:Context) : RecyclerView.Adapter<Adapter.ViewHolder>(){
    val selectionList = mutableListOf<Long>()
    val onItemClickListener : ((MutableList<Long>) -> Unit)?= null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.resident_adapter,parent,false)
        view.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                val id = v?.tag
                if(selectionList.contains(id)) selectionList.remove(id)
                else selectionList.add(id as Long)
                notifyDataSetChanged()
                onItemClickListener?.let{it(selectionList)}
            }
        })
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    class ViewHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView) , LayoutContainer
    {
        val btn  = containerView.findViewById(R.id.iv_member_option) as ImageView
        val tv_member_name  = containerView.findViewById(R.id.tv_member_name) as TextView
//        val chkBox  = containerView.findViewById(R.id.checkBox) as CheckBox
    }

    override fun onBindViewHolder(holder: Adapter.ViewHolder, position: Int) {
        //https://www.androidhuman.com/2017-11-26-kotlin_android_extensions_on_viewholder
        //holder.containerView.isActivated = selectionList.contains(getItemId(position))

       // holder.tv_member_name.setText(list[position], )

        holder.btn.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {
                Log.d("sss","Test btn${list[position].number}")
                if(list.isNotEmpty())
                    list.remove(list[position])
                notifyDataSetChanged()

            }
        })
//        holder.chkBox.setOnCheckedChangeListener(object :CompoundButton.OnCheckedChangeListener{
//            override fun onCheckedChanged(buttonView: CompoundButton?, isChecked: Boolean) {
//
//                if(isChecked){
//                    Log.d("sss","Check btn ON${list[position].number}")
//                    Toast.makeText(context,"Check btn ON${list[position].number}",Toast.LENGTH_LONG).show()
//
//                }else {
//                    Log.d("sss","Check btn OFF${list[position].number}")
//                    Toast.makeText(context,"Check btn OFF${list[position].number}",Toast.LENGTH_LONG).show()
//
//                }
//            }
//        })

    }
}