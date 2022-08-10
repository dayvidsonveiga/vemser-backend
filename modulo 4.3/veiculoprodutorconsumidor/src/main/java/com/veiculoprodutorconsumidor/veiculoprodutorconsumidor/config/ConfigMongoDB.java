package com.veiculoprodutorconsumidor.veiculoprodutorconsumidor.config;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.Document;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class ConfigMongoDB {

    String uri = "mongodb://root:root@localhost:27017/?authSource=admin&readPreference=primary&appname=MongoDB%20Compass&directConnection=true&ssl=false";
    MongoClient mongoClient = MongoClients.create(uri);

    MongoDatabase mongoDatabase = mongoClient.getDatabase("vemserdbc");

    MongoCollection<Document> veiculos = mongoDatabase.getCollection("veiculos");
}
