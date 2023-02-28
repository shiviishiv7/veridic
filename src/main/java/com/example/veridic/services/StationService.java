package com.example.veridic.services;

import com.example.veridic.exception.RecordNotFound;
import com.example.veridic.model.Station;
import com.example.veridic.repo.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class StationService {


    @Autowired
    private StationRepository stationRepository;



    public Station addStation(Station StationDto) {
        Station save = stationRepository.save(StationDto);
        return save;
    }


    public Station updateStationById(Station Station) throws RecordNotFound {
        boolean userAdd = stationRepository.existsById(Station.getId());
        if(!userAdd){
            throw new RecordNotFound("Station Not found By Id "+Station.getId());
        }
//		Station Station = this.modelMapper.map(Station, Station.class);
        Station save = stationRepository.save(Station);
        return save;
    }



    public boolean deleteStation(Long id) throws RecordNotFound {
        boolean byIsActiveAndId = stationRepository.existsById(id);
        if(!byIsActiveAndId){
            throw new RecordNotFound("Station ID Does not exists "+id);
        }
        stationRepository.deleteById(id);
        return true;
    }




    public Station findStationByStationId(Long id) throws RecordNotFound {
        Optional<Station> byIsActiveAndId = stationRepository.findById(id);
        if(byIsActiveAndId.isEmpty()){
            throw new RecordNotFound("Station Not found By Id "+id);
        }else return byIsActiveAndId.get();

    }

    public List<Station> findAllStation(Integer value) {
        if(value!=null&& value>0){
            List<Station>stationList =new ArrayList<>();
            List<Station> all = stationRepository.findAll();
            for(int i=0;i<value;i++){
                stationList.add(all.get(i));
            }
            return stationList;
        }else  return stationRepository.findAll();
    }

    public void deleteStationById(Long id) throws RecordNotFound {
        Optional<Station> byIsActiveAndId = stationRepository.findById(id);
        if(byIsActiveAndId.isEmpty()){
            throw new RecordNotFound("Station Not found By Id "+id);
        }else

        stationRepository.deleteById(id);
    }
}
