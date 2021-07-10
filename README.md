# spring-cloud-microservices-weather
# 基于SpringCloud的微服务天气预报系统

- 该项目最初是initializar-start这个单体结构构成的，但是为了提高程序的性能，用微服务架构逐步拆分成7个模块，
- micro-weather-config-client：Spring Cloud Config Client，配置中心客户端
- micro-weather-config-server：Spring Cloud Config Server，配置中心服务器
- micro-weather-eureka-server：Eureka服务注册中心
- msa-weather-city-eureka：城市数据微服务
- msa-weather-collection-server：定时刷新城市天气预报数据缓存到Redis的微服务
- msa-weather-data-eureka：根据城市id和名称提供天气预报数据的微服务
- msa-weather-report-eureka-feign-gateway-hystrix：提供从天气预报查询界面的微服务
- 该项目使用了Redis（内存缓存），Eureka（服务注册），Feign（负载均衡），Zuul（网关服务），Hystrix（熔断器）等技术。
