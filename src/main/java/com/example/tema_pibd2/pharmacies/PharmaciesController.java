package com.example.tema_pibd2.pharmacies;

import com.example.tema_pibd2.employees.Employees;
import com.example.tema_pibd2.employees.EmployeesService;
import com.example.tema_pibd2.locations.Locations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//used for making restful web services
//used at the class level and allows the class to handle the requests made by the client
@RestController
@RequestMapping(path = "api/v1/Pharmacies")
public class PharmaciesController {
    private final PharmaciesService pharmaciesService;
    //   to get rid of the injection of all self-dependencies
    @Autowired
    public PharmaciesController(PharmaciesService pharmaciesService) {
        this.pharmaciesService = pharmaciesService;
    }

    @GetMapping
    public ModelAndView getPharmacies()
    {
//        ModelAndView connects your java code (your instances) to the web page
        ModelAndView modelAndView = new ModelAndView("list-pharmacy");
        List<Pharmacies> list = pharmaciesService.getPharmacies();
        modelAndView.addObject("pharmacies", list);
        return modelAndView;
    }
//    GET request to the server on the respective page
    @GetMapping(path="/employeesP/{id_pharmacy}")
    public ModelAndView getEmployeesinPharmacies(@PathVariable("id_pharmacy") Long id)
    {
        ModelAndView modelAndView = new ModelAndView("list-employees");
        List<Employees> list=new ArrayList<>();
        List<Pharmacies> pharmaciesList=pharmaciesService.getPharmacies();
        for(Pharmacies pharmacy:pharmaciesList){
            if(pharmacy.getIdpharmacy().equals(id))
                list.addAll(pharmacy.getEmployees());
        }
        modelAndView.addObject("employees", list);
        return modelAndView;
    }
    @GetMapping(path="/locationsP/{id_pharmacy}")
    public ModelAndView getLocationsinPharmacies(@PathVariable("id_pharmacy") Long id)
    {
        ModelAndView modelAndView = new ModelAndView("list-location");
        List<Locations> list=new ArrayList<>();
        List<Pharmacies> pharmaciesList=pharmaciesService.getPharmacies();
        for(Pharmacies pharmacy:pharmaciesList){
            if(pharmacy.getIdpharmacy().equals(id))
                list.addAll(pharmacy.getLocations());
        }
        modelAndView.addObject("locations", list);
        return modelAndView;
    }

    @GetMapping("/add/")
    public ModelAndView registerPharmacyForm(){
        ModelAndView mav=new ModelAndView("add-pharmacy");
        Pharmacies pharmacy = new Pharmacies();
        mav.addObject("pharmacy", pharmacy);
        return mav;
    }
    @PostMapping("/add/save/")
    public RedirectView registerNewPharmacy(@ModelAttribute Pharmacies pharmacy) {
        pharmaciesService.addNewPharmacy(pharmacy);
        RedirectView redirectView = new RedirectView();
        redirectView.setUrl("http://localhost:8181/api/v1/Pharmacies/add/");
//        redirect to add-pharmacy
        return redirectView;
    }
    @DeleteMapping(path  = "{pharmacyId}")
    public void deletePharmacy(@PathVariable("pharmacyId") Long pharmacyId) {
        pharmaciesService.deletePharmacy(pharmacyId);
    }

    @GetMapping(path="/update/{pharmacyId}")
    public ModelAndView updatePharmacyForm(){
        ModelAndView modelAndView=new ModelAndView("put-pharmacy");
        Pharmacies pharmacy = new Pharmacies();
        modelAndView.addObject("pharmacy",pharmacy);
        return modelAndView;
    }
    @PostMapping(path = "/update/{pharmacyId}")
    public RedirectView updatePharmacy(
            @PathVariable("pharmacyId") Long pharmacyId,
            @ModelAttribute Pharmacies pharmacy) {
        pharmaciesService.updatePharmacy(pharmacyId, pharmacy.getName(), pharmacy.getEst_year());
        RedirectView redirectView=new RedirectView();
        redirectView.setUrl("http://localhost:8181/api/v1/Pharmacies");
        return redirectView;
    }
}