package com.yoo.wouldu.view.addrequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.yoo.wouldu.R
import com.yoo.wouldu.databinding.ActivityAddRequestBinding
import com.yoo.wouldu.databinding.ActivityMainBinding

class AddRequestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddRequestBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddRequestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.holder_fl_add, AddRequestFragment())
            .commit()
    }


    fun addFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction().add(R.id.holder_fl_add, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}