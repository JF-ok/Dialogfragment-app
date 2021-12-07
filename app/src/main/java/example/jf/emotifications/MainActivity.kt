package example.jf.emotifications

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var bottomNavigationMenu: BottomNavigationView
    private val dataModel: DataModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bottomNavigationMenu = findViewById(R.id.bottomNavigationView)
        bottomNavigationMenu.setOnItemSelectedListener { item ->
            var fragment: Fragment? = null
            when (item.itemId) {
                R.id.calendar_page_fragment -> {
                    fragment = CalendarFragment()
                }
                R.id.feed_page_fragment -> {
                    fragment = FeedFragment()
                }
                R.id.profile_page_fragment -> {
                    fragment = ProfileFragment()
                }
            }
                replaceFragment(fragment!!, R.id.mainFragmentContainerView)
            true
        }
        bottomNavigationMenu.selectedItemId = R.id.feed_page_fragment
        dataModel.message.observe(this, {

        })
    }

    private fun replaceFragment(fragment: Fragment, fragmentContainerId: Int ) {
        supportFragmentManager
            .beginTransaction()
            .replace(fragmentContainerId, fragment)
            .addToBackStack(fragment.tag)
            .commit()
    }
}