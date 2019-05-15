/*
 * Purpose: To calculate and provide a menu using a graphic interface
 * @author: Quincy Harden
 * @date: 3/18/2019
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.FlowLayout;

public class MenuGUI extends JFrame
{
  private Double total = 0.0;
  private JButton pizza;
  private JButton cheeseBread;
  private JButton wings;
  private JButton salad;
  private JButton rootBeer;
  private JButton coke;
  private JButton melt;
  private JButton nachos;
  private JButton burrito;
  private JButton cheeseBurger;
  private JButton item11;
  private JButton item12;
  private JButton sale;
  private JTextField fItem11;
  private JTextField fItem12;
  private JTextArea results;
  private static final int ROWS = 10;
  private static final int COLUMNS = 30;
  private static final int FIELD_WIDTH = 10;
  
  // creates the menu frame, buttons, text fields, and text area
  public MenuGUI ()
  {
    super("Food Menu");
    
    setSize(500, 500);
    
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    
    JPanel buttonPanel = new JPanel();
    
    pizza = new JButton("Pizza: $20");
    buttonPanel.add(pizza);
    pizza.addActionListener(new MenuCalculation("Pizza", 20.00));
    
    cheeseBread = new JButton("cheese Bread: $7");
    buttonPanel.add(cheeseBread);
    cheeseBread.addActionListener(new MenuCalculation("Cheese Bread", 7.00));
    
    wings = new JButton("wings: $8");
    buttonPanel.add(wings);
    wings.addActionListener(new MenuCalculation("wings", 8.00));
    
    salad = new JButton("salad: $5");
    buttonPanel.add(salad);
    salad.addActionListener(new MenuCalculation("Salad", 5.00));
    
    rootBeer = new JButton("rootBeer: $6");
    buttonPanel.add(rootBeer);
    rootBeer.addActionListener(new MenuCalculation("Root Beer", 6.00));
    
    coke = new JButton("coke: $6");
    buttonPanel.add(coke);
    coke.addActionListener(new MenuCalculation("coke", 6.00));
    
    melt = new JButton("melt: $12");
    buttonPanel.add(melt);
    melt.addActionListener(new MenuCalculation("Melt", 12.00));
    
    nachos = new JButton("nachos: $15");
    buttonPanel.add(nachos);
    nachos.addActionListener(new MenuCalculation("Nachos", 15.00));
    
    burrito = new JButton("burrito: $15");
    buttonPanel.add(burrito);
    burrito.addActionListener(new MenuCalculation("Burrito", 15.00));
    
    cheeseBurger = new JButton("cheeseBurger: $7");
    buttonPanel.add(cheeseBurger);
    cheeseBurger.addActionListener(new MenuCalculation("Cheese Burger", 7.00));
    
    item11 = new JButton("item11");
    buttonPanel.add(item11);
    item11.addActionListener(new Item11());
    
     fItem11 = new JTextField(FIELD_WIDTH);
    buttonPanel.add(fItem11);
    
    item12 = new JButton("item12");
    buttonPanel.add(item12);
    item12.addActionListener(new Item12());
    
     fItem12 = new JTextField(FIELD_WIDTH);
    buttonPanel.add(fItem12);
    
    sale = new JButton("Sale");
    buttonPanel.add(sale);
    sale.addActionListener(new Sale());
    
    
    results = new JTextArea(ROWS, COLUMNS);
    buttonPanel.add(results);
    results.setEditable(false);
    
     
    
    
    getContentPane().add(buttonPanel);
  }
  
  // prints the order in the text area and adds to the total
  private class MenuCalculation implements ActionListener
  {
    private String name;
    private Double cost;
    
    public MenuCalculation (String name, Double cost)
    {
      this.name = name;
      this.cost = cost;
    }
    
    public void actionPerformed (ActionEvent event)
       {
      
         total+= cost;
         results.append(this.name + ": " + this.cost + "\n");
       }
  }
  
  // calculates the total, tax, total sale, the tip, and displays them on the text area
  private class Sale implements ActionListener
  {
    
    public void actionPerformed (ActionEvent event)
    {
      results.append("subtotal: "  + total + "\n");
      
      Double tax = total *.16;
      results.append("Tax: "  + tax + "\n");
      
      Double totalSale = total + tax;
      results.append("Total Sale: "  + totalSale + "\n");
      
      Double tip = totalSale *0.05;
      results.append("Suggested tip: "  + tip + "\n");
    }
  }
  
  // Custom order for 11th item
  private class Item11 implements ActionListener
  {
    
    public void actionPerformed (ActionEvent event)
    {
      Double foodCost11 = Double.parseDouble(fItem11.getText());
     total+= foodCost11;
      results.append("Item11 :" + " " + foodCost11 + "\n");
    }
  }
  
   // Custom order for 12th item
  private class Item12 implements ActionListener
  {
    
    public void actionPerformed (ActionEvent event)
    {
      
     Double foodCost12 = Double.parseDouble(fItem12.getText());
     total+= foodCost12;
      results.append("Item12 :" + " " + foodCost12 + "\n");
      
    }
  }
  
  public static void main(String[] args) {
    MenuGUI simpleUI = new MenuGUI();
    
    simpleUI.setVisible(true);
  }
}

