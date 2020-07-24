package com.mhst.custom_view_assignment.views

import android.content.Context
import android.graphics.*
import android.provider.CalendarContract
import android.util.AttributeSet
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.widget.ImageViewCompat

/**
 * Created by Moe Htet on 24,July,2020
 */
class CircularImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    private var cornerRadius = 500f

    private val path = Path()

    val paint = Paint()

    override fun onDraw(canvas: Canvas?) {

        val radius = if(width>height) (height/2).toFloat() else (width/2).toFloat()

        val rectF = RectF(0f,0f,width.toFloat(),height.toFloat())

        path.addCircle((width/2).toFloat(),(height/2).toFloat(),radius,Path.Direction.CW)

        canvas?.clipPath(path)

        super.onDraw(canvas)

    }


}