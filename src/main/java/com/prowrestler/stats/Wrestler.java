package com.prowrestler.stats;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Wrestler {

    private Map<String,Integer> stats;
    private String name;

    public static final int NUM_STATS = 6;

    public Wrestler() {
        stats = new HashMap<>();
        stats.put("Looks", 0);
        stats.put("In-ring Ability", 0);
        stats.put("Finishing Move", 0);
        stats.put("Charisma", 0);
        stats.put("Mic Skills", 0);
        stats.put("Titles", 0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String,Integer> getStatMap() {
        //copying to prevent modification of original
        Map<String,Integer> currentMap = new HashMap<>();

        for (Map.Entry<String,Integer> current: stats.entrySet()) {
            currentMap.put(current.getKey(), current.getValue());
        }

        return currentMap;
    }

    public List<String> getStatTypes() {
        return new ArrayList<>(stats.keySet());
    }


}
