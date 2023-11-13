package com.example.mystorynew

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mystorynew.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), StoryMainAdapter.Listener {

    private lateinit var binding: ActivityMainBinding
    private var mainAdapter: StoryMainAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainAdapter = StoryMainAdapter(stories, listener = this)

//        val controller = AnimationUtils.loadLayoutAnimation(this, R.anim.layout_right_to_left)
//        binding.imageSliderRcv.layoutAnimation = controller
//        mainAdapter.notifyDataSetChanged()
//        binding.imageSliderRcv.scheduleLayoutAnimation()
        binding.imageSliderRcv.adapter = mainAdapter


        /*
           val imageCurrentPosition =
                (binding.imageSliderRcv.layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
            if (imageCurrentPosition < mainAdapter.itemCount - 1) {
                binding.imageSliderRcv.smoothScrollToPosition(imageCurrentPosition + 1)
                //mainAdapter.notifyDataSetChanged()

            }

         */
        //    binding.imageSliderRcv.adapter = mainAdapter


    }

    companion object {

        // Example: Load stories into a RecyclerView
        private val user1Stories = arrayListOf(
            "https://images.unsplash.com/photo-1515886657613-9f3515b0c78f",

            "https://images.unsplash.com/photo-1532675432006-329c6fed7045",

            "https://images.unsplash.com/photo-1473286835901-04adb1afab03",
            "https://images.unsplash.com/photo-1559324926-ad3e8bab9df1",


            // Add more story images or videos as needed
        )

        private val user2Stories = arrayListOf(

            "https://www.befunky.com/images/prismic/82e0e255-17f9-41e0-85f1-210163b0ea34_hero-blur-image-3.jpg",

            "https://images.unsplash.com/photo-1687825512118-5ee2ddded118",

            "https://images.unsplash.com/photo-1674478969244-a8bbf5e06624",
            "https://images.unsplash.com/photo-1675594614411-96dcea6fa87e",
            // Add more story images or videos as needed
        )

        //
//        private val user3Stories = arrayListOf(
//
//            "https://media.macphun.com/img/uploads/customer/how-to/608/15542038745ca344e267fb80.28757312.jpg",
//
//            "https://wallpaper.dog/large/20381756.jpg",
//            "https://i.pinimg.com/736x/e3/c4/7e/e3c47e0682b4247d9d024511e857c353.jpg",
//
//
//            // Add more story images or videos as needed
//        )
//
        private val user4Stories = arrayListOf(

            "https://www.befunky.com/images/prismic/82e0e255-17f9-41e0-85f1-210163b0ea34_hero-blur-image-3.jpg",

            "https://w0.peakpx.com/wallpaper/427/774/HD-wallpaper-pluma-quill.jpg",

            "https://www.freecodecamp.org/news/content/images/2022/09/jonatan-pie-3l3RwQdHRHg-unsplash.jpg",
            "https://e0.pxfuel.com/wallpapers/118/1018/desktop-wallpaper-liquid-paint-abstract-art-fluid-purple-background-1080x2340-abstract-thumbnail.jpg",
            // Add more story images or videos as needed
        )

        val stories = listOf(
            Story(
                "user1",
                "https://images.unsplash.com/photo-1531746020798-e6953c6e8e04",
                user1Stories
            ),
            Story(
                "user2",
                "https://images.unsplash.com/photo-1529626455594-4ff0802cfb7e",
                user2Stories
            ),
//            Story(
//                "user3",
//                "https://images.unsplash.com/photo-1534008757030-27299c4371b6",
//                user3Stories
//            ),
            Story(
                "user4",
                "https://images.unsplash.com/photo-1516575150278-77136aed6920",
                user4Stories
            ),
            // Add more users with their stories as needed
        )


    }


    override fun onNextItem() {
       // binding.imageSliderRcv.nextPage(true)


//        val imageCurrentPosition =
//            (binding.imageSliderRcv.layoutManager as LinearLayoutManager).findLastVisibleItemPosition()
//        if (imageCurrentPosition < mainAdapter!!.itemCount - 1) {
//            binding.imageSliderRcv.smoothScrollToPosition(imageCurrentPosition + 1)
//            //mainAdapter.notifyDataSetChanged()
//
//        } else if (imageCurrentPosition == mainAdapter!!.itemCount - 1) {
//            mainAdapter = null
//
//            mainAdapter = StoryMainAdapter(stories, listener = this)
//            binding.imageSliderRcv.adapter = mainAdapter
//
//
//
//            Toast.makeText(this, "All The Stories are shown!", Toast.LENGTH_LONG).show()
//
//            //binding.imageSliderRcv.smoothScrollToPosition(0)
//        }


//        if (imageCurrentPosition < (mainAdapter?.itemCount?.minus(1) ?: 0)) {
//            binding.imageSliderRcv.smoothScrollToPosition(imageCurrentPosition + 1)
//            //mainAdapter.notifyDataSetChanged()
//        } else {
//            mainAdapter = null
//            mainAdapter = StoryMainAdapter(stories, listener = this)
//            binding.imageSliderRcv.smoothScrollToPosition(0)
//            mainAdapter!!.notifyItemChanged(0)
//        }


    }

    override fun onPrevItem() {

       // binding.imageSliderRcv.previousPage(true)

//        val imageCurrentPosition =
//            (binding.imageSliderRcv.layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
//        if (imageCurrentPosition >= 0) {
//            try {
//                binding.imageSliderRcv.smoothScrollToPosition(imageCurrentPosition - 1)
//            } catch (e: Exception) {
//                e.stackTrace
//            }
//
//        }
    }


}