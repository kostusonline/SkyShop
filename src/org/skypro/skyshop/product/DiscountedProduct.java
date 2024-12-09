// SkyPro
// Терских Константин, kostus.online.1974@yandex.ru, 2024
// Домашнее задание по теме "ООП. Наследование. Абстрактные классы"

package org.skypro.skyshop.product;

import org.jetbrains.annotations.NotNull;

/**
 * Продукт со скидкой.
 *
 * @author Константин Терских, kostus.online.1974@yandex.ru, 2024
 * @version 1.1
 */
public final class DiscountedProduct extends Product {
    private final int basePrice;
    private final int discount;

    /**
     * Конструктор.
     *
     * @param title название продукта.
     * @param basePrice базовая цена продукта.
     * @param discount скидка, 0..100%
     */
    public DiscountedProduct(@NotNull String title, int basePrice, int discount) {
        super(title);
        this.basePrice = basePrice;
        assert discount >= 0 && discount <= 100;
        this.discount = discount;
    }

    /**
     * Получить цену продукта.
     *
     * @return цена продукта.
     */
    @Override
    public int getPrice() {
        return basePrice - (int)((double)(basePrice * discount) / 100.0);
    }

    @Override
    public String toString() {
        return getTitle() + ": " + getPrice() + " (скидка "+ discount + "%)";
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
