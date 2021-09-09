package com.providoindodigital.mgoal.ui.base

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.providoindodigital.mgoal.R
import com.providoindodigital.mgoal.databinding.ActivityLoginEmailBinding

class LoginEmailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginEmailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginEmailBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.loginTvLogin.setOnClickListener {
            val i = Intent(this, MainActivity::class.java).setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
            startActivity(i)
            finish()
        }


    }

    fun ShowHidePass(view: View){
        if(view.id == R.id.login_hide_btn){
            if(binding.loginEdtPsw.transformationMethod.equals(PasswordTransformationMethod.getInstance())){
                binding.loginHideBtn.setImageResource(R.mipmap.icon_hide)
                //Show Password
                binding.loginEdtPsw.transformationMethod = HideReturnsTransformationMethod.getInstance()
            }
            else{
                binding.loginHideBtn.setImageResource(R.mipmap.icon_show)
                //Hide Password
                binding.loginEdtPsw.transformationMethod = PasswordTransformationMethod.getInstance()

            }
        }
    }
}