package com.jelondoca.musicapp.holders

import android.app.Activity
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.jelondoca.musicapp.listeners.AlbumListener
import com.jelondoca.musicapp.models.AlbumModel
import kotlinx.android.synthetic.main.item_album.view.*

class AlbumHolder(private val view: View): RecyclerView.ViewHolder(view) {

    fun bindAlbum(itemAlbumModel: AlbumModel, listener: AlbumListener) {
        view.txtAlbumTitle.text = itemAlbumModel.name

        Glide.with(view.context).load(itemAlbumModel.image).into(view.imgAlbum)

        view.setOnClickListener {

            val params = ArrayList<androidx.core.util.Pair<View, String>>()

            params.add(androidx.core.util.Pair(view.imgAlbum, "transitionAlbumImage"))
            params.add(androidx.core.util.Pair(view.txtAlbumTitle, "transitionAlbumTitle"))

            val animation: ActivityOptionsCompat =
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                    view.context as Activity,
                    *params.toTypedArray()
                )

            listener.onClickedAlbum(animation.toBundle(), itemAlbumModel)

        }

    }
}