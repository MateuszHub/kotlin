package uj.service

import uj.models.Category
import uj.models.Item

class Categories {
    var list: List<Category> = listOf(
        Category(1, "Toys",
            listOf(Item(1, "Toy car 1", 10),
                Item(2, "Toy car 2", 20),
                Item(3, "Spinner", 30),
                Item(4, "Rubic cube", 120))),
        Category(2, "Fruits",
            listOf(Item(5, "Apple", 10),
                Item(6, "Orange", 20),
                Item(7, "Banana", 30))),
        Category(3, "Smartphones",
            listOf(Item(8, "Iphone", 5000),
                Item(9, "Samsung s22", 4000),
                Item(10, "Xiaomi 12x", 3000)))
    );
}