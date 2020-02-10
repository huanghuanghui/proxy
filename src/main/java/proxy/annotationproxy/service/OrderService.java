package proxy.annotationproxy.service;

import proxy.annotationproxy.Transaction;

/**
 * @auther hhh
 * @date 2020/2/9 15:21
 * @description
 */
public interface OrderService {




    @Transaction
    void save();
}
