// TODO ktor ContentNegotiation json example
// kotlin buildString example
// kotlin suspend function explained


object WeatherApiClient{
    private val Client = HttpClient {
        install(ContentNegotiation){
            json(Json{
                ignoreUnknownKeys = true
            })
        }
    }
}

fun main(){
    val lat = 38.0
    val lon = -9.4
    
    getWeather(lat, lon)
    WeatherApiClient.getWeather(lat, lon)
}


suspend fun getWeather(lat: float, lon: Float): WeatherData?{
    val url = "https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&daily=uv_index_max&hourly=pressure_msl&current=wind_speed_10m,wind_direction_10m,temperature_2m,weather_code,is_day&timezone=Europe%2FLondon&forecast_days=3"

    try{
        client.get(url).body<WeatherData>()
    } catch (e: Exception){

    }
    
}

