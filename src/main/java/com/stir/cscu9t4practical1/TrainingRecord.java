// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;
import java.time.temporal.TemporalField;
import java.time.temporal.ChronoUnit;
import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor
    
    // add a record to the list
   public String addEntry(Entry e){
       ListIterator<Entry> iter = tr.listIterator();
       while (iter.hasNext()) {
        Entry current = iter.next();
        if (current.hash() == e.hash()) {
            return "Entry already added !";
        }
       }
       tr.add(e);    
       return "Record added\n";
   } // addClass

   // look up the entry of a given day and month
   public String removeEntry (String name, int d, int m, int y) {
    int hash = Objects.hash(name, d, m, y);
    ListIterator<Entry> iter = tr.listIterator();
    while (iter.hasNext()) {
        Entry current = iter.next();
        if (current.hash() == hash) {
            tr.remove(current);
            return "Entry deleted !";
        }
    }  
    return "Entry not found\n";
    } // lookupEntry
    
   // look up the entry of a given day and month
   public String lookupEntry (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "Sorry couldn't find anything for this date";
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
             result = current.getEntry();
            }
       return result;
   } // lookupEntry

    // find all entries given a date
    public String findallEntry (int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        StringBuilder result = new StringBuilder("");
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
                result.append(current.getEntry());
            }

        if (result.toString().equals("")) {
            result = result.append("Sorry couldn't find anything for this date");
        }

        return result.toString();
    } // findallEntry
   
    public float weeklyDistance(String n)
    {
        java.time.LocalDate now=  java.time.LocalDate.now();
        float dist=0;

        ListIterator<Entry> iter = tr.listIterator();
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getName().equals(n)) {
                java.time.LocalDate entryDate=java.time.LocalDate.of(current.getYear(), current.getMonth(), current.getDay());
                
                if (java.time.temporal.ChronoUnit.DAYS.between(entryDate, now)<=6)
                {
                    dist+=current.getDistance();
                }               
            }
        }  
        return dist;
    }
   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }
   
} // TrainingRecord