package com.example.ssmdemo.service;

import org.elasticsearch.client.node.NodeClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * es示例
 *
 * @author cph
 * @date 2019/6/6
 */
public class QueryService {

    private static final Logger logger = LoggerFactory.getLogger(QueryService.class);


    private NodeClient nodeClient;


}
