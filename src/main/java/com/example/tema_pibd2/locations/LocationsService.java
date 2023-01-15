package com.example.tema_pibd2.locations;

import jakarta.transaction.Transactional;
import jdk.jfr.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LocationsService {

    private final LocationsRepository locationsRepository;
    @Autowired
    public LocationsService(LocationsRepository locationsRepository) {
        this.locationsRepository = locationsRepository;
    }

    public List<Locations> getLocations() {
        return locationsRepository.findAll();
    }
    public void addNewLocation(Locations location) {
        Optional<Locations> locationOptional = locationsRepository
                .findLocationsByCounty(location.getCounty());
//        if(locationOptional.isPresent()) {
//            throw new IllegalStateException("county taken");
//        }
        locationsRepository.save(location);
        System.out.println(location);
    }

    public void deleteLocation(Long locationId) {
        boolean exists = locationsRepository.existsById(locationId);
        if(!exists) {
            throw new IllegalStateException("location with id " + locationId + " does not exist");
        }
        locationsRepository.deleteById(locationId);
    }
    @Transactional
    public void updateLocation(Long locationId, String county, String city) {
        Locations location = locationsRepository.findById(locationId)
                .orElseThrow(() -> new IllegalStateException(
                        "location with id " + locationId + " does not exist"));
        if(county != null && county.length() > 0 && !Objects.equals(location.getCounty(), county)) {
            location.setCounty(county);
        }
        if(city != null && city.length() > 0 && !Objects.equals(location.getCity(), city)) {
            location.setCity(city);
        }
    }
}

