// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;

import java.util.*;

public class TrainingRecord {
    private List<Entry> tr;

    /**
     * Array constructor
     */
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    }

    /**
     * Add single entry to the arraylist and check the uniqueness by hashing result
     * of each object.
     * 
     * @param e Entry object to be added
     * @return String (result of operation)
     */
    public String addEntry(Entry e) {
        ListIterator<Entry> iter = tr.listIterator();
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.hash() == e.hash()) {
                return "Entry already added !";
            }
        }
        tr.add(e);
        return "Record added\n";
    }

    /**
     * Remove single entry given its name and date. Again, i compute the hash of the
     * entry and compare it to each entry hash in the arraylist to find the correct
     * one to be deleted. if no entry found "Entry not found\n" is returned.
     * 
     * @param name Athlete name
     * @param d    day
     * @param m    month
     * @param y    year
     * @return String (result of operation)
     */
    public String removeEntry(String name, int d, int m, int y) {
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
    }

    /**
     * Look up single entry by a given date. This is not accurate as if more entries
     * are added in the same day it will return the first one found.
     * 
     * @param d day
     * @param m month
     * @param y year
     * @return String (result of operation)
     */
    public String lookupEntry(int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        String result = "Sorry couldn't find anything for this date";
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getDay() == d && current.getMonth() == m && current.getYear() == y) {
                result = current.getEntry();
                break;
            }
        }
        return result;
    }

    /**
     * Find all the entries for a given date.
     * 
     * @param d day
     * @param m month
     * @param y year
     * @return String (result of operation)
     */
    public String findallEntry(int d, int m, int y) {
        ListIterator<Entry> iter = tr.listIterator();
        StringBuilder result = new StringBuilder("");
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getDay() == d && current.getMonth() == m && current.getYear() == y)
                result.append(current.getEntry());
        }

        if (result.toString().equals("")) {
            result = result.append("Sorry couldn't find anything for this date");
        }

        return result.toString();
    }

    /**
     * Find the sum of distances performed by an athlete in the last 7 days from the
     * current day included.
     * 
     * @param n Name
     * @return String (result of operation)
     */
    public String weeklyDistance(String n) {
        java.time.LocalDate now = java.time.LocalDate.now();
        float dist = 0;

        ListIterator<Entry> iter = tr.listIterator();
        while (iter.hasNext()) {
            Entry current = iter.next();
            if (current.getName().equals(n)) {
                java.time.LocalDate entryDate = java.time.LocalDate.of(current.getYear(), current.getMonth(),
                        current.getDay());
                if (java.time.temporal.ChronoUnit.DAYS.between(entryDate, now) <= 6) {
                    dist += current.getDistance();
                }
            }
        }

        if (dist > 0) {
            return Float.toString(dist);
        } else
            return "Weekly distance not found!";
    }

    // Count the number of entries
    public int getNumberOfEntries() {
        return tr.size();
    }

    // Clear all entries
    public void clearAllEntries() {
        tr.clear();
    }

}