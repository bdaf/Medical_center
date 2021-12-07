package pl.bdaf.medical_center.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bdaf.medical_center.entity.LaboratoryResult;
import pl.bdaf.medical_center.entity.ResearchOrder;
import pl.bdaf.medical_center.repository.LaboratoryResultsRepository;

import java.util.List;

@Service
public class LaboratoryResultsServiceImpl implements LaboratoryResultsService {

    @Autowired
    private LaboratoryResultsRepository laboratoryResultsRepository;

    @Autowired
    private ResearchOrderService researchOrderService;

    @Override
    public List<LaboratoryResult> getAllResults() {
        return laboratoryResultsRepository.findAll();
    }

    @Override
    public LaboratoryResult getResultById(Long aResultId) {
        return laboratoryResultsRepository.findById(aResultId).get();
    }

    @Override
    public ResearchOrder addResult(Long aOrderId, LaboratoryResult aResult) {
        // get order by id
        ResearchOrder order = researchOrderService.getOrderById(aOrderId);

        // return null if we can't get to any order
        if (order == null) return null;

        // save result in order
        LaboratoryResult result = laboratoryResultsRepository.save(aResult);
        order.addResult(result);
        return researchOrderService.saveOrder(order);

    }

    @Override
    public LaboratoryResult updateResultById(Long aResultId, String aResultStringFromRequest) {
        // get result by id
        LaboratoryResult result = laboratoryResultsRepository.findById(aResultId).get();

        // if there is no result with that ID return null
        if (result == null) return null;

        // update result by string from request if it's not empty
        if (aResultStringFromRequest != null || !aResultStringFromRequest.equalsIgnoreCase(""))
            result.setResult(aResultStringFromRequest);

        return laboratoryResultsRepository.save(result);
    }

    @Override
    public void deleteResultById(Long aResultId) {
        laboratoryResultsRepository.deleteById(aResultId);
    }
}
