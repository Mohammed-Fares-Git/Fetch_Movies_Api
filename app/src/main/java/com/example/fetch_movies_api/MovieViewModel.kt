package com.example.fetch_movies_api

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fetch_movies_api.model.Film


class MovieViewModel : ViewModel() {
    private val movieMutableLiveData = MutableLiveData<Film>()
    fun getFilmMutableLiveData(): LiveData<Film> {
        return movieMutableLiveData
    }

    fun setFilmMutableLiveData(film: Film) {
        movieMutableLiveData.value = film
    }
}
