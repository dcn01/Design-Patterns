package com.asura.design_patterns.principle.imageloader.step1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.asura.design_patterns.R
import kotlinx.android.synthetic.main.activity_test_image_loader.*

/**
 * @author Created by Asura on 2018/4/9 10:08.
 */
class TestActivity : AppCompatActivity() {
    val imageUrl: String = "https://upload.jianshu.io/users/upload_avatars/1981083/f1a5c1fd-f88e-4302-b7f2-29dd3c280845.jpg?imageMogr2/auto-orient/strip|imageView2/1/w/240/h/240"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_image_loader)
        title = getString(R.string.demo_srp)
        btn_load.setOnClickListener { v ->
            val imageLoader: ImageLoader = ImageLoader()
            imageLoader.displayImage(imageUrl, imageView)
        }
    }
}