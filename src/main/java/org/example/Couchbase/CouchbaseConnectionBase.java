package org.example.Couchbase;

import com.couchbase.client.java.Bucket;
import com.couchbase.client.java.Cluster;

import java.time.Duration;

public class CouchbaseConnectionBase {
    private static Bucket bucket;
    private static Cluster cluster;
    static String connectionString = "couchbase://127.0.0.1";
    static String username = "admin";
    static String password = "adminadmin";

    public static Bucket getBucket(String bucketName){
        cluster = Cluster.connect(connectionString,username,password);
        bucket = cluster.bucket(bucketName);

        return bucket;
    }

    public static void Close(){
        if(cluster != null)
            cluster.close();
    }
}
