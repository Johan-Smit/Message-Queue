package com.turtleMQ.broker.services;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class ConfigService {

    @Autowired FileRWService fileRW;

    @Autowired NodeManagerService nodeManagerService;

    private JSONParser parser;

    private String configFilePath = "src/main/resources/broker.config.json";

    public ConfigService() {
        parser = new JSONParser();
    }

    public void initialize() {
        System.out.println("\n::::::::: Initializing NodeManager\n");
        try {
            File file = fileRW.read(configFilePath);
            JSONArray nodes = (JSONArray) parser.parse(new FileReader(file));
            
            for (Object o: nodes) {
                JSONObject obj = (JSONObject) o;

                String nodeID = (String) obj.get("nodeID");
                String location = (String) obj.get("location");
                int port = Integer.parseInt((String) obj.get("port"));
                JSONArray jsonTopics = (JSONArray) obj.get("topics");
                
                ArrayList<String> topics = new ArrayList<>();

                for (Object t: jsonTopics) {
                    for (String s: ((String) t).split(",")) {
                        topics.add(s);
                    }
                }

                System.out.println(nodeID + " parsed, registering...");

                nodeManagerService.register(nodeID, location, port, topics);
            }

            nodeManagerService.activate();

            System.out.println("\n::::::::: Initializing NodeManager: Success!\n");
        }
        catch(Exception e) {
            System.out.println("Error: " + e);
            System.out.println("\n::::::::: Initializing NodeManager: Failed!\n");
        }
    }
}
