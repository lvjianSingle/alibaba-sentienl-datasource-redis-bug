package com.alibaba.csp.sentinel.dashboard.rule.redis;

import com.alibaba.csp.sentinel.dashboard.datasource.entity.rule.FlowRuleEntity;
import com.alibaba.csp.sentinel.dashboard.rule.DynamicRuleProvider;
import com.alibaba.csp.sentinel.datasource.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static com.alibaba.csp.sentinel.dashboard.rule.redis.SentinelRedisRuleConstant.RULE_FLOW_PREFIX;

/**
 * Title: FlowRuleRedisProviderImpl
 * Description: FlowRuleRedisProviderImpl
 *
 * @author lvjian
 * @version 1.0.0
 * @date 2021/3/8 18:52
 */
@Service("flowRuleRedisProvider")
public class FlowRuleRedisProviderImpl implements DynamicRuleProvider<List<FlowRuleEntity>> {

    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private Converter<String, List<FlowRuleEntity>> converter;


    @Override
    public List<FlowRuleEntity> getRules(String appName) throws Exception {
        String s = redisTemplate.opsForValue().get(RULE_FLOW_PREFIX + appName);
        if (StringUtils.isEmpty(s)) {
            return new ArrayList<>();
        }
        return converter.convert(s);
    }

}
