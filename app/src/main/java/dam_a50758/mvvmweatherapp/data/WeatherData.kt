// https://api.open-meteo.com/v1/forecast?latitude=52.52&longitude=13.41&daily=uv_index_max&hourly=pressure_msl&current=wind_speed_10m,wind_direction_10m,temperature_2m,weather_code,is_day&timezone=Europe%2FLondon&forecast_days=3

/*
Hourly weather variables:
    sea_level_pressure


Daily weather variables:
    uv_index_max


Current weather:
    temperature_2m
    is_day
    weather_code
    wind_speed_10m
    wind_direction_10m
*/

@Serializable
data class WeatherData(
    val latitude: Float,
    val longitude: Float,
    val current: Current?,
    val hourly: Hourly?,
    val daily: Daily?
)

@Serializable
data class Current(
    val time: String,
    val wind_speed_10m: Float,
    val wind_direction_10m: Int,
    val temperature_2m: Float,
    @SerialName("weather_code")
    val weatherCode: Int,
    val is_day: Int
)

@Serializable
data class Hourly(
    val time: List<String>,
    val pressure_msl: List<Float>
)

@Serializable
data class Daily(
    val time: List<String>,
    val uv_index_max: List<Float>
)

/*
api response JSOn example:
{
  "latitude": 52.52,
  "longitude": 13.419998,
  "generationtime_ms": 0.165224075317383,
  "utc_offset_seconds": 3600,
  "timezone": "Europe/London",
  "timezone_abbreviation": "GMT+1",
  "elevation": 38,
  "current_units": {
    "time": "iso8601",
    "interval": "seconds",
    "wind_speed_10m": "km/h",
    "wind_direction_10m": "°",
    "temperature_2m": "°C",
    "weather_code": "wmo code",
    "is_day": ""
  },
  "current": {
    "time": "2026-05-02T12:00",
    "interval": 900,
    "wind_speed_10m": 13.2,
    "wind_direction_10m": 197,
    "temperature_2m": 24.2,
    "weather_code": 0,
    "is_day": 1
  },
  "hourly_units": {
    "time": "iso8601",
    "pressure_msl": "hPa"
  },
  "hourly": {
    "time": [
      "2026-05-02T00:00",
      "2026-05-02T01:00",
      "2026-05-02T02:00",
      "2026-05-02T03:00",
      "2026-05-02T04:00",
      "2026-05-02T05:00",
      "2026-05-02T06:00",
      "2026-05-02T07:00",
      "2026-05-02T08:00",
      "2026-05-02T09:00",
      "2026-05-02T10:00",
      "2026-05-02T11:00",
      "2026-05-02T12:00",
      "2026-05-02T13:00",
      "2026-05-02T14:00",
      "2026-05-02T15:00",
      "2026-05-02T16:00",
      "2026-05-02T17:00",
      "2026-05-02T18:00",
      "2026-05-02T19:00",
      "2026-05-02T20:00",
      "2026-05-02T21:00",
      "2026-05-02T22:00",
      "2026-05-02T23:00",
      "2026-05-03T00:00",
      "2026-05-03T01:00",
      "2026-05-03T02:00",
      "2026-05-03T03:00",
      "2026-05-03T04:00",
      "2026-05-03T05:00",
      "2026-05-03T06:00",
      "2026-05-03T07:00",
      "2026-05-03T08:00",
      "2026-05-03T09:00",
      "2026-05-03T10:00",
      "2026-05-03T11:00",
      "2026-05-03T12:00",
      "2026-05-03T13:00",
      "2026-05-03T14:00",
      "2026-05-03T15:00",
      "2026-05-03T16:00",
      "2026-05-03T17:00",
      "2026-05-03T18:00",
      "2026-05-03T19:00",
      "2026-05-03T20:00",
      "2026-05-03T21:00",
      "2026-05-03T22:00",
      "2026-05-03T23:00",
      "2026-05-04T00:00",
      "2026-05-04T01:00",
      "2026-05-04T02:00",
      "2026-05-04T03:00",
      "2026-05-04T04:00",
      "2026-05-04T05:00",
      "2026-05-04T06:00",
      "2026-05-04T07:00",
      "2026-05-04T08:00",
      "2026-05-04T09:00",
      "2026-05-04T10:00",
      "2026-05-04T11:00",
      "2026-05-04T12:00",
      "2026-05-04T13:00",
      "2026-05-04T14:00",
      "2026-05-04T15:00",
      "2026-05-04T16:00",
      "2026-05-04T17:00",
      "2026-05-04T18:00",
      "2026-05-04T19:00",
      "2026-05-04T20:00",
      "2026-05-04T21:00",
      "2026-05-04T22:00",
      "2026-05-04T23:00"
    ],
    "pressure_msl": [1025.2, 1024.7, 1024.5, 1024.4, 1023.9, 1024, 1024, 1023.4, 1022.8, 1022.8, 1022.3, 1021.5, 1021.1, 1020.1, 1019.1, 1018.2, 1017.6, 1017.1, 1016.5, 1016.2, 1016.1, 1016.2, 1015.9, 1015.6, 1015.2, 1014.9, 1014.4, 1014.3, 1014, 1014, 1014, 1013.9, 1013.6, 1013.4, 1013.1, 1012.8, 1012.3, 1011.7, 1011.3, 1010.8, 1010.5, 1010.1, 1009.7, 1009.8, 1010.2, 1010.4, 1010.3, 1010.1, 1010.3, 1010.2, 1010.4, 1010.3, 1010.1, 1010.5, 1010.8, 1011.1, 1011.2, 1011.4, 1011.5, 1011.6, 1011.2, 1010.9, 1010.7, 1010.6, 1010.6, 1010.6, 1010.8, 1010.9, 1011.1, 1011.2, 1011.4, 1011.6]
  },
  "daily_units": {
    "time": "iso8601",
    "uv_index_max": ""
  },
  "daily": {
    "time": [
      "2026-05-02",
      "2026-05-03",
      "2026-05-04"
    ],
    "uv_index_max": [5.9, 5.55, 5.65]
  }
}
*/