package com.mycalendar.action;

import com.mycalendar.model.Event;
import com.mycalendar.service.CalendarManager;
import com.mycalendar.utils.InputValidator;

import java.time.LocalDateTime;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class ViewWeekEventsAction implements Action {
    private final CalendarManager calendarManager;
    private final Scanner scanner;

    public ViewWeekEventsAction(CalendarManager calendarManager, Scanner scanner) {
        this.calendarManager = calendarManager;
        this.scanner = scanner;
    }

    @Override
    public void execute() {
        int anneeSemaine = InputValidator.readInt(scanner, "Année (AAAA) : ", 2000, 2100);
        int semaine = InputValidator.readInt(scanner, "Semaine (1-52) : ", 1, 52);

        LocalDateTime debutSemaine = LocalDateTime.now()
                .withYear(anneeSemaine)
                .with(WeekFields.of(Locale.FRANCE).weekOfYear(), semaine)
                .with(WeekFields.of(Locale.FRANCE).dayOfWeek(), 1)
                .withHour(0).withMinute(0);
        LocalDateTime finSemaine = debutSemaine.plusDays(7).minusSeconds(1);

        List<Event> events = calendarManager.eventsDansPeriode(debutSemaine, finSemaine);

        for (Event event : events) {
            System.out.println(event.toString());
        }
    }

    @Override
    public String getDescription() {
        return "Afficher les événements d'une semaine";
    }
}
