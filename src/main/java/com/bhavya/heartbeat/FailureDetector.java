package com.bhavya.heartbeat;

import static src.com.bhavya.heartbeat.Constants.*;

public class FailureDetector {

    public void detectSuspectedNodes(MembershipList memberShipList) {
        long currentTime = System.currentTimeMillis();

        for (MemberInfo member: memberShipList.getMembers()) {
            if (!member.getStatus().equals(Status.ALIVE)) {
                continue;
            }

            if (member.getLastTimestamp() < currentTime - (SUSPICION_THRESHOLD_BEATS * PROTOCOL_PERIOD)) {
                member.setStatus(Status.SUSPECTED);
            }
        }
    }

    public void removeDeadNodes(MembershipList memberShipList) {
        long currentTime = System.currentTimeMillis();

        for (MemberInfo member: memberShipList.getMembers()) {
            if (!member.getStatus().equals(Status.SUSPECTED)) continue;

            if (member.getLastTimestamp() < currentTime - (FAILURE_THRESHOLD_BEATS * PROTOCOL_PERIOD)) {
                memberShipList.deleteMember(member.getId());
            }
        }
    }
}
