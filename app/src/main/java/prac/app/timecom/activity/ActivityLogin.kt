package prac.app.timecom.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import prac.app.timecom.R

//https://chicken-salad-sandwich.tistory.com/5

class ActivityLogin : AppCompatActivity() {
    var TAG:String = "ActivityLogin"

    private lateinit var btn_login: Button
    private lateinit var edt_id: EditText
    private lateinit var edt_pw: EditText
    private lateinit var tv_find: TextView
    private lateinit var tv_register: TextView
    private lateinit var iv_autologin: ImageView
    private lateinit var tv_autologin: TextView

    var autologin_check = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init();
        setFuction();
    }

    fun init(){
        btn_login = findViewById(R.id.btn_login)
        edt_id = findViewById(R.id.edt_id)
        edt_pw = findViewById(R.id.edt_pw)
        tv_find = findViewById(R.id.tv_find)
        tv_register = findViewById(R.id.tv_register)
        iv_autologin = findViewById(R.id.iv_autologin)
        tv_autologin = findViewById(R.id.tv_autologin)
    }

    fun setFuction(){
        //자동로그인체크
        tv_autologin.setOnClickListener {
            iv_autologin.performClick();
        }
        iv_autologin.setOnClickListener {
            autologin_check = !autologin_check
            if(autologin_check){
                iv_autologin.setImageResource(R.mipmap.check)
            } else {
                iv_autologin.setImageResource(R.mipmap.uncheck)
            }
        }

        //회원가입
        tv_register.setOnClickListener {
            val intent = Intent(this, ActivitySignup::class.java)
            startActivity(intent)
            finish()
        }

        //아이디비밀번호찾기
        tv_find.setOnClickListener {
            val intent = Intent(this, ActivityCal::class.java)
            startActivity(intent)
            finish()
        }

        //로그인시도
        btn_login.setOnClickListener {
            val chkid = chkLoginID(edt_id.text.toString())
            val chkpwd = chkLoginPWD(edt_pw.text.toString())

            if(chkid&&chkpwd) {
                //로그인 통신
            }
        }
    }

    fun chkLoginID(id:String):Boolean{
        //전화번호
        if(id.length != 11) return false
        val reg_p = Regex("01[016789][0-9]{3,4}[0-9]{4}\$")
        if(!id.matches((reg_p))) return false

         //이메일
        if(id.length != 11) return false
        val reg_e = Regex("[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*\\.[a-zA-Z]{2,3}")
        if(!id.matches((reg_e))) return false
        else return true
    }

    fun chkLoginPWD(pwd:String):Boolean{
        //비밀번호
        if(pwd.length != 11) return false
        val reg_pwd = Regex("[0-9a-zA-Z]{6,8}")
        if(!pwd.matches((reg_pwd))) return false
        else return true
    }
}