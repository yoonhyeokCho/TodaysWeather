package com.example.home

import android.Manifest
import android.annotation.SuppressLint
import android.graphics.Point
import android.os.Bundle
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.core.app.ActivityCompat
import androidx.fragment.app.viewModels
import com.example.core_ui.base.BindingFragment
import com.example.core_ui.util.ResolutionMetrics
import com.example.domain.entity.Response
import com.example.home.data.Weather
import com.example.todaysweather.feature.R
import com.example.todaysweather.feature.databinding.FragmentHomeBinding
import com.google.android.gms.location.LocationCallback
import com.google.android.gms.location.LocationRequest
import com.google.android.gms.location.LocationResult
import com.google.android.gms.location.LocationServices
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class HomeFragment(private val resolutionMetrics: ResolutionMetrics) :
    BindingFragment<FragmentHomeBinding>(R.layout.fragment_home) {

    private val Number.dp get() = resolutionMetrics.toPixel(this.toInt())
    private val viewModel by viewModels<HomeViewModel>()
    private lateinit var homeRecyclerViewAdapter: HomeRecyclerViewAdapter
    private var baseData = 1
    private var baseTime = 1
    private var curPoint: Point? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        requestLocation()
        initWeatherInfo()
    }

    private fun setWeatherData(nx: Int, ny: Int) {
        val cal = Calendar.getInstance()
        baseData = SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(cal.time).toInt()
        val timeHour = SimpleDateFormat("HH", Locale.getDefault()).format(cal.time)
        val timeMinute = SimpleDateFormat("mm", Locale.getDefault()).format(cal.time)
        baseTime = Common().getBaseTime(timeHour, timeMinute).toInt()

        if (timeHour == "00" && baseTime == 2330) {
            cal.add(Calendar.DATE, -1).toString()
            baseData = SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(cal.time).toInt()
        }
        viewModel.getWeather(
            "JSON", 72, 1, baseData, baseTime, nx.toString(), ny.toString()
        )

    }

    private fun initWeatherInfo() {
        viewModel.weatherResponse.observe(viewLifecycleOwner) {
            val itemlist: List<Response.Item> = it.body.items.item
            var index = 0
            val weatherList =
                arrayOf(Weather(), Weather(), Weather(), Weather(), Weather(),Weather())

            var count = 0
            for (i in 0 until 60) {
                index %= 7
                when (itemlist[i].category) {
                    "PTY" -> {
                        weatherList[index].precipitationType = itemlist[i].fcstValue
                        count++
                    }
                    "POP" -> {
                        weatherList[index].probabilityPrecipitation = itemlist[i].fcstValue
                        count++
                    }
                    "REH" -> {
                        weatherList[index].humidity = itemlist[i].fcstValue
                        count++
                    }
                    "SKY" -> {
                        weatherList[index].sky = itemlist[i].fcstValue
                        count++
                    }
                    "TMP" -> {
                        weatherList[index].temp = itemlist[i].fcstValue
                        count++
                    }
                    "WSD" -> {
                        weatherList[index].windSpeed = itemlist[i].fcstValue
                        count++
                    }
                    else -> continue
                }
                if (count == 6) {
                    index++
                    count = 0
                }
            }
            for (i in 0 until 5) {
                weatherList[i].fcstTime = setTimeFormat(itemlist[i * 12].fcstTime)
            }

            homeRecyclerViewAdapter = HomeRecyclerViewAdapter(weatherList)
            binding.rvWeather.adapter = homeRecyclerViewAdapter
        }
    }

    private fun setTimeFormat(time:String):String{
        var newDate = "${time[0]}${time[1]}시 ${time[2]}${time[3]}분"
        return newDate
    }

    @SuppressLint("MissingPermission")
    private fun requestLocation() {
        val locationClient = LocationServices.getFusedLocationProviderClient(requireActivity())

        try {
            // 나의 현재 위치 요청
            val locationRequest = LocationRequest.create()
            locationRequest.run {
                priority = LocationRequest.PRIORITY_HIGH_ACCURACY
                interval = 60 * 1000    // 요청 간격(1초)
            }
            val locationCallback = object : LocationCallback() {
                override fun onLocationResult(p0: LocationResult) {
                    p0.let {
                        for (location in it.locations) {
                            curPoint = Common().transfer(location.latitude, location.longitude)
                            setWeatherData(curPoint!!.x, curPoint!!.y)
                        }
                    }
                }
            }

            Looper.myLooper()?.let {
                locationClient.requestLocationUpdates(
                    locationRequest, locationCallback,
                    it
                )
            }

        } catch (e: SecurityException) {
            e.printStackTrace()
        }
    }

}