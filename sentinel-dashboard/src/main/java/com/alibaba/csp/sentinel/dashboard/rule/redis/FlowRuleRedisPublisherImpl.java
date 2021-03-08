package com.alibaba.csp.sentinel.dashboard.rule.redis;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRulePublisher;
import com.alibaba.csp.sentinel.datasource.Converter;
import com.alibaba.csp.sentinel.util.AssertUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

import static com.alibaba.csp.sentinel.dashboard.rule.redis.SentinelRedisRuleConstant.RULE_FLOW_CHANNEL_PREFIX;
import static com.alibaba.csp.sentinel.dashboard.rule.redis.SentinelRedisRuleConstant.RULE_FLOW_PREFIX;

/**
 * Title: FlowRuleRedisPublisherImpl
 * Description: FlowRuleRedisPublisherImpl
 *
 * @author lvjian
 * @version 1.0.0
 * @date 2021/3/8 18:53
 */
@Service("flowRuleRedisPublisher")
public class FlowRuleRedisPublisherImpl implements DynamicRulePublisher<List<FlowRuleEntity>> {

    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private Converter<List<FlowRuleEntity>, String> converter;



    @Override
    public void publish(String app, List<FlowRuleEntity> rules) throws Exception {
        AssertUtil.notEmpty(app, "app name cannot be empty");
        if (rules == null) {
            return;
        }

        byte[] bytes = Objects.requireNonNull(converter.convert(rules)).getBytes();

        RedisConnection connection = redisTemplate.getRequiredConnectionFactory().getConnection();
        connection.multi();
        connection.set((RULE_FLOW_PREFIX + app).getBytes(), bytes);
        connection.publish((RULE_FLOW_CHANNEL_PREFIX + app).getBytes(), bytes);
        connection.exec();
    }

}
