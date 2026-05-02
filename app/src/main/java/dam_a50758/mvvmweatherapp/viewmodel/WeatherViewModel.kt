package dam_a50758.mvvmweatherapp.viewmodel

class WeatherViewModel(
): ViewModel(){
    private val _uiState = MutableStateFlow(WeatherUIState(
        0f, 0f, 0f, 0f, 0, 0, 0f, "", 0, 0f
    ))
    
    val uiState: StateFlow<WeatherUIState> = _uiState.asStateFlow()

    fun updateLatitude(newLat: Float){
        _uiState.value = _uiState.value.copy(latitude = newLat)
    }

    fun updateLongitude(newLon: Float){
        _uiState.value = _uiState.value.copy(longitude = newLon)
    }

    fun fetchWeather(){
        val lat = _uiState.value.latitude
        val lon = _uiState.value.longitude

        viewModelScope.launch{
            val weather = WeatherApiClient.getWeather(lat, lon)

            if (weather != null){
                _uiState.value = _uiState.value.copy(
                    temperature = weather.current.temperature_2m,
                    windSpeed: weather.current.wind_speed_10m,
                    windDirection: weather.current.wind_direction_10m,
                    weatherCode: weather.current.weatherCode,
                    seaLevelPressure: weather.hourly.pressure_msl[0],
                    time: weather.current.time,
                    isDay: weather.current.is_day,
                    uvIndexMax: weather.daily.uv_index_max[0]
                )
            }  
        }
    }
}
