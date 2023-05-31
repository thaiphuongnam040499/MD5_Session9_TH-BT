package rikkei.academy.repository;

import org.springframework.data.repository.CrudRepository;
import rikkei.academy.model.Order;

public interface IOrderRepository extends CrudRepository<Order,Long> {

}
