package edu.nahom.products.data;

import org.springframework.data.repository.CrudRepository;
import edu.nahom.products.models.OrderEntity;

public interface OrdersRepository extends CrudRepository<OrderEntity, Integer> {
}
