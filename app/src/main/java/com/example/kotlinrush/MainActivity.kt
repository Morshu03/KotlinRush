package com.example.kotlinrush


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinrush.adapter.AnimalAdapter
import com.example.kotlinrush.databinding.ActivityMainBinding
import com.example.kotlinrush.model.Animal
import com.example.kotlinrush.model.Cat
import com.example.kotlinrush.model.Dog

class MainActivity : AppCompatActivity() {

    //TODO:
    // В inputContainer делаем 3 editText
    // в функции addItem берем значения из этих инпутов, если они все не пустые создаем Дог и добавляем в список
    // если хоть одно из полей пустое тост
    private lateinit var binding: ActivityMainBinding
    private val adapter = AnimalAdapter()
    private val animalList: MutableList<Animal> = getMyAnimalsList()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        binding.apply {
            recView.layoutManager = LinearLayoutManager(this@MainActivity)
            recView.adapter = adapter
            adapter.setList(animalList)
            fab.setOnClickListener {
                if (binding.nameEdtTxt.text.isNotEmpty()
                    && binding.heightEdtTxt.text.isNotEmpty()
                    && binding.weightEdtTxt.text.isNotEmpty()
                ) {
                    addItem()
                } else {
                    Toast.makeText(this@MainActivity, "please", Toast.LENGTH_SHORT).show()
                }
            }
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

    private fun addItem() {
        val name = binding.nameEdtTxt.text.toString()
        val height = binding.heightEdtTxt.text.toString().toInt()
        val weight = binding.weightEdtTxt.text.toString().toInt()
        val dogToAdd = Dog(
            name = name,
            weight = weight,
            height = height
        )
        animalList.add(1, dogToAdd)
        adapter.notifyItemInserted(1)
    }
}
