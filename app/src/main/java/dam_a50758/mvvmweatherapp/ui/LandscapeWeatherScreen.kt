package dam_a50758.mvvmweatherapp.uiState

import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue

@Composable 
fun LandscapeWeatherUI(
    weatherViewModel: WeatherViewModel = viewModel()
){
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
        Row{
            Column{
                TextFieldValue(
                    value = latitude.toString(),
                    onValueChange = {newValue ->
                        newValue.toFloatOrNull()?.let {
                            weatherViewModel.updateLatitude(it)
                        }
                    }
                )
        
                TextFieldValue(
                    value = longitude.toString(),
                    onValueChange = {newValue ->
                        newValue.toFloatOrNull()?.let {
                            weatherViewModel.updateLongitude(it)
                        }
                    }
                )
            }

            Column{
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
            }
        }
        Button(onClick = {
            weatherViewModel.fetchWeather()
        }){
            Text("Update")
        }
    }
}