package com.go2it.dynamicConnectivity;

import java.util.List;

public interface DataStructure {
    boolean areConnected(int i1, int i2);

    List<Integer> findComponent(int i1, int i2);

    int count();
}
