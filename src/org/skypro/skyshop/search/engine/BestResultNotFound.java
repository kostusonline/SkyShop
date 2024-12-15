// SkyPro
// Терских Константин, kostus.online.1974@yandex.ru, 2024
// Домашнее задание по теме "Исключения в Java"

package org.skypro.skyshop.search.engine;

/**
 * Исключение, которое выбрасывается в случае, если лучший результат не найден.
 *
 * @author Константин Терских, kostus.online.1974@yandex.ru, 2024
 * @version 1.1
 */
public class BestResultNotFound extends Exception {
    /**
     * Конструктор класса.
     *
     * @param message сообщение об ошибке
     */
    public BestResultNotFound(String message) {
        super(message);
    }
}
