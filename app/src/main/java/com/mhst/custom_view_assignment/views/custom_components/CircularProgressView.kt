package com.mhst.custom_view_assignment.views.custom_components

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import androidx.core.content.withStyledAttributes
import com.mhst.custom_view_assignment.R
import java.math.BigDecimal

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
            strokeWidth = 10f
            style = Paint.Style.STROKE
            color = Color.BLUE
            textSize = 40f
        }
        val originPaint = Paint().apply {
            strokeWidth = 10f
            style = Paint.Style.STROKE
            color = Color.DKGRAY
        }
        val textPaint = Paint().apply{
            color = Color.BLUE
            textSize = 40f
        }
        val  y = (height/2) - ((originPaint.descent() + originPaint.ascent()) / 2)
        //path.addArc(recfF,270f,180f)
        canvas?.drawText("${progress}%",(width/2).toFloat(),(height/2).toFloat(),textPaint)
        canvas?.drawArc(recfF,270f,360f,false,originPaint)
        val calculated = BigDecimal(progress).divide(BigDecimal(100)).multiply(BigDecimal(360))
        canvas?.drawArc(recfF,270f,calculated.toFloat(),false,paint)
    }

}