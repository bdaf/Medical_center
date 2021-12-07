package pl.bdaf.medical_center.service;

import pl.bdaf.medical_center.entity.ResearchOrder;

import java.util.List;

public interface ResearchOrderService {
    List<ResearchOrder> getAllOrders();

    ResearchOrder getOrderById(Long aOrderId);

    ResearchOrder saveOrder(ResearchOrder aOrder);
}
