package barron.clocker

import android.os.Bundle
import android.view.View
import android.widget.Space
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Timer
import java.util.TimerTask

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val date: TextView = findViewById(R.id.date)
        val time1: TextView = findViewById(R.id.time1)
        val time2: TextView = findViewById(R.id.time2)
        val space1: Space = findViewById(R.id.space1)
        val space2: Space = findViewById(R.id.space2)
        val space3: Space = findViewById(R.id.space3)

        if(resources.configuration.orientation == 1) {
            date.textSize = 30F
            time1.textSize = 120F
            time2.textSize = 40F
            space1.visibility = View.VISIBLE
            space2.visibility = View.VISIBLE
            space3.visibility = View.VISIBLE
        } else {
            date.textSize = 40F
            time1.textSize = 180F
            time2.textSize = 50F
            space1.visibility = View.GONE
            space2.visibility = View.GONE
            space3.visibility = View.GONE
        }

        Timer().schedule(object:TimerTask() {
            override fun run() {
                date.text = SimpleDateFormat("yyyy-MM-dd EEEE").format(Date())
                time1.text = SimpleDateFormat("HH:mm").format(Date())
                time2.text = SimpleDateFormat("- ss -").format(Date())
            }
        }, Date(), 1000)
    }
}
