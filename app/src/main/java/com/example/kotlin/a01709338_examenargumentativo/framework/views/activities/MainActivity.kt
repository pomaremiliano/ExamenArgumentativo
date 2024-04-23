import android.os.Bundle
import android.widget.Button
import android.widget.TableLayout
import android.widget.TableRow
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.kotlin.a01709338_examenargumentativo.R
import com.example.kotlin.a01709338_examenargumentativo.data.network.model.ApiObject

class MainActivity : AppCompatActivity() {
    private lateinit var viewModel: DataViewModel
    private lateinit var dataTable: TableLayout
    private lateinit var loadDataButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(DataViewModel::class.java)
        dataTable = findViewById(R.id.tableLayout)
        loadDataButton = findViewById(R.id.search_button)

        loadDataButton.setOnClickListener {
            viewModel.getAllData()
        }

        viewModel.data.observe(this, { apiObject ->
            updateTable(apiObject)
        })
    }

    private fun updateTable(apiObject: ApiObject?) {
        dataTable.removeAllViews()
        if (apiObject != null) {
            addRow("Field1", apiObject.results.toString())

        }
    }

    private fun addRow(label: String, value: String) {
        val row = TableRow(this)
        val labelView = TextView(this).apply {
            text = label


        }
        val valueView = TextView(this).apply {
            text = value

        }
        row.addView(labelView)
        row.addView(valueView)
        dataTable.addView(row)
    }
}
