package proxy.dynamicproxy.cglibdynamicproxy;


import proxy.service.UserService;
import proxy.service.UserServiceImpl;

/**
 * @auther hhh
 * @date 2020/2/9 0:55
 * @description
 */
public class Test {
    public static void main(String[] args) {
        UserServiceImpl target = new UserServiceImpl();
        //获取到代理对象
        UserServiceImpl proxy = (UserServiceImpl) new ProxyFactory(target).getProxyInstance();
        proxy.save();
    }
}
