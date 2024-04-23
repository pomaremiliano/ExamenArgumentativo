package com.example.kotlin.a01709338_examenargumentativo.framework.views.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlin.a01709338_examenargumentativo.R
import com.example.kotlin.a01709338_examenargumentativo.data.network.ApiService
import com.example.kotlin.a01709338_examenargumentativo.data.network.NetworkModuleDI
import com.example.kotlin.a01709338_examenargumentativo.data.network.model.ApiObject
import com.example.kotlin.a01709338_examenargumentativo.framework.viewmodel.DataViewModel

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


    }


    private fun showResult(data: ApiObject) {
        resultTable.removeAllViews()
        val headersRow = TableRow(this)
        val campo1Header = TextView(this).apply {
            text = "ID"
        }
        val campo2Header = TextView(this).apply {
            text = "Data"
        }
        headersRow.addView(campo1Header)
        headersRow.addView(campo2Header)
        resultTable.addView(headersRow)
        data.results.forEach {
            val row = TableRow(this)
            val campo1 = TextView(this).apply {
                text = it.expire.toString()
            }
            val campo2 = TextView(this).apply {
                text = it.flags.toString()
            }
            val campo3 = TextView(this).apply {
                text = it.mname
            }
            val campo4 = TextView(this).apply {
                text = it.record_type
            }
            val campo5 = TextView(this).apply {
                text = it.refresh.toString()
            }
            val campo6 = TextView(this).apply {
                text = it.retry.toString()
            }
            val campo7 = TextView(this).apply {
                text = it.rname
            }
            val campo8 = TextView(this).apply {
                text = it.serial.toString()
            }
            val campo9 = TextView(this).apply {
                text = it.tag
            }
            val campo10 = TextView(this).apply {
                text = it.ttl.toString()
            }
            val campo11 = TextView(this).apply {
                text = it.value
            }
            row.addView(campo1)
            row.addView(campo2)
            row.addView(campo3)
            row.addView(campo4)
            row.addView(campo5)
            row.addView(campo6)
            row.addView(campo7)
            row.addView(campo8)
            row.addView(campo9)
            row.addView(campo10)
            row.addView(campo11)
            resultTable.addView(row)
        }
    }
}