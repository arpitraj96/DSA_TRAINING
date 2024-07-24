package VJudge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class ChefOfTheYear {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nm = br.readLine().trim().split("\\s+");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);
        
        String[] chefs = new String[N];
        String[] countries = new String[N];
        
        Map<String, Integer> chefIndex = new HashMap<>();
        Map<String, Integer> countryIndex = new HashMap<>();
        
        for (int i = 0; i < N; i++) {
            String[] input = br.readLine().trim().split("\\s+");
            chefs[i] = input[0];
            countries[i] = input[1];
            chefIndex.put(chefs[i], i);
            if (!countryIndex.containsKey(countries[i])) {
                countryIndex.put(countries[i], i);
            }
        }
        
        int[] chefVotes = new int[N];
        int[] countryVotes = new int[N];
        
        for (int i = 0; i < M; i++) {
            String email = br.readLine().trim();
            int chefIdx = chefIndex.get(email);
            chefVotes[chefIdx]++;
            int countryIdx = countryIndex.get(countries[chefIdx]);
            countryVotes[countryIdx]++;
        }
        
        br.close();
        
        int maxCountryVotes = -1;
        String countryWinner = "";
        for (int i = 0; i < N; i++) {
            if (countryVotes[i] > maxCountryVotes || (countryVotes[i] == maxCountryVotes && countries[i].compareTo(countryWinner) < 0)) {
                maxCountryVotes = countryVotes[i];
                countryWinner = countries[i];
            }
        }
        
        int maxChefVotes = -1;
        String chefOfTheYear = "";
        for (int i = 0; i < N; i++) {
            if (chefVotes[i] > maxChefVotes || (chefVotes[i] == maxChefVotes && chefs[i].compareTo(chefOfTheYear) < 0)) {
                maxChefVotes = chefVotes[i];
                chefOfTheYear = chefs[i];
            }
        }
        
        System.out.println(countryWinner);
        System.out.println(chefOfTheYear);
    }
}