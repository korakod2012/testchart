package com.example.testchart

import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.components.YAxis.AxisDependency
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnAddWeight = findViewById<Button>(R.id.btn_PlotWeight)
        setupChart()

        btnAddWeight.setOnClickListener {
            addEntry()
        }
    }

    private fun addEntry(){

        //get line data from old
        val data: LineData? = lineChart.data

        if ( data != null){
            var set = data.getDataSetByIndex(0)

            data.addEntry(
                Entry(
                    set.entryCount.toFloat(),
                    (Math.random() * 40).toFloat() + 30f
                ), 0
            )
            data.notifyDataChanged()

            // let the chart know it's data has changed
            lineChart.notifyDataSetChanged()

            // move to the latest entry
            lineChart.moveViewToX(data.entryCount.toFloat())

        }
    }

    private fun setupChart(){
        val entries = ArrayList<Entry>()
        val linedataSet = LineDataSet(entries, "Weight")
        linedataSet.setDrawValues(false)
        linedataSet.setDrawFilled(true)
        linedataSet.lineWidth = 3f
        linedataSet.fillColor = R.color.gray
        linedataSet.fillAlpha = R.color.red
        lineChart.xAxis.labelRotationAngle = 0f
        lineChart.xAxis.isEnabled = false
        lineChart.data = LineData(linedataSet)
        lineChart.axisRight.isEnabled = false
        lineChart.setTouchEnabled(true)
        lineChart.description.text = "Days"
        lineChart.animateX(1800, Easing.EaseInExpo)
    }

}