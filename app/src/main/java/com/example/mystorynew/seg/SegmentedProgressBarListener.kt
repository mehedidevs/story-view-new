package com.example.mystorynew.seg
interface SegmentedProgressBarListener {
    /**
     * Notifies when selected segment changed
     */
    fun onPage(oldPageIndex: Int, newPageIndex: Int)

    /**
     * Notifies when last segment finished animating
     */
    fun onFinished()
}