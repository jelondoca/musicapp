package com.jelondoca.musicapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.jelondoca.musicapp.adapters.AlbumAdapter
import com.jelondoca.musicapp.listeners.AlbumListener
import com.jelondoca.musicapp.models.AlbumModel
import com.jelondoca.musicapp.repositories.AlbumRepository
import kotlinx.android.synthetic.main.activity_album.*
import java.lang.Exception

class AlbumActivity : AppCompatActivity(), AlbumListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)
        createThreadToGetAlbums()
    }

    override fun onClickedAlbum(bundle: Bundle?, album: AlbumModel) {

    }

    private fun createThreadToGetAlbums() {
        val thread = Thread(Runnable {
            getAlbumFromRepository()
        })
        thread.start()
    }

    private fun getAlbumFromRepository() {
        try {
            val repository = AlbumRepository()
            val result = repository.getAlbums(2)
            loadAdapter(result)
        } catch (e: Exception) {
            runOnUiThread {
                Toast.makeText(this, e.message ?: "Error", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun loadAdapter(result: List<AlbumModel>) {
        runOnUiThread {
            recyclerViewAlbum.layoutManager = GridLayoutManager(this, 2)
            recyclerViewAlbum.adapter = AlbumAdapter(result, this)
        }
    }

}
