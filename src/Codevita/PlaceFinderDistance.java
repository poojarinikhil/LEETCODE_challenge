package Codevita;

import java.util.*;

class Device {
    int id;
    Map<Integer, Integer> neighbors;

    Device(int id) {
        this.id = id;
        this.neighbors = new HashMap<>();
    }
}

public class PlaceFinderDistance {
    static double calculateDistance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of devices
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline

        // Create an array to store devices
        Device[] devices = new Device[n + 1];

        // Initialize devices
        for (int i = 1; i <= n; i++) {
            devices[i] = new Device(i);
        }

        // Read the information about each device
        for (int i = 1; i <= n; i++) {
            String[] input = scanner.nextLine().split(":");
            int deviceId = Integer.parseInt(input[0]);
            int numOfNeighbors = Integer.parseInt(input[1]);

            for (int j = 0; j < numOfNeighbors; j++) {
                String[] neighborInfo = scanner.nextLine().split(" ");
                int neighborId = Integer.parseInt(neighborInfo[0]);
                int distance = Integer.parseInt(neighborInfo[1]);
                int angle = Integer.parseInt(neighborInfo[2]);

                int x1 = devices[deviceId].id;
                int y1 = 0; // Assuming devices are in a line on the x-axis
                int x2 = devices[neighborId].id;
                int y2 = 0; // Assuming devices are in a line on the x-axis

                double distanceBetweenDevices = calculateDistance(x1, y1, x2, y2);

                // Update neighbors map
                devices[deviceId].neighbors.put(neighborId, (int) distanceBetweenDevices);
            }
        }

        // Read the devices between which distance needs to be found
        int device1Id = scanner.nextInt();
        int device2Id = scanner.nextInt();

        // Find the distance between the specified devices
        double distance = findDistance(devices, device1Id, device2Id);
        System.out.printf("%.2f\n", distance);

        scanner.close();
    }

    static double findDistance(Device[] devices, int device1Id, int device2Id) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.add(device1Id);
        visited.add(device1Id);

        Map<Integer, Double> distanceMap = new HashMap<>();
        distanceMap.put(device1Id, 0.0);

        while (!queue.isEmpty()) {
            int currentDeviceId = queue.poll();
            Device currentDevice = devices[currentDeviceId];

            for (Map.Entry<Integer, Integer> neighborEntry : currentDevice.neighbors.entrySet()) {
                int neighborId = neighborEntry.getKey();
                int distanceToNeighbor = neighborEntry.getValue();

                if (!visited.contains(neighborId)) {
                    visited.add(neighborId);
                    queue.add(neighborId);
                    distanceMap.put(neighborId, distanceMap.get(currentDeviceId) + distanceToNeighbor);
                }
            }
        }

        return distanceMap.get(device2Id);
    }
}
