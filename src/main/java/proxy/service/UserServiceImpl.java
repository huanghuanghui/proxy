package proxy.service;

import proxy.annotationproxy.Transaction;

/**
 * @auther hhh
 * @date 2020/2/8 23:39
 * @description
 */
public class UserServiceImpl implements UserService {


    @Override
    @Transaction
    public void save() {
        System.out.println("模拟保存数据接口");
    }
}
