package basic;

/**
 * Итератор для строки, содержащей математическое выражение.
 */
class StringIterator implements AbstractStringIterator {
    /**
     * Строка, содержащая математическое выражение.
     */
    private String string;

    /**
     * Индекс текущего символа строки, содержащей математическое выражение
     */
    private int currentIndex;

    /**
     * @param string Строка, содержащая математическое выражение
     */
    StringIterator(String string) {
        this.string = string.replace(" ", "");
        currentIndex = 0;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean hasNext() {
        return  string != null &&
                !string.isEmpty() &&
                currentIndex < string.length();
    }

    /**
     * {@inheritDoc}
     *
     * @return число или оператор
     */
    @Override
    public String next() {
        StringBuilder operand = new StringBuilder();
        char element = string.charAt(currentIndex);

        while(Character.isDigit(element) || element == '.' || (currentIndex == 0 && element == '-') ||
                (currentIndex > 0 && string.charAt(currentIndex - 1) == '(' && element == '-')) {
            operand.append(element);
            currentIndex++;

            if(currentIndex == string.length())
                return operand.toString();

            element = string.charAt(currentIndex);
        }

        if(operand.length() != 0)
            return operand.toString();

        currentIndex++;
        return Character.toString(element);
    }
}
