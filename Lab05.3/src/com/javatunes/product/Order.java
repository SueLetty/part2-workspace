/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.product;

import com.javatunes.billing.EuropeTax;
import com.javatunes.billing.Location;
import com.javatunes.billing.OnlineTax;
import com.javatunes.billing.USATax;
import java.util.Collection;

public class Order {
  private String id;
  private double total_cost;
  private Location factory = Location.USA;
  
  public Order(String id) {
    this.id = id;
  }


  public double getTotal_cost() {
    return total_cost;
  }

  public Location getFactory() {
    return factory;
  }

  public void setFactory(Location factory) {
    this.factory = factory;
  }

  /**
   * DONE:
   * get the items from the cart and iterate over them, print each item's product code
   * get cart total and print
   */
  public void processCart(ShoppingCart<? extends Product> cart) {
    System.out.println("Order: " + getId() + " contains the following:");
    
    Collection<? extends Product> cartItems = cart.allItems();
    for (Product product : cartItems) {
      System.out.println(product.getCode());
    }
    total_cost = cart.total();
    System.out.println("Order Total: " + cart.total());

  }
  
  public String getId() {
    return id;
  }
  public double getTax(){
    double taxable = getTotal_cost();
    double tax = 0;

    if(getFactory() == Location.USA){
      USATax usaTax = new USATax();
      tax = usaTax.taxAmount(taxable);
    }
    if(getFactory() == Location.EUROPE){
      EuropeTax europeTax = new EuropeTax();
      tax = europeTax.taxAmount(taxable);
    }
    if(getFactory() == Location.ONLINE){
      OnlineTax onlineTax = new OnlineTax();
      tax = onlineTax.taxAmount(taxable);
    }
    System.out.printf("total tax is %.2f%n", tax);
    return tax;
  }
}