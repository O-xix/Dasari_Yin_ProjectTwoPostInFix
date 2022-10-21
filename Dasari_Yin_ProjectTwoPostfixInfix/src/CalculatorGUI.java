package Dasari_Yin_ProjectTwoPostfixInfix.src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static Dasari_Yin_ProjectTwoPostfixInfix.src.Main.infixToPostfix;


public class CalculatorGUI extends JFrame implements ActionListener {
    static JFrame frame;
    static JTextField textfield;
    String infixString = "";

    public static void init(CalculatorGUI calculatorGUI) {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textfield = new JTextField(16);
        //buttons
        Button one, two, three, four, five, six, seven , eight, nine, zero, add, subtract, multiply, divide, startpara, endpara, clear, equals;

        //set up buttons
        one = new Button("1");
        two = new Button("2");
        three = new Button("3");
        four = new Button("4");
        five = new Button("5");
        six = new Button("6");
        seven = new Button("7");
        eight = new Button("8");
        nine = new Button("9");
        zero = new Button("0");

        add = new Button("+");
        subtract = new Button("-");
        multiply = new Button("*");
        divide = new Button("/");

        startpara = new Button("(");
        endpara = new Button(")");

        clear = new Button("C");
        equals = new Button("=");

        //panel
        JPanel panel = new JPanel();

        //actionListener
        one.addActionListener(calculatorGUI);
        two.addActionListener(calculatorGUI);
        three.addActionListener(calculatorGUI);
        four.addActionListener(calculatorGUI);
        five.addActionListener(calculatorGUI);
        six.addActionListener(calculatorGUI);
        seven.addActionListener(calculatorGUI);
        eight.addActionListener(calculatorGUI);
        nine.addActionListener(calculatorGUI);
        zero.addActionListener(calculatorGUI);

        add.addActionListener(calculatorGUI);
        subtract.addActionListener(calculatorGUI);
        multiply.addActionListener(calculatorGUI);
        divide.addActionListener(calculatorGUI);

        startpara.addActionListener(calculatorGUI);
        endpara.addActionListener(calculatorGUI);

        clear.addActionListener(calculatorGUI);
        equals.addActionListener(calculatorGUI);

        //add buttons
        panel.add(textfield);
        panel.add(one);
        panel.add(two);
        panel.add(three);
        panel.add(four);
        panel.add(five);
        panel.add(six);
        panel.add(seven);
        panel.add(eight);
        panel.add(nine);
        panel.add(zero);

        panel.add(add);
        panel.add(subtract);
        panel.add(multiply);
        panel.add(divide);

        panel.add(startpara);
        panel.add(endpara);

        panel.add(clear);
        panel.add(equals);

        //finishing up
        frame.add(panel);
        frame.setSize(200, 220);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String buttoninput = e.getActionCommand();

        if(buttoninput.charAt(0) == 'C') {
            infixString = "";
            textfield.setText(infixString);
        }
        else if (buttoninput.charAt(0) == '=') {
            String postfixString = infixToPostfix(infixString);
            JOptionPane.showMessageDialog(null, ("Postfix Result: " + postfixString));
        }
        else {
            infixString = infixString + (buttoninput.charAt(0) + " ");
            textfield.setText(infixString);
        }
    }
}
