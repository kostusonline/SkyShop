// SkyPro
// Терских Константин, kostus.online.1974@yandex.ru, 2024
// Домашнее задание по теме "ООП. Полиморфизм. Интерфейсы"

package org.skypro.skyshop.search;

import org.jetbrains.annotations.NotNull;

public interface Searchable {
    /**
     * @return Имя объекта Searchable
     */
    @SuppressWarnings("unused")
    @NotNull
    default String getSearchableName() {
        return this.getClass().getSimpleName() + "-" + this.hashCode();
    }

    /**
     * @return Содержимое, по которому производится поиск
     */
    @NotNull
    String getSearchableTerm();

    /**
     * @return Вид содержимого, по которому производится поиск
     */
    @SuppressWarnings("unused")
    @NotNull
    String getSearchableContentKind();
}
