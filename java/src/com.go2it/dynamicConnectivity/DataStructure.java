package dynamicConnectivity;

import java.util.List;

public interface DataStructure {
    int root(int i);

    boolean areConnected(int i1, int i2);

    List<Integer> findComponent(int i1, int i2);

    int count();
}
