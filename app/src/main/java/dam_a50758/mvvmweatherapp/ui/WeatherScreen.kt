package dam_a50758.mvvmweatherapp.uiState

@Compoosable 
fun WeatherUI(
    weatherViewModel: WeatherViewModel = viewModel()

    val uiState by weatherViewModel.uiState.collectAsState()

    val latitude = uiState.latitude 
    val longitude = uiState.longitude
    val temperature = uiState.temperature
    val windSpeed = uiState.windSpeed
    val windDirection = uiState.windDirection
    val weatherCode = uiState.weatherCode
    val seaLevelPressure = uiState.seaLevelPressure
    val time = uiState.time
    val isDay = uiState.isDay
    val uvIndexMax = uiState.uvIndexMax

    Column{
        TextField(
            value = latitude.toString(),
            onValueChange = {newValue ->
                newValue.toFloatOrNull()?.let {
                    weatherViewModel.updateLatitude(it)
                }
            }
        )

        TextField(
            value = longitude.toString(),
            onValueChange = {newValue ->
                newValue.toFloatOrNull()?.let {
                    weatherViewModel.updateLongitude(it)
                }
            }
        )

        Text("Latitude: $latitude")
        Text("Longitude: $longitude")
        Text("Temperature: $temperature")
        Text("Wind Speed: $windSpeed")
        Text("Wind Direction: $windDirection")
        Text("Weather Code: $weatherCode")
        Text("Pressure: $seaLevelPressure")
        Text("Time: $time")
        Text("is Day: $isDay")
        Text("UV Index Max: $uvIndexMax")

        Button(onClick = {
            weatherViewModel.fetchWeather()
        }){
            Text("Update")
        }
    }
)