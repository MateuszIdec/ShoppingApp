package com.example.mobilesystemstask2

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.mobilesystemstask2.databinding.FragmentSecondBinding
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import kotlin.collections.ArrayList


/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private var chart: LineChart? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        _binding =  FragmentSecondBinding.inflate(inflater, container, false)
        chart = binding.chart
        setLineChartData()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setLineChartData() {

        val lineDataSet = LineDataSet(exampleData(), "First shop")
        val lineDataSet1 = LineDataSet(exampleData(), "Second shop")
        lineDataSet.color = Color.GRAY
        lineDataSet1.color = Color.GREEN
        val data = LineData(lineDataSet)
        val data1 = LineData(lineDataSet1)
        lineDataSet.circleRadius = 4f
        lineDataSet.setCircleColor(Color.BLACK)
        lineDataSet.lineWidth = 2f

        lineDataSet1.circleRadius = 4f
        lineDataSet1.setCircleColor(Color.BLACK)
        lineDataSet1.lineWidth = 2f

        val xAxis = chart!!.xAxis
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        val yAxis = chart!!.axisLeft
        yAxis.spaceTop = 40f
        yAxis.labelCount = 4

        chart!!.description.isEnabled = false
        chart!!.axisRight.setDrawGridLines(false)
        chart!!.xAxis.setDrawGridLines(false)
        chart!!.axisRight.setDrawLabels(false)
        chart?.xAxis?.granularity = 0.5f
        chart?.data = data
        chart?.setVisibleXRangeMaximum(4f)
        chart?.invalidate()
    }

    private fun exampleData() : ArrayList<Entry> {
        val dataValues = ArrayList<Entry>()
        dataValues.add(Entry(0f,2.2f))
        dataValues.add(Entry(1f,2.6f))
        dataValues.add(Entry(2f,2.3f))
        return dataValues
    }

    private fun exampleData1() : ArrayList<Entry> {
        val dataValues = ArrayList<Entry>()
        dataValues.add(Entry(0.2f,2.4f))
        dataValues.add(Entry(1f,2.3f))
        dataValues.add(Entry(2f,2.5f))
        return dataValues
    }

}