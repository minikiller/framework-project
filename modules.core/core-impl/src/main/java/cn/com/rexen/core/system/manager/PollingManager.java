package cn.com.rexen.core.system.manager;

import cn.com.rexen.core.api.system.IPolling;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zangyanming on 2016/2/25.
 * 维护IPolling列表
 */
public class PollingManager {
    private static PollingManager install;
    //    private static Comparator<IPolling> COMPARATOR = new Comparator<IPolling>() {
//        // This is where the sorting happens.
//        public int compare(IPolling o1, IPolling o2) {
//            return o1.getIndex() - o2.getIndex();
//        }
//    };
    private List<IPolling> PollingList = new ArrayList<IPolling>();

    private PollingManager() {
    }

    public synchronized static PollingManager getInstall() {
        if (install == null) {
            install = new PollingManager();
        }
        return install;
    }

    public void add(IPolling Polling) {
        PollingList.add(Polling);
    }

    public void remove(IPolling Polling) {
        PollingList.remove(Polling);
    }

    public List<IPolling> getPollingList() {
        if (PollingList != null)
            ;//Collections.sort(PollingList, COMPARATOR);
        return PollingList;
    }
}
