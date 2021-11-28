package com.yoo.wouldu.view.addrequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.yoo.wouldu.R
import com.yoo.wouldu.databinding.ActivityAddRequestBinding
import com.yoo.wouldu.databinding.ActivityMainBinding
import com.yoo.wouldu.model.data.request.How
import com.yoo.wouldu.viewmodel.AddViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddRequestActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddRequestBinding
    val addViewModel: AddViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddRequestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        init()
    }

    fun init() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.holder_fl_add, AddRequestFragment())
            .commit()

        addViewModel._how.value = intent.getSerializableExtra("how") as How?
    }

    fun addFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction().add(R.id.holder_fl_add, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}