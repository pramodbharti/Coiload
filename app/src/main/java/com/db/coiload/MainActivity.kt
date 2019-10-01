package com.db.coiload

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.db.coiload.databinding.ActivityMainBinding
import com.db.coiload.models.Photo

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: PhotoViewModel
    private lateinit var photoAdapter: PhotoAdapter
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(PhotoViewModel::class.java)
        setViewModel()
    }

    private fun setViewModel() {
        viewModel.getPhotos().observe(this, Observer { photos ->
            updatePhotos(photos)
        })
    }

    private fun updatePhotos(photos: List<Photo>) {
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvPhotos.layoutManager = linearLayoutManager
        binding.rvPhotos.setHasFixedSize(true)
        binding.rvPhotos.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        photoAdapter = PhotoAdapter(this, photos)
        binding.rvPhotos.adapter = photoAdapter
    }
}
