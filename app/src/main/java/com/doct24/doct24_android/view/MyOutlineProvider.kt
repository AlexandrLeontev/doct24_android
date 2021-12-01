package com.doct24.doct24_android.view

import android.graphics.Outline
import android.graphics.Rect
import android.view.View
import android.view.ViewOutlineProvider
import androidx.annotation.FloatRange

internal class MyOutlineProvider() : ViewOutlineProvider() {

    private val cornerRadius: Float = 0f
    private var scaleX: Float = 1f
    private var scaleY: Float = 1f
    private var yShift: Int = 6
    private val rect: Rect = Rect()

    override fun getOutline(view: View?, outline: Outline?) {
        view?.background?.copyBounds(rect)
        rect.scale(scaleX, scaleY)
        rect.offset(yShift, yShift)
        outline?.setRoundRect(rect, cornerRadius)
    }

}

private fun Rect.scale(
    @FloatRange(from = -1.0, to = 1.0) scaleX: Float,
    @FloatRange(from = -1.0, to = 1.0) scaleY: Float
) {
    val newWidth = width() * scaleX
    val newHeight = height() * scaleY
    val deltaX = (width() - newWidth) / 2
    val deltaY = (height() - newHeight) / 2

    set(-1, -1, (right - deltaX).toInt(), (bottom - deltaY).toInt())
}