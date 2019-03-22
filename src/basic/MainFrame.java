package basic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.EmptyStackException;

/**
 * Окно приложения.
 */
class MainFrame extends JFrame {
    private JLabel label;
    private JTextField input;
    private JButton button;
    private JTextArea textArea;
    private JPanel inputPanel;
    private JPanel parentPanel;

    MainFrame() {
        super("Calculator");

        label = new JLabel("Math expression:");
        input = new JTextField(30);
        button = new JButton("Calculate");
        textArea = new JTextArea();

        inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 15));
        inputPanel.add(label);
        inputPanel.add(input);
        inputPanel.add(button);

        parentPanel = new JPanel();
        parentPanel.setLayout(new BorderLayout());
        parentPanel.add(inputPanel, BorderLayout.NORTH);
        parentPanel.add(textArea, BorderLayout.CENTER);
        setContentPane(parentPanel);

        textArea.setEditable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        button.addActionListener(this::getResult);
    }

    /**
     * Получает математическое выражение из поля ввода и
     * помещает результат вычисления выражения в текстовое поле.
     *
     * @param event объект ActionEvent
     */
    private void getResult(ActionEvent event) {
        String expression = input.getText();

        if(expression.isEmpty()) {
            JOptionPane.showMessageDialog(parentPanel, "No math expression specified!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        AbstractOperatorsPriorities priorities = new OperatorsPriorities();
        priorities.addOperator("+", 1);
        priorities.addOperator("-", 1);
        priorities.addOperator("*", 2);
        priorities.addOperator("/", 2);

        AbstractStringIterator iterator = new StringIterator(expression);

        Calculator calculator = new Calculator(priorities, iterator);

        try {
            Double result = calculator.getResult();
            textArea.setText(String.format("%.2f", result));
        } catch(NullPointerException | EmptyStackException e) {
            JOptionPane.showMessageDialog(parentPanel, "Incorrect math expression!",
                    "Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}
