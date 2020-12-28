package com.bibitaries.sepakbola.data.remote

import com.bibitaries.sepakbola.data.model.OlahragaList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface OlahragaService {
    @GET("/olahraga")
    fun listOlahraga() : Call<OlahragaList>

    @GET("detail/")
    fun detailOlahraga(@Query("url") url: String) : Call<OlahragaList>

    @GET("search/")
    fun searchOlahraga(@Query("q") query: String) : Call<OlahragaList>
}