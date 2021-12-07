package pl.bdaf.medical_center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.bdaf.medical_center.entity.LaboratoryResult;
import pl.bdaf.medical_center.service.LaboratoryResultsService;

import java.util.List;

@RestController
@RequestMapping("/api/results")
public class LaboratoryResultsController {

    @Autowired
    private LaboratoryResultsService laboratoryResultsService;

    @GetMapping
    public List<LaboratoryResult> getAllResults(){
        return laboratoryResultsService.getAllResults();
    }

    @GetMapping("/{id}")
    public LaboratoryResult getResultById(@PathVariable("id") Long aResultId){
        return laboratoryResultsService.getResultById(aResultId);
    }

    @PostMapping("/{id}")
    public LaboratoryResult saveResult(@PathVariable("id") Long aOrderId, @RequestBody LaboratoryResult aResult){
        return laboratoryResultsService.saveResult(aOrderId, aResult);
    }

    @PutMapping("/{id}")
    public LaboratoryResult updateResultById(@PathVariable("id") Long aResultId, @RequestBody String aResult){
        return laboratoryResultsService.updateResultById(aResultId, aResult);
    }

    @DeleteMapping("/{id}")
    public String deleteResultById(@PathVariable("id") Long aResultId){
        laboratoryResultsService.deleteResultById(aResultId);
        return "Result with Id "+ aResultId + " has been deleted successfully.";
    }
}
