import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import android.widget.EditText
import android.widget.Button
import com.example.weatherappvr1.R

class MainActivity : AppCompatActivity() {
    private lateinit var tableLayout: TableLayout
    private lateinit var locationEditText: EditText
    private lateinit var fetchButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        tableLayout = findViewById(R.id.weatherTable)
        locationEditText = findViewById(R.id.locationEditText)
        fetchButton = findViewById(R.id.fetchButton)

        fetchButton.setOnClickListener {
            val location = locationEditText.text.toString()
            val weatherData = getWeatherData(location)
            displayWeatherData(weatherData)
        }
    }

    private fun getWeatherData(location: String): WeatherData {
        when (location) {
            "Monday" -> return WeatherData("Monday", 12, 18, 15.0)
            "Tuesday" -> return WeatherData("Tuesday", 13, 19, 16.0)
            "Wednesday" -> return WeatherData("Wednesday", 14, 20, 17.0)
            "Thursday" -> return WeatherData("Thursday", 15, 21, 18.0)
            "Friday" -> return WeatherData("Friday", 16, 22, 19.0)
            "Saturday" -> return WeatherData("Saturday", 17, 23, 20.0)
            "Sunday" -> return WeatherData("Sunday", 18, 24, 21.0)
            else -> return WeatherData("", 0, 0, 0.0)
        }
    }

    private fun displayWeatherData(weatherData: WeatherData) {
        val tableRow = TableRow(this)
        tableRow.layoutParams = TableRow.LayoutParams(
            TableRow.LayoutParams.MATCH_PARENT,
            TableRow.LayoutParams.WRAP_CONTENT
        )

        val dayTextView = TextView(this)
        dayTextView.text = weatherData.day
        tableRow.addView(dayTextView)

        val minTempTextView = TextView(this)
        minTempTextView.text = "Min: ${weatherData.minTemp}°C"
        tableRow.addView(minTempTextView)

        val maxTempTextView = TextView(this)
        maxTempTextView.text = "Max: ${weatherData.maxTemp}°C"
        tableRow.addView(maxTempTextView)

        val avgTempTextView = TextView(this)
        avgTempTextView.text = "Avg: ${weatherData.avgTemp}°C"
        tableRow.addView(avgTempTextView)

        tableLayout.addView(tableRow)
    }
}

data class WeatherData(val day: String, val minTemp: Int, val maxTemp: Int, val avgTemp: Double)