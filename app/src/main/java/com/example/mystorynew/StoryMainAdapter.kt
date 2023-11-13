package com.example.mystorynew

import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.mystorynew.databinding.StoryItemMainBinding
import com.example.mystorynew.seg.SegmentedProgressBarListener
import java.util.ArrayList


class StoryMainAdapter(
    private val mainStoryList: List<Story>,
    private val listener: Listener
) :
    RecyclerView.Adapter<StoryMainAdapter.StoryMainViewHolder>() {


    interface Listener {
        fun onNextItem()
        fun onPrevItem()

    }


    private var pressTime = 0L
    private var limit = 500L
    private val sliderHandler = Handler()
    private lateinit var binding: StoryItemMainBinding

    private val handler = Handler(Looper.getMainLooper())
    private val autoScrollDelay = 3000L // Adjust the delay as needed
//
//    private val sliderRunnable =
//        Runnable { binding.imageSliderRcv.currentItem = binding.imageSliderRcv.currentItem + 1 }


    private val sliderRunnable =
        Runnable { binding.imageSliderRcv.currentItem = 0 }
    val hasNext = true
    var adapter: StoryAdapter? = null

    class StoryMainViewHolder(val binding: StoryItemMainBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StoryMainViewHolder {

        binding = StoryItemMainBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )

        return StoryMainViewHolder(
            binding
        )
    }

    override fun getItemCount(): Int {
        return mainStoryList.size
    }

    override fun onBindViewHolder(holder: StoryMainViewHolder, position: Int) {

        mainStoryList[position].let {
            holder.binding.apply {
                storyUsername.text = it.username
                adapter = StoryAdapter(it.stories)



                binding.spb.segmentCount = it.stories.size
                binding.spb.timePerSegmentMs = autoScrollDelay
                binding.imageSliderRcv.adapter = StoryAdapter(it.stories)
                binding.spb.viewPager = binding.imageSliderRcv


//                binding.spb.listener = object : SegmentedProgressBarListener {
//                    override fun onPage(oldPageIndex: Int, newPageIndex: Int) {
//                    }
//                    override fun onFinished() {
//                        listener.onNextItem()
//                    }
//                }

                binding.previousPage.setOnClickListener {


                    binding.imageSliderRcv.previousPage(true)

                    Log.d("TAG", "previousPage: ")


//                    if (it.stories.size-1 >1 ) {
//                        listener.onPrevItem()
//                    } else {
//
//                    }


                }

                binding.nextPage.setOnClickListener {

                    if (!binding.imageSliderRcv.canScrollHorizontally(View.SCROLL_AXIS_HORIZONTAL)) {
                        listener.onNextItem()
                    } else {
                        binding.imageSliderRcv.nextPage(true)
                    }
                    Log.d("TAG", "nextPage: ")




                    if (!binding.imageSliderRcv.canScrollHorizontally(View.SCROLL_AXIS_HORIZONTAL)) {
                        listener.onNextItem()
                    } else {
                        binding.imageSliderRcv.nextPage(true)
                    }
                }

            }
        }
    }

    private fun setStories(stories: ArrayList<String>) {
        adapter == StoryAdapter(emptyList())
        adapter = StoryAdapter(stories)


        binding.imageSliderRcv.adapter = adapter
        binding.spb.segmentCount = stories.size
        binding.spb.timePerSegmentMs = autoScrollDelay
        binding.spb.viewPager = binding.imageSliderRcv

        binding.spb.listener = object : SegmentedProgressBarListener {
            override fun onPage(oldPageIndex: Int, newPageIndex: Int) {


            }

            override fun onFinished() {

                listener.onNextItem()

            }

        }

        binding.previousPage.setOnClickListener {

            if (stories.size - 1 > 1) {
                listener.onPrevItem()
            } else {
                binding.imageSliderRcv.previousPage(true)
            }


        }

        binding.nextPage.setOnClickListener {
            if (!binding.imageSliderRcv.canScrollHorizontally(View.SCROLL_AXIS_HORIZONTAL)) {
                listener.onNextItem()
            } else {
                binding.imageSliderRcv.nextPage(true)
            }

            //            if (!binding.imageSliderRcv.canScrollHorizontally(View.SCROLL_AXIS_HORIZONTAL)) {
//                listener.onNextItem()
//            } else {
//                binding.imageSliderRcv.nextPage(true)
//            }
        }


//                imageSliderRcv.registerOnPageChangeCallback(object :
//                    ViewPager2.OnPageChangeCallback() {
//                    override fun onPageScrollStateChanged(state: Int) {
//                        super.onPageScrollStateChanged(state)
//
//
//                    }
//
//                    override fun onPageSelected(position: Int) {
//                        super.onPageSelected(position)
//
////                        binding.spb.playSegment(2000)
////                        binding.spb.setCompletedSegments(position )
//
//                        if (!imageSliderRcv.canScrollHorizontally(View.SCROLL_AXIS_HORIZONTAL)) {
//                            listener.onNextItem()
//                        } else {
//                            imageSliderRcv.nextPage(true)
//                        }
//
////
////                        sliderHandler.removeCallbacks(sliderRunnable)
////                        sliderHandler.postDelayed(
////                            sliderRunnable,
////                            autoScrollDelay
////                        ) // slide duration 2 seconds
//
//                        if (position == adapter.itemCount - 1) {
//                            //binding.spb.restartSegment()
////                            sliderHandler.removeCallbacks(sliderRunnable)
////                            sliderHandler.postDelayed(
////                                sliderRunnable,
////                                autoScrollDelay
////                            ) // slide duration 2 seconds
//
//                            Log.d("TAG", "onPageSelected:${adapter.itemCount} ")
//                            Log.d("TAG", "Position :${position} ")
//                            // If so, set the current item to the first page to restart
//                            // binding.imageSliderRcv.setCurrentItem(0, true)
//                        } else {
//
//                        }
//
//
//                    }
//
//
//                })


    }

    fun startProgress() {
        binding.spb.reset()
        binding.spb.restartSegment()

    }


}