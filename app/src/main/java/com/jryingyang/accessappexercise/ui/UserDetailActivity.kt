package com.jryingyang.accessappexercise.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.jryingyang.accessappexercise.R
import com.jryingyang.accessappexercise.api.GithubService
import com.jryingyang.accessappexercise.data.GithubRepository
import com.jryingyang.accessappexercise.databinding.ActivityUserDetailBinding
import kotlinx.coroutines.launch

class UserDetailActivity : AppCompatActivity() {
    private lateinit var viewModel: UserViewModel
    private lateinit var viewDataBinding: ActivityUserDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewDataBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_detail)

        setContentView(viewDataBinding.root)
        val login = intent.getStringExtra(getString(R.string.login))

        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(
                GithubRepository(GithubService.create())
            )
        ).get(UserViewModel::class.java)

        lifecycleScope.launch {
            val data = viewModel.getUserDetail(login!!)
            viewDataBinding.data = data

            Glide.with(viewDataBinding.detailAvatar.context)
                .load(data.avatar_url)
                .apply(RequestOptions.circleCropTransform())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewDataBinding.detailAvatar)
        }
    }

    fun closeBtnClick(view: View) {
        finish()
    }
}