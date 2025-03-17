package main;

import java.util.List;

public class RallyChampionship {
    public static void main(String[] args) {
        ChampionshipManager manager = ChampionshipManager.getInstance();

        Driver driver1 = new Driver("Sébastien Ogier", "France", new GravelCar("Toyota", "Yaris", 380, 470.6));
        Driver driver2 = new Driver("Kalle Rovanperä", "Finland", new AsphaltCar("Hyundai", "i20", 360, 524.4));
        Driver driver3 = new Driver("Ott Tänak", "Estonia", new GravelCar("Ford", "Puma", 370, 490));
        Driver driver4 = new Driver("Thierry Neuville", "Belgium", new AsphaltCar("Hyundai", "i20", 365, 495));

        manager.registerDriver(driver1);
        manager.registerDriver(driver2);
        manager.registerDriver(driver3);
        manager.registerDriver(driver4);

        RallyRaceResult race1 = new RallyRaceResult("Rally Finland", "Jyväskylä");
        race1.recordResult(driver1, 25);
        race1.recordResult(driver3, 18);
        race1.recordResult(driver2, 15);
        race1.recordResult(driver4, 12);
        manager.addRaceResult(race1);

        RallyRaceResult race2 = new RallyRaceResult("Monte Carlo Rally", "Monaco");
        race2.recordResult(driver2, 25);
        race2.recordResult(driver4, 18);
        race2.recordResult(driver1, 15);
        race2.recordResult(driver3, 12);
        manager.addRaceResult(race2);

        driver1.addPoints(25 + 15);
        driver2.addPoints(15 + 25);
        driver3.addPoints(18 + 12);
        driver4.addPoints(12 + 18);

        List<Driver> standings = manager.getDriverStandings();
        int position = 1;
        for (Driver driver : standings) {
            System.out.println(position++ + ". " + driver.getName() + " (" + driver.getCountry() + "): " + driver.getPoints() + " points");
        }

        System.out.println("\n===== CHAMPIONSHIP LEADER =====");
        System.out.println(manager.getLeadingDriver().getName() + " with " + manager.getLeadingDriver().getPoints() + " points");

        System.out.println("\n===== CHAMPIONSHIP STATISTICS =====");
        System.out.println("Total Drivers: " + manager.getTotalDrivers());
        System.out.println("Total Races: " + manager.getTotalRaces());
        System.out.printf("Average Points Per Driver: " + ChampionshipStatistics.calculateAveragePointsPerDriver(standings));
        System.out.println("Most Successful Country: " + ChampionshipStatistics.findMostSuccessfulCountry(standings));
        System.out.println("Total Championship Points: " + manager.getTotalChampionshipPoints());

        System.out.println("\n===== RACE RESULTS =====");
        for (RallyRaceResult race : List.of(race1, race2)) {
            System.out.println("Race: " + race.getRaceName() + " (" + race.getLocation() + ")");
            int pos = 1;
            for (Driver driver : race.getResults()) {
                System.out.println("  Position " + pos++ + ": " + driver.getName() + " - " + race.getDriverPoints(driver) + " points");
            }
        }

        System.out.println("\n===== CAR PERFORMANCE RATINGS =====");
        System.out.println("Gravel Car Performance: " + driver1.getCar().calculatePerformance());
        System.out.println("Asphalt Car Performance: " + driver2.getCar().calculatePerformance());
    }
}


