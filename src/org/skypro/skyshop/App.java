// SkyPro
// Терских Константин, kostus.online.1974@yandex.ru, 2024
// Домашнее задание по теме "ООП. Полиморфизм. Интерфейсы"

package org.skypro.skyshop;

import org.skypro.skyshop.article.Article;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;
import org.skypro.skyshop.search.engine.SearchEngine;

import java.util.Arrays;

public class App {
    public static void main(String[] args) {
        // создадим продукты
        Product product1 = new SimpleProduct("Молоко", 80);
        Product product2 = new FixPriceProduct("Хлеб");
        Product product3 = new FixPriceProduct("Сыр");
        Product product4 = new DiscountedProduct("Масло", 400, 20);
        Product product5 = new DiscountedProduct("Яйца", 140, 10);
        Product product6 = new SimpleProduct("Мясо", 900);
        Product product7 = new SimpleProduct("Бластер", 200);

        // создадим корзину
        var basket = new ProductBasket();

        // Добавление продукта в корзину.
        System.out.println("Заполнение корзины...");
        basket.add(product1);
        basket.add(product2);
        basket.add(product3);
        basket.add(product4);
        basket.add(product5);
        System.out.println("Заполнена");
        System.out.println();

        // Добавление продукта в заполненную корзину, в которой нет свободного места.
        System.out.println("Переполнение корзины...");
        basket.add(product6);
        System.out.println();

        // Печать содержимого корзины с несколькими товарами.
        basket.print();

        // Получение стоимости корзины с несколькими товарами.
        int price = basket.getTotalPrice();
        System.out.println("Итого: " + price);

        // Получение количества специальных товаров в корзине
        int specialProductCount = basket.getSpecialProductCount();
        System.out.println("Специальных товаров: " + specialProductCount);

        System.out.println();

        // Поиск товара, который есть в корзине.
        boolean exists = basket.contains(product1.getTitle());
        System.out.println("Товар " + product1.getTitle() + " есть в корзине: " + exists);

        // Поиск товара, которого нет в корзине.
        exists = basket.contains(product7.getTitle());
        System.out.println("Товар " + product7.getTitle() + " есть в корзине: " + exists);

        System.out.println();

        // Очистка корзины.
        System.out.println("Очистка корзины...");
        basket.clear();
        System.out.println("Корзина очищена");
        System.out.println();

        // Печать содержимого пустой корзины.
        basket.print();

        // Получение стоимости пустой корзины.
        price = basket.getTotalPrice();
        System.out.println("Стоимость пустой корзины: " + price);

        // Получение количества специальных товаров в корзине
        specialProductCount = basket.getSpecialProductCount();
        System.out.println("Специальных товаров в пустой корзине: " + specialProductCount);

        System.out.println();

        // Поиск товара по имени в пустой корзине.
        exists = basket.contains(product1.getTitle());
        System.out.println("Товар " + product1.getTitle() + " есть в корзине: " + exists);

        System.out.println();

        // Тестирование движка поиска
        Article article1 = new Article("Хлеб и молоко - можно ли выжить?",
                "Выжить на хлебе и молоке невозможно, " +
                        "так как ни один продукт не способен дать человеку всё, " +
                        "что нужно для здорового образа жизни.");

        Article article2 = new Article("Что нужно есть время от времени",
                "При составлении рациона питания стоит учитывать " +
                        "индивидуальные особенности человека, " +
                        "в том числе биологические ритмы. " +
                        "Но мясо есть необходимо.");

        Article article3 = new Article("Lorem Ipsum,",
                "У меня когда-то давно был автомобиль Toyota Ipsum в 10-м кузове. " +
                        "Лучшая машина на планете Земля.");

        System.out.println("Заполнение движка поиска...");
        SearchEngine searchEngine = new SearchEngine(20);
        searchEngine.add(product1);
        searchEngine.add(product2);
        searchEngine.add(product3);
        searchEngine.add(product4);
        searchEngine.add(product5);
        searchEngine.add(product6);
        searchEngine.add(product7);
        searchEngine.add(article1);
        searchEngine.add(article2);
        searchEngine.add(article3);
        System.out.println("Заполнен");

        String query = "Бластер";
        var searchResults = searchEngine.search(query);
        System.out.println("Результаты поиска " + query + ": " + Arrays.toString(searchResults));

        query = "Молоко";
        searchResults = searchEngine.search(query);
        System.out.println("Результаты поиска " + query + ": " + Arrays.toString(searchResults));

        query = "молоко";
        searchResults = searchEngine.search(query);
        System.out.println("Результаты поиска " + query + ": " + Arrays.toString(searchResults));

        query = "мясо";
        searchResults = searchEngine.search(query);
        System.out.println("Результаты поиска " + query + ": " + Arrays.toString(searchResults));

        System.out.println();

        query = "олок";
        searchResults = searchEngine.search(query);
        System.out.println("Результаты поиска " + query + ": " + Arrays.toString(searchResults));

        System.out.println();

        System.out.println("Представление результатов поиска в виде имён:");
        for (var searchResult : searchResults) {
            if (searchResult != null) {
                System.out.println("Имя searchable: " + searchResult.getSearchableName());
            }
        }
    }
}