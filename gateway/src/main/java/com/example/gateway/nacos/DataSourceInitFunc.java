package com.example.gateway.nacos;

import com.alibaba.csp.sentinel.datasource.ReadableDataSource;
import com.alibaba.csp.sentinel.datasource.nacos.NacosDataSource;
import com.alibaba.csp.sentinel.init.InitFunc;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

/**
 * @description: 限流规则持久化 - 推模式
 * @author: zhangshuai
 * @create: 2019-11-02 22:20
 */
public class DataSourceInitFunc implements InitFunc {

    @Override
    public void init() throws Exception {
        // nacos server ip
        final String remoteAddress = "localhost";
        // nacos group
        final String groupId = "DEFAULT_GROUP";
        // nacos dataId
        final String dataId = "gateway-flow-rules";
        // remoteAddress 代表 Nacos 服务端的地址
        // groupId 和 dataId 对应 Nacos 中相应配置
        ReadableDataSource<String, List<FlowRule>> flowRuleDataSource = new NacosDataSource<>(remoteAddress, groupId, dataId,
                source -> JSON.parseObject(source, new TypeReference<List<FlowRule>>() {}));
        FlowRuleManager.register2Property(flowRuleDataSource.getProperty());
    }
}
