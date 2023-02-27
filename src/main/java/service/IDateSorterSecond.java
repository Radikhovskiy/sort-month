package service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IDateSorterSecond implements IDateSorter {
    @Override
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        return unsortedDates.stream().sorted(getComparator()).collect(Collectors.toList());
    }

    private Comparator<LocalDate> getComparator() {
        return (date1, date2) -> {
            boolean month1HasR = date1.getMonth().toString().contains("R");
            boolean month2HasR = date2.getMonth().toString().contains("R");

            if (month1HasR && !month2HasR) {
                return -1;
            } else if (!month1HasR && month2HasR) {
                return 1;
            }

            return date2.compareTo(date1);
        };
    }
}
