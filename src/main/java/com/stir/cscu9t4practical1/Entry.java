// This class holds information about a single training session
package com.stir.cscu9t4practical1;

import java.util.Objects;
import java.util.Calendar;

// Considered as default entry (run)
public class Entry {
  private String name;
  private Calendar dateAndTime;
  private float distance;
  
  public Entry (String n, int d, int m, int y, int h, int min, int s, float dist) {
    name = n;
    Calendar inst = Calendar.getInstance();
    inst.set(y,m-1,d,h,min,s);
    dateAndTime = inst;
    distance = dist;
  } //constructor
  
  public String getName () {
    return name;
  } //getName
  
  public int getDay () {
    return dateAndTime.get(Calendar.DATE);
  } //getDay
  
  public int getMonth () {
    return dateAndTime.get(Calendar.MONTH) + 1;
  } //getMonth
  
  public int getYear () {
    return dateAndTime.get(Calendar.YEAR);
  } //getYear

  public int getHour () {
    return dateAndTime.get(Calendar.HOUR);
  } //getHour

  public int getMin () {
    return dateAndTime.get(Calendar.MINUTE);
  } //getMin

  public int getSec () {
    return dateAndTime.get(Calendar.SECOND);
  } //getSec

  public float getDistance () {
    return distance;
  } //getYear

  public int hash() {
    return Objects.hash(name, getDay(), getMonth(), getYear());
  }

  public String getEntry () {
   String result = getName()+" ran " + getDistance() + " km in "
             +getHour()+":"+getMin()+":"+ getSec() + " on "
             +getDay()+"/"+getMonth()+"/"+getYear() + "\n";
   return result;
  } //getEntry
   
} // Entry


class SwimEntry extends Entry {
  String where;

  public SwimEntry (String n, int d, int m, int y, int h, int min, int s, float dist, String where) {
    super(n, d, m, y, h, min, s, dist);
    this.where = where;
  }     

  public String getWhere() {
    if (this.where.equals("pool"))
      where = "in a pool";
    return this.where;
  }

  @Override
  public String getEntry () {
    return super.getName() + " swam " + super.getDistance() + " km " + this.getWhere() + " in " + super.getHour() + ":" + super.getMin() + ":" + super.getSec() + " on " + super.getDay() + "/" + super.getMonth() + "/" + super.getYear() + "\n";
  }

}

class CycleEntry extends Entry {
  String terrain;
  String tempo;

  public CycleEntry (String n, int d, int m, int y, int h, int min, int s, float dist, String terrain, String tempo) {
    super(n, d, m, y, h, min, s, dist);
    this.terrain = terrain;
    this.tempo = tempo;
  }     

  public String getTempo() {
    return this.tempo;
  }

  public String getTerrain() {
    return this.terrain;
  }

  @Override
  public String getEntry () {
    return super.getName() + " cycled " + super.getDistance() + " km in " + super.getHour() + ":" + super.getMin() + ":" + super.getSec() + " on " + super.getDay() + "/" + super.getMonth() + "/" + super.getYear() + " on " + this.getTerrain() + " at " + this.getTempo() + " tempo\n";
  }

}


class SprintEntry extends Entry {
  int recovery;
  int repetitions;

  public SprintEntry (String n, int d, int m, int y, int h, int min, int s, float dist, int repetitions, int recovery) {
    super(n, d, m, y, h, min, s, dist);
    this.recovery = recovery;
    this.repetitions = repetitions;
  }     

  public int getRecovery() {
    return this.recovery;
  }

  public int getRepetitions() {
    return this.repetitions;
  }
  
  @Override
  public String getEntry () {  
    return super.getName() + " sprinted " + this.getRepetitions() + "x" + (int)this.getDistance() + "m in " + super.getHour() + ":" + super.getMin() + ":" + super.getSec() + " with " + this.getRecovery() + " minutes recovery on " + super.getDay() + "/" + super.getMonth() + "/" + super.getYear() + "\n";
  }

}

