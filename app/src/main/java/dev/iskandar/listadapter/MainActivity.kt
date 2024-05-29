package dev.iskandar.listadapter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.iskandar.listadapter.adapters.MyListAdapter
import dev.iskandar.listadapter.databinding.ActivityMainBinding
import dev.iskandar.listadapter.models.User

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var list: ArrayList<User>
    private lateinit var myListAdapter: MyListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        myListAdapter = MyListAdapter()
        binding.rv.adapter = myListAdapter

        loadData()
    }

    private fun loadData() {
        list = ArrayList()
        for (i in 0 until 100) {
            list.add(User("Iskandar $i", "+99800$i"))
        }
        myListAdapter.submitList(list)
    }
}