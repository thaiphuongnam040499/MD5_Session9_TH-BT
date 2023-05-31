package rikkei.academy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import rikkei.academy.model.Cart;
import rikkei.academy.model.Order;
import rikkei.academy.model.Product;
import rikkei.academy.service.order.IOrderService;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @PostMapping("/addOrder")
    public String add(@SessionAttribute("cart") Cart cart) {
        Map<Product, Integer> products = cart.getProducts();
        for (Map.Entry<Product, Integer> p : products.entrySet()) {
            Order o = new Order();
            o.setPrice(p.getKey().getPrice());
            o.setProduct(p.getKey());
            o.setQuantity(p.getValue());
            orderService.save(o);
        }
        return "/order";
    }
}
