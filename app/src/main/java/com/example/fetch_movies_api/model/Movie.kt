package com.example.fetch_movies_api.model

import java.io.Serializable


class Movie : Serializable {
    var traduction: Boolean? = null
    var image: String? = null
    var price: Int? = null
    var name: String? = null
    var id: String? = null
}
