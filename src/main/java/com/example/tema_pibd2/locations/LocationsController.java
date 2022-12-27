package com.example.tema_pibd2.locations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/Locations")
public class LocationsController {
    private final LocationsService locationsService;

    @Autowired
    public LocationsController(LocationsService locationsService) {
        this.locationsService = locationsService;
    }

    @GetMapping
    public List<Locations> getLocations() {
        return locationsService.getLocations();
    }

    @PostMapping
    public void registerNewLocation(@RequestBody Locations location) {
        locationsService.addNewLocation(location);
    }
    @DeleteMapping(path  = "{locationId}")
    public void deleteLocation(@PathVariable("locationId") Long locationId) {
        locationsService.deleteLocation(locationId);
    }
    @PutMapping(path = "{locationId}")
    public void updateLocation(
            @PathVariable("locationId") Long locationId,
            @RequestParam(required = false) String county,
            @RequestParam(required = false) String city) {
        locationsService.updateLocation(locationId, county, city);
    }
}
