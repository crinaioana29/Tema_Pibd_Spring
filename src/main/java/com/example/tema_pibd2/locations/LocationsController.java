package com.example.tema_pibd2.locations;

import com.example.tema_pibd2.employees.Employees;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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
    public ModelAndView getLocations()
    {
        ModelAndView modelAndView = new ModelAndView("list-location");
        List<Locations> list = locationsService.getLocations();
        modelAndView.addObject("locations", list);
        return modelAndView;
    }

    @GetMapping("/add/")
    public ModelAndView registerLocationForm(){
        ModelAndView mav=new ModelAndView("add-location");
//        vrem sa fie empty initial, ca sa poti introduce date de pe website
        Locations locations=new Locations();
        mav.addObject("location",locations);
        return mav;
    }

    @PostMapping("/add/save/")
    public RedirectView registerNewLocation(@ModelAttribute Locations location) {
        locationsService.addNewLocation(location);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:8181/api/v1/Locations/add/");
        return redirectView;
    }
    @DeleteMapping(path  = "{locationId}")
    public void deleteLocation(@PathVariable("locationId") Long locationId) {
        locationsService.deleteLocation(locationId);
    }
    @GetMapping(path="/update/{locationId}")
    public ModelAndView updateLocationForm(){
        ModelAndView modelAndView=new ModelAndView("put-location");
//        Tot la fel empty ca sa putem pune noi valorile pe care le vrem
        Locations locations=new Locations();
        modelAndView.addObject("location",locations);
        return modelAndView;
    }
    @PostMapping(path = "/update/{locationId}")
    public RedirectView updateLocation(
            @PathVariable("locationId") Long locationId,
            @ModelAttribute Locations locations) {
        locationsService.updateLocation(locationId, locations.getCounty(), locations.getCity());
//    la fel ca la add, vrem sa ne duca intr o alta pagina, nu pe una goala dupa ce s a terminat de facut
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl("http://localhost:8181/api/v1/Employees");
        return redirectView;
    }
}
