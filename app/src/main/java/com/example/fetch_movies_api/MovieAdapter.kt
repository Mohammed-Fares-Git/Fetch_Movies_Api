package com.example.fetch_movies_api

import android.R
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fetch_movies_api.model.Film
import com.squareup.picasso.Picasso


class FilmsAdapter(private val films: ArrayList<Film>, private val filmIteraction: FilmIteraction) :
    RecyclerView.Adapter<FilmsAdapter.FilmVh>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilmVh {
        val v: View =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item, null, false)
        return FilmVh(v)
    }

    override fun onBindViewHolder(holder: FilmVh, position: Int) {
        val film = films[position]
        holder.bind(film, film.name, film.price!!, film.image, film.traduction)
    }

    override fun getItemCount(): Int {
        return films.size
    }

    inner class FilmVh(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var film: Film? = null
        private val tv_name: TextView
        private val tv_price: TextView
        private val film_image: ImageView
        private val sub_titel_image: ImageView

        init {
            tv_name = itemView.findViewById<TextView>(R.id.tv_name)
            tv_price = itemView.findViewById<TextView>(R.id.tv_price)
            film_image = itemView.findViewById<ImageView>(R.id.img_film_small_pic)
            sub_titel_image = itemView.findViewById<ImageView>(R.id.img_subtitel)
            itemView.setOnClickListener { filmIteraction.onFilmClicked(film) }
        }

        fun bind(film: Film?, name: String?, price: Int, imgUrl: String?, isTranslated: Boolean?) {
            this.film = film
            Picasso.get().load(imgUrl).resize(200, 200)
                .centerCrop()
                .into(film_image)
            tv_name.text = "$name fares"
            tv_price.text = "$price £"
            if (isTranslated!!) {
                sub_titel_image.setImageResource(R.drawable.baseline_subtitles_24)
            } else {
                sub_titel_image.setImageResource(R.drawable.baseline_subtitles_off_24)
            }
        }
    }

    interface FilmIteraction {
        fun onFilmClicked(film: Film?)
    }
}