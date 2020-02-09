package proxy.dynamicproxy.jdkdynamicproxy;

import proxy.service.UserService;
import proxy.service.UserServiceImpl;

/**
 * @auther hhh
 * @date 2020/2/9 0:18
 * @description
 */
public class Test {
    public static void main(String[] args) {
        UserService target = new UserServiceImpl();
        UserService proxy = (UserService) new ProxyFactory(target).getProxyInstance();
        proxy.save();
    }
}
