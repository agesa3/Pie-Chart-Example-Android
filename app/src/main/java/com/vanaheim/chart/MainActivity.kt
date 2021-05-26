package com.vanaheim.chart

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setUpPieChart()
        loadPieChartData()
    }

    private fun loadPieChartData() {
        val entries: ArrayList<PieEntry> = ArrayList()
        entries.add(PieEntry(0.2f, "Food & Dining"))
        entries.add(PieEntry(0.15f, "Medical"))
        entries.add(PieEntry(0.10f, "Entertainment"))
        entries.add(PieEntry(0.25f, "Electricity and Gas"))
        entries.add(PieEntry(0.3f, "Housing"))

        val colors: ArrayList<Int> = ArrayList()
        for (color in ColorTemplate.MATERIAL_COLORS) {
            colors.add(color)
        }

        for (color in ColorTemplate.VORDIPLOM_COLORS) {
            colors.add(color)
        }

        val dataSet = PieDataSet(entries, "Expense Category")
        dataSet.colors = colors

        val data = PieData(dataSet)
        data.setDrawValues(true)
        data.setValueFormatter(PercentFormatter(activity_main_piechart))
        data.setValueTextSize(12f)
        data.setValueTextColor(Color.BLACK)

        activity_main_piechart.data = data
        activity_main_piechart.invalidate()

        activity_main_piechart.animateY(1400, Easing.EaseInOutQuad)
    }

    private fun setUpPieChart() {
        activity_main_piechart.isDrawHoleEnabled=true
        activity_main_piechart.setUsePercentValues(true)
        activity_main_piechart.setEntryLabelTextSize(12F)
        activity_main_piechart.setEntryLabelColor(Color.BLACK)
        activity_main_piechart.centerText="Spending by Category"
        activity_main_piechart.setCenterTextSize(24F)
        activity_main_piechart.description.isEnabled=false

//        activity_main_piechart.apply {
//            isDrawHoleEnabled=true
//            setUsePercentValues(true)
//            setEntryLabelTextSize(12F)
//            setEntryLabelColor(Color.BLACK)
//            centerText="Spending By Category"
//            setCenterTextSize(24F)
//            description.isEnabled=false
//
//        }

        val l = activity_main_piechart.legend
        l.verticalAlignment = Legend.LegendVerticalAlignment.TOP
        l.horizontalAlignment = Legend.LegendHorizontalAlignment.RIGHT
        l.orientation = Legend.LegendOrientation.VERTICAL
        l.setDrawInside(false)
        l.isEnabled = true

    }
}