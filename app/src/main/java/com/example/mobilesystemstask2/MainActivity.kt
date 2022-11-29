package com.example.mobilesystemstask2



import android.hardware.SensorManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.mobilesystemstask2.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var sensorManager: SensorManager
    private val diceMap = mapOf(1 to "one", 2 to "two", 3 to "three", 4 to "four", 5 to "five", 6 to "six")
    private var currentView = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        val button = findViewById<Button>(R.id.button)



//        button.setOnClickListener {
//            rollDice(currentView)
//        }
        binding.bottomNavigationView.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.one_menu -> {
                    replaceFragment(FirstFragment())
                    currentView = 1
                }
                R.id.two_menu -> {
                    replaceFragment(SecondFragment())
                    currentView = 2
                }
            }
            return@setOnItemSelectedListener true
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }

}
