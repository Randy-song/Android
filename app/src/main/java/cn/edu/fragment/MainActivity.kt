package cn.edu.fragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.fragment.app.Fragment
import cn.edu.fragment.fragments.GameFragment
import cn.edu.fragment.fragments.HelloFragment

class MainActivity : AppCompatActivity() {
    private lateinit var btnGame: TextView
    private lateinit var btnHello: TextView
    private  var fragmentGame: Fragment = GameFragment.newInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState ==null){
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, fragmentGame)
                .commit()
        }
        initView()
        initEvent()
        replaceFragment(fragmentGame)
    }

    private fun initEvent() {
        btnGame.setOnClickListener {
            replaceFragment(fragmentGame)
        }
        btnHello.setOnClickListener {
            replaceFragment(HelloFragment())
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container,fragment)
        transaction.commit()
    }

    private fun initView() {
        btnGame = findViewById(R.id.btn_Game)
        btnHello = findViewById(R.id.btn_Hello)
    }
}