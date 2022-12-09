package kz.bitlab.demo.db;

import kz.bitlab.demo.models.Magazine;

import java.util.ArrayList;
import java.util.List;

public class DBManager {

    static List<Magazine> magazineList = new ArrayList<>();

    static {
        magazineList.add(new Magazine(0L, "IT-1", "IT description 1"));
        magazineList.add(new Magazine(1L, "IT-2", "IT description 2"));
        magazineList.add(new Magazine(2L, "IT-3", "IT description 3"));
    }

    static Long id = 3L;

    public static List<Magazine> getAllMagazines() {
        return magazineList;
    }

    public static void addMagazine(Magazine magazine) {
        magazine.setId(id);
        magazineList.add(magazine);
        id++;
    }
}
