// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;




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
   public String lookupEntry (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "No entries found";
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
            result = result.append("No entries found");
        }

        return result.toString();
    } // findallEntry
   
   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }
   
} // TrainingRecord