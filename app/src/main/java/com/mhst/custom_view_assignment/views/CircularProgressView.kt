package com.mhst.custom_view_assignment.views

import android.content.Context
import android.content.ReceiverCallNotAllowedException
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.content.withStyledAttributes
import com.mhst.custom_view_assignment.R

/**
 * Created by Moe Htet on 25,July,2020
 */
class CircularProgressView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    var path = Path()

    var progress = 0

    init {
        context.withStyledAttributes(attrs,R.styleable.ProgressView){
            progress = getInteger(R.styleable.ProgressView_taskProgress,0)
        }
    }

    override fun onDraw(canvas: Canvas?) {
        val recfF = RectF(0f,0f,width.toFloat(),height.toFloat())
        val paint = Paint()
        paint.apply {
            strokeWidth = 5f
            setStyle(Paint.Style.STROKE)
            color = Color.BLUE
            textSize = 40f
        }
        //path.addArc(recfF,270f,180f)
        canvas?.drawText("${progress}%",(width/2).toFloat(),(height/2).toFloat(),paint)
        canvas?.drawArc(recfF,270f,progress.toFloat(),true,paint)
    }

}