package com.jryingyang.accessappexercise.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jryingyang.accessappexercise.R
import com.jryingyang.accessappexercise.api.GithubService
import com.jryingyang.accessappexercise.model.User
import com.jryingyang.accessappexercise.data.GithubRepository
import com.jryingyang.accessappexercise.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: UserViewModel
    private lateinit var viewDataBinding: ActivityMainBinding
    private val adapter = UserAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        val view = viewDataBinding.root
        setContentView(view)

        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                GithubRepository(GithubService.create())
            )
        ).get(UserViewModel::class.java)

        initAdapter()
    }

    private fun initAdapter() {
        viewDataBinding.userList.adapter = adapter
        viewModel.listData.observe(this, Observer<List<User>> { result ->
            adapter.submitList(result)
        })
    }
}