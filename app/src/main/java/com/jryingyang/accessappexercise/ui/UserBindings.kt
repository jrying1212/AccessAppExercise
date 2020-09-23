package com.jryingyang.accessappexercise.ui

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions

class UserBindings {

    companion object {

        @JvmStatic
        @BindingAdapter("visibleGone")
        fun showHide(view: View, show: Boolean) {
            if (show) {
                view.visibility = View.VISIBLE
            } else {
                view.visibility = View.GONE
            }
        }

        @JvmStatic
        @BindingAdapter("imageUrl")
        fun bindImage(imageView: ImageView, url: String) {
            Glide.with(imageView.context)
                .load(url)
                .apply(RequestOptions.circleCropTransform())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(imageView)
        }
    }
}