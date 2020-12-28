package com.bibitaries.sepakbola.data.repository

import android.app.DownloadManager
import com.bibitaries.sepakbola.data.model.ActionState
import com.bibitaries.sepakbola.data.model.Olahraga
import com.bibitaries.sepakbola.data.remote.OlahragaService
import com.bibitaries.sepakbola.data.remote.RetrofitApi
import retrofit2.await
import java.lang.Exception

class OlahragaRepository {
    private val olahragaService: OlahragaService by lazy { RetrofitApi.olahragaService() }

    suspend fun listOlahraga() : ActionState<List<Olahraga>> {
        return try {
            val list = olahragaService.listOlahraga().await()
            ActionState(list.data)
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun detailOlahraga(url: String) : ActionState<Olahraga> {
        return try {
            val list = olahragaService.detailOlahraga(url).await()
            ActionState(list.data.first())
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }

    suspend fun searchOlahraga(query: String) : ActionState<List<Olahraga>> {
        return try {
            val list = olahragaService.searchOlahraga(query).await()
            ActionState(list.data)
        } catch (e: Exception) {
            ActionState(message = e.message, isSuccess = false)
        }
    }
}