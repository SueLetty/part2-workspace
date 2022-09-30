/*
 * This code is sample code, provided AS-IS, and we make NO
 * warranties as to its correctness or suitability for any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.thread;

public class MessagePrinter extends Thread {
  private final int DEFAULT_INTERVAL = 1000;

  private final String message;
  private final int interval;

  public MessagePrinter(String message) {
    this.message = message;
    interval=DEFAULT_INTERVAL;
    setName(getClass().getName());
  }

  public MessagePrinter(String message, int interval) {
    this.message = message;
    this.interval = interval;
    setName(getClass().getName());
  }

  public void run() {
    for (int i = 0; i < 10; i++) {
      System.out.println(Thread.currentThread().getName() + ": " + message);
      try {
        Thread.sleep(interval);
      } catch (InterruptedException ignored) {
        // Do nothing; not serious.
      }
    }

  }
}