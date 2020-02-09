package proxy.dynamicproxy.jdkdynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @auther hhh
 * @date 2020/2/9 0:12
 * @description
 */
public class ProxyFactory {
    private Object target;

    public ProxyFactory(Object target) {
        super();
        this.target = target;
    }

    public Object getProxyInstance() {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), target.getClass().getInterfaces(), new InvocationHandler() {
            /**
             *
             * @param proxy 代理對象
             * @param method 目標對象方法
             * @param args 目标对象参数
             * @return
             * @throws Throwable
             */
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("事务开始");
                //调用目标对象方法
                Object result = method.invoke(target, args);
                System.out.println("事务结束");
                return result;
            }
        });
    }
}
