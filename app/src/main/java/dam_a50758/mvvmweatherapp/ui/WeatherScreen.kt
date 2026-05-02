package dam_a50758.mvvmweatherapp.uiState

import androidx.compose.runtime.*
import androidx.compose.ui.text.input.TextFieldValue

@Composable
fun WeatherContent(
    uiState: WeatherUiState,
    latField: TextFieldValue
    lonField: TextFieldValue
    onLatitudeChange: (Float) -> Unit,
    onLongitudeChange: (Float) -> Unit,
    onFetch: () -> Unit
){
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


@Composable 
fun WeatherUI(
    weatherViewModel: WeatherViewModel = viewModel()
){

    val uiState by weatherViewModel.uiState.collectAsState()

    var latField by remember {mutableStateOf(TextFieldValue(uiState.latitude.toString))}
    var lonField by remember {mutableStateOf(TextFieldValue(uiState.longitude.toString))}

    WeatherContent(
        uiState = uiState,
        latField = latField,
        lonField = lonField,
        onLatChange = {
            latField = it
            it.text.toFloatOrNull()?.let(weatherViewModel::updateLatitude)
        },
        onLongitudeChange = {
            lonField = it
            it.text.toFloatOrNull()?.let(weatherViewModel::updateLongitude)
        },
        onFetch = {
            weatherViewModel.fetchWeather()
        }
    )
}