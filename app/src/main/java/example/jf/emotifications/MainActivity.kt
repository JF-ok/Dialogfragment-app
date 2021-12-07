package example.jf.emotifications

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    lateinit var bottomNavigationMenu: BottomNavigationView
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
                replaceFragment(fragment!!)
            true
        }
        bottomNavigationMenu.selectedItemId = R.id.feed_page_fragment
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.mainFragmentContainerView, fragment)
            .addToBackStack(fragment.tag)
            .commit()
    }
}