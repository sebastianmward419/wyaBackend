package com.todenterprises.wyaapp.cronjobs;

import org.springframework.stereotype.Component;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.beans.factory.annotation.Autowired;

import com.todenterprises.wyaapp.database.OfficeMate;
import com.todenterprises.wyaapp.database.OfficeMateRepository;

import java.util.List;

@Component
public class ResetDailyStats {

    @Autowired
    OfficeMateRepository repository;

    @Scheduled (cron="0 0 0 * * *", zone="US/Pacific")
    public void resetStatusLocation () {
        System.out.println ("Its time \n \n \n");

        List<OfficeMate> officemates = repository.findAll();

        officemates.forEach(officemate -> {
            officemate.setLocation("???");
            officemate.setStatus("maybe");

            repository.save (officemate);
        });


    }

}