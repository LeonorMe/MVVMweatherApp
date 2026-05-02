package dam_a50758.mvvmweatherapp.viewmodel

data class WeatherUIState(
    val latitude: Float,
    val longitude: Float,
    val temperature: Float,
    val windSpeed: Float,
    val windDirection: Int,
    val weatherCode: Int,
    val seaLevelPressure: Float,
    val time: String,
    val isDay: Int,
    val uvIndexMax: Float
)