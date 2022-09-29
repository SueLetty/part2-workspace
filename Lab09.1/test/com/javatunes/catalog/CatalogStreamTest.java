/*
 * This code is sample code, provided as-is, and we make no
 * warranties as to its correctness or suitability for
 * any purpose.
 *
 * We hope that it's useful to you.  Enjoy.
 * Copyright LearningPatterns Inc.
 */
package com.javatunes.catalog;

import static java.util.Comparator.comparing;
import static org.junit.Assert.*;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Before;
import org.junit.Test;

public class CatalogStreamTest {
  
  private Collection<MusicItem> allMusicItems;

  @Before
  public void setUp() {
    Catalog catalog = new InMemoryCatalog();
    allMusicItems = catalog.getAll();
  }
  
  /**
   * TASK: find all MusicItems whose artist starts with "D" and sort them by price.
   * RESULT: MusicItems 11 and 10, in that order.
   */
  @Test
  public void testArtistStartsWithSortPrice() {
    List<MusicItem> items = allMusicItems.stream()
      .filter(item -> item.getArtist().startsWith("D"))
      .sorted(comparing(MusicItem::getPrice))
      .collect(Collectors.toList());
    
    assertEquals(2, items.size());
    assertEquals(Long.valueOf(11), items.get(0).getId());
    assertEquals(Long.valueOf(10), items.get(1).getId());
  }
  
  /**
   * TASK: find all MusicItems where title is same as artist and sort them by natural order.
   * MusicItem implements Comparable: natural order is id increasing.
   * RESULT:
   */
  @Test
  public void testTitleEqualsArtistSortNaturalOrder() {

    List<MusicItem> items = allMusicItems.stream()
        .filter(item -> item.getArtist().equals(item.getTitle()))
        .sorted()
        .collect(Collectors.toList());

    assertEquals(2, items.size());
    assertEquals(Long.valueOf(6), items.get(0).getId());
    assertEquals(Long.valueOf(7), items.get(1).getId());
  }
  
  /**
   * TASK: find all MusicItems whose price is less than 12.00 and sort them by genre (MusicCategory).
   * The natural order of an enum is the order in which they're declared (it's not alphabetical).
   * We'll provide that for you here: BLUES, CLASSICAL, JAZZ, RAP, COUNTRY, POP, ALTERNATIVE, ROCK, CLASSIC_ROCK
   * RESULT:
   */
  @Test
  public void testPriceLessThanSortMusicCategory() {

    List<MusicItem> items = allMusicItems.stream()
        .filter(item -> item.getPrice() < 12.0)
        .sorted(comparing(MusicItem::getMusicCategory))
        .collect(Collectors.toList());

    assertEquals(5, items.size());
    assertEquals(Long.valueOf(7), items.get(0).getId()); //CLASSICAL
    assertEquals(Long.valueOf(13), items.get(1).getId());//COUNTRY
    assertEquals(Long.valueOf(16), items.get(2).getId());//ROCK
    assertEquals(Long.valueOf(17), items.get(3).getId());//ROCK
    assertEquals(Long.valueOf(18), items.get(4).getId());//CLASSIC_ROCK
  }
  
  /**
   * TASK: find all "rock" items under 15 dollars and sort them by release date (oldest first).
   * RESULT:
   */
  @Test
  public void testSortMusicCategorySortReleaseDateDesc() {

    List<MusicItem> items = allMusicItems.stream()
        .filter(item -> item.getMusicCategory() == MusicCategory.ROCK)
        .filter(item -> item.getPrice() < 15)
        .sorted(comparing(MusicItem::getReleaseDate))
        .collect(Collectors.toList());

    assertEquals(3, items.size());
    assertEquals(Long.valueOf(16), items.get(0).getId());
    assertEquals(Long.valueOf(17), items.get(1).getId());
    assertEquals(Long.valueOf(8), items.get(2).getId());
  }
  
  /**
   * TASK: find all items that cost more than 17 dollars and sort them by price descending, then by artist.
   * You can use visual inspection (sysout) on this one if you're getting tight on time.
   * RESULT:
   */
  @Test
  public void testPriceGreaterThanSortPriceDescThenMusicCategory() {

    List<MusicItem> items = allMusicItems.stream()
        .filter(item -> item.getPrice() > 17)
        .sorted(comparing(MusicItem::getPrice).reversed()
            .thenComparing(MusicItem::getArtist))
        .collect(Collectors.toList());

    assertEquals(7, items.size());
    assertEquals(Long.valueOf(15), items.get(0).getId());//18.97  Aerosmith
    assertEquals(Long.valueOf(12), items.get(1).getId());//17.97  "Creed"
    assertEquals(Long.valueOf(10), items.get(2).getId());//17.97  Def Leppard
    assertEquals(Long.valueOf(4), items.get(3).getId()); //17.97  Jonny Lang
    assertEquals(Long.valueOf(14), items.get(4).getId());//17.97  Peter Gabriel",
    assertEquals(Long.valueOf(9), items.get(5).getId());//17.97  Sarah McLachlan
    assertEquals(Long.valueOf(6), items.get(6).getId());//17.97  "Seal

  }
  
  /**
   * TASK: find all items under 12 dollars released in the 80s and sort them by artist.
   * Hint: To see if an item was released in the 80s, use item.getReleaseDate().toString().startsWith("198")
   * RESULT:
   */
  @Test
  public void testReleaseDateSortArtist() {
    List<MusicItem> items = allMusicItems.stream()
        .filter(item -> item.getPrice() < 12)
        .filter(item -> item.getReleaseDate().toString().startsWith("198"))
        .sorted(comparing(MusicItem::getArtist))
        .collect(Collectors.toList());

    assertEquals(4, items.size());
    assertEquals(Long.valueOf(13), items.get(0).getId());//"Bobs",
    assertEquals(Long.valueOf(18), items.get(1).getId()); //"Journey",
    assertEquals(Long.valueOf(17), items.get(2).getId()); //Van Halen",
    assertEquals(Long.valueOf(16), items.get(3).getId());//"Yes",

  }
}