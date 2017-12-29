package service;

import entity.Context;
import entity.Key;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class MenuService {
    private List<Key> items = new ArrayList<>();

    public MenuService() {

        items.add(new Key() {
            @Override
            public void apply() {
                System.out.println("Enter date");
                LocalDate localDate = InputHelper.getInputDate("yyyy-MM-dd").orElse(LocalDate.now());
                Context.getFilmScheduleService().showSchedule(localDate);
                System.out.println();
            }

            @Override
            public String getDescription() {
                return "Show schedule for date and time";
            }
        });


        items.add(new Key() {
            @Override
            public void apply() {
                System.out.println("Enter date");
                String filmTitle = InputHelper.getInputString().get();
                Context.getFilmManager().printFilmInformation(filmTitle);
                System.out.println();
            }

            @Override
            public String getDescription() {
                return "Show film information";
            }
        });

    }

    public void showMenu() {
        int count = 0;
        for (Key item : items) {
            System.out.println(++count + ") " + item.getDescription());
        }
    }

    public void applyChoise(int input) {
        if ((input > 0) & (input <= items.size())) {
            items.get(input).apply();
        }
    }
}
