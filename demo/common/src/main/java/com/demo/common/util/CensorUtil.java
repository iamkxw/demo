package com.demo.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 审查工具类
 * Created by Sawyer on 2016/6/7.
 */
public class CensorUtil {

    private static TrieNode root = new TrieNode();

    /**
     * 添加敏感词
     * Created by Sawyer on 2016/6/7
     */
    public static void addWord(String word) {
        if (word == null || word.length() == 0) return;
        //从根节点开始添加敏感词
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char code = word.charAt(i);
            //将code添加到子节点，同时将当前节点变为子节点
            current = current.add(code);
        }
        //当将所有字符添加到trie后，将最后的节点设置为叶子节点
        current.end = true;
    }

    /**
     * 是否含有敏感词
     * Created by Sawyer on 2016/6/7
     */
    public static boolean hasBadWord(String text) {
        IndexWordPair pair = getBaddWord(text);
        if (pair == null) return false;
        return true;
    }

    /**
     * 返回含有的敏感词
     * Created by Sawyer on 2016/6/7
     */
    private static IndexWordPair getBaddWord(String text) {
        if (text == null || text.length() == 0) return null;
        List<Character> chlist = new ArrayList<>();
        for (int i = 0; i < text.length(); i++) {
            TrieNode current = root;
            int index = i;
            //如果当前节点的子节点包含当前字符，则继续看下一个字符是否也在其孙节点中，直至到达叶子节点
            while ((current = current.child.get(text.charAt(index))) != null) {
                chlist.add(text.charAt(index));
                //如果到达叶子节点，则返回找到的敏感词
                if (current.end) {
                    char[] chars = new char[chlist.size()];
                    for (int x = 0; x < chlist.size(); x++) {
                        chars[x] = chlist.get(x);
                    }
                    return new IndexWordPair(index, new String(chars));
                }
                //将index+1，匹配下一个字符
                //如果到达文本的长度，且未达到叶子节点，则退出while。
                if (text.length() == ++index) {
                    break;
                }
            }
        }
        return null;
    }

    /**
     * 使用指定符号代替敏感词显示
     * Created by Sawyer on 2016/6/7
     */
    public static String replaceWith(String text, char mark) {
        if (text == null || text.length() == 0) return null;
        char[] ca = text.toCharArray();
        for (int i = 0; i < text.length(); i++) {
            //用来记录敏感字符的下标
            List<Integer> badIdx = new ArrayList<>();
            TrieNode current = root;
            int index = i;
            //如果当前节点的子节点包含当前字符，则继续看下一个字符是否也在其孙节点中，直至到达叶子节点
            while ((current = current.child.get(ca[index])) != null) {
                //记录脏字符下标
                badIdx.add(index);
                //如果到达叶子节点，则将脏字替换成指定字符
                if (current.end) {
                    for (int idx = 0; idx < badIdx.size(); idx++) {
                        ca[badIdx.get(idx)] = mark;
                    }
                    break;
                }
                //将index+1，匹配下一个字符
                //如果到达文本的长度，且未达到叶子节点，则退出while。
                if (text.length() == ++index) {
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char c : ca) {
            sb.append(c);
        }
        return sb.toString();
    }

    /**
     * trie数基本节点结构
     * Created by Sawyer on 2016/6/7
     */
    private static class TrieNode {
        public char value;
        public Map<Character, TrieNode> child = new HashMap<Character, TrieNode>();
        private boolean end = false; //新节点都为非叶子节点

        public TrieNode() {

        }

        //增加一个节点
        public TrieNode add(char newChar) {
            //检查是否已经有该子节点
            TrieNode t = child.get(newChar);
            if (t == null) t = new TrieNode();
            t.value = newChar;
            //将该值加入子节点
            child.put(newChar, t);
            //返回子节点
            return t;
        }
    }

    /**
     * 返回的敏感词对象
     * Created by Sawyer on 2016/6/7
     */
    private static class IndexWordPair {
        public int index;
        public String word;

        public IndexWordPair(int index, String word) {
            this.index = index;
            this.word = word;
        }
    }
}
