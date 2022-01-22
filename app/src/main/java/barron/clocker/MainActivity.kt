package barron.clocker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Timer
import java.util.TimerTask

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val time: TextView = findViewById(R.id.time)
        val date: TextView = findViewById(R.id.date)

        if(resources.configuration.orientation == 1) {
            date.textSize = 18F
            time.textSize = 60F
        } else {
            date.textSize = 30F
            time.textSize = 100F
        }

        Timer().schedule(object:TimerTask() {
            override fun run() {
                date.text = SimpleDateFormat("yyyy-MM-dd EEEE").format(Date())
                time.text = SimpleDateFormat("HH:mm:ss").format(Date())
            }
        }, Date(), 1000)
    }
}
