package main;

import java.util.*;
import java.util.stream.Collectors;

public class RallyRaceResult implements RaceResult {
    private String raceName;
    private String location;
    private Map<Driver, Integer> results = new HashMap<>();

    public RallyRaceResult(String raceName, String location) {
        this.raceName = raceName;
        this.location = location;
    }

    public String getRaceName() {
        return raceName;
    }

    public String getLocation() {
        return location;
    }

    @Override
    public void recordResult(Driver driver, int points) {
        results.put(driver, points);
    }

    @Override
    public int getDriverPoints(Driver driver) {
        return results.getOrDefault(driver, 0);
    }

    @Override
    public List<Driver> getResults() {
        return results.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}


