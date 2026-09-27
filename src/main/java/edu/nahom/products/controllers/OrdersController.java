package edu.nahom.products.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import edu.nahom.products.data.OrdersDataService;
import edu.nahom.products.models.OrderModel;

@Controller
public class OrdersController {

    @Autowired
    private OrdersDataService ordersDataService;

    @GetMapping("/orders")
    public String showAllOrders(Model model) {
        model.addAttribute("title", "All Orders");
        model.addAttribute("orders", ordersDataService.getAll());

        return "allOrders";
    }
    @GetMapping("/orders/showOrder/{id}")
public String showOneOrder(@PathVariable int id, Model model) {
    model.addAttribute("title", "Show One Order");
    model.addAttribute("order", ordersDataService.getById(id));

    return "oneOrder";
}
@GetMapping("/orders/editOrder/{id}")
public String editOrder(@PathVariable int id, Model model) {
    model.addAttribute("title", "Edit Order");
    model.addAttribute("order", ordersDataService.getById(id));

    return "editOrder";
}

@PostMapping("/orders/processEditOrder")
public String processEditOrder(@ModelAttribute OrderModel order) {
    ordersDataService.update(order);

    return "redirect:/orders";
}
@GetMapping("/orders/newOrder")
public String newOrder(Model model) {
    model.addAttribute("title", "New Order");
    model.addAttribute("order", new OrderModel());

    return "newOrder";
}

@PostMapping("/orders/processNewOrder")
public String processNewOrder(@ModelAttribute OrderModel order) {
    ordersDataService.create(order);

    return "redirect:/orders";
}
@GetMapping("/orders/deleteOrder/{id}")
public String deleteOrder(@PathVariable int id) {
    ordersDataService.deleteById(id);

    return "redirect:/orders";
}
}