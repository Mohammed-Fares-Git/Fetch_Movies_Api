package com.example.fetch_movies_api

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.fetch_movies_api.model.Movie
import com.squareup.picasso.Picasso


class MovieAdapter(private val films: ArrayList<Movie>, private val filmIteraction: MovieIteraction) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val v: View =
            LayoutInflater.from(parent.context).inflate(R.layout.movie_list_item, null, false)
        return MovieViewHolder(v)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val film = films[position]
        holder.bind(film, film.name, film.price!!, film.image, film.traduction)
    }

    override fun getItemCount(): Int {
        return films.size
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private lateinit var movie: Movie
        private val tv_name: TextView
        private val tv_price: TextView
        private val film_image: ImageView
        private val sub_titel_image: ImageView

        init {
            tv_name = itemView.findViewById<TextView>(R.id.tv_name)
            tv_price = itemView.findViewById<TextView>(R.id.tv_price)
            film_image = itemView.findViewById<ImageView>(R.id.img_film_small_pic)
            sub_titel_image = itemView.findViewById<ImageView>(R.id.img_subtitel)
            itemView.setOnClickListener { filmIteraction.onMovieClicked(movie) }
        }

        fun bind(movie1: Movie, name: String?, price: Int, imgUrl: String?, isTranslated: Boolean?) {
            this.movie = movie1
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

    interface MovieIteraction {
        fun onMovieClicked(movie: Movie)
    }
}