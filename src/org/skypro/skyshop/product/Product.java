// SkyPro
// Терских Константин, kostus.online.1974@yandex.ru, 2024
// Домашнее задание по теме "Введение в ООП. Инкапсуляция"

package org.skypro.skyshop.product;

import org.jetbrains.annotations.NotNull;

/**
 * Продукт.
 *
 * @author Константин Терских, kostus.online.1974@yandex.ru, 2024
 * @version 1.1
 */
public class Product {
    /**
     * Название продукта.
     */
    @NotNull
    private final String title;

    /**
     * Цена продукта.
     */
    private final int price;

    /**
     * Конструктор.
     *
     * @param title название продукта.
     * @param price цена продукта.
     */
    public Product(@NotNull String title, int price) {
        this.title = title;
        this.price = price;
    }

    /**
     * Получить название продукта.
     *
     * @return название продукта.
     */
    @NotNull
    public String getTitle() {
        return title;
    }

    /**
     * Получить цену продукта.
     *
     * @return цена продукта.
     */
    public int getPrice() {
        return price;
    }
}
