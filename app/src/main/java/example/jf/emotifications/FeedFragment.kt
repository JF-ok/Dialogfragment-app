package example.jf.emotifications

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.LifecycleOwner
import com.google.android.material.floatingactionbutton.FloatingActionButton

private const val EDIT_TEXT_INTENT = "TestText"

class FeedFragment : Fragment() {
    private val dataModel: DataModel by activityViewModels()
    lateinit var floatingActionButton: FloatingActionButton
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_feed, container, false)
        val fragment: Fragment = DialogFragment()
        floatingActionButton = view.findViewById(R.id.add_fab)
//        val dialogIntent : String? = intent.extras?.getString(EDIT_TEXT_INTENT)

        floatingActionButton.setOnClickListener {
            this.replaceFragment(fragment!!)
        }
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataModel.message.observe(activity as LifecycleOwner, {
            if (it != "") {
                floatingActionButton.setImageResource(R.drawable.ic_apply_icon)
            } else {
                floatingActionButton.setImageResource(R.drawable.ic_add_icon)
            }
        })
        floatingActionButton.setOnClickListener {

        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = activity?.supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager!!.beginTransaction()
        fragmentTransaction.replace(R.id.dialog_fragment_container_view, fragment)
        fragmentTransaction.addToBackStack(fragment.tag)
        fragmentTransaction.commit()
    }
}