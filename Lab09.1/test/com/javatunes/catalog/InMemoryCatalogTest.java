package com.javatunes.catalog;

import static org.junit.Assert.*;

import org.junit.Test;

public class InMemoryCatalogTest {

  @Test
  public void findById() {
    MusicItem found = new InMemoryCatalog().findById(14L);
    assertEquals("So", found.getTitle());
    assertEquals("Peter Gabriel", found.getArtist());

    found = new InMemoryCatalog().findById(Long.MAX_VALUE);
    assertNull(found);
  }
}