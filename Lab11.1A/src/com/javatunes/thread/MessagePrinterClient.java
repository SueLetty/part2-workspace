/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.thread;

public class MessagePrinterClient {

  public static void main(String[] args) {

    MessagePrinter printer1 = new MessagePrinter("apples are yummy");
    printer1.start();
    MessagePrinter printer2 = new MessagePrinter("Pears, too", 500);
    printer2.start();
  }
}