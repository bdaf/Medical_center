package pl.bdaf.medical_center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.bdaf.medical_center.entity.Consent;
import pl.bdaf.medical_center.service.ConsentService;

import java.util.List;

@RestController
@RequestMapping("/api/consents")
public class ConsentController {

    @Autowired
    private ConsentService consentService;

    @GetMapping
    public List<Consent> getAllConsents(){
        return consentService.getAllConsents();
    }

    @GetMapping("/{id}")
    public Consent getAllConsents(@PathVariable("id") Long aConsentId){
        return consentService.getConsentById(aConsentId);
    }

    @PostMapping
    public Consent saveConsent(@RequestBody Consent aConsent){
        return consentService.saveConsent(aConsent);
    }

    @DeleteMapping("/{id}")
    public String deleteConsentById(@PathVariable("id") Long aConsentId){
        consentService.deleteById(aConsentId);
        return "Consent with Id "+ aConsentId + " has been deleted successfully.";
    }
}
