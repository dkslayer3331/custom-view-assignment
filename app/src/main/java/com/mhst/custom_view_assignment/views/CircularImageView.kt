package com.mhst.custom_view_assignment.views

import android.content.Context
import android.graphics.*
import android.provider.CalendarContract
import android.util.AttributeSet
import android.widget.ImageView
import androidx.appcompat.widget.AppCompatImageView
import androidx.core.content.withStyledAttributes
import androidx.core.widget.ImageViewCompat
import com.mhst.custom_view_assignment.R

/**
 * Created by Moe Htet on 24,July,2020
 */
class CircularImageView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : AppCompatImageView(context, attrs, defStyleAttr) {

    private var cornerRadius = 500f

    val stroke = 0f

    var strokeColor = Color.WHITE

    private val path = Path()

    val paint = Paint()

    var useStroke = false

    init {
        context.withStyledAttributes(attrs, R.styleable.ImageStroke){
               useStroke = getBoolean(R.styleable.ImageStroke_stroke,false)
                strokeColor = getColor(R.styleable.ImageStroke_strokeColor,strokeColor)
        }
    }

    override fun onDraw(canvas: Canvas?) {

        if(useStroke){
            paint.style = Paint.Style.STROKE
            paint.color = Color.GREEN
            paint.strokeWidth = 5f
        }

        val radius = if(width>height) (height/2).toFloat() else (width/2).toFloat()

        val rectF = RectF(0f,0f,width.toFloat(),height.toFloat())

        path.addCircle((width/2).toFloat(),(height/2).toFloat(),radius,Path.Direction.CW)

        canvas?.clipPath(path)

        super.onDraw(canvas)

    }


}