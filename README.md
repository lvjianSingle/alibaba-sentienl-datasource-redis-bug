# ���ڿͻ��˼���sentinel-datasource-redis�����������ͷ�����



> ### ����Ŀdemo������ʾ����bug��





- spring-cloud-alibaba�汾��2.2.5.RELEASE

- sentinel-dashboard�汾��1.8.0

- sentinel-datasource-redis�汾��1.8.0



## bug���ֳ���



- �ͻ���������`spring-cloud-starter-alibaba-sentinel`��`sentinel-datasource-redis`��������`spring.cloud.sentinel.datasource`����

  ```yaml
  spring:
    application:
      name: product
    cloud:
      sentinel:
        eager: true
        enabled: true
        transport:
          dashboard: 127.0.0.1:8080 # Sentinel ����̨��ַ
        filter:
          url-patterns: /** # ��������ĵ�ַ��Ĭ��Ϊ /*
        datasource:
          flow:
            redis:
              rule-type: FLOW
              host: 127.0.0.1
              port: 6379
              database: 0
              rule-key: sentinel:rules:flow:${spring.application.name}
              channel: sentinel:rules:flow:channel:${spring.application.name}
              master-id: sentinel:rules:flow:master-id:${spring.application.name}
  ```



- ����`spring-boot-starter-actuator` ������`endpoints`���ԣ���

```yaml
management:
  endpoints:
    web:
      exposure:
        include: '*'
  endpoint:
    health:
      show-details: always
```

- ����spring-boot-adminϵͳ

- `spring-cloud-starter-alibaba-sentinel`����`SentinelEndpointAutoConfiguration`��������Ч

  ÿ�λ�ȡ�˵���Ϣʱ��`SentinelHealthIndicator`��ȥ��ȡRedis�еĹ������ݣ��ڻ�ȡ������֮�� Redis�����������������رգ�**��������ʱ������������������ȫ������������ ����Redis���񲻿���**��

![image-20210309002750443](./doc/images/image-20210309002750443.png)





## ��demo��Ŀʹ��

1������eureka

2������sentinel-dashboard��sentinel-dashboard����ʹ��Redis���и��죬Ĭ��redis����Ϊ127.0.0.1:6379�����ձ����Լ���Redis�������ü��ɡ�

3������spring-boot-admin

4������order-demo��product-demo

5������Redis�����ʹ��`info clients`����۲���������
