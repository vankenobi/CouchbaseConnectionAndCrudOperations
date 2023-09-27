package org.example;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Collection;
import com.couchbase.client.java.kv.GetResult;
import org.example.Couchbase.CouchbaseConnectionBase;
import org.example.Model.User;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class Main {

    public static void main(String[] args) {

        Bucket bucket = CouchbaseConnectionBase.getBucket("users");
        Collection collection = bucket.scope("customer").collection("premium");

        get(collection);
        insert(collection);
        replace(collection);
        upsert(collection);
    }

    public static void insert(@NotNull Collection collection){
        // Insert a document as model to the collection
        User user = new User();
        user.setCustomerId("12367");
        user.setEmail("metgad@gmail.com");
        user.setFirstName("metgad");
        user.setLastName("Near");
        user.setMembershipLevel("premium");
        var result1 = collection.insert(UUID.randomUUID().toString(),user);
        System.out.println(result1);
    }

    public static void get(@NotNull Collection collection){
        // Get specific document with id from a collection
        GetResult result = collection.get("2");
        System.out.println(result.toString());
    }

    public static void replace(@NotNull Collection collection){
        // Replace the document with document of given id
        User user = new User();
        user.setCustomerId("12367");
        user.setEmail("olac@gmail.com");
        user.setFirstName("Olac");
        user.setLastName("Neartg");
        user.setMembershipLevel("premium");

        collection.replace("5fbc8803-728b-4d2f-8cdd-b1e9987c4836",user);
    }

    public static void upsert(@NotNull Collection collection){
        User user = new User();
        user.setCustomerId("12368");
        user.setEmail("updated@gmail.com");
        user.setFirstName("Updated");
        user.setLastName("gardles");
        user.setMembershipLevel("premium");

        collection.upsert("4",user);
    }
}