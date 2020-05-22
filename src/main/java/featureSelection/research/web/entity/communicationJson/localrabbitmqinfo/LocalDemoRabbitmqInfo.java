package featureSelection.research.web.entity.communicationJson.localrabbitmqinfo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName : LocalRabbitmqInfo
 * @Description : 本地rabbitmq信息
 * @Author : WDD
 * @Date: 2020-05-19 20:50
 */
@Component
public class LocalDemoRabbitmqInfo implements LocalRabbitmqInfo {
    @Value(value ="${spring.rabbitmq.host}")
    private String host;
    @Value(value ="${spring.rabbitmq.port}")
    private int port;
    @Value(value ="${spring.rabbitmq.username}")
    private String username;
    @Value(value ="${spring.rabbitmq.password}")
    private String password;
    private String exchange="resultReciverExchange";
    private String routingkey="demoResultReciverRoutingkey";

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getRoutingkey() {
        return routingkey;
    }

    public void setRoutingkey(String routingkey) {
        this.routingkey = routingkey;
    }

    @Override
    public String toString() {
        return "LocalDemoRabbitmqInfo{" +
                "host='" + host + '\'' +
                ", port='" + port + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", exchange='" + exchange + '\'' +
                ", routingkey='" + routingkey + '\'' +
                '}';
    }
}
