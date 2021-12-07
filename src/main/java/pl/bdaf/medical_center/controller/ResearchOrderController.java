package pl.bdaf.medical_center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @PostMapping
    public ResearchOrder saveOrder(@RequestBody ResearchOrder aOrder){
        return researchOrderService.saveOrder(aOrder);
    }

}
