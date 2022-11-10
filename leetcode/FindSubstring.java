package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class FindSubstring {
    public static List<Integer> findSubstring(String s, String[] words) {
        if (s.isEmpty() || words.length == 0)
            return List.of();
        var word_len = words[0].length();
        var word_cnt = words.length;
        var total_len = word_len * word_cnt;
        if (total_len > s.length())
            return List.of();
        var indices = new ArrayList<Integer>();
        var hash_map = new HashMap<String, Integer>();
        for (var i = 0; i < words.length; i++) {
            hash_map.put(words[i], hash_map.getOrDefault(words[i], 0) + 1);
        }
        for (var i = 0; i <= s.length() - total_len; i++) {
            var j = i;
            var temp_map = new HashMap<String, Integer>(hash_map);
            var temp_cnt = word_cnt;
            while (j < i + total_len) {
                var word = s.substring(j, j + word_len);
                if (!hash_map.containsKey(word) || temp_map.get(word) == 0)
                    break;
                j += word_len;
                temp_map.put(word, temp_map.get(word) - 1);
                temp_cnt--;
            }
            if (temp_cnt == 0)
                indices.add(i);
        }
        return indices;
    }
}
