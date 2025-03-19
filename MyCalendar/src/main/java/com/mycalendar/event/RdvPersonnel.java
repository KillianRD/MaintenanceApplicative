package com.mycalendar.event;

import com.mycalendar.main.Date;
import com.mycalendar.main.DureeEvent;
import com.mycalendar.main.Proprietaire;
import com.mycalendar.main.Titre;

public class RdvPersonnel extends Event {
    public RdvPersonnel(Titre title, Proprietaire proprietaire, Date date, DureeEvent dureeMinutes) {
        super(EventType.RDV_PERSONNEL, title, proprietaire, date, dureeMinutes);
    }

    @Override
    public String description() {
        return "RDV : " + title + " à " + date.start().toString();
    }
}
