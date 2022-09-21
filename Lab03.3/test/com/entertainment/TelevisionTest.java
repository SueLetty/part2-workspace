package com.entertainment;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TelevisionTest {
  Television tv = new Television("ABC",55,DisplayType.LCD);
  @Test
  public void testSetVolume() {
    int volume = tv.getVolume();
    tv.setVolume(100);
    assertEquals(100,tv.getVolume());

  }

  @Test
  public void testSetVolumeException(){
    int volume = tv.getVolume();
    try{
      tv.setVolume(110);
      fail("Should have thrown IllegalArgumentException");
    }catch (IllegalArgumentException e){
      assertEquals(volume, tv.getVolume());
    }
  }

  @Test
  public void testChangeChannel() throws InvalidChannelException{
    tv.changeChannel(12);
    assertEquals(12,tv.getCurrentChannel());
  }
  @Test
  public void testChangeChanelException() throws InvalidChannelException{
    int channel = tv.getCurrentChannel();
    try{
      tv.changeChannel(0);
      fail("Should have thrown InvalidChannelException");
    }catch (InvalidChannelException e){
      assertEquals(channel, tv.getCurrentChannel());
    }
  }

  @Test
  public void testCompareTo() {
    Television tv1 = new Television("ABC");
    assertTrue(tv.compareTo(tv1) == 0);

    tv1.setBrand("abc");
    assertTrue(tv.compareTo(tv1) < 0);
  }

  @Test
  public void testHashCode() {
    Television tv1 = new Television("ABC",55,DisplayType.LCD);
    assertEquals(tv.hashCode(),tv1.hashCode());
    Television tv2 = new Television("ABC",60,DisplayType.LCD);
    assertNotEquals(tv.hashCode(),tv2.hashCode());

  }

  @Test
  public void testEquals() {
    Television tv1 = new Television("ABC",55,DisplayType.LCD);
    assertEquals(tv, tv1);
    Television tv2 = new Television("ABC",0,DisplayType.LCD);
    assertNotEquals(tv,tv2);
  }
}