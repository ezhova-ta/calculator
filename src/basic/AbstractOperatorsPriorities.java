package basic;

/**
 * Абстрактное представление о классе, хранящем приоритеты операций.
 */
public interface AbstractOperatorsPriorities {
    /**
     * Возвращает приоритет операции.
     *
     * @param operator оператор
     * @return приоритет операции, ассоциированной с переданным оператором
     */
    Integer getPriority(String operator);

    /**
     * Добавляет оператор.
     *
     * @param operator оператор
     * @param priority приоритет операции, ассоциированной с переданным оператором
     */
    void addOperator(String operator, int priority);

    /**
     * Удаляет оператор.
     *
     * @param operator оператор
     */
    void deleteOperator(String operator);
}
