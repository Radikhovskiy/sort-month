import service.IDateSorter;
import service.IDateSorterFirst;
import service.IDateSorterSecond;
import java.time.LocalDate;
import java.util.List;

public class Main {
    private static final List<LocalDate> dates = List.of(
            LocalDate.of(2005,07,01),
            LocalDate.of(2005, 01, 02),
            LocalDate.of(2005, 01, 01),
            LocalDate.of(2005, 05, 03)
    );

    public static void main(String[] args) {
        IDateSorter iDateSorter1 = new IDateSorterFirst();
        System.out.println(iDateSorter1.sortDates(dates));

        IDateSorter iDateSorter2 = new IDateSorterSecond();
        System.out.println(iDateSorter2.sortDates(dates));
    }
}
