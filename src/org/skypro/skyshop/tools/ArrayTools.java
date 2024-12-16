// SkyPro
// Терских Константин, kostus.online.1974@yandex.ru, 2024
// Домашнее задание по теме "ООП. Полиморфизм. Интерфейсы"

package org.skypro.skyshop.tools;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.List;

/**
 * Инструменты для работы с массивами.
 *
 * @author Константин Терских, kostus.online.1974@yandex.ru, 2024
 * @version 1.1
 */
public final class ArrayTools {
    /**
     * Универсальный признак "не найдено".
     */
    public static final int NOT_FOUND = -1;

    /**
     * Получение первой от нуля свободной или занятой ячейки в хранилище.
     *
     * @return индекс свободной ячейки или {@link #NOT_FOUND}
     */
    @SuppressWarnings("unused")
    @Contract(pure = true)
    public static <T> int getFirsIndex(T[] array, boolean free) {
        for (int i = 0; i < array.length; i++) {
            if (free && array[i] == null) {
                return i;
            }
            else if (!free && array[i] != null) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    public static <T> @NotNull String toString(List<T> list) {
        if (list == null) {
            return "";
        }
        String[] semiResults = new String[list.size()];
        for (int i = 0; i < semiResults.length; i++) {
            semiResults[i] = list.get(i).toString();
        }
        return String.join(", ", semiResults);
    }
}
