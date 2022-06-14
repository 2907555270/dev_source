package order.controller;

import order.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.net.http.HttpClient;
import java.util.List;

@RestController
@RequestMapping("/order")
public class OrderController {

    /**
     * 参数id:
     *  通过订单系统，查询商品服务，根据id查询商品信息
     *      1.配置商品对象
     *      2.调用商品服务
     *    a. 使用java中的url connection，Httpclient,OkHttp调用远程服务
     *    b. Spring封装的RestTemplate：Restful风格
     */

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 注入DiscoveryClient
     *  springCloud 提供的获取元数据的工具类
     *  调用方法获取服务的元数据信息
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    //调用商品服务
    @GetMapping("/buy/{id}")
    public Product findById(@PathVariable Long id){
        //已调用服务名称获取所有的元数据
        List<ServiceInstance> instances = discoveryClient.getInstances("service-product");
        //获取唯一的一个元数据
        ServiceInstance instance = instances.get(0);
        //根据元数据中的主机地址和端口号拼接 微服务的url
        Product product = null;
        return restTemplate.getForObject("http://"+instance.getHost()+":"+instance.getPort()+"/product/"+id, Product.class);
    }
}
