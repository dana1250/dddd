package prac.app.timecom.activity

import android.app.ProgressDialog
import android.content.ContentValues.TAG
import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import prac.app.timecom.R
import kotlin.coroutines.coroutineContext

class ActivityFindAccount : AppCompatActivity()  {
    var TAG = "ActivityFindAccount"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find_account)

        init();
        setFuction();
    }

    fun init(){

    }

    fun setFuction(){

    }

    class FindAccount : AsyncTask<String, Void, String>() {
        lateinit var progressDialog : ProgressDialog

        override fun onPostExecute(result: String?) {
            super.onPostExecute(result)
            Log.d(TAG, "POST response  - " + result)
            if(result.contains("찾을 수 없습니다.")){
                Toast.makeText(FindUser::class.java, "찾을 수 없습니다.", Toast.LENGTH_LONG).show()
            } else{
                showResult(result);
            }
        }
        override fun doInBackground(vararg p0: String?): String {
            TODO("Not yet implemented")
        }

    }
}