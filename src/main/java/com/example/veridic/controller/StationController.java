package com.example.veridic.controller;


import com.example.veridic.model.Station;
import com.example.veridic.exception.RecordNotFound;
import com.example.veridic.response.StationListResponse;
import com.example.veridic.response.StationResponse;
import com.example.veridic.services.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1/station")
public class StationController {

    @Autowired
    private StationService stationService;



    private ResponseEntity<StationListResponse> addStatusCodeAndMessageStationList(List<Station> cartItemList, String message) {
        StationListResponse stationResponse = new StationListResponse();
        stationResponse.setData(cartItemList);
        stationResponse.setMessage(message);

        stationResponse.setStatusCode(HttpStatus.OK);
        return new ResponseEntity<StationListResponse>(stationResponse, HttpStatus.OK);
    }

    private ResponseEntity<StationResponse> addStatusCodeAndMessageStation(Station Station, String message) {
        StationResponse stationResponse = new StationResponse();
        stationResponse.setData(Station);
        stationResponse.setMessage(message);
        stationResponse.setStatusCode(HttpStatus.OK);
        return new ResponseEntity<StationResponse>(stationResponse, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<StationListResponse> findAllStation(@RequestParam(value = "limit",required = false)Integer value){
        List<Station> stationList = stationService.findAllStation(value);
        return addStatusCodeAndMessageStationList(stationList, "success");
    }

    @GetMapping("/show/{id}")
    public ResponseEntity<StationResponse> getStationById(@PathVariable("id") Long id) throws RecordNotFound {
        Station stationByID = stationService.findStationByStationId(id);
        return addStatusCodeAndMessageStation(stationByID, "success");
    }

    @PostMapping("/add")
    public ResponseEntity<StationResponse> addStation(@RequestBody Station StationRequest) {
        Station Station = stationService.addStation(StationRequest);
        return addStatusCodeAndMessageStation(Station, "Station Added Successfully");
    }

    @PutMapping("/{id}/edit")
    public ResponseEntity<StationResponse> updateStation(@PathVariable("id") Long ID, @RequestBody Station station) throws RecordNotFound {
        Station Station = stationService.updateStationById(station);
        return addStatusCodeAndMessageStation(Station, "Station Updated Successfully");
    }


    @DeleteMapping("/{id}/delete")
    public ResponseEntity<StationResponse> deleteStationById(@PathVariable("id") Long id) throws RecordNotFound {
        stationService.deleteStationById(id);
        return addStatusCodeAndMessageStation(null, "Station Deleted Successfully");
    }


}


