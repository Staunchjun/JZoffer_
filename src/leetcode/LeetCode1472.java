package leetcode;

import java.util.Objects;

public class LeetCode1472 {
    class History {
        String url = null;
        History next = null;
        History pre = null;
    }

    History homepage = new History();
    History currentUrl;

    public LeetCode1472(String homepage) {
        this.homepage.url = homepage;
        currentUrl = this.homepage;
    }

    public void visit(String url) {
        History cur = homepage;
        while (Objects.nonNull(cur)) {
            if (cur.url.equals(url)) {
                cur.next = null;
                return;
            }
            cur = cur.next;
        }
        // 如果搜索不到url，则基于当前页面往后挂
        History temp = new History();
        temp.pre = currentUrl;
        temp.url = url;
        currentUrl.next = temp;
        currentUrl = temp;
    }

    public String back(int steps) {
        int cnt = 0;
        while (Objects.nonNull(currentUrl) && cnt < steps) {

            if (Objects.isNull(currentUrl.pre)){
                return currentUrl.url;
            }

            currentUrl = currentUrl.pre;
            cnt++;
        }

        return currentUrl.url;
    }

    public String forward(int steps) {
        int cnt = 0;
        while (Objects.nonNull(currentUrl) && cnt < steps) {

            if (Objects.isNull(currentUrl.next)){
                return currentUrl.url;
            }

            currentUrl = currentUrl.next;
            cnt++;
        }

        return currentUrl.url;
    }

    public static void main(String[] args) {
        LeetCode1472 browserHistory = new LeetCode1472("leetcode.com");
        browserHistory.visit("google.com"); // 你原本在浏览 "leetcode.com" 。访问 "google.com"
        browserHistory.visit("facebook.com"); // 你原本在浏览 "google.com" 。访问 "facebook.com"
        browserHistory.visit("youtube.com"); // 你原本在浏览 "facebook.com" 。访问 "youtube.com"
        System.out.println(browserHistory.back(1)); // 你原本在浏览 "youtube.com" ，后退到 "facebook.com" 并返回 "facebook.com"
        System.out.println(browserHistory.back(1)); // 你原本在浏览 "facebook.com" ，后退到 "google.com" 并返回 "google.com"
        System.out.println(browserHistory.forward(1)); // 你原本在浏览 "google.com" ，前进到 "facebook.com" 并返回 "facebook.com"
        browserHistory.visit("linkedin.com"); // 你原本在浏览 "facebook.com" 。 访问 "linkedin.com"
        System.out.println(browserHistory.forward(2)); // 你原本在浏览 "linkedin.com" ，你无法前进任何步数。
        System.out.println(browserHistory.back(2)); // 你原本在浏览 "linkedin.com" ，后退两步依次先到 "facebook.com" ，然后到 "google.com" ，并返回 "google.com"
        System.out.println(browserHistory.back(7));// 你原本在浏览 "google.com"， 你只能后退一步到 "leetcode.com" ，并返回 "leetcode.com"
    }
}