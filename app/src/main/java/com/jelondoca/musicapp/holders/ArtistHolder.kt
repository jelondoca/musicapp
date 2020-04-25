package com.jelondoca.musicapp.holders

import android.app.Activity
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jelondoca.musicapp.listeners.ArtistListener
import com.jelondoca.musicapp.models.ArtistModel
import kotlinx.android.synthetic.main.item_artist.view.*
import androidx.core.util.Pair

class ArtistHolder(private val view: View, private val listener: ArtistListener):RecyclerView.ViewHolder(view){

    fun bindArtist(artist: ArtistModel){
        Glide.with(view.context).load(artist.image).into(view.imgArtist)
        view.nameArtist.text = artist.name
        view.setOnClickListener{
            val params = ArrayList<Pair<View, String>>()
            params.add(Pair(view.imgArtist, "transitionArtistImage"))
            params.add(Pair(view.nameArtist, "transitionArtistName"))

            val animation: ActivityOptionsCompat =
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                    view.context as Activity,
                    *params.toTypedArray()
                )

            listener.onClickedArtist(animation.toBundle(), artist)
        }
    }
}