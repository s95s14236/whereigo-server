package com.whereigo.schedule;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.whereigo.service.AttractionService;


@Component
public class FetchTask {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AttractionService attractionService;

    // @Scheduled(cron = "0 0 0 * * ?", zone = "Asia/Taipei")
    // public void saveDailyTranctionStockData() {
    //     // twsiOpenService.scheduleAddDailyTranctionStockData();
    //     // log.info("上市個股日成交資訊-存入");
    // }
}
