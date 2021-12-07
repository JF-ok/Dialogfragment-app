package example.jf.emotifications

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.floatingactionbutton.FloatingActionButton

class FeedFragment : Fragment() {
    lateinit var floatingActionButton : FloatingActionButton
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_feed,container,false)
        val fragment: Fragment = DialogFragment()
        floatingActionButton = view.findViewById(R.id.add_fab)
        floatingActionButton.setOnClickListener {
            this.replaceFragment(fragment!!)
            Toast.makeText(context,"Что думаешь?", Toast.LENGTH_SHORT).show()
        }
        return view
    }
        private fun replaceFragment(fragment: Fragment) {
            val fragmentManager = activity?.supportFragmentManager
            val fragmentTransaction: FragmentTransaction = fragmentManager!!.beginTransaction()
            fragmentTransaction.replace(R.id.dialog_fragment_container_view, fragment)
            fragmentTransaction.addToBackStack(fragment.tag)
            fragmentTransaction.commit()
        }
}