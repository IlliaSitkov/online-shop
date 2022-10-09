package com.example.onlineshop.services.implementations;

import com.example.onlineshop.exceptions.order.NoOrderWithSuchCustomerEmailException;
import com.example.onlineshop.exceptions.order.NoOrderWithSuchIdException;
import com.example.onlineshop.mapstruct.dtos.filterBoundsDtos.OrderFilterBoundsDto;
import com.example.onlineshop.mapstruct.dtos.order.OrderPostDto;
import com.example.onlineshop.models.Customer;
import com.example.onlineshop.models.Order;
import com.example.onlineshop.models.OrderStatus;
import com.example.onlineshop.models.Salesman;
import com.example.onlineshop.repositories.OrderFilterRepository;
import com.example.onlineshop.repositories.OrderRepository;
import com.example.onlineshop.repositories.queryinterfaces.MinMaxValues;
import com.example.onlineshop.services.interfaces.CustomerService;
import com.example.onlineshop.services.interfaces.OrderService;
import com.example.onlineshop.services.interfaces.SalesmanService;
import com.example.onlineshop.utils.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CustomerService customerService;

    @Autowired
    private SalesmanService salesmanService;

    @Autowired
    private OrderFilterRepository orderFilterRepository;

    @Autowired
    private Utils utils;

    @Override
    public OrderFilterBoundsDto getOrderFilterBounds(Long customerId, Long salesmanId) {
        MinMaxValues minMaxProdNum = orderRepository.getMinMaxProdNameNumber(customerId,salesmanId);
        MinMaxValues minMaxCost = orderRepository.getMinMaxCost(customerId,salesmanId);
        MinMaxValues minMaxCatNum = orderRepository.getMinMaxCategoryNumber(customerId,salesmanId);

        OrderFilterBoundsDto dto = new OrderFilterBoundsDto();

        dto.setMinProdNum((int)minMaxProdNum.getMinValue());
        dto.setMaxProdNum((int)minMaxProdNum.getMaxValue());

        dto.setMinCost(minMaxCost.getMinValue());
        dto.setMaxCost(minMaxCost.getMaxValue());

        dto.setMinCatNum((int)minMaxCatNum.getMinValue());
        dto.setMaxCatNum((int)minMaxCatNum.getMaxValue());

        return dto;
    }

    @Override
    public Iterable<Order> getFilteredOrders(List<String> statuses,
                                             int prodNameNum,
                                             int categNum,
                                             double orderCost,
                                             String date,
                                             boolean dateFilterEnabled,
                                             long salesmanId,
                                             long customerId,
                                             long providerIdBad,
                                             long orderId,
                                             long providerId,
                                             int prodNumK) {
        return orderFilterRepository.filterOrders(statuses,prodNameNum,categNum,orderCost,date,dateFilterEnabled,salesmanId,customerId,providerIdBad,orderId,providerId,prodNumK);
    }

    @Override
    public Iterable<Order> findAll() {
        return orderRepository.getAll();
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(() ->  new NoOrderWithSuchIdException(id));
    }

    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public Order findByCustomerEmail(String email) {
        System.out.println(email);
        Order o = orderRepository.getByCustomerEmail(email);
        if (o == null) throw new NoOrderWithSuchCustomerEmailException(email);
        return o;
    }

    @Override
    public Order buyOrder(Long orderId) {
        Order order = orderRepository.findById(orderId).orElseThrow(() ->  new NoOrderWithSuchIdException(orderId));
        order.setStatus(OrderStatus.IN_PROGRESS);
        order.setDate(utils.getCurrentDate());
        return orderRepository.save(order);
    }

    @Override
    public Order save(OrderPostDto orderPostDto) {

        Order o = new Order();
        Customer customer = customerService.findById(orderPostDto.getCustomerId());

        o.setDate(utils.getCurrentDate());
        o.setCustomer(customer);
        o.setStatus(OrderStatus.NEW);

        return orderRepository.save(o);
    }

    @Override
    public Order markOrderAsDone(Long orderId, Long salesmanId) {

        Order o = orderRepository.findById(orderId).orElseThrow(() -> new NoOrderWithSuchIdException(orderId));

        Salesman s = salesmanService.findById(salesmanId);

        o.setStatus(OrderStatus.DONE);
        o.setDate(utils.getCurrentDate());
        o.setSalesman(s);

        return orderRepository.save(o);
    }










}
