// SkyPro
// Терских Константин, kostus.online.1974@yandex.ru, 2024
// Домашнее задание по теме "Java Collections Framework: Map"

package org.skypro.skyshop.basket;

import org.jetbrains.annotations.NotNull;
import org.skypro.skyshop.product.Product;

import java.util.*;

/**
 * Корзина товаров.
 *
 * @author Константин Терских, kostus.online.1974@yandex.ru, 2024
 * @version 1.2
 */
public class ProductBasket {
    private final Map<String, List<Product>> basket;

    /**
     * Конструктор.
     */
    public ProductBasket() {
        basket = new HashMap<>();
        clear();
        // Сейчас не нужна упорядоченность товаров в корзине - важны
        // только базовые операции. Поэтому достаточно HashMap.
    }

    /**
     * Очистка корзины.
     */
    public void clear() {
        basket.clear();
    }

    /**
     * Добавление товара в корзину.
     *
     * @param product добавляемый товар
     */
    public void add(@NotNull Product product) {
        // готовим ссылку на ассоциированный список продуктов
        List<Product> products;

        // если в корзине нет такого товара, то создаем список
        if (!basket.containsKey(product.getTitle())) {
            products = new LinkedList<>();
            basket.put(product.getTitle(), products);
        } else {
            // иначе получаем ссылку на список
            products = basket.get(product.getTitle());
        }

        // добавляем товар в список
        products.add(product);
    }

    /**
     * Удаление товара из корзины.
     *
     * @param title наименование удаляемого товара
     */
    @NotNull
    public List<Product> remove(@NotNull String title) {
        List<Product> removed = new LinkedList<>();
        if (basket.isEmpty()) {
            return removed;
        }

        if (basket.containsKey(title)) {
            removed = basket.remove(title);
        }
        return removed;
    }

    /**
     * Получение общей стоимости корзины.
     *
     * @return общая стоимость корзины
     */
    public int getTotalPrice() {
        //List<Product> products = basket.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
        if (basket.isEmpty()) {
            return 0;
        }

        int sum = 0;
        for (String title : basket.keySet()) {
            List<Product> products = basket.get(title);
            for (Product product : products) {
                sum += product.getPrice();
            }
        }
        return sum;
    }

    /**
     * Получение количества специальных товаров в корзине.
     *
     * @return количество специальных товаров в корзине
     */
    public int getSpecialProductCount() {
        if (basket.isEmpty()) {
            return 0;
        }

        int count = 0;
        for (String title : basket.keySet()) {
            List<Product> products = basket.get(title);
            for (Product product : products) {
                if (product.isSpecial()) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * Получение общего количества товаров в корзине.
     *
     * @return общее количество товаров в корзине
     */
    @SuppressWarnings("unused")
    private int getProductCount() {
        if (basket.isEmpty()) {
            return 0;
        }

        int count = 0;
        for (String title : basket.keySet()) {
            List<Product> products = basket.get(title);
            count += products.size();
        }
        return count;
    }

    /**
     * Печать корзины.
     */
    public void print() {
        if (basket.isEmpty()) {
            System.out.println("в корзине пусто");
            return;
        }

        for (String title : basket.keySet()) {
            List<Product> products = basket.get(title);
            for (Product product : products) {
                System.out.println(product);
            }
        }
    }

    /**
     * Проверка наличия товара в корзине.
     *
     * @param title название товара
     * @return true если товар есть в корзине
     */
    public boolean contains(@NotNull String title) {
        return basket.containsKey(title);
    }
}
