package com.example.onlineshop.services.implementations;

import com.example.onlineshop.exceptions.product.NoProductWithSuchArticul;
import com.example.onlineshop.exceptions.productInOrder.InsufficientProductQuantityException;
import com.example.onlineshop.exceptions.productInOrder.NoProductInOrderWithSuchIdException;
import com.example.onlineshop.mapstruct.dtos.productInOrder.ProductInOrderPostDto;
import com.example.onlineshop.models.Order;
import com.example.onlineshop.models.Product;
import com.example.onlineshop.models.ProductInOrder;
import com.example.onlineshop.models.ProductInOrderId;
import com.example.onlineshop.repositories.ProductInOrderRepository;
import com.example.onlineshop.repositories.ProductRepository;
import com.example.onlineshop.services.interfaces.OrderService;
import com.example.onlineshop.services.interfaces.ProductInOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductInOrderServiceImpl implements ProductInOrderService {

    @Autowired
    private ProductInOrderRepository productInOrderRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OrderService orderService;


    @Override
    public ProductInOrder updateProductQuantityInOrder(Long orderId, Long productId, int quantity) {

        ProductInOrder productInOrder = productInOrderRepository.getProductInOrderById(orderId,productId);

        if (productInOrder == null) throw new NoProductInOrderWithSuchIdException(orderId,productId);

        int initialOrderQuantity = productInOrder.getQuantity();

        Product product = productInOrder.getProduct();
        product.setQuantity(product.getQuantity()+initialOrderQuantity);

        System.out.println("Order quant: "+quantity);
        System.out.println("Prod quant: "+product.getQuantity());

        if (quantity < 1 || product.getQuantity() < quantity) {
            throw new InsufficientProductQuantityException();
        }

        product.setQuantity(product.getQuantity()-quantity);

        productInOrder.setQuantity(quantity);

        productRepository.save(product);
        return productInOrderRepository.save(productInOrder);
    }

    @Override
    public void deleteById(Long orderId, Long productId) {
        ProductInOrder productInOrder = productInOrderRepository.getProductInOrderById(orderId,productId);

        Product product = productInOrder.getProduct();
        product.setQuantity(product.getQuantity()+productInOrder.getQuantity());

        productRepository.save(product);
        productInOrderRepository.deleteById(new ProductInOrderId(orderId,productId));
    }

    @Override
    public ProductInOrder save(ProductInOrderPostDto productInOrderPostDto) {

        Product p = productRepository.findById(productInOrderPostDto.getProductId()).orElseThrow(() -> new NoProductWithSuchArticul(productInOrderPostDto.getProductId()));

        Order o = orderService.findById(productInOrderPostDto.getOrderId());

        int quantity = productInOrderPostDto.getQuantity();

        if (quantity < 1 || p.getQuantity() < quantity) {
            throw new InsufficientProductQuantityException();
        }

        p.setQuantity(p.getQuantity()-quantity);

        ProductInOrder productInOrder = new ProductInOrder();
        productInOrder.setId(new ProductInOrderId(productInOrderPostDto.getOrderId(),productInOrderPostDto.getProductId()));
        productInOrder.setProduct(p);
        productInOrder.setOrder(o);
        productInOrder.setPrice(p.getPrice());

        productInOrder.setQuantity(quantity);
        return productInOrderRepository.save(productInOrder);
    }


}
