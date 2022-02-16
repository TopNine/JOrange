package com.life.jorange.main.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.life.jorange.R
import com.life.jorange.base.OnItemClickListener
import com.life.jorange.base.adapter.BaseListAdapter
import com.life.jorange.base.entity.ListInfo
import com.life.jorange.databinding.ActivityBaseListBinding

open class BaseListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityBaseListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBaseListBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbar)
        binding.baseRecycleView.apply {
            val baseAdapter = BaseListAdapter(getItems())
            baseAdapter.mClickListener = object : OnItemClickListener<ListInfo> {
                override fun onItemClick(t: ListInfo) {
                    handleItemClick(t)
                }
            }
            layoutManager = LinearLayoutManager(this@BaseListActivity)
            adapter = baseAdapter
        }
    }

    open fun handleItemClick(listInfo: ListInfo) {

    }

    open fun getItems(): MutableList<ListInfo> {
        return mutableListOf()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }


}