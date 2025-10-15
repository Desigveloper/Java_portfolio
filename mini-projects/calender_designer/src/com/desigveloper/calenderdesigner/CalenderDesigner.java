package com.desigveloper.calenderdesigner;
import java.time.LocalDate;
import java.util.*;

public class CalenderDesigner {

    // Generate a month's calender a list of strings
    public List<String> getMonthCalender(int year, int month) {
        List<String> lines = new ArrayList<>();
        var date = LocalDate.of(year, month, 1);

        // Header
        lines.add(String.format("%s %d", date.getMonth(), year));
        lines.add("Mon Tue Wed Thu Fri Sat Sun\t");

        int firstDayOfWeek = date.getDayOfWeek().getValue();
        int daysInMonth = date.lengthOfMonth();

        var week = new StringBuilder();
        // Padding the first week
        for (int i = 1; i <= firstDayOfWeek; i++) {
            week.append("  ");
        }

        for (int day = 1; day <= daysInMonth; day++) {
            week.append(String.format("%3d", day));

            if ((firstDayOfWeek + day - 2) % 7 == 0 || day == daysInMonth) {
                lines.add(week.toString());
                week = new StringBuilder();
            }
        }

        // Ensure all calenders have the same number of lines (max 6 weeks)
        while (lines.size() < 8) {
            lines.add(" ");
        }

        return lines;
    }
    
}
