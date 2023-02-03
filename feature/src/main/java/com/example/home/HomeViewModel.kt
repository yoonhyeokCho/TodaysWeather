package com.example.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.entity.Response
import com.example.domain.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val homeRepository: HomeRepository
) : ViewModel() {

    private val _weatherResponse = MutableLiveData<Response>()
    val weatherResponse: LiveData<Response> = _weatherResponse


    fun getWeather(
        dataType: String,
        numOfRows: Int,
        pageNo: Int,
        baseDate: Int,
        baseTime: Int,
        nx: String,
        ny: String
    ) {
        viewModelScope.launch {
            val response = homeRepository.getWeatherInfo(
                dataType,
                numOfRows,
                pageNo,
                baseDate,
                baseTime,
                nx,
                ny
            )
                .onSuccess {
                    _weatherResponse.value = it.Domainresponse
                }.onFailure {
                    Log.d("HomeViewModel", "fail getWeather: ")
                }
        }
    }

}