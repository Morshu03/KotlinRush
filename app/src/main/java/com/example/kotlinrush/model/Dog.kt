package com.example.kotlinrush.model

class Dog(height: Int, weight: Int, name: String?) : Animal(height, weight, name!!) {
    override fun toString(): String {
        return "Dog{" +
                "height=" + super.getHeight() +
                ", weight=" + super.getWeight() +
                ", name=" + super.getName() +
                '}'
    }
}