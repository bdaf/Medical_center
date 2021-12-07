package pl.bdaf.medical_center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.bdaf.medical_center.entity.Consent;
import pl.bdaf.medical_center.entity.ResearchOrder;
import pl.bdaf.medical_center.service.ResearchOrderService;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class ResearchOrderController {

    @Autowired
    protected ResearchOrderService researchOrderService;

    @GetMapping
    public List<ResearchOrder> getAllOrders(){
        return researchOrderService.getAllOrders();
    }

    @GetMapping("/{id}")
    public ResearchOrder getOrderById(@PathVariable("id") Long aOrderId){
        return researchOrderService.getOrderById(aOrderId);
    }

    @PostMapping("/{id}")
    public Consent saveOrder(@PathVariable("id") Long aConsentId, @RequestBody ResearchOrder aOrder){
        return researchOrderService.addOrder(aConsentId, aOrder);
    }

}
