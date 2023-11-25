package Codevita;
import java.util.*;
import java.util.*;

class Online_shopping {
    static class Item {
        String name;
        int cost;

        Item(String name, int cost) {
            this.name = name;
            this.cost = cost;
        }
    }

    static class ItemComparator implements Comparator<Item> {
        @Override
        public int compare(Item a, Item b) {
            return Integer.compare(b.cost, a.cost);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read input
        int n = scanner.nextInt();
        int[] tokens = new int[n];
        for (int i = 0; i < n; ++i) {
            tokens[i] = scanner.nextInt();
        }

        int[] claim = new int[n];
        for (int i = 0; i < n; ++i) {
            claim[i] = scanner.nextInt();
        }

        int k = scanner.nextInt();

        scanner.nextLine(); // Consume the newline

        Map<String, Integer> items = new HashMap<>();
        String item;
        int cost;
        while (scanner.hasNext()) {
            item = scanner.next();
            scanner.next(); // Consume ":"
            cost = scanner.nextInt();
            items.put(item, cost);
        }

        // Calculate maximum tokens
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (claim[i] == 1)
                sum += tokens[i];
        }

        // Find the maximum achievable tokens
        int maxi = 0;
        for (int i = 0; i < n; i++) {
            int ans = 0;
            for (int j = i; j < i + k; j++) {
                if (claim[j] == 0)
                    ans += tokens[j];
            }
            maxi = Math.max(ans, maxi);
        }
        maxi += sum;

        // Filter items based on maximum achievable tokens
        List<Item> itemsList = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : items.entrySet()) {
            if (entry.getValue() <= maxi) {
                itemsList.add(new Item(entry.getKey(), entry.getValue()));
            }
        }

        // Find the maximum cost among filtered items
        int a = 0;
        for (Item i : itemsList) {
            a = Math.max(a, i.cost);
        }

        // Sort items based on the maximum cost
        Collections.sort(itemsList, new ItemComparator());

        // Collect items with the maximum cost
        List<String> result = new ArrayList<>();
        for (Item i : itemsList) {
            if (i.cost == a)
                result.add(i.name);
        }

        // Sort the result lexicographically
        Collections.sort(result);

        // Print the result
        for (String itemName : result) {
            System.out.print(itemName + " ");
        }
    }
}



