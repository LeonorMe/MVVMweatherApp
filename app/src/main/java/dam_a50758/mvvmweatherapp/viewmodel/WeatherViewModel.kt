package dam_a50758.mvvmweatherapp.viewmodel

class WeatherViewModel(
): ViewModel(){
    private val _uistate = MutableStateFlow(WeatherUIState(
        0f, 0f, 0f, 0f, 0, 0f, "", 0, 0f
    ))
    
    val uiState: StateFlow<WeatherUIState> = _uistate

    fun updateLatitude(newLat: Float){

    }

    fun updateLongitude(newLon: Float){
        state.copy()
    }

    fun fetchWeather(){
        // get current lat/lon from state
        lat = state.
        lon = state.

        // call WeatherApiClient.getWeather(lat, lon)
        // convert API data in UI state
        // update _uiState
        // getWeather() is suspend and ViewModel needs a coroutine
        viewModelScope.launch{
            _uiState = WeatherApiClient.getWeather(lat, lon)
            
            // data mapping
            temperature = weather.current.temperature_2m
            _uiState.value = _uiState.value.copy()
        }

        
    }
}