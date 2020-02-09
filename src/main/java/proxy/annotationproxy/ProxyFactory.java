package proxy.annotationproxy;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @auther hhh
 * @date 2020/2/9 15:00
 * @description
 */
public class ProxyFactory implements MethodInterceptor {

    //目标对象
    private Object target;

    private static int i = 0;

    /**
     * 在构造中完成目标对象的初始化
     *
     * @param target
     */
    public ProxyFactory(Object target) {
        super();
        this.target = target;
    }


    /**
     * 得到方法的代理对象
     *
     * @return
     */
    public Object getProxyInstance() {
        //创建实例
        Enhancer enhancer = new Enhancer();
        //设置父类为被代理的类（在内存中动态构建）
        enhancer.setSuperclass(target.getClass());
        //设置回调函数
        enhancer.setCallback(this);
        //将产生的代理对象返回
        return enhancer.create();
    }

    /**
     * 由于性能原因，我们使用 Cglib的@link net.sf.cglib.proxy.MethodProxy，而不是使用反射中的@link: java.lang.reflect.Method
     *
     * @param o           被代理对象
     * @param method      执行的方法
     * @param params      方法中的参数数组
     * @param methodProxy 代理的方法
     * @return
     * @throws Throwable
     */
    public Object intercept(Object o, Method method, Object[] params, MethodProxy methodProxy) throws Throwable {
        Object result = null;
        //开启AOP的功能
        if (method.isAnnotationPresent(Transaction.class)) {
            System.out.println("事务开始");
            System.out.println("拦截Transaction注解：" + i);
            //推荐使用methodProxy进行方法调用
            result = methodProxy.invokeSuper(o, params);
            System.out.println("事务结束");
        }
        i++;
        return result;
    }
}
