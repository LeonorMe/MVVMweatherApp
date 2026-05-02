package dam_a50758.mvvmweatherapp.uiState

import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue
/* 
@Composable
fun WeatherContent(
    uiState: WeatherUiState,
    onLatitudeChange: (Float) -> Unit,
    onLongitudeChange: (Float) -> Unit,
    onFetch: () -> Unit
)
*/
@Composable 
fun WeatherUI(
    weatherViewModel: WeatherViewModel = viewModel()
){

    val uiState by weatherViewModel.uiState.collectAsState()

    //var latField by remember {mutableStateOf(TextFieldValue(uiState.latitude.toString))}
    //var lonField by remember {mutableStateOf(TextFieldValue(uiState.longitude.toString))}

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
}