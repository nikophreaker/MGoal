package com.providoindodigital.mgoal.ui.base

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.providoindodigital.mgoal.R
import com.providoindodigital.mgoal.api.ApiService
import com.providoindodigital.mgoal.auth.AuthViewModel
import com.providoindodigital.mgoal.databinding.ActivityLoginEmailBinding
import com.providoindodigital.mgoal.auth.AuthListener
import com.providoindodigital.mgoal.utils.SessionManagerUtil
import com.providoindodigital.mgoal.utils.toast
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONArray
import org.json.JSONObject

class LoginEmailActivity : AppCompatActivity(), AuthListener {
    private lateinit var binding: ActivityLoginEmailBinding
    private val apiService = ApiService.create()
    private var tokens: String? = "-"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginEmailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val viewModel = ViewModelProviders.of(this).get(AuthViewModel::class.java)
        binding.viewModel = viewModel
        viewModel.authListener = this

        binding.loginTvLogin.setOnClickListener {
            //session = session.Session(baseContext)
//            val email: RequestBody =
//                emailText.toRequestBody("text/plain".toMediaType())
//            val password: RequestBody =
//                passwordText.toRequestBody("text/plain".toMediaType())
//            getToken(email,password)
//            getTokenData()
//            if(tokens != "-"){
//                val i = Intent(this, MainActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
//                startActivity(i)
//                finish()
//            } else {
//                Toast.makeText(this,"Gagal Login",Toast.LENGTH_LONG).show()
//            }
            //var token = tokenData
            //session?.setEmail(emailText)
            //session?.setPassword(passwordText)
        }

    }

//    private fun getToken(email: RequestBody, password: RequestBody){
//        val emailText = binding.edtEmail.text.toString()
//        val passwordText = binding.loginEdtPsw.text.toString()
//        apiService.getToken(email, password)
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribeOn(Schedulers.io())
//            .subscribe ({
//                run {
//                    if (it.token != "") {
//                        val tokenData = TokenData(it.token)
//                        tokens = tokenData.token
//                        Log.i("xx", " ${it.token}")
//                        SessionManagerUtil.startUserSession(this, 1200) // starting session
//                        SessionManagerUtil.storeUserToken(this, tokens.toString())
//                        SessionManagerUtil.storeUserEmail(this, emailText)
//                        SessionManagerUtil.storeUserPwd(this, passwordText)
//                        val i = Intent(this, MainActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
//                        startActivity(i)
//                        finish()
//                    } else {
//                        Log.e("NOT FOUND","NO DATA")
//                    }
//                }
//            }, {    Toast.makeText(this,"Gagal Login",Toast.LENGTH_LONG).show()
//            })
//    }

    fun ShowHidePass(view: View) {
        if (view.id == R.id.login_hide_btn) {
            if (binding.loginEdtPsw.transformationMethod.equals(PasswordTransformationMethod.getInstance())) {
                binding.loginHideBtn.setImageResource(R.mipmap.icon_hide)
                //Show Password
                binding.loginEdtPsw.transformationMethod =
                    HideReturnsTransformationMethod.getInstance()
            } else {
                binding.loginHideBtn.setImageResource(R.mipmap.icon_show)
                //Hide Password
                binding.loginEdtPsw.transformationMethod =
                    PasswordTransformationMethod.getInstance()

            }
        }
    }

    override fun onStarted() {
        toast("Login started")
    }

    override fun onSuccess(loginResponse: LiveData<String>) {
        loginResponse.observe(this, Observer {
            //toast(it)
            val jsonObject = JSONObject(it)
            val token = jsonObject.get("token")
            SessionManagerUtil.startUserSession(this, 1200) // starting session
            SessionManagerUtil.storeUserToken(this, token.toString())
            SessionManagerUtil.storeUserEmail(this, binding.edtEmail.text.toString())
            SessionManagerUtil.storeUserPwd(this, binding.loginEdtPsw.text.toString())
            val i = Intent(this, MainActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(i)
            finish()
            Log.i("TOKEN_USER",token.toString())
        })
    }

    override fun onFailure(message: String) {
        toast(message)
    }
}