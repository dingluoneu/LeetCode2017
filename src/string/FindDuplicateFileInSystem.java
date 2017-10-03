package string;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindDuplicateFileInSystem {

    public static void main(String[] args) {
        String[] paths = {"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"};

        findDuplicate(paths);

    }

    public List<List<String>> findDuplicates(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        if (paths == null || paths.length == 0) return res;

        Map<String, Set<String>> map = new HashMap<>();

        for (String path : paths) {
            String[] strs = path.split("\\s+");

            for (int i = 1; i < strs.length; i++) {
                int index = strs[i].indexOf("(");
                String content = strs[i].substring(index);
                String fileName = strs[0] + "/" + strs[i].substring(0, index);
                Set<String> fileNames = map.getOrDefault(content, new HashSet<>());
                fileNames.add(fileName);
                map.put(content, fileNames);
            }
        }

        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                res.add(new ArrayList<>(map.get(key)));
            }
        }
        return res;
    }

    public static List<List<String>> findDuplicate(String[] paths) {

        List<List<String>> res = new ArrayList<>();
        if (paths == null || paths.length == 0) return res;

        Map<String, List<String>> contentToDirectoryPathMap = new HashMap<>();

        for (String s : paths) {
            String directoryPath = extractDirectoryPath(s);
            List<String> files = extractAllFiles(s);

            for (String file : files) {
                String[] nameAndContent = extractContent(file);
                String name = nameAndContent[0];
                String path = directoryPath + name + ".txt";
                String content = nameAndContent[1];

                if (contentToDirectoryPathMap.containsKey(content)) {
                    contentToDirectoryPathMap.get(content).add(path);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(path);
                    contentToDirectoryPathMap.put(content, list);
                }

            }
        }

        for (List<String> item : contentToDirectoryPathMap.values()) {
            res.add(item);
        }
        return res;
    }

    private static List<String> extractAllFiles(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;

        Matcher m = Pattern.compile("\\d+\\.txt\\([a-z]+\\)").matcher(s);

        while (m.find()) {
            String file = m.group(0);
            res.add(file);
        }
        return res;
    }

    private static String extractDirectoryPath(String s) {
        if (s == null || s.length() == 0) return "";

        int i = 0;
        while (i < s.length() && !Character.isWhitespace(s.charAt(i))) {
            i++;
        }
        return s.substring(0, i) + "/";
    }

    private static String[] extractContent(String fileName) {
        int i = 0;
        while (i < fileName.length() && fileName.charAt(i) != '.') {
            i++;
        }

        String name = fileName.substring(0, i);

        int j = 0;
        while (j < fileName.length() && fileName.charAt(j) != '(') {
            j++;
        }

        String content = fileName.substring(j + 1, fileName.length() - 1);

        return new String[] {name, content};
    }
}
