package com.monapk.infowindows

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.model.Marker

class CustomInfoWindowAdapter(context: Context) : GoogleMap.InfoWindowAdapter {
    private val window: View = (context as Activity).layoutInflater.inflate(R.layout.custom_info_window, null)
    private val contents: View = (context as Activity).layoutInflater.inflate(R.layout.custom_info_contents, null)

    override fun getInfoWindow(marker: Marker): View? {
        // マーカータップ時にgetInfoWindow()が呼ばれる.
        render(marker, window)
        return window
    }

    override fun getInfoContents(marker: Marker): View? {
        // getInfoWindow()でnullが返って来た時にgetInfoContents()呼ばれる.
        // getInfoContents()がnullを返す場合はデフォルトの情報ウィンドウが返される
        render(marker, contents)
        return contents
    }

    private fun render(marker: Marker, view: View) {
        view.findViewById<ImageView>(R.id.fujiImageView).setImageResource(R.drawable.fuji)

        val title: String? = marker.title
        val titleUi = view.findViewById<TextView>(R.id.title)
        if (title != null) {
            titleUi.text = title
        } else {
            titleUi.text = ""
        }

        val snippet: String? = marker.snippet
        val snippetUi = view.findViewById<TextView>(R.id.snippet)
        if (snippet != null) {
            snippetUi.text = snippet
        } else {
            snippetUi.text = ""
        }
    }
}