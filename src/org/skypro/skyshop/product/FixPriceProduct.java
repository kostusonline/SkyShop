// SkyPro
// Терских Константин, kostus.online.1974@yandex.ru, 2024
// Домашнее задание по теме "ООП. Наследование. Абстрактные классы"

package org.skypro.skyshop.product;

import org.jetbrains.annotations.NotNull;

/**
 * Продукт по фиксированной цене.
 *
 * @author Константин Терских, kostus.online.1974@yandex.ru, 2024
 * @version 1.1
 */
public final class FixPriceProduct extends Product {
    private final static int FIXED_PRICE = 100;

    /**
     * Конструктор.
     *
     * @param title название продукта.
     */
    public FixPriceProduct(@NotNull String title) {
        super(title);
    }

    /**
     * Получить цену продукта.
     *
     * @return цена продукта.
     */
    @Override
    public int getPrice() {
        return FIXED_PRICE;
    }

    @Override
    public String toString() {
        return getTitle() + ": Фиксированная цена " + FIXED_PRICE;
    }

    @Override
    public boolean isSpecial() {
        return true;
    }
}
