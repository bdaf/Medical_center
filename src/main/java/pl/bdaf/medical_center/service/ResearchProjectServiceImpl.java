package pl.bdaf.medical_center.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bdaf.medical_center.entity.ResearchProject;
import pl.bdaf.medical_center.repository.ResearchProjectRepository;

import java.util.List;

@Service
public class ResearchProjectServiceImpl implements ResearchProjectService{

    @Autowired
    private ResearchProjectRepository researchProjectRepository;

    @Override
    public List<ResearchProject> getAllProjects() {
        return researchProjectRepository.findAll();
    }

    @Override
    public ResearchProject getProjectById(Long aProjectId) {
        return researchProjectRepository.findById(aProjectId).get();
    }

    @Override
    public ResearchProject saveProject(ResearchProject aProject) {
        return researchProjectRepository.save(aProject);
    }

    @Override
    public ResearchProject updateProjectById(Long aProjectId, ResearchProject aProjectFromRequest) {
        ResearchProject resultProject = researchProjectRepository.findById(aProjectId).get();

        if(resultProject == null) return null;

        if(aProjectFromRequest.getDisease() != null && !aProjectFromRequest.getDisease().equalsIgnoreCase(""))
            resultProject.setDisease(aProjectFromRequest.getDisease());

        return researchProjectRepository.save(resultProject);
    }

    @Override
    public void deleteProjectById(Long aProjectId) {
        researchProjectRepository.deleteById(aProjectId);
    }
}
