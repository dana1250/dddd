package prac.app.timecom.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import prac.app.timecom.R

class ActivitySignup : AppCompatActivity() {
    var TAG:String = "ActivitySignup"

    private lateinit var tv_login: TextView

    private lateinit var spn_dept: Spinner

    private lateinit var edt_phonenum: EditText
    private lateinit var edt_authnum: EditText
    private lateinit var edt_pwd: EditText
    private lateinit var edt_pwdchk: EditText
    private lateinit var edt_name: EditText
    private lateinit var edt_email: EditText

    private lateinit var btn_send: Button
    private lateinit var btn_auth: Button
    private lateinit var btn_signup: Button

    private lateinit var iv_back: ImageView

    var chk_auth = false
    var chk_send = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        init()
        setFunction()
    }

    fun init(){
        tv_login = findViewById(R.id.tv_login)
        spn_dept = findViewById(R.id.spn_dept)
        edt_phonenum = findViewById(R.id.edt_phonenum)
        edt_authnum = findViewById(R.id.edt_authnum)
        edt_pwd = findViewById(R.id.edt_pwd)
        edt_pwdchk = findViewById(R.id.edt_pwdchk)
        edt_name = findViewById(R.id.edt_name)
        edt_email = findViewById(R.id.edt_email)
        btn_send = findViewById(R.id.btn_send)
        btn_auth = findViewById(R.id.btn_auth)
        btn_signup = findViewById(R.id.bnt_signup)
        iv_back = findViewById(R.id.iv_back)
    }

    fun setFunction(){
        btn_send.setOnClickListener {
            if(edt_phonenum.text.toString() == null){
                Toast.makeText(applicationContext, "전화번호를 입력하세요", Toast.LENGTH_SHORT).show()
            }
        }

        btn_auth.setOnClickListener {
            if(chk_send) {
                if (edt_authnum.text.toString() == null) {
                    Toast.makeText(applicationContext, "인증번호를 입력하세요", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(applicationContext, "먼저 인증번호를 전송해주세요", Toast.LENGTH_SHORT).show()
            }
        }

        btn_signup.setOnClickListener {
            if(!(chk_send&&chk_auth)){
                Toast.makeText(applicationContext, "전화번호 확인을 진행해주세요", Toast.LENGTH_SHORT).show()
            } else if(!(edt_pwd.text.toString().equals(edt_pwdchk.text.toString()))){
                Toast.makeText(applicationContext, "비밀번호가 일치하지 않습니다", Toast.LENGTH_SHORT).show()
            } else if(edt_name.text.toString() == null){
                Toast.makeText(applicationContext, "이름을 입력해주세요", Toast.LENGTH_SHORT).show()
            } else if(edt_email.text.toString() == null){
                Toast.makeText(applicationContext, "이메일을 입력해주세요", Toast.LENGTH_SHORT).show()
            } else {

            }
        }

        //로그인 이동
        tv_login.setOnClickListener {
            val intent = Intent(this, ActivityLogin::class.java)
            startActivity(intent)
            finish()
        }
    }
}