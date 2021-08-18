package com.github.peep

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.peep.view.HorizontalItemDecorator
import com.github.peep.view.CollectionAdapter
import com.github.peep.view.CollectionData

import com.github.peep.view.VerticalItemDecorator
import kotlinx.android.synthetic.main.activity_collection.*

class CollectionActicity : AppCompatActivity() {
    lateinit var collectionAdapter: CollectionAdapter
    val datas = mutableListOf<CollectionData>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_collection)

        initRecycler()
    }

    private fun initRecycler() {
        collectionAdapter = CollectionAdapter(this)
        rv_profile.adapter = collectionAdapter

        //firebase 에 연동되어 있지 않기 때문에 임의의 더미 데이터 삽입
        datas.apply {
            add(CollectionData(img = R.drawable.peep_illust, name = "일러삡", count = 0))

            collectionAdapter.datas = datas

            rv_profile.addItemDecoration(VerticalItemDecorator(20))
            rv_profile.addItemDecoration(HorizontalItemDecorator(10))
            collectionAdapter.notifyDataSetChanged()
        }
    }
}