package com.example.ssmdemo.helloworld.es;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.transport.TransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;

/**
 * @author cph
 * @date 2019/6/10
 */
public class ESService {

    private static final Logger logger = LoggerFactory.getLogger(ESService.class);

    @Autowired
    TransportClient transportClient;

    //create
    public void create() throws IOException {
        IndexResponse indexResponse = transportClient.prepareIndex("twitter", "tweet", "1")
                .setSource(jsonBuilder()
                    .startObject()
                    .field("user", "aaa")
                    .field("age", "28")
                    .field("message", "es test")
                    .endObject())
                .get();
    }

    //delete
    public void delete(){
        DeleteResponse deleteResponse = transportClient.prepareDelete("twitter", "tweet", "1").get();
    }

    //update
    public void update() throws IOException, InterruptedException, ExecutionException {
        UpdateRequest updateRequest = new UpdateRequest();
        updateRequest.index("twitter");
        updateRequest.type("tweet");
        updateRequest.id("1");
        updateRequest.doc(jsonBuilder()
            .startObject()
            .field("user", "bbb")
            .endObject());
        transportClient.update(updateRequest).get();
    }

    //retrieve

}
