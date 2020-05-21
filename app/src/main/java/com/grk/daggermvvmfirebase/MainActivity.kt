package com.grk.daggermvvmfirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.RequestManager
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var glide: RequestManager

    private lateinit var myImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        (application as MyApplication).applicationComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myImageView = findViewById(R.id.my_image_view)
        glide.load("http://www.thepluspaper.com/wp-content/uploads/2019/01/1.jpg").into(myImageView)

    }
}
