package com.example.onlineshop.repositories;

import com.example.onlineshop.models.ProductInOrder;
import com.example.onlineshop.models.ProductInOrderId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductInOrderRepository extends JpaRepository<ProductInOrder, ProductInOrderId> {

    @Query(value =
            "SELECT * " +
            "FROM product_in_order " +
            "WHERE order_id = :orderId AND product_articul = :productArticul",nativeQuery = true)
    ProductInOrder getProductInOrderById(@Param("orderId") Long orderId,@Param("productArticul") Long productId);


}
