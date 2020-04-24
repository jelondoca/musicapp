package com.jelondoca.musicapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.jelondoca.musicapp.adapters.ArtistAdapter
import com.jelondoca.musicapp.listeners.ArtistListener
import com.jelondoca.musicapp.models.ArtistModel
import com.jelondoca.musicapp.repositories.ArtistRepository
import com.jelondoca.musicapp.utils.ITEM_ARTIST
import kotlinx.android.synthetic.main.activity_album.*
import kotlinx.android.synthetic.main.activity_artist.*

class ArtistActivity : AppCompatActivity(), ArtistListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_artist)

        createThreadToGetArtists()

    }

    override fun onClickedArtist(bundle: Bundle?, artist: ArtistModel) {
        val intent = Intent(this, AlbumActivity::class.java)
        intent.putExtra(ITEM_ARTIST, artist)
        startActivity(intent, bundle)
    }

    private fun createThreadToGetArtists() {
        val thread = Thread(Runnable {
            getArtistFromRepository()
        })
        thread.start()
    }

    private fun getArtistFromRepository() {
        try {
            val repository = ArtistRepository()
            val result = repository.getArtists()
            loadAdapter(result)
        } catch (e: Exception) {
            runOnUiThread {
                Toast.makeText(this, e.message ?: "Error", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun loadAdapter(data: List<ArtistModel>) {
        runOnUiThread {
            rvArtist.layoutManager = GridLayoutManager(this, 3)
            rvArtist.adapter = ArtistAdapter(data, this)
        }
    }
}
