package ddd;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Scalculator extends JFrame implements ActionListener {
    JTextField t1, t2, t3;
    double num1, num2, result;
    char operator;
    boolean enteringSecond = false; // flag to know where to put digits

    public Scalculator() {
        setTitle("Calculator");
        setSize(350, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 5, 5,5));
        inputPanel.add(new JLabel("Num1:"));
        t1 = new JTextField();
        inputPanel.add(t1);


        inputPanel.add(new JLabel("Num2:"));
        t2 = new JTextField();
        inputPanel.add(t2);

        inputPanel.add(new JLabel("Result:"));
        t3 = new JTextField();
        inputPanel.add(t3);
        t3.setEditable(false);

        add(inputPanel, BorderLayout.NORTH);

        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", "C", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.addActionListener(this);
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String input = e.getActionCommand();

        if (input.matches("[0-9]")) { // digit
            if (!enteringSecond) {
                t1.setText(t1.getText() + input);
            } else {
                t2.setText(t2.getText() + input);
            }
        } else if (input.equals("C")) {
            t1.setText("");
            t2.setText("");
            t3.setText("");
        } else if (input.equals("=")) {
            try {
                num1 = Double.parseDouble(t1.getText());
                num2 = Double.parseDouble(t2.getText());
                switch (operator) {
                    case '+': result = num1 + num2; break;
                    case '-': result = num1 - num2; break;
                    case '*': result = num1 * num2; break;
                    case '/': result = (num2 != 0) ? num1 / num2 : Double.NaN; break;
                    default: result = 0;
                }
                t3.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                t3.setText("Error");
            }
        } else { // operator
            if (!t1.getText().isEmpty()) {
                operator = input.charAt(0);
                enteringSecond = true;
            }
        }
    }

    public static void main(String[] args) {
        new Scalculator();
    }
}