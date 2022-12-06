package com.bhavya.heartbeat;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;

public class HeartbeatServer {
    private final String id;
    private final MembershipList memberList;

    private final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    private ScheduledFuture<?> heartbeatScheduler;

    public HeartbeatServer(String id) {
        this.id = id;
        this.memberList = new MembershipList();
    }

    public List<MemberInfo> members() {
        return memberList.getMembers();
    }

    public void receiveHeartbeat(HeartbeatUpdateRequest request) {
        memberList.update(request);
    }
}
