package com.santidevs.painter

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

class DrawPath @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private var paint: Paint = Paint()
    private var path: Path = Path()

    init {
        paint.color = Color.RED
        paint.strokeWidth = 10f
        paint.style = Paint.Style.STROKE
        paint.isAntiAlias = true
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        canvas.drawPath(path, paint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        val xPos: Float = event.x
        val yPos: Float = event.y
        when (event.action) {
            MotionEvent.ACTION_DOWN -> {
                path.moveTo(xPos, yPos)
            }
            MotionEvent.ACTION_MOVE -> {
                path.lineTo(xPos, yPos)
            }
            MotionEvent.ACTION_UP -> {
                // Acciones al levantar el dedo
            }
            else -> {
                // Otros casos
            }
        }
        invalidate()
        return true
    }
    fun clearCanvas() {
        path.reset()
        invalidate()
    }
}