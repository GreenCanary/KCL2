package com.mike.kcl2;

import java.util.*;

public class DensityPercentageLookup {
    private static final Map<Integer, List<DensityData>> temperatureTables = new HashMap<>();

    static {
        initialize20CTable();
        initialize25CTable();
        initialize30CTable();

        // Sort all tables by density
        for (List<DensityData> table : temperatureTables.values()) {
            Collections.sort(table);
        }
    }

    private static void initialize20CTable() {
        List<DensityData> table20C = new ArrayList<>();
        // 20°C data
        addDataToTable(table20C, 21, 9.98, 1.240);
        addDataToTable(table20C, 20.85, 10.05, 1.239);
        addDataToTable(table20C, 20.65, 10.14, 1.238);
        addDataToTable(table20C, 20.45, 10.23, 1.237);
        addDataToTable(table20C, 20.2, 10.34, 1.236);
        addDataToTable(table20C, 19.95, 10.45, 1.235);
        addDataToTable(table20C, 19.71, 10.55, 1.234);
        addDataToTable(table20C, 19.45, 10.67, 1.233);
        addDataToTable(table20C, 19.2, 10.78, 1.232);
        addDataToTable(table20C, 18.9, 10.91, 1.231);
        addDataToTable(table20C, 18.4, 11.14, 1.230);
        addDataToTable(table20C, 18.3, 11.18, 1.229);
        addDataToTable(table20C, 18.2, 11.22, 1.228);
        addDataToTable(table20C, 18, 11.31, 1.227);
        addDataToTable(table20C, 17.9, 11.36, 1.227);
        addDataToTable(table20C, 17.8, 11.40, 1.225);
        addDataToTable(table20C, 17.7, 11.44, 1.225);
        addDataToTable(table20C, 17.6, 11.49, 1.225);
        addDataToTable(table20C, 17.56, 11.50, 1.225);
        addDataToTable(table20C, 17.5, 11.53, 1.225);
        addDataToTable(table20C, 17.4, 11.57, 1.225);
        addDataToTable(table20C, 17.4, 11.65, 1.224);
        addDataToTable(table20C, 17.3, 11.69, 1.224);
        addDataToTable(table20C, 17.2, 11.80, 1.224);
        addDataToTable(table20C, 17.1, 11.91, 1.224);
        addDataToTable(table20C, 17, 12.01, 1.223);
        addDataToTable(table20C, 16.9, 12.12, 1.223);
        addDataToTable(table20C, 16.8, 12.22, 1.222);
        addDataToTable(table20C, 16.7, 12.33, 1.222);
        addDataToTable(table20C, 16.6, 12.41, 1.221);
        addDataToTable(table20C, 16.6, 12.43, 1.221);
        addDataToTable(table20C, 16.53, 12.45, 1.221);
        addDataToTable(table20C, 16.5, 12.46, 1.221);
        addDataToTable(table20C, 16.4, 12.54, 1.221);
        addDataToTable(table20C, 16.3, 12.59, 1.221);
        addDataToTable(table20C, 16.2, 12.65, 1.220);
        addDataToTable(table20C, 16.1, 12.70, 1.220);
        addDataToTable(table20C, 16, 12.76, 1.220);
        addDataToTable(table20C, 15.9, 12.82, 1.219);
        addDataToTable(table20C, 15.8, 12.89, 1.219);
        addDataToTable(table20C, 15.7, 12.93, 1.219);
        addDataToTable(table20C, 15.6, 12.98, 1.218);
        addDataToTable(table20C, 15.6, 13.00, 1.218);
        addDataToTable(table20C, 15.59, 13.02, 1.218);
        addDataToTable(table20C, 15.5, 13.06, 1.218);
        addDataToTable(table20C, 15.48, 13.08, 1.218);
        addDataToTable(table20C, 15.42, 13.10, 1.218);
        addDataToTable(table20C, 15.4, 13.12, 1.218);
        addDataToTable(table20C, 15.3, 13.19, 1.217);
        addDataToTable(table20C, 15.2, 13.26, 1.217);
        addDataToTable(table20C, 15.1, 13.32, 1.216);
        addDataToTable(table20C, 15, 13.39, 1.216);
        addDataToTable(table20C, 14.9, 13.45, 1.215);
        addDataToTable(table20C, 14.8, 13.52, 1.215);
        addDataToTable(table20C, 14.7, 13.59, 1.214);
        addDataToTable(table20C, 14.6, 13.65, 1.214);
        addDataToTable(table20C, 14.5, 13.72, 1.214);
        addDataToTable(table20C, 14.4, 13.78, 1.213);
        addDataToTable(table20C, 14.3, 13.85, 1.213);
        addDataToTable(table20C, 14.2, 13.92, 1.213);
        addDataToTable(table20C, 14.1, 13.98, 1.212);
        addDataToTable(table20C, 14, 14.05, 1.212);
        addDataToTable(table20C, 13.9, 14.11, 1.211);
        addDataToTable(table20C, 13.8, 14.18, 1.211);
        addDataToTable(table20C, 13.7, 14.26, 1.211);
        addDataToTable(table20C, 13.6, 14.31, 1.210);
        addDataToTable(table20C, 13.5, 14.38, 1.210);
        addDataToTable(table20C, 13.4, 14.44, 1.209);
        addDataToTable(table20C, 13.3, 14.51, 1.209);
        addDataToTable(table20C, 13.2, 14.57, 1.208);
        addDataToTable(table20C, 13.1, 14.64, 1.208);
        addDataToTable(table20C, 13.06, 14.67, 1.208);
        addDataToTable(table20C, 13.00, 14.71, 1.207);
        addDataToTable(table20C, 12.9, 14.76, 1.207);
        addDataToTable(table20C, 12.9, 14.78, 1.206);
        addDataToTable(table20C, 12.8, 14.80, 1.206);
        addDataToTable(table20C, 12.7, 14.82, 1.205);
        addDataToTable(table20C, 12.67, 14.85, 1.205);
        addDataToTable(table20C, 12.6, 14.97, 1.204);
        addDataToTable(table20C, 12.5, 15.04, 1.204);

        temperatureTables.put(20, table20C);
    }

    private static void initialize25CTable() {
        List<DensityData> table25C = new ArrayList<>();
        // 25°C data
        addDataToTable(table25C, 21, 10.26, 1.243);
        addDataToTable(table25C, 20.85, 10.33, 1.242);
        addDataToTable(table25C, 20.65, 10.44, 1.241);
        addDataToTable(table25C, 20.45, 10.54, 1.240);
        addDataToTable(table25C, 20.25, 10.67, 1.239);
        addDataToTable(table25C, 20.1, 10.74, 1.238);
        addDataToTable(table25C, 20, 10.80, 1.238);
        addDataToTable(table25C, 19.9, 10.85, 1.238);
        addDataToTable(table25C, 19.8, 10.90, 1.237);
        addDataToTable(table25C, 19.7, 10.90, 1.237);
        addDataToTable(table25C, 19.7, 10.96, 1.237);
        addDataToTable(table25C, 19.6, 11.01, 1.237);
        addDataToTable(table25C, 19.5, 11.06, 1.236);
        addDataToTable(table25C, 19.4, 11.12, 1.236);
        addDataToTable(table25C, 19.3, 11.17, 1.235);
        addDataToTable(table25C, 19.2, 11.22, 1.235);
        addDataToTable(table25C, 19.1, 11.28, 1.234);
        addDataToTable(table25C, 19, 11.33, 1.234);
        addDataToTable(table25C, 18.9, 11.39, 1.233);
        addDataToTable(table25C, 18.8, 11.44, 1.233);
        addDataToTable(table25C, 18.7, 11.49, 1.232);
        addDataToTable(table25C, 18.6, 11.55, 1.232);
        addDataToTable(table25C, 18.5, 11.60, 1.231);
        addDataToTable(table25C, 18.4, 11.66, 1.231);
        addDataToTable(table25C, 18.3, 11.71, 1.230);
        addDataToTable(table25C, 18.2, 11.76, 1.230);
        addDataToTable(table25C, 18.1, 11.82, 1.229);
        addDataToTable(table25C, 18, 11.87, 1.229);
        addDataToTable(table25C, 17.9, 11.93, 1.228);
        addDataToTable(table25C, 17.8, 11.98, 1.228);
        addDataToTable(table25C, 17.7, 12.03, 1.227);
        addDataToTable(table25C, 17.6, 12.09, 1.227);
        addDataToTable(table25C, 17.56, 12.11, 1.226);
        addDataToTable(table25C, 17.5, 12.14, 1.226);
        addDataToTable(table25C, 17.42, 12.18, 1.226);
        addDataToTable(table25C, 17.4, 12.20, 1.226);
        addDataToTable(table25C, 17.3, 12.26, 1.225);
        addDataToTable(table25C, 17.2, 12.32, 1.225);
        addDataToTable(table25C, 17.1, 12.37, 1.224);
        addDataToTable(table25C, 17, 12.43, 1.224);
        addDataToTable(table25C, 16.9, 12.49, 1.223);
        addDataToTable(table25C, 16.8, 12.54, 1.223);
        addDataToTable(table25C, 16.7, 12.60, 1.223);
        addDataToTable(table25C, 16.62, 12.64, 1.223);
        addDataToTable(table25C, 16.6, 12.66, 1.222);
        addDataToTable(table25C, 16.53, 12.70, 1.222);
        addDataToTable(table25C, 16.5, 12.72, 1.222);
        addDataToTable(table25C, 16.4, 12.81, 1.222);
        addDataToTable(table25C, 16.3, 12.89, 1.221);
        addDataToTable(table25C, 16.2, 12.97, 1.221);
        addDataToTable(table25C, 16.1, 13.05, 1.221);
        addDataToTable(table25C, 16, 13.13, 1.220);
        addDataToTable(table25C, 15.9, 13.22, 1.220);
        addDataToTable(table25C, 15.8, 13.30, 1.220);
        addDataToTable(table25C, 15.7, 13.38, 1.220);
        addDataToTable(table25C, 15.62, 13.40, 1.220);
        addDataToTable(table25C, 15.6, 13.46, 1.219);
        addDataToTable(table25C, 15.59, 13.50, 1.219);
        addDataToTable(table25C, 15.5, 13.54, 1.219);
        addDataToTable(table25C, 15.48, 13.56, 1.219);
        addDataToTable(table25C, 15.42, 13.60, 1.219);
        addDataToTable(table25C, 15.4, 13.62, 1.219);
        addDataToTable(table25C, 15.3, 13.70, 1.218);
        addDataToTable(table25C, 15.2, 13.79, 1.218);
        addDataToTable(table25C, 15.1, 13.86, 1.218);
        addDataToTable(table25C, 15, 13.93, 1.217);
        addDataToTable(table25C, 14.9, 14.01, 1.217);
        addDataToTable(table25C, 14.8, 14.09, 1.217);
        addDataToTable(table25C, 14.7, 14.17, 1.216);
        addDataToTable(table25C, 14.6, 14.23, 1.215);
        addDataToTable(table25C, 14.5, 14.32, 1.215);
        addDataToTable(table25C, 14.4, 14.40, 1.214);
        addDataToTable(table25C, 14.3, 14.48, 1.214);
        addDataToTable(table25C, 14.2, 14.56, 1.214);
        addDataToTable(table25C, 14.1, 14.64, 1.213);
        addDataToTable(table25C, 14, 14.72, 1.213);
        addDataToTable(table25C, 13.9, 14.79, 1.213);
        addDataToTable(table25C, 13.8, 14.87, 1.212);
        addDataToTable(table25C, 13.7, 14.95, 1.212);
        addDataToTable(table25C, 13.6, 15.03, 1.211);
        addDataToTable(table25C, 13.5, 15.11, 1.211);
        addDataToTable(table25C, 13.4, 15.18, 1.210);
        addDataToTable(table25C, 13.3, 15.26, 1.210);
        addDataToTable(table25C, 13.2, 15.34, 1.209);
        addDataToTable(table25C, 13.1, 15.42, 1.209);
        addDataToTable(table25C, 13.1, 15.40, 1.209);
        addDataToTable(table25C, 13.0, 15.49, 1.209);
        addDataToTable(table25C, 12.9, 15.57, 1.208);
        addDataToTable(table25C, 12.89, 15.60, 1.208);
        addDataToTable(table25C, 12.8, 15.65, 1.208);
        addDataToTable(table25C, 12.7, 15.73, 1.207);
        addDataToTable(table25C, 12.67, 15.75, 1.207);
        addDataToTable(table25C, 12.6, 15.81, 1.207);
        addDataToTable(table25C, 12.5, 15.89, 1.206);

        temperatureTables.put(25, table25C);
    }

    private static void initialize30CTable() {
        List<DensityData> table30C = new ArrayList<>();
        // 30°C data
        addDataToTable(table30C, 21, 10.95, 1.243);
        addDataToTable(table30C, 20.9, 11.01, 1.242);
        addDataToTable(table30C, 20.8, 11.06, 1.242);
        addDataToTable(table30C, 20.7, 11.22, 1.241);
        addDataToTable(table30C, 20.6, 11.16, 1.241);
        addDataToTable(table30C, 20.5, 11.22, 1.240);
        addDataToTable(table30C, 20.4, 11.27, 1.240);
        addDataToTable(table30C, 20.3, 11.32, 1.239);
        addDataToTable(table30C, 20.2, 11.38, 1.239);
        addDataToTable(table30C, 20.1, 11.43, 1.238);
        addDataToTable(table30C, 20, 11.48, 1.238);
        addDataToTable(table30C, 19.9, 11.53, 1.238);
        addDataToTable(table30C, 19.8, 11.58, 1.237);
        addDataToTable(table30C, 19.75, 11.61, 1.237);
        addDataToTable(table30C, 19.7, 11.63, 1.237);
        addDataToTable(table30C, 19.6, 11.69, 1.236);
        addDataToTable(table30C, 19.5, 11.74, 1.236);
        addDataToTable(table30C, 19.4, 11.79, 1.236);
        addDataToTable(table30C, 19.3, 11.85, 1.235);
        addDataToTable(table30C, 19.2, 11.90, 1.235);
        addDataToTable(table30C, 19.1, 11.95, 1.235);
        addDataToTable(table30C, 19, 12.00, 1.234);
        addDataToTable(table30C, 18.9, 12.06, 1.234);
        addDataToTable(table30C, 18.8, 12.11, 1.234);
        addDataToTable(table30C, 18.7, 12.16, 1.234);
        addDataToTable(table30C, 18.6, 12.21, 1.233);
        addDataToTable(table30C, 18.5, 12.27, 1.233);
        addDataToTable(table30C, 18.4, 12.32, 1.233);
        addDataToTable(table30C, 18.3, 12.37, 1.232);
        addDataToTable(table30C, 18.2, 12.42, 1.232);
        addDataToTable(table30C, 18.1, 12.48, 1.231);
        addDataToTable(table30C, 18, 12.53, 1.231);
        addDataToTable(table30C, 17.9, 12.58, 1.231);
        addDataToTable(table30C, 17.8, 12.63, 1.231);
        addDataToTable(table30C, 17.7, 12.69, 1.230);
        addDataToTable(table30C, 17.6, 12.74, 1.230);
        addDataToTable(table30C, 17.58, 12.75, 1.230);
        addDataToTable(table30C, 17.5, 12.78, 1.229);
        addDataToTable(table30C, 17.42, 12.85, 1.229);
        addDataToTable(table30C, 17.4, 12.87, 1.229);
        addDataToTable(table30C, 17.3, 12.93, 1.229);
        addDataToTable(table30C, 17.2, 13.00, 1.228);
        addDataToTable(table30C, 17.1, 13.06, 1.228);
        addDataToTable(table30C, 17, 13.12, 1.227);
        addDataToTable(table30C, 16.9, 13.19, 1.227);
        addDataToTable(table30C, 16.8, 13.26, 1.226);
        addDataToTable(table30C, 16.7, 13.32, 1.226);
        addDataToTable(table30C, 16.62, 13.36, 1.225);
        addDataToTable(table30C, 16.6, 13.38, 1.225);
        addDataToTable(table30C, 16.53, 13.43, 1.225);
        addDataToTable(table30C, 16.5, 13.49, 1.225);
        addDataToTable(table30C, 16.4, 13.52, 1.224);
        addDataToTable(table30C, 16.3, 13.59, 1.224);
        addDataToTable(table30C, 16.2, 13.66, 1.224);
        addDataToTable(table30C, 16.1, 13.74, 1.224);
        addDataToTable(table30C, 16, 13.81, 1.223);
        addDataToTable(table30C, 15.9, 13.88, 1.223);
        addDataToTable(table30C, 15.8, 13.95, 1.223);
        addDataToTable(table30C, 15.7, 14.02, 1.222);
        addDataToTable(table30C, 15.62, 14.04, 1.222);
        addDataToTable(table30C, 15.6, 14.05, 1.222);
        addDataToTable(table30C, 15.59, 14.10, 1.222);
        addDataToTable(table30C, 15.5, 14.12, 1.222);
        addDataToTable(table30C, 15.48, 14.13, 1.222);
        addDataToTable(table30C, 15.42, 14.15, 1.221);
        addDataToTable(table30C, 15.4, 14.24, 1.221);
        addDataToTable(table30C, 15.3, 14.31, 1.221);
        addDataToTable(table30C, 15.2, 14.38, 1.221);
        addDataToTable(table30C, 15.1, 14.46, 1.220);
        addDataToTable(table30C, 15, 14.53, 1.220);
        addDataToTable(table30C, 14.9, 14.60, 1.220);
        addDataToTable(table30C, 14.8, 14.68, 1.219);
        addDataToTable(table30C, 14.7, 14.75, 1.219);
        addDataToTable(table30C, 14.6, 14.82, 1.219);
        addDataToTable(table30C, 14.5, 14.89, 1.218);
        addDataToTable(table30C, 14.4, 14.97, 1.218);
        addDataToTable(table30C, 14.3, 15.04, 1.218);
        addDataToTable(table30C, 14.2, 15.11, 1.217);
        addDataToTable(table30C, 14.1, 15.19, 1.217);
        addDataToTable(table30C, 14, 15.26, 1.217);
        addDataToTable(table30C, 13.9, 15.33, 1.216);
        addDataToTable(table30C, 13.8, 15.40, 1.216);
        addDataToTable(table30C, 13.7, 15.48, 1.215);
        addDataToTable(table30C, 13.6, 15.55, 1.215);
        addDataToTable(table30C, 13.5, 15.62, 1.215);
        addDataToTable(table30C, 13.4, 15.70, 1.214);
        addDataToTable(table30C, 13.3, 15.77, 1.214);
        addDataToTable(table30C, 13.2, 15.84, 1.214);
        addDataToTable(table30C, 13.1, 15.92, 1.213);
        addDataToTable(table30C, 13.06, 15.97, 1.213);
        addDataToTable(table30C, 13.00, 16.00, 1.213);
        addDataToTable(table30C, 12.90, 16.06, 1.213);
        addDataToTable(table30C, 12.89, 16.10, 1.212);
        addDataToTable(table30C, 12.8, 16.13, 1.212);
        addDataToTable(table30C, 12.7, 16.21, 1.212);
        addDataToTable(table30C, 12.67, 16.23, 1.212);
        addDataToTable(table30C, 12.6, 16.28, 1.212);
        addDataToTable(table30C, 12.5, 16.35, 1.211);

        temperatureTables.put(30, table30C);
    }

    private static void addDataToTable(List<DensityData> table, double nacl, double kcl, double density) {
        table.add(new DensityData(nacl, kcl, density));
    }

    public static DensityData findPercentages(int temperature, double density) {
        List<DensityData> table = temperatureTables.get(temperature);
        if (table == null) {
            throw new IllegalArgumentException("No data available for temperature " + temperature);
        }

        int index = Collections.binarySearch(table, new DensityData(0, 0, density));

        if (index >= 0) {
            return table.get(index);
        } else {
            int insertionPoint = -index - 1;
            if (insertionPoint == 0) return table.get(0);
            if (insertionPoint == table.size()) return table.get(table.size() - 1);

            DensityData lower = table.get(insertionPoint - 1);
            DensityData higher = table.get(insertionPoint);
            return (density - lower.density) < (higher.density - density) ? lower : higher;
        }
    }

    public static class DensityData implements Comparable<DensityData> {
        public final double naclPercentage;
        public final double kclPercentage;
        public final double density;

        public DensityData(double naclPercentage, double kclPercentage, double density) {
            this.naclPercentage = naclPercentage;
            this.kclPercentage = kclPercentage;
            this.density = density;
        }

        @Override
        public int compareTo(DensityData other) {
            return Double.compare(this.density, other.density);
        }

        @Override
        public String toString() {
            return String.format("NaCl: %.2f%%, KCl: %.2f%%, Density: %.3f t/m³",
                    naclPercentage, kclPercentage, density);
        }
    }

    public static void main(String[] args) {
        // Test cases
        testLookup(20, 1.225);
        testLookup(25, 1.230);
        testLookup(30, 1.220);

        // Edge case - temperature not available
        try {
            testLookup(35, 1.200);
        } catch (IllegalArgumentException e) {
            System.out.println("\nTest for unavailable temperature (35°C):");
            System.out.println(e.getMessage());
        }
    }

    private static void testLookup(int temp, double density) {
        System.out.printf("\nFor %d°C and density %.3f t/m³:%n", temp, density);
        DensityData result = findPercentages(temp, density);
        System.out.println(result);
    }
}