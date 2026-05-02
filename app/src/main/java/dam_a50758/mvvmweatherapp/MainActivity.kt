package dam_a50758.mvvmweatherapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.compose.ui.platform.LocalConfiguration
import android.content.res.Configuration

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent{
            val configuration = LocalConfiguration.current

            if(configuration.orientation == Configuration.ORIENTATION_LANDSCAPE){
                LandscapeWeatherUI()
            } else{
                WeatherUI()
            } 
        }
    }
}