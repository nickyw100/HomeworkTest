package com.Ntrepid;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.*;
import java.util.stream.Collectors;

@WebService()
public class Solution {

    @WebMethod
    public String parsePathLogs(HashMap<String, List<String>> pagesByUser, int numberToReturn) {
        if (pagesByUser == null || numberToReturn < 1) {
            // No data to process; get out now
            return null;
        }
        List<List<String>> triples = pagesByUser.values().stream().map(Solution::buildTripleLists).collect(Collectors.toList());

        List<String> combinedList = mergeLists(triples);
        // Count the occurrences of all triples
        Set<String> removedDuplicates = new HashSet<String>();
        for (String path : combinedList) {
            removedDuplicates.add(path);
        }
        // removedDuplicates now contains a unique set of paths.
        // Loop thru it, and count the frequencies.
        Map<String, Integer> pathMap = buildFrequencyMap(combinedList, removedDuplicates);

        // Sort Map by Integer value descending. Print results to console.
        pathMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(System.out::println);

        List<String> result = sortMapByValueDescending(pathMap);
        // Only return N entries. If N is too big, return all you've got.
        if (numberToReturn > result.size()) {
            numberToReturn = result.size();
        }
        List<String> subList = result.subList(0, numberToReturn);
        return subList.toString();
    }

    // Create the lists of triples
    private static List<String> buildTripleLists(List<String> list) {
        int counter1 = 0;
        ArrayList<String> pathList = new ArrayList<>();
        for (String u1Element : list) {
            if (counter1 <= list.size() - 3) {
                String testString1 = new StringBuilder()
                        .append(list.get(counter1))
                        .append(list.get(counter1 + 1))
                        .append(list.get(counter1 + 2)).toString();
                pathList.add(testString1);
                counter1++;
            }
        }
        return pathList;
    }

    private static List<String> mergeLists(Collection<List<String>> lists) {
        List<String> combinedList = new ArrayList<String>();
        for (List<String> list : lists) {
            combinedList.addAll(list);
        }
        return combinedList;
    }

    private static List<String> sortMapByValueDescending(Map<String, Integer> pathMap) {
        List<String> result = new ArrayList<>();
        // Sort Map by Integer value descending. Push to List
        pathMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach(e -> result.add(e.getKey()));
        return result;
    }

    private Map<String, Integer> buildFrequencyMap(List<String> combinedList, Set<String> removedDuplicates) {
        Map<String, Integer> pathMap = new HashMap<>();
        for (String uniquePath : removedDuplicates) {
            Integer occurrences = Collections.frequency(combinedList, uniquePath);
            // Add this entry to a Map<String, Integer>
            pathMap.put(uniquePath, occurrences);
        }
        return pathMap;
    }
}
