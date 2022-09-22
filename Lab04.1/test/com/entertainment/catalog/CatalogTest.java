/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.entertainment.catalog;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;
import com.entertainment.Television;

public class CatalogTest {
  
  /**
   * Contract: a no-matches result should be an empty collection (not null).
   */
  @Test
  public void testFindByBrandNoMatches() {
    Collection<Television> tvs = Catalog.findByBrand("NO-MATCHES");
    assertNotNull(tvs);
    assertTrue(tvs.isEmpty());
  }

  @Test
  public void testFindByBrandWithMatches(){
    Collection<Television> tvs = Catalog.findByBrand("Sony");
    assertNotNull(tvs);
    assertFalse(tvs.isEmpty());
    assertEquals(7, tvs.size());
  }

  @Test
  public void testFindByBrandNoBrands(){
    Map<String,Collection<Television>> televisionsByBrand = Catalog.findByBrands();
    assertNotNull(televisionsByBrand);
    assertTrue(televisionsByBrand.isEmpty());
  }

  @Test
  public void testFindByBrandSomeBrands(){
    Map<String,Collection<Television>> televisionsByBrand = Catalog.findByBrands("Sony","Zenith","NO_MATCHES");
    assertNotNull(televisionsByBrand);
    assertFalse(televisionsByBrand.isEmpty());
    assertEquals(3, televisionsByBrand.size());
    assertEquals(7,televisionsByBrand.get("Sony").size());
    assertEquals(9,televisionsByBrand.get("Zenith").size());
    assertTrue(televisionsByBrand.get("NO_MATCHES").isEmpty());
  }
}