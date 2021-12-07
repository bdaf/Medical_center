package pl.bdaf.medical_center.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.bdaf.medical_center.entity.Consent;
import pl.bdaf.medical_center.entity.ResearchOrder;
import pl.bdaf.medical_center.repository.ResearchOrderRepository;

import java.util.ArrayList;
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
        Consent consentToAddOrderIn = consentService.getConsentById(aConsentId);

        // return null if we can't get to any consent
        if(consentToAddOrderIn == null) return null;

        // save order only if patient is connected to project
        if(consentToAddOrderIn.getIsConnected()) {
            consentToAddOrderIn.addOrder(researchOrderRepository.save(aOrder));
            return consentService.saveConsent(consentToAddOrderIn);
        }
        return null;
    }
    /*
        Category categoryToAddDiscountIn = categoryService.findById(aCategoryId);

        if(aDiscount.getPercent() >= 1) aDiscount.setPercent(0.99F);
        if(aDiscount.getPercent() <= 0) aDiscount.setPercent(0.01F);

        categoryToAddDiscountIn.addDiscount(discountRepository.save(aDiscount));

        return categoryService.saveCategory(categoryToAddDiscountIn);
     */


    public ResearchOrder saveOrder(ResearchOrder aOrder){
        return researchOrderRepository.save(aOrder);
    }
}
