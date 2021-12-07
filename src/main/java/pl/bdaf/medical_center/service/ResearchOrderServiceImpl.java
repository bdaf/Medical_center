package pl.bdaf.medical_center.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bdaf.medical_center.entity.Consent;
import pl.bdaf.medical_center.entity.ResearchOrder;
import pl.bdaf.medical_center.repository.ResearchOrderRepository;

import java.util.List;

@Service
public class ResearchOrderServiceImpl implements ResearchOrderService{

    @Autowired
    private ResearchOrderRepository researchOrderRepository;

    @Autowired
    private ConsentService consentService;

    @Override
    public List<ResearchOrder> getAllOrders() {
        return researchOrderRepository.findAll();
    }

    @Override
    public ResearchOrder getOrderById(Long aOrderId) {
        return researchOrderRepository.findById(aOrderId).get();
    }

    @Override
    public Consent addOrder(Long aConsentId, ResearchOrder aOrder) {
        // get consent by id
        Consent consent = consentService.getConsentById(aConsentId);

        // return null if we can't get to any consent
        if(consent == null) return null;

        // save order only if patient is connected to project
        if(consent.getIsConnected()) {
            researchOrderRepository.save(aOrder);
            consent.addOrder(aOrder);
            return consentService.saveConsent(consent);
        }
        return null;
    }

    public ResearchOrder saveOrder(ResearchOrder aOrder){
        return researchOrderRepository.save(aOrder);
    }
}
