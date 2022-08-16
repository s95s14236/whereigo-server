package com.whereigo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.whereigo.model.ApiResponse;
import com.whereigo.model.Attraction;
import com.whereigo.service.AttractionService;

@RestController
@CrossOrigin
@RequestMapping("attraction")
public class AttractionController {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    AttractionService attractionService;

    @GetMapping(value = "/saveAllAttraction", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> saveAllAttractions() {
        log.info("/attraction/saveAllAttraction");
        ApiResponse apiResponse = new ApiResponse();
        attractionService.saveAllAttractions();
        apiResponse.setMessage("save all attractions success");
        apiResponse.setStatusCode(200);
        return ResponseEntity.ok().body(apiResponse);
    }

    /**
     * 不分區query, 分頁搜尋
     */
    @CrossOrigin
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> getPageAttractions(
        @RequestParam(name = "page", required = false, defaultValue = "0") int page,
        @RequestParam(name = "size", required = false, defaultValue = "10") int size
    ) {
        ApiResponse apiResponse = new ApiResponse();
        log.info("/attraction, page={}, size={}", page, size);
        
        List<Attraction> attractions = attractionService.getPageAttractions(page, size);
        Map<String, Object> data = new HashMap<>();
        data.put("attractions", attractions);
        apiResponse.setData(data);
        apiResponse.setMessage("get attraction by success");
        apiResponse.setStatusCode(200);
        return ResponseEntity.ok().body(apiResponse);
    }

    /**
     * 根據縣市|區域query, 分頁搜尋
     * @param region 縣市
     * @param town 區域
     * @param page 頁
     * @param size 每頁size
     * @return
     */
    @CrossOrigin
    @GetMapping(value = "/region/{region}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> getPageAttractionsByRegion(
        @PathVariable(name = "region") String region,
        @RequestParam(name = "town", required = false, defaultValue = "") String town,
        @RequestParam(name = "page", required = false, defaultValue = "0") int page,
        @RequestParam(name = "size", required = false, defaultValue = "10") int size
    ) {
        ApiResponse apiResponse = new ApiResponse();
        log.info("/attraction/region/{}, town={}, page={}, size={}", region, town, page, size);
        List<Attraction> attractions = attractionService.getPageAttractionsByRegionAndTown(region, town, page, size);
        Map<String, Object> data = new HashMap<>();
        data.put("attractions", attractions);
        apiResponse.setData(data);
        apiResponse.setMessage("get attraction by success");
        apiResponse.setStatusCode(200);
        return ResponseEntity.ok().body(apiResponse);
    }

    /**
     * query attraction by id
     */
    @CrossOrigin
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiResponse> getAttractionById(@PathVariable("id") Long id) {
        ApiResponse apiResponse = new ApiResponse();
        log.info("/attraction/{}", id);
        Attraction attraction = attractionService.getAttractionById(id);
        Map<String, Object> data = new HashMap<>();
        data.put("attraction", attraction);
        apiResponse.setData(data);
        apiResponse.setMessage("get attraction by success");
        apiResponse.setStatusCode(200);
        return ResponseEntity.ok().body(apiResponse);
    }
}
