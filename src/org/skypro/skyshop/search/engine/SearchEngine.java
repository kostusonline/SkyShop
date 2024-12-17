// SkyPro
// Терских Константин, kostus.online.1974@yandex.ru, 2024
// Домашнее задание по теме "Java Collections Framework: Map"

package org.skypro.skyshop.search.engine;

import org.jetbrains.annotations.NotNull;
import org.skypro.skyshop.search.Searchable;
import org.skypro.skyshop.tools.StringTools;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Движок поиска.<br>
 * Не содержит привязок к продукту или к магазину. Привязка только к интерфейсу поиска.
 * Поэтому класс находится в пакете поиска, в основной иерархии магазина.
 *
 * @author Константин Терских, kostus.online.1974@yandex.ru, 2024
 * @version 1.1
 */
public final class SearchEngine {
    private final List<Searchable> searchableItems;

    /**
     * Конструктор.
     */
    public SearchEngine() {
        this.searchableItems = new LinkedList<>();
        clear();
    }

    /**
     * Очистка массива.
     */
    public void clear() {
        searchableItems.clear();
    }

    /**
     * Добавление элемента в массив.
     *
     * @param searchable элемент для добавления.
     */
    public void add(@NotNull Searchable searchable) {
        searchableItems.add(searchable);
    }

    /**
     * Количество результатов поиска.
     */
    public static final int MAX_RESULTS = 10_000;

    /**
     * Поиск.<br>
     * Ограничение по количеству результатов оставлено для безопасности,<br>
     * но предел увеличен до очень большого значения.
     *
     * @param query запрос.
     */
    @NotNull
    public Map<String, Searchable> search(@NotNull String query) {
        Map<String, Searchable> results = new TreeMap<>();

        int i = 0;
        for (Searchable searchable : searchableItems) {
            if (searchable == null) {
                continue;
            }
            if (searchable.getSearchableTerm().contains(query)) {
                results.put(searchable.getSearchableName(), searchable);
                if (i++ >= MAX_RESULTS) {
                    break;
                }
            }
        }
        return results;
    }

    /**
     * Поиск наиболее частого результата.
     *
     * @param query запрос.
     * @throws BestResultNotFound если не найдено совпадений.
     */
    @NotNull
    public Searchable searchMostFrequent(String query) throws BestResultNotFound {
        if (searchableItems.isEmpty()) {
            throw new BestResultNotFound("Массив элементов для поиска пуст");
        }

        Searchable mostFrequent = searchableItems.getFirst();
        int maxCount = StringTools.countMatches(mostFrequent.getSearchableTerm(), query);

        for (Searchable searchable : searchableItems) {
            int count = StringTools.countMatches(searchable.getSearchableTerm(), query);
            if (count > maxCount) {
                maxCount = count;
                mostFrequent = searchable;
            }
        }

        if (maxCount <= 0) {
            throw new BestResultNotFound("Не найдено совпадений");
        }

        return mostFrequent;
    }
}
