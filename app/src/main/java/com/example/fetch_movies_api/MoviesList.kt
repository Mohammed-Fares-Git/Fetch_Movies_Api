package com.example.fetch_movies_api

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.example.fetch_movies_api.model.Movie
import com.example.fetch_movies_api.databinding.FragmentMoviesListBinding
import org.json.JSONException


class MoviesList : Fragment() {
    private lateinit var frg1Binding: FragmentMoviesListBinding
    private lateinit var sharedeViewModel: MovieViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        frg1Binding = FragmentMoviesListBinding.inflate(inflater, container, false)
        sharedeViewModel = ViewModelProvider(requireActivity()).get(MovieViewModel::class.java)
        // Inflate the layout for this fragment
        frg1Binding.filmsList.setLayoutManager(LinearLayoutManager(activity))
        frg1Binding.filmsList.setHasFixedSize(true)
        filmsData
        return frg1Binding.getRoot()
    }

    val filmsData: Unit
        get() {
            val movies = ArrayList<Movie>()
            val requestQueue = Volley.newRequestQueue(activity)
            val request = JsonArrayRequest(
                Request.Method.GET, FILMS_URL, null,
                { response ->
                    for (i in 0 until response.length()) {
                        try {
                            val jsonObject = response.getJSONObject(i)
                            val movie = Movie()
                            movie.id = jsonObject.getString("id")
                            movie.name = jsonObject.getString("name")
                            movie.image = jsonObject.getString("image")
                            movie.price = jsonObject.getInt("price")
                            movie.traduction = jsonObject.getBoolean("traduction")
                            movies.add(movie)
                            val movieAdapter = MovieAdapter(movies, object : MovieAdapter.MovieIteraction {
                                override fun onMovieClicked(movie: Movie) {
                                    sharedeViewModel.setFilmMutableLiveData(movie)
                                }

                            })
                            frg1Binding.filmsList.setAdapter(movieAdapter)
                            frg1Binding.filmsList.setHasFixedSize(true)
                        } catch (e: JSONException) {
                            frg1Binding.filmsList.setVisibility(View.GONE)
                            Log.e("Faesss", "onErrorResponse: $e")
                        }
                    }
                }
            ) { error -> Log.e("VllEYYYYYyy", "onErrorResponse: $error") }
            requestQueue.add(request)
        }

    companion object {
        const val FILMS_URL = "https://run.mocky.io/v3/d9293f76-e064-4731-ba9f-dcef017cca1a"
    }
}