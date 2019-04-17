package com.xueyou.demo.leader;

import com.xueyou.demo.utils.zkUtils.CreateClient;
import com.xueyou.demo.utils.zkUtils.CuratorZkClientBridge;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.leader.LeaderSelector;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListener;
import org.apache.curator.framework.recipes.leader.LeaderSelectorListenerAdapter;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by wuxueyou on 2017/12/11.
 */
//@Component
public class SelectLeader {
    private static String connectionString = "localhost:2181";
    private static String ID = "2";

    public SelectLeader() {
        try {
            init();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void init() throws Exception {
        CuratorFramework curatorFramework = CreateClient.createSimple(connectionString);
        curatorFramework.start();
        //doSomething to zookeeper
        CuratorZkClientBridge curatorZkClientBridge = new CuratorZkClientBridge(curatorFramework);

//        System.out.println(getNode(curatorZkClientBridge, "/"));
        //master 选举
        LeaderSelectorListener listener = new LeaderSelectorListenerAdapter() {
            public void takeLeadership(CuratorFramework client) throws Exception {
                // this callback will get called when you are the leader
                // do whatever leader work you need to and only exit
                // this method when you want to relinquish leadership
                System.out.println("i am master" + "\t" + ID + "\t" + new SimpleDateFormat("HH:mm:ss").format(new Date()));
                Thread.sleep(Integer.MAX_VALUE);
            }
        };

        LeaderSelector selector = new LeaderSelector(curatorFramework, "/xytestleader/master", listener);
        selector.autoRequeue();  // not required, but this is behavior that you will probably expect
        selector.start();
    }


}
