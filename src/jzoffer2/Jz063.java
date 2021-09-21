package jzoffer2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Jz063 {
    class Node {
        Map<Character, Node> next = new HashMap<>();
        boolean isEnd = false;
    }

    private Node root = new Node();

    public String replaceWords(List<String> dictionary, String sentence) {
        // 有两种做法：
        // 1: 直接使用startwith for 一下 dictionary 进行判断。
        // dictionary的需要全部都判断。
        // 优化点：
        // 这里可能会有个坑点就是如果dictionary 前缀相同的比较多，则可以忽略很多不需要的。
        // 2: dictionary 组成字典树，可以缩短比较。
        // 采用方法2
        // 构造字典树
        for (String word : dictionary) {
            Node temp = root;
            for (int i = 0; i < word.length(); i++) {
                char character = word.charAt(i);
                Map<Character, Node> next = temp.next;
                // 这里的构图有问题， 如果遇到 cat catt 这样的情况，先构造处的从catt，那么后来的cat则无法被视作为单词。
                // 这里的 is End 需要判断一下。
                Node nextNode;
                if (!next.containsKey(character)) {
                    nextNode = new Node();
                } else {
                    nextNode = next.get(character);
                }
                // 构造树的时候，还是要注意下最后一个字母的判断，要放在最后，防止出现 cat catt的情况
                if (i == word.length() - 1) {
                    nextNode.isEnd = true;
                }
                next.put(character, nextNode);
                temp = nextNode;
            }
        }

        //这里要注意意外的情况，即为空。
        // 这里有一个坑点，就是如果继承词有许多，则使用最短的词根进行替换。
        String[] words = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        for (String word : words) {
            StringBuilder str = new StringBuilder();
            Node temp = root;
            for (int i = 0; i < word.length(); i++) {
                char character = word.charAt(i);
                Map<Character, Node> next = temp.next;
                // 下一个字符不存在，则认为和字典里的不匹配
                if (!next.containsKey(character)) {
                    res.append(word);
                    res.append(" ");
                    break;
                }
                // 下一个字符存在则认为和字典里的匹配
                str.append(character);
                Node nextNode = next.get(character);
                // 判断是否为前缀
                if (nextNode.isEnd) {
                    // 如果是前缀 则 替换，退出
                    res.append(str);
                    res.append(" ");
                    break;
                }
                // 如果现在不是前缀，那么判断下，当前是不是最后一个了？
                // 这里有一个坑点 就是， 如果 字典存在前缀 sf，但是匹配的是s，怎么办？
                // 如果已经遍历到最后一个了 并且 还是没找到最后一个，则散场。
                if (i == word.length() - 1) {
                    res.append(word);
                    res.append(" ");
                    break;
                }
                temp = nextNode;
            }

        }
        return res.toString().trim();
    }

    public static void main(String[] args) {
        System.out.println(new Jz063().replaceWords(Arrays.stream(new String[]{"cat", "bat", "rat"}).collect(Collectors.toList()), "the cattle was rattled by the battery"));
        System.out.println(new Jz063().replaceWords(Arrays.stream(new String[]{"a", "b", "c"}).collect(Collectors.toList()), "aadsfasf absbs bbab cadsfafs"));
        System.out.println(new Jz063().replaceWords(Arrays.stream(new String[]{"a", "aa", "aaa", "aaaa"}).collect(Collectors.toList()), "a aa a aaaa aaa aaa aaa aaaaaa bbb baba ababa"));
        System.out.println(new Jz063().replaceWords(Arrays.stream(new String[]{"catt", "cat", "bat", "rat"}).collect(Collectors.toList()), "the cattle was rattled by the battery"));
        System.out.println(new Jz063().replaceWords(Arrays.stream(new String[]{"ac", "ab"}).collect(Collectors.toList()), "it is abnormal that this solution is accepted"));
        System.out.println(new Jz063().replaceWords(Arrays.stream(new String[]{"e", "k", "c", "harqp", "h", "gsafc", "vn", "lqp", "soy", "mr", "x", "iitgm", "sb", "oo", "spj", "gwmly", "iu", "z", "f", "ha", "vds", "v", "vpx", "fir", "t", "xo", "apifm", "tlznm", "kkv", "nxyud", "j", "qp", "omn", "zoxp", "mutu", "i", "nxth", "dwuer", "sadl", "pv", "w", "mding", "mubem", "xsmwc", "vl", "farov", "twfmq", "ljhmr", "q", "bbzs", "kd", "kwc", "a", "buq", "sm", "yi", "nypa", "xwz", "si", "amqx", "iy", "eb", "qvgt", "twy", "rf", "dc", "utt", "mxjfu", "hm", "trz", "lzh", "lref", "qbx", "fmemr", "gil", "go", "qggh", "uud", "trnhf", "gels", "dfdq", "qzkx", "qxw"}).collect(Collectors.toList()), "ikkbp miszkays wqjferqoxjwvbieyk gvcfldkiavww vhokchxz dvypwyb bxahfzcfanteibiltins ueebf lqhflvwxksi dco kddxmckhvqifbuzkhstp wc ytzzlm gximjuhzfdjuamhsu gdkbmhpnvy ifvifheoxqlbosfww mengfdydekwttkhbzenk wjhmmyltmeufqvcpcxg hthcuovils ldipovluo aiprogn nusquzpmnogtjkklfhta klxvvlvyh nxzgnrveghc mpppfhzjkbucv cqcft uwmahhqradjtf iaaasabqqzmbcig zcpvpyypsmodtoiif qjuiqtfhzcpnmtk yzfragcextvx ivnvgkaqs iplazv jurtsyh gzixfeugj rnukjgtjpim hscyhgoru aledyrmzwhsz xbahcwfwm hzd ygelddphxnbh rvjxtlqfnlmwdoezh zawfkko iwhkcddxgpqtdrjrcv bbfj mhs nenrqfkbf spfpazr wrkjiwyf cw dtd cqibzmuuhukwylrnld dtaxhddidfwqs bgnnoxgyynol hg dijhrrpnwjlju muzzrrsypzgwvblf zbugltrnyzbg hktdviastoireyiqf qvufxgcixvhrjqtna ipfzhuvgo daee r nlipyfszvxlwqw yoq dewpgtcrzausqwhh qzsaobsghgm ichlpsjlsrwzhbyfhm ksenb bqprarpgnyemzwifqzz oai pnqottd nygesjtlpala qmxixtooxtbrzyorn gyvukjpc s mxhlkdaycskj uvwmerplaibeknltuvd ocnn frotscysdyclrc ckcttaceuuxzcghw pxbd oklwhcppuziixpvihihp"));
    }
}

