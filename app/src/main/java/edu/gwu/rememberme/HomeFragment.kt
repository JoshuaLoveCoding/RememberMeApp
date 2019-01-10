package edu.gwu.rememberme


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import kotlinx.android.synthetic.main.fragment_home.*
import java.util.*


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HomeFragment : Fragment() {

    private lateinit var persistenceManager: PersistenceManager
    private lateinit var remindersAdapter: RemindersAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        var view : View = inflater.inflate(R.layout.fragment_home, container, false)

        persistenceManager = PersistenceManager(context!!)

        val reminders = persistenceManager.fetchReminders()

        remindersAdapter = RemindersAdapter(reminders)

//        recycler_view.adapter = remindersAdapter
//        recycler_view.layoutManager = LinearLayoutManager(activity)

        return view
    }

    fun confirmButtonPressed(button: Button) {
        button.setOnClickListener {
            val reminderText = editTextReminder.text.toString()
            if (reminderText != "") {
                val reminder = Reminder(reminderText, Date())
                persistenceManager.saveReminder(reminder)
            }
        }
    }

}
