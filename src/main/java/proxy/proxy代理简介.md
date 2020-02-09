# 代理

面向对象设计原则：对扩展开放，对修改关闭。代理模式：公共了对类的另外的访问方式，通过代理对象访问目标对象。代理可以在不改变当前对象的情况下，增加其他额外的功能。

```sequence
Client目标客户端类->Subject公共接口: 访问代理对象
Proxy代理类->Subject公共接口:实现Subject公共接口
note left of Subject公共接口:+request():String
note left of Proxy代理类:+request():String
note left of RealSubject委托类:+request():String...
RealSubject委托类->Subject公共接口:实现Subject公共接口
```

客户端类访问目标对象时，通过访问代理间接的访问目标对象 ，代理中提供的方法其实就是目标类中的方法+扩展。Proxy与RealSubject实现公共Subject接口

举例理解代理：假设我们想邀请以为明星（被代理对象）驻场，我们无法直接获取明星的联系方式，无法邀请，这时候我们可以联系明星的经纪人，经理人就是明星的代理，经济人（代理对象）为为明星安排出行计划等等其他情况（增加被代理对象的额外功能）

