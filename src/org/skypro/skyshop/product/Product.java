// SkyPro
// Терских Константин, kostus.online.1974@yandex.ru, 2024
// Домашнее задание по теме "ООП. Наследование. Абстрактные классы"

package org.skypro.skyshop.product;

import org.jetbrains.annotations.NotNull;
import org.skypro.skyshop.search.Searchable;

/**
 * Продукт.
 *
 * @author Константин Терских, kostus.online.1974@yandex.ru, 2024
 * @version 1.1
 */
public abstract class Product implements Searchable {
    @NotNull
    private final String title;

    /**
     * Конструктор.
     *
     * @param title название продукта.
     */
    public Product(@NotNull String title) {
        this.title = title;
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
    public abstract int getPrice();

    @Override
    public String toString() {
        return title;
    }

    /**
     * Проверить, является ли продукт специальным.
     *
     * @return true, если продукт специальный.
     */
    public boolean isSpecial() {
        return false;
    }

    @NotNull
    public String getSearchableName() {
        return this.getClass().getSimpleName() + "-" + SEARCHABLE_CONTENT_KIND + "-" + this.hashCode();
    }

    @Override
    public @NotNull String getSearchableTerm() {
        return toString();
    }

    public static final String SEARCHABLE_CONTENT_KIND = "PRODUCT";

    @Override
    public @NotNull String getSearchableContentKind() {
        return SEARCHABLE_CONTENT_KIND;
    }
}
