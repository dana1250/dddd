package prac.app.timecom.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_resident.*
import prac.app.timecom.R
import prac.app.timecom.model.JsonObj
import prac.app.timecom.model.Memberlist
import prac.app.timecom.model.Model
import prac.app.timecom.recycler.Adapter
import prac.app.timecom.recycler.DayAdapter
import prac.app.timecom.recycler.pracAdapter
import prac.app.timecom.recycler.practiceAdapter

class ActivityResident : AppCompatActivity() {
    val list :MutableList<Model> by lazy {
        mutableListOf<Model>()}

    var number = 0

    private lateinit var rv_members: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resident)

        rv_members = findViewById(R.id.rv_members)

        rv_members.hasFixedSize()
        var layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        rv_members.layoutManager = layoutManager

        val gson = GsonBuilder().create()
        val list = gson.fromJson((R.raw.emp_info).toString(), JsonObj::class.java)

        runOnUiThread {
            rv_members.adapter = practiceAdapter(list)
        }


    }
}