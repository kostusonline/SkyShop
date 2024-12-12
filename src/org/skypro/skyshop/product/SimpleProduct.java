// SkyPro
// Терских Константин, kostus.online.1974@yandex.ru, 2024
// Домашнее задание по теме "ООП. Наследование. Абстрактные классы"

package org.skypro.skyshop.product;

import org.jetbrains.annotations.NotNull;

/**
 * Обычный продукт.
 *
 * @author Константин Терских, kostus.online.1974@yandex.ru, 2024
 * @version 1.1
 */
public final class SimpleProduct extends Product {
    private final int price;

    /**
     * Конструктор.
     *
     * @param title название продукта.
     * @param price цена продукта.
     */
    public SimpleProduct(@NotNull String title, int price) {
        super(title);
        this.price = price;
    }

    /**
     * Получить цену продукта.
     *
     * @return цена продукта.
     */
    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return getTitle() + ": " + getPrice();
    }
}
