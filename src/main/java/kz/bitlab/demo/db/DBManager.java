package kz.bitlab.demo.db;

import kz.bitlab.demo.models.Magazine;

import java.util.ArrayList;
import java.util.List;

public class DBManager {

    static List<Magazine> magazineList = new ArrayList<>();

//    static {
//        magazineList.add(new Magazine(0L, "IT-1", "IT description 1", 1000));
//        magazineList.add(new Magazine(1L, "IT-2", "IT description 2", 2000));
//        magazineList.add(new Magazine(2L, "IT-3", "IT description 3", 3000));
//    }

    static Long id = 3L;

    public static List<Magazine> getAllMagazines() {
        return magazineList;
    }

    public static void addMagazine(Magazine magazine) {
        magazine.setId(id);
        magazineList.add(magazine);
        id++;
    }

    public static Magazine getMagazineById(Long id) {
        return magazineList.get(Integer.parseInt(id.toString()));
    }

    public static void updateMagazine(Magazine magazine) {
        magazineList.set(Integer.parseInt(magazine.getId().toString()), magazine);
    }

    public static void deleteMagazine(Long id) {
        magazineList.remove(Integer.parseInt(id.toString()));
    }
}
