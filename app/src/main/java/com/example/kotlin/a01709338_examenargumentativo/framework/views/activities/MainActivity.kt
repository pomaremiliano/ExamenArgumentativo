package com.example.kotlin.a01709338_examenargumentativo.framework.views.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.kotlin.a01709338_examenargumentativo.R
import com.example.kotlin.a01709338_examenargumentativo.data.network.ApiService
import com.example.kotlin.a01709338_examenargumentativo.data.network.NetworkModuleDI
import com.example.kotlin.a01709338_examenargumentativo.data.network.model.ApiDataItem
import kotlinx.coroutines.launch

class MainActivity: AppCompatActivity() {
    //private lateinit var viewModel: DataViewModel
    private lateinit var dataInput: EditText
    private lateinit var resultTable: TableLayout
    private lateinit var searchButton: Button
    private lateinit var service: ApiService


    override fun onCreate (savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        service = NetworkModuleDI.makeRetrofitService()

        dataInput = findViewById(R.id.data_input)
        searchButton = findViewById(R.id.search_button)
        resultTable = findViewById(R.id.result_table)

        searchButton.setOnClickListener {
            getData()
        }
    }

    private fun getData() {
        lifecycleScope.launch {
            try {
                val res = service.getAllData()
                println(res)
                println(res.results)
                showResult(res.results)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    private fun showResult(dataList: List<ApiDataItem>) {
        println(dataList)

        val tableLayout = findViewById<TableLayout>(R.id.tableLayout)
        tableLayout.removeAllViews()

        val headersRow = TableRow(this)
        val campo1Header = TextView(this).apply {
            text = "Data"
        }

        headersRow.addView(campo1Header)
        tableLayout.addView(headersRow)

        dataList.forEach { results ->
            val dataRow = TableRow(this)
            val campo1 = TextView(this).apply {
                text = results.expire.toString()
                text = results.flags.toString()
                text = results.mname
                text = results.record_type
                text = results.refresh.toString()
                text = results.retry.toString()
                text = results.serial.toString()
                text = results.tag
                text = results.ttl.toString()
                text = results.value
            }

            dataRow.addView(campo1)
            tableLayout.addView(dataRow)
        }
    }
}