package com.mhst.custom_view_assignment.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView

/**
 * Created by Moe Htet on 25,July,2020
 */
class ProgressView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    val paint = Paint()

    override fun onDraw(canvas: Canvas?) {
        val rectF = RectF(0f,0f,width.toFloat(),height.toFloat())
        canvas?.drawArc(rectF, 0f, 360f, false,paint);
        // draw progress line
        canvas?.drawArc(rectF, 0f, 270f, false,paint);
    }

}
