package com.jelondoca.musicapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.jelondoca.musicapp.adapters.AlbumAdapter
import com.jelondoca.musicapp.listeners.AlbumListener
import com.jelondoca.musicapp.models.AlbumModel
import com.jelondoca.musicapp.models.ArtistModel
import com.jelondoca.musicapp.repositories.AlbumRepository
import com.jelondoca.musicapp.utils.ITEM_ALBUM
import com.jelondoca.musicapp.utils.ITEM_ARTIST
import kotlinx.android.synthetic.main.activity_album.*
import java.lang.Exception

class AlbumActivity : AppCompatActivity(), AlbumListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_album)

        intent?.let{myIntent ->
            val artist = myIntent.getParcelableExtra<ArtistModel>(ITEM_ARTIST)
            if(artist != null){
                Glide.with(this).load(artist.image).into(imgArtist)
                nameArtist.text = artist.name
                createThreadToGetAlbums(artist.id)
            }else{
                Toast.makeText(this, "No llegaron los parametros", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onClickedAlbum(bundle: Bundle?, album: AlbumModel) {
        val intent = Intent(this, SongActivity::class.java)
        intent.putExtra(ITEM_ALBUM, album)
        startActivity(intent, bundle)
    }

    private fun createThreadToGetAlbums(idArtist: Int) {
        val thread = Thread(Runnable {
            getAlbumFromRepository(idArtist)
        })
        thread.start()
    }

    private fun getAlbumFromRepository(idArtist: Int) {
        try {
            val repository = AlbumRepository()
            val result = repository.getAlbums(idArtist)
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
