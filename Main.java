import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class PasswordStrengthChecker extends JFrame implements ActionListener {
 private JLabel label, result, suggestion;
 private JTextField passwordField;
 private JButton btnCheck;
 private Icon icon;
 PasswordStrengthChecker() {
 try {
 icon = new 
ImageIcon(this.getClass().getResource("/icons/password.png"));
 } catch (NullPointerException e) {
 System.err.println("Error loading icon: " + e.getMessage());
 }
 label = new JLabel("Enter your password to check its strength");
 label.setBounds(70, 60, 260, 30);
 label.setForeground(Color.white);
 passwordField = new JPasswordField();
 passwordField.setBounds(100, 100, 200, 30);
 btnCheck = new JButton("Check Password Strength", icon);
 btnCheck.setBounds(90, 150, 240, 30);
 btnCheck.addActionListener(this);
 result = new JLabel();
 result.setBounds(170, 200, 200, 30);
 suggestion = new JLabel();
 suggestion.setBounds(130, 230, 200, 30);
 add(label);
 add(passwordField);
 add(btnCheck);
 add(result);
 add(suggestion);
 setSize(400, 400);
 getContentPane().setBackground(Color.BLACK);
 setTitle("Password Strength Checker");
 setLayout(null);
 setVisible(true);
 setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 }
 public static void main(String[] args) {
 new PasswordStrengthChecker();
 }
 @Override
 public void actionPerformed(ActionEvent e) {
 String password = passwordField.getText();
 validatePassword(password);
 }
 private void validatePassword(String password) {
 result.setText("");
 suggestion.setText("");
 if (password.trim().isEmpty()) {
 suggestion.setText("Password cannot be empty");
 suggestion.setForeground(Color.red);
 } else if (password.length() < 8) {
 result.setText("WEAK!");
 result.setForeground(Color.red);
 suggestion.setText("Add more characters");
 suggestion.setForeground(Color.red);
 } else if (password.length() > 30) {
 result.setText("Password too long");
 result.setForeground(Color.red);
 suggestion.setText("Reduce to 8-30 characters");
 suggestion.setForeground(Color.red);
 } else {
 boolean hasNumber = password.matches(".*\\d.*");
 boolean hasUpperCase = 
!password.equals(password.toLowerCase());
 boolean hasSpecialChar = password.matches(".*[!@#$%^&*()_+\\-
=\\[\\]{};':\",.<>?/\\\\|].*");
 if (!hasNumber || !hasUpperCase || !hasSpecialChar) {
 result.setText("WEAK!");
 result.setForeground(Color.red);
 StringBuilder suggestions = new StringBuilder("Add ");
 if (!hasNumber) suggestions.append("any digit, ");
 if (!hasUpperCase) suggestions.append("an uppercase letter, 
");
 if (!hasSpecialChar) suggestions.append("any special 
character");
 suggestion.setText(suggestions.toString().replaceAll(", $", 
""));
 suggestion.setForeground(Color.red);
 } else {
 result.setText("STRONG");
 result.setForeground(Color.GREEN);
 }
 }
