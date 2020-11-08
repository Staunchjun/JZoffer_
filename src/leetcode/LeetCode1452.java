package leetcode;

import java.util.*;

public class LeetCode1452 {
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            boolean isChilrd = false;
            for (int j = 0; j < favoriteCompanies.size(); j++) {
                if (i== j){
                    continue;
                }else {
                    HashSet<String> favoriteCompanies1 = new HashSet(favoriteCompanies.get(i));
                    HashSet<String> favoriteCompanies2 = new HashSet(favoriteCompanies.get(j));
                    if (favoriteCompanies2.containsAll(favoriteCompanies1)){
                        isChilrd = true;
                    }
                }
            }
            if (!isChilrd){
                res.add(i);
            }
        }
        Collections.sort(res);
        return res;
    }

    /**
     * 示例 1：
     *
     * 输入：favoriteCompanies = [["leetcode","google","facebook"],["google","microsoft"],["google","facebook"],["google"],["amazon"]]
     * 输出：[0,1,4]
     * 解释：
     * favoriteCompanies[2]=["google","facebook"] 是 favoriteCompanies[0]=["leetcode","google","facebook"] 的子集。
     * favoriteCompanies[3]=["google"] 是 favoriteCompanies[0]=["leetcode","google","facebook"] 和 favoriteCompanies[1]=["google","microsoft"] 的子集。
     * 其余的收藏清单均不是其他任何人收藏的公司清单的子集，因此，答案为 [0,1,4] 。
     * 示例 2：
     *
     * 输入：favoriteCompanies = [["leetcode","google","facebook"],["leetcode","amazon"],["facebook","google"]]
     * 输出：[0,1]
     * 解释：favoriteCompanies[2]=["facebook","google"] 是 favoriteCompanies[0]=["leetcode","google","facebook"] 的子集，因此，答案为 [0,1] 。
     * 示例 3：
     *
     * 输入：favoriteCompanies = [["leetcode"],["google"],["facebook"],["amazon"]]
     * 输出：[0,1,2,3]
     * @param args
     */
}
