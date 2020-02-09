package proxy.staticproxy;


import proxy.service.UserService;
import proxy.service.UserServiceImpl;

/**
 * @auther hhh
 * @date 2020/2/8 23:46
 * @description
 */
public class Test {
    public static void main(String[] args) {
        UserService target = new UserServiceImpl();
        UserService proxy = new StaticUserProxy(target);
        proxy.save();
    }
}
