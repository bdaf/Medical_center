package pl.bdaf.medical_center.service;

import pl.bdaf.medical_center.entity.LaboratoryResult;
import pl.bdaf.medical_center.entity.ResearchOrder;

import java.util.List;

public interface LaboratoryResultsService {
    List<LaboratoryResult> getAllResults();

    LaboratoryResult getResultById(Long aResultId);

    ResearchOrder addResult(Long aOrderId, LaboratoryResult aResult);

    LaboratoryResult updateResultById(Long aResultId, String aResult);

    void deleteResultById(Long aResultId);
}
