// SkyPro
// Терских Константин, kostus.online.1974@yandex.ru, 2024
// Домашнее задание по теме "ООП. Полиморфизм. Интерфейсы"

package org.skypro.skyshop.search.engine;

import org.jetbrains.annotations.NotNull;
import org.skypro.skyshop.arrays.ArrayTools;
import org.skypro.skyshop.search.Searchable;

import java.util.Arrays;

/**
 * Движок поиска.<br>
 * Не содержит привязок к продукту или к магазину. Привязка только к интерфейсу поиска.
 * Поэтому класс находится в пакете поиска, в основной иерархии магазина.
 *
 * @author Константин Терских, kostus.online.1974@yandex.ru, 2024
 * @version 1.1
 */
public final class SearchEngine {
    private final Searchable[] searchableItems;

    /**
     * Конструктор.
     *
     * @param size размер массива.
     */
    public SearchEngine(int size) {
        this.searchableItems = new Searchable[size];
        clear();
    }

    /**
     * Очистка массива.
     */
    public void clear() {
        Arrays.fill(searchableItems, null);
    }

    /**
     * Добавление элемента в массив.
     *
     * @param searchable элемент для добавления.
     */
    public void add(@NotNull Searchable searchable) {
        int freeIndex = ArrayTools.getFirsIndex(searchableItems, true);
        if (freeIndex == ArrayTools.NOT_FOUND) {
            System.out.println("Невозможно добавить элемент для поиска");
            return;
        }
        searchableItems[freeIndex] = searchable;
    }

    /**
     * Количество результатов поиска.
     */
    public static final int MAX_RESULTS = 5;

    /**
     * Поиск.
     *
     * @param query запрос.
     */
    @NotNull
    public Searchable[] search(String query) {
        Searchable[] results = new Searchable[MAX_RESULTS];
        Arrays.fill(results, null);

        int i = 0;
        for (Searchable searchable : searchableItems) {
            if (searchable == null) {
                continue;
            }
            if (searchable.getSearchableTerm().contains(query)) {
                results[i++] = searchable;
                if (i >= MAX_RESULTS) {
                    break;
                }
            }
        }
        return results;
    }
}
