package com.jelondoca.musicapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.jelondoca.musicapp.adapters.SongAdapter
import com.jelondoca.musicapp.listeners.SongListener
import com.jelondoca.musicapp.models.AlbumModel
import com.jelondoca.musicapp.models.SongModel
import com.jelondoca.musicapp.repositories.SongRepository
import com.jelondoca.musicapp.utils.ITEM_ALBUM
import kotlinx.android.synthetic.main.activity_song.*
import java.lang.Exception

class SongActivity : AppCompatActivity(), SongListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_song)

        intent?.let { myIntent ->
            val album = myIntent.getParcelableExtra<AlbumModel>(ITEM_ALBUM)
            if(album != null){
                Glide.with(this).load(album.image).into(imgHeaderDetail)
                txtTitleDeail.text = album.name
                createThreadToGetSongs(album.id)
            }else {
                Toast.makeText(this, "No llegaron los parametros", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onClickedSong(song: SongModel) {
        val intent = Intent(Intent.ACTION_VIEW).setData(Uri.parse(song.url))
        if(intent.resolveActivity(packageManager) != null){
            startActivity(intent)
        }
    }

    private fun createThreadToGetSongs(idAlbum: Int){
        val thread = Thread(Runnable {
            getSongsFromRepository(idAlbum)
        })
        thread.start()
    }

    private fun getSongsFromRepository(idAlbum: Int){
        try {
            val repository= SongRepository()
            val result = repository.getSongs(idAlbum)
            loadAdapter(result)
        }catch (e: Exception){
            runOnUiThread {
                Toast.makeText(this, e.message ?: "Error", Toast.LENGTH_LONG).show()
            }
        }
    }

    private fun loadAdapter(result: List<SongModel>){
        runOnUiThread {
            rvSong.layoutManager = LinearLayoutManager(this)
            rvSong.adapter = SongAdapter(result, this)
        }
    }
}
