package com.example.testchart

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val entries = ArrayList<Entry>()
        entries.add(Entry(1f, 75f))
        entries.add(Entry(2f, 79f))
        entries.add(Entry(3f, 77f))
        entries.add(Entry(4f, 77f))
        entries.add(Entry(5f, 78f))
        entries.add(Entry(6f, 75f))
        entries.add(Entry(7f, 79f))
        entries.add(Entry(8f, 77f))
        entries.add(Entry(9f, 77f))
        entries.add(Entry(10f, 78f))



        val vl = LineDataSet(entries, "Weight")
        vl.setDrawValues(false)
        vl.setDrawFilled(true)
        vl.lineWidth = 3f
        vl.fillColor = R.color.gray
        vl.fillAlpha = R.color.red

        lineChart.xAxis.labelRotationAngle = 0f

        lineChart.xAxis.isEnabled = false
        lineChart.data = LineData(vl)
        lineChart.axisRight.isEnabled = false
        //lineChart.xAxis.axisMaximum = 10F
        lineChart.setTouchEnabled(true)
        lineChart.description.text = "Days"
        lineChart.animateX(1800, Easing.EaseInExpo)

    }
}