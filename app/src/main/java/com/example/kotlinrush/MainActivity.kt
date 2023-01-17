package com.example.kotlinrush

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlinrush.adapter.AnimalAdapter
import com.example.kotlinrush.databinding.ActivityMainBinding
import com.example.kotlinrush.model.Animal
import com.example.kotlinrush.model.Cat
import com.example.kotlinrush.model.Dog

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val adapter = AnimalAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        binding.apply {
            recView.layoutManager = LinearLayoutManager(this@MainActivity)
            recView.adapter = adapter
            adapter.setList(myAnimal())
        }
    }

    fun myAnimal(): ArrayList<Animal> {
        val animals = ArrayList<Animal>()

        val first_sobaka = Dog(30, 65, "Аляска")
        animals.add(first_sobaka)

        val second_sobaka = Dog(25, 60, "Каспер")
        animals.add(second_sobaka)

        val third_sobaka = Dog(12, 35, "Бульдог")
        animals.add(third_sobaka)

        val fourth_sobaka = Dog(13, 36, "Значение_знаешь?")
        animals.add(fourth_sobaka)

        val fifth_sobaka = Dog(14, 37, "Буль_ДОГ")
        animals.add(fifth_sobaka)

        val pervaya_koshka = Cat(15, 15, "Домашнич", 8)
        animals.add(pervaya_koshka)

        val vtoraya_koshka = Cat(10, 12, "Помойнич", 1)
        animals.add(vtoraya_koshka)

        val tretiya_koshka = Cat(2, 3, "Новорождёныч", 8)
        animals.add(tretiya_koshka)

        val chetvertaya_koska = Cat(15, 1, "Приведеныч", 0)
        animals.add(chetvertaya_koska)

        val pyataya_koshka = Cat(12, 14, "Томыч", 3)
        animals.add(pyataya_koshka)

        return animals
    }
}
