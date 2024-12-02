// SkyPro
// Терских Константин, kostus.online.1974@yandex.ru, 2024
// Домашнее задание по теме "Введение в ООП. Инкапсуляция"

package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.Product;

public class App {
    public static void main(String[] args) {
        // создадим продукты
        Product product1 = new Product("Молоко", 80);
        Product product2 = new Product("Хлеб", 120);
        Product product3 = new Product("Сыр", 420);
        Product product4 = new Product("Масло", 400);
        Product product5 = new Product("Яйца", 140);
        Product product6 = new Product("Мясо", 900);
        Product product7 = new Product("Бластер", 200);

        // создадим корзину
        var basket = new ProductBasket();

        // Добавление продукта в корзину.
        basket.add(product1);
        basket.add(product2);
        basket.add(product3);
        basket.add(product4);
        basket.add(product5);

        // Добавление продукта в заполненную корзину, в которой нет свободного места.
        basket.add(product6);

        // Печать содержимого корзины с несколькими товарами.
        basket.print();

        // Получение стоимости корзины с несколькими товарами.
        int price = basket.getTotalPrice();
        System.out.println("Стоимость корзины с несколькими товарами: " + price);

        // Поиск товара, который есть в корзине.
        boolean exists = basket.contains(product1.getTitle());
        System.out.println("Товар " + product1.getTitle() + " есть в корзине: " + exists);

        // Поиск товара, которого нет в корзине.
        exists = basket.contains(product7.getTitle());
        System.out.println("Товар " + product7.getTitle() + " есть в корзине: " + exists);

        // Очистка корзины.
        basket.clear();

        // Печать содержимого пустой корзины.
        basket.print();

        // Получение стоимости пустой корзины.
        price = basket.getTotalPrice();
        System.out.println("Стоимость пустой корзины: " + price);

        // Поиск товара по имени в пустой корзине.
        exists = basket.contains(product1.getTitle());
        System.out.println("Товар " + product1.getTitle() + " есть в корзине: " + exists);
    }
}