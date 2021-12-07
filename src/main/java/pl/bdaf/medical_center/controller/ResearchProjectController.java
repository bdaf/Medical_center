package pl.bdaf.medical_center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.bdaf.medical_center.entity.ResearchProject;
import pl.bdaf.medical_center.service.ResearchProjectService;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ResearchProjectController {

    @Autowired
    private ResearchProjectService researchProjectService;

    @GetMapping
    public List<ResearchProject> getAllProjects(){
        return researchProjectService.getAllProjects();
    }

    @GetMapping("/{id}")
    public ResearchProject getProjectById(@PathVariable("id") Long aProjectId){
        return researchProjectService.getProjectById(aProjectId);
    }

    @PostMapping
    public ResearchProject saveProject(@RequestBody ResearchProject aProject){
        return researchProjectService.saveProject(aProject);
    }

    @PutMapping("/{id}")
    public ResearchProject updateProjectById(@PathVariable("id") Long aProjectId, @RequestBody ResearchProject aProject){
        return researchProjectService.updateProjectById(aProjectId, aProject);
    }

    @DeleteMapping("/{id}")
    public String deleteProjectById(@PathVariable("id") Long aProjectId){
        researchProjectService.deleteProjectById(aProjectId);
        return "Research Project with Id "+ aProjectId + " has been deleted successfully.";
    }
}
