import java.io.*;
import java.util.*;

class Result {

    /*
     * Complete the 'priceCheck' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts the following parameters:
     *  1. List<String> products
     *  2. List<Float> productPrices
     *  3. List<String> productSold
     *  4. List<Float> soldPrice
     */

    public static int priceCheck(List<String> products, List<Float> productPrices, List<String> productSold, List<Float> soldPrice) {
        // Store product names and their correct prices in a HashMap
        HashMap<String, Float> priceMap = new HashMap<>();
        for (int i = 0; i < products.size(); i++) {
            priceMap.put(products.get(i), productPrices.get(i));
        }

        // Count the number of errors in pricing
        int errorCount = 0;
        for (int i = 0; i < productSold.size(); i++) {
            if (priceMap.containsKey(productSold.get(i)) && !priceMap.get(productSold.get(i)).equals(soldPrice.get(i))) {
                errorCount++;
            }
        }

        return errorCount;
    }
}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());
        List<String> products = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            products.add(bufferedReader.readLine().trim());
        }

        List<Float> productPrices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            productPrices.add(Float.parseFloat(bufferedReader.readLine().trim()));
        }

        int m = Integer.parseInt(bufferedReader.readLine().trim());
        List<String> productSold = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            productSold.add(bufferedReader.readLine().trim());
        }

        List<Float> soldPrice = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            soldPrice.add(Float.parseFloat(bufferedReader.readLine().trim()));
        }

        int result = Result.priceCheck(products, productPrices, productSold, soldPrice);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
