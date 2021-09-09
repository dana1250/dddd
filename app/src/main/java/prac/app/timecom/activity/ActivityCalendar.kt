package prac.app.timecom.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.*
import prac.app.timecom.R
import prac.app.timecom.model.CalendarDateModel
import prac.app.timecom.recycler.*
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ActivityCalendar : AppCompatActivity() {
    var TAG:String = "ActivityCalendar"

    private val sdf_YM = SimpleDateFormat("MMMM yyyy", Locale.KOREA)
    private val sdf_D = SimpleDateFormat("E요일", Locale.KOREA)
    private val sdf_DN = SimpleDateFormat("dd", Locale.KOREA)
    private var cal = Calendar.getInstance(Locale.KOREA)
    private var currentDate = Calendar.getInstance(Locale.KOREA)
    private val dates = ArrayList<Date>()

    private lateinit var tv_day_num: TextView
    private lateinit var tv_day: TextView
    private lateinit var tv_date: TextView

    private lateinit var btn_today: Button

    private lateinit var iv_month_up: ImageView
    private lateinit var iv_month_down: ImageView

    private lateinit var iv_sort: ImageView
    private var isascending = false


    private lateinit var rv_days: RecyclerView
    private lateinit var mAdapter: RecyclerView.Adapter<DayAdapter.ViewHolder>

    private val cnt_date = ArrayList<Date>()
    val monthCalendar = cal.clone() as Calendar
    val maxDaysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH)


    private lateinit var staggeredGridLayoutManager : StaggeredGridLayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar)

        init()
        setFuction()
    }

    fun init(){
        tv_day_num = findViewById(R.id.tv_day_num)
        tv_day = findViewById(R.id.tv_day)
        tv_date = findViewById(R.id.tv_date)


        btn_today = findViewById(R.id.btn_today)

        iv_sort = findViewById(R.id.iv_sort)

        iv_month_up = findViewById(R.id.iv_month_up)
        iv_month_down = findViewById(R.id.iv_month_down)

        rv_days = findViewById(R.id.rv_days)

        var days_layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false) //가로 스크롤
        rv_days.layoutManager = days_layoutManager

        staggeredGridLayoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL)

        setUpCalendar()
    }

    fun setFuction(){

        btn_today.setOnClickListener {
            setUpToday()
        }

        iv_sort.setOnClickListener {
            isascending = !isascending
            if(isascending) {
                iv_sort.setImageResource(R.mipmap.icon_asc)
            } else {
                iv_sort.setImageResource(R.mipmap.icon_desc)
            }
        }

        iv_month_up.setOnClickListener {
            cal.add(Calendar.MONTH, 1)
            setUpCalendar()
        }

        iv_month_down.setOnClickListener {
            cal.add(Calendar.MONTH, -1)
            setUpCalendar()
        }
    }

    private fun setUpCalendar() {
        val calendarList = ArrayList<CalendarDateModel>()

        tv_date.text = sdf_YM.format(cal.time)
        tv_day.text = sdf_D.format(cal.time)
        tv_day_num.text = sdf_DN.format(cal.time)

        ///가로로 넘어가는 일별 달력
        cnt_date.clear()
        monthCalendar.set(Calendar.DAY_OF_MONTH, 1)
        while (cnt_date.size < maxDaysInMonth) {
            cnt_date.add(monthCalendar.time)
            calendarList.add(CalendarDateModel(monthCalendar.time))
            monthCalendar.add(Calendar.DAY_OF_MONTH, 1)
        }

        var sdf = SimpleDateFormat("dd", Locale.KOREA)
        Log.d("Today", "today >>>>>>> "+sdf.format(cal.time))
        staggeredGridLayoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL)
        staggeredGridLayoutManager.scrollToPosition(sdf.format(cal.time).toInt()-3)
        rv_days.layoutManager = staggeredGridLayoutManager
        ///가로로 넘어가는 일별 달력

        val monthCalendar = cal.clone() as Calendar
        val maxDaysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH)
        dates.clear()
        monthCalendar.set(Calendar.DAY_OF_MONTH, 1)
        while (dates.size < maxDaysInMonth) {
            dates.add(monthCalendar.time)
            calendarList.add(CalendarDateModel(monthCalendar.time))
            monthCalendar.add(Calendar.DAY_OF_MONTH, 1)
        }

        mAdapter = DayAdapter(calendarList)
        rv_days.adapter = mAdapter
    }

    private fun setUpToday(){
        val calendarList = ArrayList<CalendarDateModel>()

        ///오늘 일자 출력
        tv_date.text = sdf_YM.format(currentDate.time)
        tv_day.text = sdf_D.format(currentDate.time)
        tv_day_num.text = sdf_DN.format(currentDate.time)

        ///가로로 넘어가는 일별 달력
        cal = currentDate

        cnt_date.clear()
        monthCalendar.set(Calendar.DAY_OF_MONTH, 1)
        while (cnt_date.size < maxDaysInMonth) {
            cnt_date.add(monthCalendar.time)
            calendarList.add(CalendarDateModel(monthCalendar.time))
            monthCalendar.add(Calendar.DAY_OF_MONTH, 1)
        }

        var sdf = SimpleDateFormat("dd", Locale.KOREA)
        Log.d("Today", "today >>>>>>> "+sdf.format(currentDate.time))
        staggeredGridLayoutManager = StaggeredGridLayoutManager(1, LinearLayoutManager.HORIZONTAL)
        staggeredGridLayoutManager.scrollToPosition(sdf.format(currentDate.time).toInt()-3)
        rv_days.layoutManager = staggeredGridLayoutManager
        ///가로로 넘어가는 일별 달력

        mAdapter = DayAdapter(calendarList)
        rv_days.adapter = mAdapter
    }
}