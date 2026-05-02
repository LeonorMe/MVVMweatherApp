package dam_a50758.mvvmweatherapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import kotlinx.serialization.Serializable

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val configuration = LocalConfiguration.current

        setContent{
            if(configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
                LandscapeWeatherUI()
            } else{
                WeatherUI()
            }
            
        }

        //lifecycleScope.fetchWeather()

        /*
        val lat = 38.0
        val lon = -9.4
        

        viewModelscope.lauch {
            WeatherApiClient.getWeather(lat, lon) 
        }
        */
    }
}