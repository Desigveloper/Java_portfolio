package com.desigveloper.calenderdesigner;


import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        int year = LocalDate.now().getYear();
        int monthsPerRow = 3;
        int totalMonths = 12;

        List<List<String>> calendars = new ArrayList<>();
        var designer = new CalenderDesigner();

        // Generate calendars for each month
        for (int m = 1; m <= totalMonths; m++) {
            calendars.add(designer.getMonthCalender(year, m));
        }

        try (var writer = new PrintWriter("calender_designer//calender.txt")) {
            for (int row = 0; row < totalMonths / monthsPerRow; row++) {
                for (int line = 0; line < 8; line++) {
                    var sb = new StringBuilder();
                    for (int col = 0; col < monthsPerRow; col++) {
                        int idx = row * monthsPerRow + col;
                        sb.append(String.format("%-25s", calendars.get(idx).get(line)));
                    }
                    writer.println(sb.toString());
                }
                writer.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
