package Comparators;

import JsonManipulation.Review;

import java.util.Comparator;

public class DatesComparator implements Comparator<Review> {
    @Override
    public int compare(Review o1, Review o2) {
        String date1 = o1.reviewCreatedOnDate;
        String date2 = o2.reviewCreatedOnDate;
        String[] date1_split = date1.split("T");
        String[] date2_split = date2.split("T");

        String d1 = getDay(date1_split[0]);
        String d2 = getDay(date2_split[0]);
        String m1 = getMonth(date1_split[0]);
        String m2 = getMonth(date2_split[0]);
        String y1 = getYear(date1_split[0]);
        String y2 = getYear(date2_split[0]);

        String h1 = getHours(date1_split[1]);
        String h2 = getHours(date2_split[1]);
        String min1 = getMinutes(date1_split[1]);
        String min2 = getMinutes(date2_split[1]);
        String sec1 = getSeconds(date1_split[1]);
        String sec2 = getSeconds(date2_split[1]);
        if(y1.compareTo(y2) != 0){
            return Integer.compare(Integer.parseInt(y1), Integer.parseInt(y2));
        }
        if(m1.compareTo(m2) != 0){
            return Integer.compare(Integer.parseInt(m1), Integer.parseInt(m2));
        }
        if(d1.compareTo(d2) != 0){
            return Integer.compare(Integer.parseInt(d1), Integer.parseInt(d2));
        }
        if(h1.compareTo(h2) != 0){
            return Integer.compare(Integer.parseInt(h1), Integer.parseInt(h2));
        }
        if(min1.compareTo(min2) != 0){
            return Integer.compare(Integer.parseInt(min1), Integer.parseInt(min2));
        }
        if(sec1.compareTo(sec2) != 0){
            return Integer.compare(Integer.parseInt(sec1), Integer.parseInt(sec2));
        }
        return 0;
    }

    public String getMonth(String s){
        String[] ymd = s.split("-");
        return ymd[0];
    }

    public String getYear(String s){
        String[] ymd = s.split("-");
        return ymd[1];
    }

    public String getDay(String s){
        String[] ymd = s.split("-");
        return ymd[2];
    }

    public String getHours(String s){
        String[] hms = s.split(":");
        return hms[0];
    }

    public String getMinutes(String s){
        String[] hms = s.split(":");
        return hms[1];
    }

    public String getSeconds(String s){
        String[] hms = s.split(":");
        return hms[2].substring(0, 2);
    }
}
