package basic;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс, хранящий приоритеты операций.
 */
class OperatorsPriorities implements AbstractOperatorsPriorities {
    /**
     * Отображение, хранящее приоритеты операций.
     */
    private Map<String, Integer> map;

    /**
     * @param map отображение, хранящее приоритеты операций
     */
    OperatorsPriorities(HashMap<String, Integer> map) {
        this.map = map;
    }

    OperatorsPriorities() {
        map = new HashMap<>();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Integer getPriority(String operator) {
        return map.get(operator);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addOperator(String operator, int priority) {
        map.put(operator, priority);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteOperator(String operator) {
        map.remove(operator);
    }
}
