package 进阶班.class08;

import java.util.HashMap;

/**
 * @author Doromv
 * @create 2022-05-10-14:34
 */
public class TrieTree {
    public static class Node{
        public int pass;
        public int end;
        public Node[] nexts;

        public Node() {
            this.pass =0;
            this.end =0;
            this.nexts = new Node[26];
        }
    }

    public static class Trie {
        private Node root;

        public Trie() {
            this.root = new Node();
        }

        public void insert(String word) {
            if(word==null){
                return;
            }
            char[] chars = word.toCharArray();
            Node cur= root;
            cur.pass++;
            int index=0;
            for (int i = 0; i < chars.length; i++) {
                index=chars[i]-'a';
                if(cur.nexts[index]==null){
                    cur.nexts[index]=new Node();
                }
                cur=cur.nexts[index];
                cur.pass++;
            }
            cur.end++;
        }

        public int search(String word) {
            if(word==null){
                return 0;
            }
            char[] chars = word.toCharArray();
            int index=0;
            Node cur=root;
            for (int i = 0; i < chars.length; i++) {
                index=chars[i]-'a';
                if(cur.nexts[index]==null){
                    return 0;
                }
                cur=cur.nexts[index];
            }
            return cur.end;
        }

        public void delete(String word) {
            if (search(word)!=0){
                Node cur=root;
                cur.pass--;
                int index=0;
                char[] chars = word.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    index=chars[i]-'a';
                    if(--cur.nexts[index].pass==0){
                        cur.nexts[index]=null;
                        return;
                    }
                    cur=cur.nexts[index];
                }
                cur.end--;
            }
        }

        public int prefixNumber(String pre) {
            if(pre==null){
                return 0;
            }
            Node cur=root;
            int index=0;
            char[] chars = pre.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                index=chars[i]-'a';
                if(cur.nexts[index]==null){
                    return 0;
                }
                cur=cur.nexts[index];
            }
            return cur.pass;
        }
    }

    public static class Right {

        private HashMap<String, Integer> box;

        public Right() {
            box = new HashMap<>();
        }

        public void insert(String word) {
            if(box.containsKey(word)){
                box.put(word, box.get(word)+1);
            }else {
                box.put(word,1);
            }
        }

        public void delete(String word) {
            if (box.containsKey(word)) {
                if (box.get(word) == 1) {
                    box.remove(word);
                } else {
                    box.put(word, box.get(word) - 1);
                }
            }
        }

        public int search(String word) {
            if (!box.containsKey(word)) {
                return 0;
            } else {
                return box.get(word);
            }
        }

        public int prefixNumber(String pre) {
            int count = 0;
            for (String cur : box.keySet()) {
                if (cur.startsWith(pre)) {
                    count += box.get(cur);
                }
            }
            return count;
        }
    }
    // for test
    public static String generateRandomString(int strLen) {
      char[] ans=new char[(int) (Math.random()*strLen)+1];
        for (int i = 0; i < ans.length; i++) {
            int value= (int) (Math.random()*26);
            ans[i]= (char) (97+value);
        }
        return String.valueOf(ans);
    }

    // for test
    public static String[] generateRandomStringArray(int arrLen, int strLen) {
        String[] ans = new String[(int) (Math.random() * arrLen) + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = generateRandomString(strLen);
        }
        return ans;
    }

    public static void main(String[] args) {
        int arrLen = 100;
        int strLen = 20;
        int testTimes = 100000;
        for (int i = 0; i < testTimes; i++) {
            String[] arr = generateRandomStringArray(arrLen, strLen);
            Trie trie = new Trie();
            Right right = new Right();
            for (int j = 0; j < arr.length; j++) {
                double decide = Math.random();
                if (decide < 0.25) {
                    trie.insert(arr[j]);
                    right.insert(arr[j]);
                } else if (decide < 0.5) {
                    trie.delete(arr[j]);
                    right.delete(arr[j]);
                } else if (decide < 0.75) {
                    int ans1 = trie.search(arr[j]);
                    int ans3 = right.search(arr[j]);
                    if (ans1 !=ans3) {
                        System.out.println("Oops!");
                    }
                } else {
                    int ans1 = trie.prefixNumber(arr[j]);
                    int ans3 = right.prefixNumber(arr[j]);
                    if (ans1 !=ans3) {
                        System.out.println("Oops!");
                    }
                }
            }
        }
        System.out.println("finish!");

    }
}
