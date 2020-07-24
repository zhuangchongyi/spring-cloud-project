### spring cloud 技术组成
- spring cloud
  - eureka 
    - 微服务治理，服务注册和发现
  - ribbon 
    - 负载均衡、请求重试
  - hystrix 
    - 断路器，服务降级、熔断
  - feign 
    - ribbon + hystrix 集成，并提供生命式客户端
  - hystrix dashboard 和 turbine 
    - hystrix 微服务监控
  - zuul
    - API 网关，提供微服务的统一入口，并提供统一的权限验证
  - config
    - 配置中心
  -bus
    - 配置更新消息总线
  - sleuth
    - 链路追踪

### 项目组成模块
- spring-cloud-project
    - sc1-common 公共代码项目
    - sc2-item-service 商品服务提供者
    - sc3-user-service 用户服务提供者
    - sc4-order-service 订单服务提供者
    - sc5-eureka 服务注册和发现
    - sc6-ribbon 服务消费者
    - sc7-hystrix 断路器
    - sc8-hystrix-dashboard hystrix监控仪表盘
    - sc9-feign 代替 hystrix+ribbon,提供了声明式消费者客户端
    - sc10-turbine 汇集监控信息，将聚合后的信息提供给hystrix-dashboard来集中展示和监控
    - sc11-zuul  Zuul API网关，为微服务应用提供统一的对外访问接口
    
    


> 修改hosts文件
```
C:\Windows\System32\drivers\etc\hosts
# 添加内容：
127.0.0.1       eureka1
127.0.0.1       eureka2
```