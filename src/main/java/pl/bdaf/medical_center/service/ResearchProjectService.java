package pl.bdaf.medical_center.service;

import pl.bdaf.medical_center.entity.ResearchProject;

import java.util.List;

public interface ResearchProjectService {
    List<ResearchProject> getAllProjects();

    ResearchProject getProjectById(Long aProjectId);

    ResearchProject saveProject(ResearchProject aProject);

    ResearchProject updateProjectById(Long aProjectId, ResearchProject aProject);

    void deleteProjectById(Long aProjectId);
}
