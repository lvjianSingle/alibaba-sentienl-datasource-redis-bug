package com.alibaba.csp.sentinel.dashboard.rule.redis;

/**
 * Title: SentinelRedisRuleConstant
 * Description: SentinelRedisRuleConstant
 *
 * @author lvjian
 * @version 1.0.0
 * @date 2021/3/8 19:00
 */
public class SentinelRedisRuleConstant {

    /**
     * 前缀
     */
    public static final String SENTINEL_ROLE_PREFIX = "sentinel:rules:";

    /**
     * flow rule
     */
    public static final String RULE_FLOW_PREFIX = SENTINEL_ROLE_PREFIX + "flow:";
    /**
     * flow rule channel
     */
    public static final String RULE_FLOW_CHANNEL_PREFIX = RULE_FLOW_PREFIX + "channel:";


}
