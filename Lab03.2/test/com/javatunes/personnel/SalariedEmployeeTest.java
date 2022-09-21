package com.javatunes.personnel;

import static org.junit.Assert.*;

import gov.irs.TaxPayer;
import java.sql.Date;
import org.junit.Before;
import org.junit.Test;

public class SalariedEmployeeTest {
  private static final double SALARY =  100000;
  private static final double TOLERANCE = 0.001;
  private static final double TAX = SALARY * TaxPayer.SALARIED_TAX_RATE;
  private SalariedEmployee emp;

  @Before
  public void setUp(){
    emp = new SalariedEmployee("Steve Jobs", Date.valueOf("2015-03-31"),SALARY);
  }

  @Test
  public void testPay() {
    assertEquals(SALARY,emp.pay(),TOLERANCE);
  }

  @Test
  public void testPayTaxes() {
    assertEquals(TAX,emp.payTaxes(),TOLERANCE);
  }
}