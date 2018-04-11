package com.asura.design_patterns

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import com.asura.design_patterns.bulider.step0.Director
import com.asura.design_patterns.bulider.step0.MacBookBuilder
import com.asura.design_patterns.bulider.step1.SurfaceBuilder
import com.asura.design_patterns.principle.SixPrinciplesActivity
import com.asura.design_patterns.singleinstance.step5.SingletonManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var names: ArrayList<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initData()
    }

    private fun initData() {
        names = ArrayList<String>()
        names.add(getString(R.string.principles))
        names.add(getString(R.string.principle_single_instance))
        names.add(getString(R.string.principle_builder))
        names.add("原型模式")
        names.add("工厂方法模式")
        names.add("抽象工厂方法模式")
        names.add("策略模式")
        names.add("状态模式")
        names.add("责任链模式")
        names.add("解释器模式")
        names.add("命令模式")
        names.add("观察者模式")
        names.add("备忘录模式")
        names.add("迭代器模式")
        names.add("模板方法模式")
        names.add("访问者模式")
        names.add("中介者模式")
        names.add("代理模式")
        names.add("组合模式")
        names.add("适配器模式")
        names.add("装饰模式")
        names.add("享元模式")
        names.add("外观模式")
        names.add("桥接模式")
        names.add("MVC")
        names.add("MVP")
        names.add("MVVM")
        recyclerView!!.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView!!.adapter = PatternsAdapter(names, PatternsAdapter.CallBack { view, position ->
            Toast.makeText(this, names.get(position), Toast.LENGTH_SHORT).show()
            viewDetails(position)
        })
    }

    private fun viewDetails(position: Int) {
        when (position) {
            0 -> {
                val intent = Intent()
                intent.putExtra("content", resources.getString(R.string.app_name))
                intent.setClass(this@MainActivity, SixPrinciplesActivity::class.java)
                startActivity(intent)
            }
            1 -> {
                //创建单例
                val ceo0 = com.asura.design_patterns.singleinstance.step0.CEO.getCEO()
                val ceo1 = com.asura.design_patterns.singleinstance.step1.CEO.getCEO()
                val ceo2 = com.asura.design_patterns.singleinstance.step2.CEO.getInstance()
                val ceo3 = com.asura.design_patterns.singleinstance.step3.CEO.getInstance()
                val ceo4 = com.asura.design_patterns.singleinstance.step4.CEO.INSTANCE
                //加入到集合容器中管理
                SingletonManager.registerService("ceo0", ceo0)
                SingletonManager.registerService("ceo1", ceo1)
                SingletonManager.registerService("ceo2", ceo2)
                SingletonManager.registerService("ceo3", ceo3)
                SingletonManager.registerService("ceo4", ceo4)
                //重新获取一次单例
                val ceo02 = com.asura.design_patterns.singleinstance.step0.CEO.getCEO()
                val ceo12 = com.asura.design_patterns.singleinstance.step1.CEO.getCEO()
                val ceo22 = com.asura.design_patterns.singleinstance.step2.CEO.getInstance()
                val ceo32 = com.asura.design_patterns.singleinstance.step3.CEO.getInstance()
                val ceo42 = com.asura.design_patterns.singleinstance.step4.CEO.INSTANCE
                //比较两次实例是否相同
                Log.d("asura", (ceo02 == ceo0).toString());
                Log.d("asura", (ceo12 == ceo1).toString());
                Log.d("asura", (ceo22 == ceo2).toString());
                Log.d("asura", (ceo32 == ceo3).toString());
                Log.d("asura", (ceo42 == ceo4).toString());
                //和容器里的单例做比较
                Log.d("asura", (ceo02 == SingletonManager.getService("ceo0")).toString());
                Log.d("asura", (ceo12 == SingletonManager.getService("ceo1")).toString());
                Log.d("asura", (ceo22 == SingletonManager.getService("ceo2")).toString());
                Log.d("asura", (ceo32 == SingletonManager.getService("ceo3")).toString());
                Log.d("asura", (ceo42 == SingletonManager.getService("ceo4")).toString());
            }
            2 -> {
                val builder = MacBookBuilder()
                val director = Director(builder)
                director.construct("Apple", "Apple Retina Display")
                val computer = builder.build()
                Log.d("asura", computer.toString())

                val builder1 = SurfaceBuilder()
                val computer1 = builder1.buildBoard("ASUS B350")
                        .buildDisplay("SamSung 34\" Display")
                        .build()
                Log.d("asura", computer1.toString())
            }
        }
    }
}
