package proxy.annotationproxy;


import org.springframework.cglib.proxy.Proxy;
import proxy.annotationproxy.service.OrderService;
import proxy.annotationproxy.service.impl.OrderServiceImpl;

/**
 * @auther hhh
 * @date 2020/2/9 15:09
 * @description
 */
public class Test {
    public static void main(String[] args) {
        ProxyFactory proxyHandler = new ProxyFactory(new OrderServiceImpl());
        Object object = proxyHandler.getProxyInstance();
        System.out.println(object instanceof Proxy);//
        System.out.println(object instanceof OrderService);
        System.out.println(object instanceof OrderServiceImpl); //不是目标类的子类
        for (int i = 0; i < 5; i++) {
            ((OrderServiceImpl) object).save();
        }
    }
}
