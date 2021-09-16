package com.providoindodigital.mgoal.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.providoindodigital.mgoal.databinding.ActivityMatchInfoBinding
import com.providoindodigital.mgoal.databinding.IncludeMatchInfoToolOpenBinding

class MatchInfoActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMatchInfoBinding
    private lateinit var binding_open: IncludeMatchInfoToolOpenBinding
    private var status: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMatchInfoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }

}