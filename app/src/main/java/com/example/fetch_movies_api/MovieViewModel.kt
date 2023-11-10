package com.example.fetch_movies_api

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.fetch_movies_api.model.Film


class MovieViewModel : ViewModel() {
    private val filmMutableLiveData = MutableLiveData<Film>()
    fun getFilmMutableLiveData(): LiveData<Film> {
        return filmMutableLiveData
    }

    fun setFilmMutableLiveData(film: Film) {
        filmMutableLiveData.value = film
    }
}
