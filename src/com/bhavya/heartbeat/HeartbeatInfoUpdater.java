package src.com.bhavya.heartbeat;

public class HeartbeatInfoUpdater {

    public void updateMemberInfoAndSync(MembershipList memberList, String serverId) {
        FailureDetector failureDetector = new FailureDetector();
        memberList.updateMemberHeartbeat(serverId);
        failureDetector.detectSuspectedNodes(memberList);
        failureDetector.removeDeadNodes(memberList);
    }
}
