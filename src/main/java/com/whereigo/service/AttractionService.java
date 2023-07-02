package com.whereigo.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.whereigo.enumSave.ApiUrl;
import com.whereigo.model.Attraction;
import com.whereigo.model.AttractionsResponse;
import com.whereigo.model.PageResult;
import com.whereigo.repository.AttractionRepository;
import com.whereigo.util.ApiUtil;

@Service
public class AttractionService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AttractionRepository attractionRepository;

    /**
     * get all attractions
     * @returnc Attraction[]
     */
    public Attraction[] getAllAttraction() {
        AttractionsResponse attractionsResponse = ApiUtil.send(ApiUrl.GET_ALL_ATTRACTIONS.getUrl(), ApiUrl.GET_ALL_ATTRACTIONS.getMethod(), AttractionsResponse.class);
        return attractionsResponse.getXml_head().getInfos().getInfo();
    }

    public void saveAllAttractions() {
        Attraction[] attractions = getAllAttraction();
        for (Attraction attraction: attractions) {
            attractionRepository.save(attraction);
        }
    }

    /**
     * 獲取該縣市|分區的景點
     * @param page 頁面
     * @param size 一頁幾個景點
     * @return Attraction array
     */
    public PageResult<Attraction> getPageAttractionsByRegionAndTown(String region, String town, int page, int size) {
        // Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending().and(Sort.by(Sort.Order.by("picture1").nullsLast())));
        Pageable pageable = PageRequest.of(page, size, Sort.by("picture1").descending().and(Sort.by("changetime").descending()));
        Page<Attraction> attractionPage;
        if (town.trim().length() > 0) {
            attractionPage =  attractionRepository.findAllByRegionAndTown(region, town, pageable);
        } else {
            attractionPage = attractionRepository.findAllByRegion(region, pageable);
        }
        Integer nextPageNum = attractionPage.hasNext() ? page+1 : null;
        return new PageResult<Attraction>(attractionPage.getContent(), nextPageNum);
    }

    /**
     * 獲取不分區的景點
     * @param page 頁面
     * @param size 一頁幾個景點
     * @return Attraction array
     */
    public PageResult<Attraction> getPageAttractions(int page, int size) {
        // Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending().and(Sort.by(Sort.Order.by("picture1").nullsLast()).descending()));
        Pageable pageable = PageRequest.of(page, size, Sort.by("picture1").descending().and(Sort.by("id").descending()));
        Page<Attraction> attractionPage = attractionRepository.findAll(pageable);
        Integer nextPageNum = attractionPage.hasNext() ? page+1 : null;
        return new PageResult<Attraction>(attractionPage.getContent(), nextPageNum);
    }

    /**
     * query attraction by attraction id
     * @param id
     * @return
     */
    public Attraction getAttractionById(Long id) {
        return attractionRepository.findById(id).orElse(null);
    }
}
