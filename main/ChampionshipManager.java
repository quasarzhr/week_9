package main;

import java.util.*;

public class ChampionshipManager {
    private static ChampionshipManager instance;
    private List<Driver> drivers = new ArrayList<>();
    private List<RallyRaceResult> races = new ArrayList<>();
    private int totalDrivers;
    private int totalRaces;

    private ChampionshipManager() {}

    public static ChampionshipManager getInstance() {
        if (instance == null) {
            instance = new ChampionshipManager();
        }
        return instance;
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
        totalDrivers++;
    }

    public void addRaceResult(RallyRaceResult result) {
        races.add(result);
        totalRaces++;
    }

    public List<Driver> getDriverStandings() {
        drivers.sort(Comparator.comparingInt(Driver::getPoints).reversed());
        return drivers;
    }

    public Driver getLeadingDriver() {
        return drivers.isEmpty() ? null : drivers.get(0);
    }

    public int getTotalChampionshipPoints() {
        return drivers.stream().mapToInt(Driver::getPoints).sum();
    }

    public int getTotalDrivers() {
        return totalDrivers;
    }

    public int getTotalRaces() {
        return totalRaces;
    }
}

