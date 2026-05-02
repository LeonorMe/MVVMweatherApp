package dam_a50758.mvvmweatherapp.data

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import kotlinx.serialization.Serializable

object WeatherApiClient{

    private val client = HttpClient {
        install(ContentNegotiation){
            json(Json{
                ignoreUnknownKeys = true
            })
        }
    }

    suspend fun getWeather(lat: Float, lon: Float): WeatherData?{
        val url = "https://api.open-meteo.com/v1/forecast?latitude=$lat&longitude=$lon&daily=uv_index_max&hourly=pressure_msl&current=wind_speed_10m,wind_direction_10m,temperature_2m,weather_code,is_day&timezone=Europe%2FLondon&forecast_days=3"

        try{
            return client.get(url).body<WeatherData>()
        } catch (e: Exception){
            return null
        }
    }
}
