package proxy.staticproxy;


import proxy.service.UserService;

/**
 * @auther hhh
 * @date 2020/2/8 23:40
 * @description 代理类与委托类都需要实现相同接口，还需添加对委托类的引用
 * 对目标方法进行扩展
 */
public class StaticUserProxy implements UserService {
    //目标对象的引用
    private UserService target;

    //在加载对象的时候对数据进行初始化
    public StaticUserProxy(UserService target) {
        super();
        this.target = target;
    }

    //代理在不改动类的情况下，对类进行扩展
    @Override
    public void save() {
        //模拟对被代理类的实物操作
        System.out.println("开启事务");
        //具体业务方法实现
        target.save();
        System.out.println("结束事务");

    }
}
