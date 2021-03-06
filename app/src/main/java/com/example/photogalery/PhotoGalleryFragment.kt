package com.example.photogalery

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Retrofit


class PhotoGalleryFragment : Fragment() {
    private lateinit var photoRecyclerView:RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val retrofit:Retrofit=Retrofit.Builder().baseUrl("https://www.flickr.com/").build()
        val flickApi:FlickApi=retrofit.create(FlickApi::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view=inflater.inflate(R.layout.fragment_photo_gallery, container, false)
        photoRecyclerView=view.findViewById(R.id.photo_recycler_view)
        photoRecyclerView.layoutManager=GridLayoutManager(context,3)
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance() = PhotoGalleryFragment()
    }
}