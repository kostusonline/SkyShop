// SkyPro
// Терских Константин, kostus.online.1974@yandex.ru, 2024
// Домашнее задание по теме "Исключения в Java"

package org.skypro.skyshop.tools;

import org.jetbrains.annotations.NotNull;

/**
 * Инструменты для работы со строками.
 *
 * @author Константин Терских, kostus.online.1974@yandex.ru, 2024
 * @version 1.1
 */
public final class StringTools {
    /**
     * @return Количество вхождений подстроки query в строке searchTerm.
     */
    public static int countMatches(@NotNull String searchTerm, @NotNull String query) {
        if (searchTerm.isEmpty() || query.isEmpty()) {
            return 0;
        }

        int count = 0, fromIndex = 0;
        int queryLength = query.length();
        while ((fromIndex = searchTerm.indexOf(query, fromIndex)) != -1) {
            count++;
            fromIndex += queryLength;
        }

        return count;
    }
}
