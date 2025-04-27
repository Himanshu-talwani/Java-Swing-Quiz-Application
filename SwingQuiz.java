import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class SwingQuiz extends JFrame implements ActionListener {
    String[] questions = {
        "Which keyword is used to define a class in Java?",
        "Which symbol is used to end a statement in Java?",
        "Which can store multiple values of the same type in Java?", // Changed
        "Which keyword is used to create an object in Java?",
        "Java is a _____ typed language.",
        "Which data type is used to store textual data in a variable",
        "Which Java structure repeats code until a condition becomes false?", // Changed
        "How do you write a single-line comment in Java?",
        "Which function is used to print in Java?",
        "Java programs are first compiled into _____."
    };
    
    String[][] options = {
        {"class", "method", "object", "package"},
        {"colon (:)", "comma (,)", "semicolon (;)", "dot (.)"},
        {"ArrayList", "Object", "Array", "HashMap"}, // Changed
        {"class", "new", "this", "that"},
        {"Dynamically","Statically","Weakly","Strongly"},
        {"char", "String", "int", "float"},
        {"if-else", "for loop", "switch", "try-catch"}, // Changed
        {"// comment", "/* comment */", "# comment", "<!-- comment -->"},
        {"System.out.println()", "cout<<", "printf()", "Console.WriteLine()"},
        {"bytecode", "source code", "assembly code", "binary code"}
    };
    
    char[] answers = {'a', 'c', 'c', 'b', 'b', 'b', 'b', 'a', 'a', 'a'};  
    int index = 0;
    int score = 0;

    JLabel questionLabel;
    JRadioButton optionA, optionB, optionC, optionD;
    ButtonGroup optionsGroup;
    JButton nextButton, skipButton;
    JPanel panel;

    public SwingQuiz() {
        setTitle("✨ Java Quiz Application ✨");
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the window
        setLayout(null);
        getContentPane().setBackground(new Color(180, 215, 255));// More saturated, but still soft

        questionLabel = new JLabel();
        questionLabel.setFont(new Font("Lora", Font.BOLD, 16));
        questionLabel.setBounds(30, 30, 520, 40);
        add(questionLabel);

        optionA = new JRadioButton();
        optionB = new JRadioButton();
        optionC = new JRadioButton();
        optionD = new JRadioButton();

        // Style options
        Font optionFont = new Font("Arial", Font.BOLD + Font.ITALIC, 18);
        Color optionColor = new Color(60, 60, 60);

        optionA.setFont(optionFont);
        optionB.setFont(optionFont);
        optionC.setFont(optionFont);
        optionD.setFont(optionFont);

        optionA.setForeground(optionColor);
        optionB.setForeground(optionColor);
        optionC.setForeground(optionColor);
        optionD.setForeground(optionColor);

        optionA.setBounds(50, 90, 500, 30);
        optionB.setBounds(50, 130, 500, 30);
        optionC.setBounds(50, 170, 500, 30);
        optionD.setBounds(50, 210, 500, 30);

        optionsGroup = new ButtonGroup();
        optionsGroup.add(optionA);
        optionsGroup.add(optionB);
        optionsGroup.add(optionC);
        optionsGroup.add(optionD);

        add(optionA);
        add(optionB);
        add(optionC);
        add(optionD);

        nextButton = new JButton("Next ➡️");
        nextButton.setBounds(150, 270, 120, 40);
        nextButton.setBackground(new Color(100, 200, 150));
        nextButton.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
        nextButton.addActionListener(this);
        add(nextButton);

        skipButton = new JButton("Skip ⏩ ");
        skipButton.setBounds(300, 270, 120, 40);
        skipButton.setBackground(new Color(250, 150, 100));
        skipButton.setFont(new Font("Segoe UI Emoji", Font.BOLD, 16));
        skipButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                index++;
                optionsGroup.clearSelection();
                loadQuestion();
            }
        });
        add(skipButton);

        loadQuestion();

        setVisible(true);
    }

    void loadQuestion() {
        if (index < questions.length) {
            questionLabel.setText((index + 1) + ". " + questions[index]);
            optionA.setText("A) " + options[index][0]);
            optionB.setText("B) " + options[index][1]);
            optionC.setText("C) " + options[index][2]);
            optionD.setText("D) " + options[index][3]);
        } else {
            showResult();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (!optionA.isSelected() && !optionB.isSelected() && !optionC.isSelected() && !optionD.isSelected()) {
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI Emoji", Font.PLAIN, 12));
            JOptionPane.showMessageDialog(this, "❗ Please select an option or click Skip!");            return;
        }

        char selectedAnswer = ' ';
        if (optionA.isSelected()) selectedAnswer = 'a';
        else if (optionB.isSelected()) selectedAnswer = 'b';
        else if (optionC.isSelected()) selectedAnswer = 'c';
        else if (optionD.isSelected()) selectedAnswer = 'd';

        if (selectedAnswer == answers[index]) {
            score++;
        }

        index++;
        optionsGroup.clearSelection();
        loadQuestion();
    }

    void showResult() {
        UIManager.put("OptionPane.messageFont", new Font("Segoe UI Emoji", Font.PLAIN, 14));

UIManager.put("OptionPane.minimumSize", new Dimension(400, 200));
UIManager.put("OptionPane.messageFont", new Font("Segoe UI Emoji", Font.PLAIN, 16));
UIManager.put("Button.background", new Color(100, 200, 150));

int option = JOptionPane.showConfirmDialog(
    this,
    "✅ Quiz finished!\nYour Score: " + score + "/" + questions.length + "\n\nDo you want to try again?",
    "Result",
    JOptionPane.YES_NO_OPTION
);
        if (option == JOptionPane.YES_OPTION) {
            index = 0;
            score = 0;
            loadQuestion();
        } else {
            UIManager.put("OptionPane.messageFont", new Font("Segoe UI Emoji", Font.PLAIN, 15));
            JOptionPane.showMessageDialog(this, "Thank you for playing! 😊");
            
            System.exit(0); }
    }


    public static void main(String[] args) {
        new SwingQuiz();
    }
}
