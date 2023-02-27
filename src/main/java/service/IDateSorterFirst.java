package service;

import java.time.LocalDate;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class IDateSorterFirst implements IDateSorter {
    @Override
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        List<LocalDate> containR = unsortedDates.stream()
                .filter(d -> d.getMonth().toString().contains("R"))
                .sorted()
                .collect(Collectors.toList());

        List<LocalDate> notContainR = unsortedDates.stream()
                .filter(d -> !d.getMonth().toString().contains("R"))
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        return Stream.of(containR, notContainR)
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
