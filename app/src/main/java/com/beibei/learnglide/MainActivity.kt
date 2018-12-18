package com.beibei.learnglide

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.TypedValue
import android.view.View
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    val url = "https://1x.com/images/user/c254f3ce23b7ad0ae3fcb6081aed3ade-sd.jpg"

    @SuppressLint("CheckResult")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private fun dp2px(context: Context, dpVal: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                dpVal, context.resources.displayMetrics).toInt()
    }

    fun circle(v: View) {
        val options = RequestOptions.circleCropTransform()
//                .diskCacheStrategy(DiskCacheStrategy.NONE)//不做磁盘缓存
//                .skipMemoryCache(true)//不做内存缓存

        Glide.with(this)
                .load(url)
                .apply(options)
                .into(iv)
    }

    fun round(v: View) {
        //设置图片圆角角度
        val roundedCorners = RoundedCorners(dp2px(this, 30.0f))
//通过RequestOptions扩展功能,override:采样率,因为ImageView就这么大,可以压缩图片,降低内存消耗
        val options = RequestOptions.bitmapTransform(roundedCorners)
//                .override(300, 300)

        Glide.with(this)
                .load(url)
                .apply(options)
                .into(iv)
    }

    fun part_round(v: View) {
        val ridus = dp2px(this, 30.0f).toFloat()
        val roundCorner = RoundCorner(ridus, ridus, 0f, 0f)
        val options = RequestOptions.bitmapTransform(roundCorner)

        Glide.with(this)
                .load(url)
                .apply(options)
                .into(iv)

    }
}
