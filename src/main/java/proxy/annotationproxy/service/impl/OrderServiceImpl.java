package proxy.annotationproxy.service.impl;

import proxy.annotationproxy.Transaction;
import proxy.annotationproxy.service.OrderService;

/**
 * @auther hhh
 * @date 2020/2/9 15:21
 * @description
 */
public class OrderServiceImpl implements OrderService {

    @Override
    @Transaction
    public void save() {
        System.out.println("order service save");
    }
}
