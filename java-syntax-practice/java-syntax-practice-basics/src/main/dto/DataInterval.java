package src.main.dto;

import java.time.LocalDate;

public class DataInterval extends Pair<LocalDate> {

    public void setSecond(LocalDate secondDate){
        if(secondDate.compareTo(getFirst()) <= 0) {
            super.setSecond(secondDate);
        }

    }
}
