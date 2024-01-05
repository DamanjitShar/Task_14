// AppointmentsActivity.kt

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.daman.task_14.R


class AppointmentsActivity : AppCompatActivity() {

    private lateinit var viewModel: AppointmentsViewModel
    private lateinit var appointmentsAdapter: AppointmentsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_appointments)

        viewModel = ViewModelProvider(this).get(AppointmentsViewModel::class.java)
        appointmentsAdapter = AppointmentsAdapter()

        // Set up RecyclerView
        val recyclerViewAppointments
        recyclerViewAppointments.layoutManager = LinearLayoutManager(this)
        recyclerViewAppointments.adapter = appointmentsAdapter

        // Observe the selected tab changes
        viewModel.selectedTab.observe(this, { selectedTab ->
            // Update the RecyclerView based on the selected tab
            when (selectedTab) {
                "Active" -> showActiveAppointments()
                "Past" -> showPastAppointments()
                "Cancelled" -> showCancelledAppointments()
                // Handle other tabs if needed
            }
        })

        // Set click listeners for the tabs
        textViewActiveTab.setOnClickListener { viewModel.setSelectedTab("Active") }
        textViewPastTab.setOnClickListener { viewModel.setSelectedTab("Past") }
        textViewCancelledTab.setOnClickListener { viewModel.setSelectedTab("Cancelled") }

        // Initially, show active appointments
        viewModel.setSelectedTab("Active")
    }

    private fun showActiveAppointments() {
        // Logic to fetch and display active appointments
        appointmentsAdapter.submitList(/* List of active appointments */)
    }

    private fun showPastAppointments() {
        // Logic to fetch and display past appointments
        appointmentsAdapter.submitList(/* List of past appointments */)
    }

    private fun showCancelledAppointments() {

        appointmentsAdapter.submitList(/* List of cancelled appointments */)
    }
}
