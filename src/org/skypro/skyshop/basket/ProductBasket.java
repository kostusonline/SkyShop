// SkyPro
// Терских Константин, kostus.online.1974@yandex.ru, 2024
// Домашнее задание по теме "Java Collections Framework: List"

package org.skypro.skyshop.basket;

import org.jetbrains.annotations.NotNull;
import org.skypro.skyshop.product.Product;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * Корзина товаров.
 *
 * @author Константин Терских, kostus.online.1974@yandex.ru, 2024
 * @version 1.1
 */
public class ProductBasket {
    /**
     * Реализация хранилища товаров.
     */
    private final List<Product> products;

    /**
     * Конструктор.
     */
    public ProductBasket() {
        products = new LinkedList<>();
        clear();
        // LinkedList выбран потому, что сейчас не нужна функциональность
        // массива в части доступа по индексу. Больше нужна функциональность
        // по произвольному добавлению и удалению элементов.
    }

    /**
     * Очистка корзины.
     */
    public void clear() {
        products.clear();
    }

    /**
     * Добавление товара в корзину.
     *
     * @param product добавляемый товар
     */
    public void add(@NotNull Product product) {
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

        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            var element = iterator.next();
            if (element.getTitle().equals(title)) {
                iterator.remove();
                removed.add(element);
            }
        }

        return removed;
    }

    /**
     * Получение общей стоимости корзины.
     *
     * @return общая стоимость корзины
     */
    public int getTotalPrice() {
        int sum = 0;
        for (Product product : products) {
            if (product != null) {
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
        int count = 0;
        for (Product product : products) {
            if (product != null) {
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
    private int getProductCount() {
        return products.size();
    }

    /**
     * Печать корзины.
     */
    public void print() {
        if (getProductCount() <= 0) {
            System.out.println("в корзине пусто");
            return;
        }

        for (Product product : products) {
            if (product != null) {
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
        for (Product product : products) {
            if (product != null) {
                if (Objects.equals(product.getTitle(), title)) {
                    return true;
                }
            }
        }
        return false;
    }
}
