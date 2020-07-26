package com.mhst.custom_view_assignment.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.core.content.withStyledAttributes
import com.mhst.custom_view_assignment.R
import java.math.BigDecimal

/**
 * Created by Moe Htet on 26,July,2020
 */
class StraightProgressBar @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private val paint = Paint()

    private  val progressPaint = Paint()

    var progress = 0

    init {
        context.withStyledAttributes(attrs,R.styleable.StraightProgressView){
            progress = getInteger(R.styleable.StraightProgressView_strProgress,0)
        }
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.apply {
            strokeWidth = 20f
            style = Paint.Style.FILL
            color = Color.BLUE
        }
        progressPaint.apply {
            strokeWidth = 20f
            style = Paint.Style.FILL
            color = Color.GREEN
        }
        canvas?.drawLine(0f,0f,width.toFloat(),0f,paint)
        val calculated = BigDecimal(progress).divide(BigDecimal(100)).multiply(BigDecimal(width))
        Log.d("straight","$calculated")
        canvas?.drawLine(0f,0f,calculated.toFloat(),0f,progressPaint)
    }

}