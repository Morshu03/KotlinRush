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

    //TODO:
    // Добавить на мейн активити FloatingActionButton с иконкой плюсика
    // по нажатию на нее будет добавляться еще одна собака между аляской и каспером
    // собака произвольная
    private lateinit var binding: ActivityMainBinding
    private val adapter = AnimalAdapter()

    private val dogToAdd = Dog(
        height = 179,
        weight = 120,
        name = "Жопыч"
    )



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
            adapter.setList(getMyAnimalsList())
        }
    }

    private fun getMyAnimalsList(): ArrayList<Animal> {
        val animals = ArrayList<Animal>()
        animals.add(Dog(30, 65, "Аляска"))
        animals.add(Dog(25, 60, "Каспер"))
        animals.add(Dog(12, 35, "Бульдог"))
        animals.add(Dog(13, 36, "Значение_знаешь?"))
        animals.add(Dog(14, 37, "Буль_ДОГ"))
        animals.add(Cat(15, 15, "Домашнич", 8))
        animals.add(Cat(10, 12, "Помойнич", 1))
        animals.add(Cat(2, 3, "Новорождёныч", 8))
        animals.add(Cat(15, 1, "Приведеныч", 0))
        animals.add(Cat(12, 14, "Томыч", 3))
        return animals
    }
}
