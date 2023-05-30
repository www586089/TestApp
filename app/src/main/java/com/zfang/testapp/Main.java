package com.zfang.testapp;

import com.zfang.testapp.node.TreeNode;
import com.zfang.testapp.process.util.LogUtil;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Stack;

public class Main {

    private static Main app = new Main();
    /**
     * 要求程序对用户输入的字符串进行处理。具体规则如下：
     *  a）把每个单词的首字母变为大写
     *  b）把数字与字母之间用下划线字符（_）分开，使得更清晰
     *  c）把单词中间有多个空格的调整为1个空格
     *  例如：
     *  用户输入：
     *  you and me what    cpp2022program
     *  则程序输出：
     *  You And Me What Cpp_2022_program
     * @param args
     */
    public static void main(String[] args) {
//        new Main().test3("you and me what    cpp2022program");
//        new Main().fetchLength2(new int[] {1, 2, 3, 2, 3, 4, 3, 4, 5, 6, 7});
//        new Main().change(new int[] {5, 5, 10});
//        new Main().largestPerimeter(new int[] {3, 6, 2, 3});
//        new Main().treeTest();
//        new Main().bitTest();
//        app.weakRefenceTest();
//        app.dateSelect();
        app.dateCompute();
    }
    // 创建一个引用队列
    ReferenceQueue<Object> queue = new ReferenceQueue<>();

    private void weakRefenceTest() {
        // 创建一个对象
        Object obj = new Object();
        // 创建一个弱引用，并指向这个对象，并且将引用队列传递给弱引用
        WeakReference<Object> reference = new WeakReference<>(obj, queue);
        // 打印出这个弱引用，为了跟gc之后queue里面的对比证明是同一个
        System.out.println("这个弱引用是:" + reference);
        // gc一次看看(毛用都没)
        System.gc();
        // 打印队列(应该是空)
        printlnQueue("before");

        // 先设置obj为null，obj可以被回收了
        obj = null;
        // 再进行gc，此时obj应该被回收了，那么queue里面应该有这个弱引用了
        Runtime.getRuntime().gc();
//        System.gc();
        // 再打印队列
        printlnQueue("after");
//        dateSelect();
    }

    private void dateCompute() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault());

        Calendar calendarStart = Calendar.getInstance();
        Calendar calendarEnd = Calendar.getInstance();
        calendarStart.add(Calendar.YEAR, -1);
        calendarStart.add(Calendar.DAY_OF_YEAR, 1);

        String startTimeStr = sdf.format(calendarStart.getTime());
        String endTimeStr = sdf.format(calendarEnd.getTime());
        System.out.println("startTimeStr = " + startTimeStr + ", endTimeStr = " + endTimeStr);
    }

    private void dateSelect() {
        int startTime = 0, endTime = 0;
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(Calendar.YEAR, 2023);
        calendar.set(Calendar.MONTH, 1);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
//        String endTimeStr = sdf.format(calendar.getTime());
//        if (endTimeStr.length() > 0) {
//            endTime = intValue(endTimeStr);
//        }
//        calendar.add(Calendar.MONTH, -6);
//        calendar.add(Calendar.DAY_OF_MONTH, 1);
//        String startTimeStr = sdf.format(calendar.getTime());
//        if (startTimeStr.length() > 0) {
//            startTime = intValue(startTimeStr);
//        }
        int nowYear = calendar.get(Calendar.YEAR);
        int nowMonth = calendar.get(Calendar.MONTH);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd", Locale.getDefault());
        String endTimeStr = sdf.format(calendar.getTime());
        if (endTimeStr.length() > 0) {
            endTime = intValue(endTimeStr);
        }
        logCalendar(calendar);
        LogUtil.println("nowYear = " + nowYear + ", nowMonth = " + nowMonth + " time = " + endTime);

        calendar.set(Calendar.MONTH, 12);
        logCalendar(calendar);
        calendar.set(Calendar.DAY_OF_MONTH, calendar.getActualMaximum(Calendar.DATE));
        logCalendar(calendar);
        nowMonth = calendar.get(Calendar.MONTH);
        String time = sdf.format(calendar.getTime());
        logCalendar(calendar);
        LogUtil.println("nowYear = " + nowYear + ", nowMonth = " + nowMonth  + " time = " + time);

        log("startTime = " + startTime + ", endTime = " + endTime);
    }

    private void logCalendar(Calendar calendar) {

        LogUtil.println("getMaximum = " + calendar.getMaximum(Calendar.DATE));
        LogUtil.println("getActualMaximum = " + calendar.getActualMaximum(Calendar.DATE));
//
//        LogUtil.println("getMaximum2 = " + calendar.getMaximum(Calendar.DAY_OF_MONTH));
//        LogUtil.println("getActualMaximum2 = " + calendar.getActualMaximum(Calendar.DAY_OF_MONTH));
    }


    public static int intValue(String text) {
        try {
            double value = Double.parseDouble(text);
            return (int) value;
        } catch (Exception e) {
            return 0;
        }
    }
    private void printlnQueue(String tag) {
        System.out.print(tag);
        Object obj;
        // 循环打印引用队列
        while ((obj = queue.poll()) != null) {
            System.out.println(": " + obj);
        }
        System.out.println();
    }

    /**
     * -1: 1110 0000000000000000000000000000    32
     *  0: 0
     *  1: 0010 0000000000000000000000000000    30
     *  2: 0100 0000000000000000000000000000    31
     *  3: 0110 0000000000000000000000000000    31
     */
    private void bitTest() {
        int bitCount = Integer.SIZE - 3;
        System.out.println("-1: " + Integer.toBinaryString(-1 << bitCount) + "  " + (-1 << bitCount));
        System.out.println(" 0: " + Integer.toBinaryString(0 << bitCount) + "  " + (0 << bitCount));
        System.out.println(" 1: " + Integer.toBinaryString(1 << bitCount) + "  " + (1 << bitCount));
        System.out.println(" 2: " + Integer.toBinaryString(2 << bitCount) + "  " + (2 << bitCount));
        System.out.println(" 3: " + Integer.toBinaryString(3 << bitCount) + "  " + (3 << bitCount));
    }

    private void treeTest() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node6;
        node5.right = node7;

//        preOrder(node1);
//        preOrderIterate(node1);
//        morrisPreOrder(node1);
//        inOrder(node1);
//        inOrderIterate(node1);
//        morrisInOrder(node1);
//        afterOrder(node1);
//        postOrderIterate(node1);
//        morrisPostOrder(node1);
//        List<TreeNode> list = new ArrayList<>();
//        levelOrder(node1, 1, list);
//        printList(list);
//        levelOrderIterate(node1);

        testReverse();
    }

    private void testReverse() {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.right = node2;
        node2.right = node3;
        node3.right = node4;
        node4.right = node5;
        node5.right = node6;
        node6.right = node7;

//        TreeNode root = reverse(node1);
//        printList(root);
//        root = reverse(root);
//        printList(root);
        TreeNode root = reverseNode(node1);
        printList(root);
    }

    private void printList(TreeNode root) {
        while (null != root) {
            log(root.value);
            root = root.right;
        }
    }

    private void morrisPreOrder(TreeNode cur) {
        if (null == cur) {
            return;
        }
        while (null != cur) {
            TreeNode mostRight = cur.left;
            if (null != mostRight) {
                //找到当前节点的前驱节点（左子树的最右边节点）
                while (null != mostRight.right && cur != mostRight.right) {
                    mostRight = mostRight.right;
                }
                if (null == mostRight.right) {//建立索引
                    mostRight.right = cur;
                    log(cur.value);
                    cur = cur.left;
                    continue;
                } else {//删除索引
                    mostRight.right = null;
                }
            } else {
                //处理当前节点
                log(cur.value);
            }
            //处理右节点
            cur = cur.right;
        }
    }
    private void printList(List<TreeNode> list) {
        for (TreeNode node: list) {
//            if (null != node) {
                log(node);
//            }
        }
    }

    private void preOrder(TreeNode root) {
        if (null == root) {
            return;
        }
        log(root.value);//第一次成为栈顶元素打印
        preOrder(root.left);
        preOrder(root.right);
    }

    private void preOrderIterate(TreeNode root) {
        if (null == root) {
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            if (null != root) {
                log(root.value);
                stack.push(root.right);
                stack.push(root.left);
            }
        }
    }

    private void inOrder(TreeNode root) {
        if (null == root) {
            return;
        }

        inOrder(root.left);
        log(root.value);//第二次成为栈顶元素打印
        inOrder(root.right);
    }

    private void inOrderIterate(TreeNode root) {
        if (null == root) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || null != root) {
            if (null != root) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                log(root.value);
                root = root.right;
            }
        }
    }

    private void morrisInOrder(TreeNode cur) {
        if (null == cur) {
            return;
        }
        while (null != cur) {
            TreeNode mostRight = cur.left;
            if (null != mostRight) {
                //找到当前节点的前驱节点（左子树的最右边节点）
                while (null != mostRight.right && cur != mostRight.right) {
                    mostRight = mostRight.right;
                }
                if (null == mostRight.right) {//建立索引
                    mostRight.right = cur;
//                    log(cur.value);
                    cur = cur.left;
                    continue;
                } else {//删除索引
                    mostRight.right = null;
                }
            } else {
                //处理当前节点
//                log(cur.value);
            }
            log(cur.value);
            //处理右节点
            cur = cur.right;
        }
    }

    private void afterOrder(TreeNode root) {
        if (null == root) {
            return;
        }

        afterOrder(root.left);
        afterOrder(root.right);
        log(root.value);//第三次成为栈顶元素打印
    }
    private void postOrderIterate(TreeNode root) {
        if (null == root) {
            return;
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode preNode = null;
        while (!stack.isEmpty() || null != root) {
            if (null != root) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                //右节点为空或者右节点已经打印过则可以访问当前节点
                if (null == root.right || preNode == root.right) {
                    preNode = root;
                    log(root.value);
                    root = null;
                } else {
                    //当前节点还不能访问，需要重新入栈
                    stack.push(root);
                    root = root.right;
                }
            }
        }
    }

    private void morrisPostOrder(TreeNode cur) {
        if (null == cur) {
            return;
        }
        TreeNode root = cur;
        while (null != cur) {
            TreeNode mostRight = cur.left;
            if (null != mostRight) {
                //找到当前节点的前驱节点（左子树的最右边节点）
                while (null != mostRight.right && cur != mostRight.right) {
                    mostRight = mostRight.right;
                }
                if (null == mostRight.right) {//建立索引
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                } else {//删除索引
                    mostRight.right = null;
                    printNode(cur.left);
                }
            }
            //处理右节点
            cur = cur.right;
        }

        printNode(root);//打印最后一条链路
    }

    private void printNode(TreeNode head) {
        TreeNode tail = reverse(head);
        head = tail;//先保存起来
        while (null != tail) {
            log(tail.value);
            tail = tail.right;
        }
        reverse(head);
    }

    /**
     * 迭代反转链表
     * @param head
     * @return
     */
    private TreeNode reverse(TreeNode head) {
        TreeNode prev = null;
        TreeNode cur = head;
        TreeNode next;
        while (null != cur) {
            //next 先后移一个位置，保存下一个要处理的节点
            next = cur.right;
            cur.right = prev;//指向前一个节点
            prev = cur;//前一个节点后移到当前位置

            //cur后移一个位置到要处理的节点
            cur = next;
        }

        return prev;
    }


    private TreeNode reverseNode(TreeNode head) {
        if (null == head || null == head.right) {
            return head;
        }
        TreeNode newHead = reverseNode(head.right);
        head.right.right = head;
        head.right = null;
        return newHead;
    }

    private void levelOrder(TreeNode root, int index, List<TreeNode> list) {
        if (null == root) {
            return;
        }

        int length = list.size();
        if (length <= index) {
            int count = (index + 1) - length;
            for (int i = 0; i < count; i++) {
                list.add(null);
            }
        }
        list.set(index, root);
        levelOrder(root.left, 2 *  index, list);
        levelOrder(root.right, 2 * index + 1, list);
    }

    private void levelOrderIterate(TreeNode root) {
        if (null == root) {
            return;
        }

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            root = queue.pop();
            log(root.value);

            if (null != root.left) {
                queue.offer(root.left);
            }
            if (null != root.right) {
                queue.offer(root.right);
            }
        }
    }

    private <T> void  log(T t) {
        System.out.println(t);
    }

    private void largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            if (nums[i] < nums[i - 1] + nums[i - 2]) {
                result = nums[i] + nums[i - 1] + nums[i - 2];
                break;
            }
        }

        System.out.println("result = " + result);
    }


    private void change(int[] bills) {
        int five = 0;
        int ten = 1;
        int[] fee = new int[2];
        boolean result = true;
        OutLoop: for (Integer item: bills) {
            switch (item) {
                case 5:
                    fee[five] += 1;
                    break;
                case 10:
                    if (fee[five] > 0) {
                        fee[five] -= 1;
                        fee[ten] += 1;
                    } else {
                        result = false;
                        break OutLoop;
                    }
                    break;
                case 20:
                    if (fee[ten] > 0 && fee[five] > 0) {
                        fee[five] -= 1;
                        fee[ten] -= 1;
                    } else if (fee[five] > 2) {
                        fee[five] -= 3;
                    } else {
                        result = false;
                        break OutLoop;
                    }
                    break;
            }
        }

        System.out.println("result = " + result);
    }
    private void change2(int[] bills) {
        Map<Integer, Integer> back = new HashMap<>();
        boolean result = true;
        int x5 = 0, x10 = 0;
        OutLoop: for (Integer item : bills) {
            int x = 0;
            if (null != back.get(item)) {
                x = back.get(item);
            }
            switch (item) {
                case 5:
                    back.put(5, x + 1);
                    break;
                case 10:
                    if (null != back.get(5)) {
                        x5 = back.get(5);
                    }
                    if (0 == x5) {
                        result = false;
                        break OutLoop;
                    } else {
                        back.put(5, x5 - 1);
                        back.put(10, x + 1);
                    }
                    break;
                case 20:
                    x10 = 0;
                    x5 = 0;
                    if (null != back.get(10)) {
                        x10 = back.get(10);
                    }
                    if (null != back.get(5)) {
                        x5 = back.get(5);
                    }
                    if (x10 > 0 && x5 > 0) {
                        back.put(10, x10 - 1);
                        back.put(5, x5 - 1);
                    } else if (x5 > 2) {
                        back.put(5, x5 - 3);
                    } else {
                        result = false;
                        break OutLoop;
                    }
                    break;
            }
        }
        System.out.println("resut = " + result);
    }

    private void fetchLength2(int[] nums) {
        int length = nums.length;
        int maxLength = 0;
        int start = 0;
        int i = 1;
        for (; i < length; i++) {
            if (nums[i] <= nums[i - 1]) {
                maxLength = Math.max(i - start, maxLength);
                start = i;
            }
        }

        System.out.println("maxLength = " + Math.max(i - start, maxLength));
    }

    private void fetchLength(int[] nums) {
        int maxLength = 0;
        int curMaxLength = 1;
        int length = nums.length;
        int prev = -1;
        int cur = nums[0];
        for (int i = 1; i < length; i++) {
            prev = cur;
            cur = nums[i];
            if (cur > prev) {
                curMaxLength++;
            } else {
                maxLength = Math.max(curMaxLength, maxLength);
                curMaxLength = 1;
            }
        }

        System.out.println("maxLength = " + Math.max(curMaxLength, maxLength));
    }

    private String test(String str) {
        int dif = 'a' - 'A';
        System.out.println("diff = " + dif);
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        System.out.println("lenght = " + length);
        for (int i = 0; i < length; ) {
            char ch = str.charAt(i);

            if (ch == ' ') {
                char chSpace;
                do {
                    i++;
                    if (i >= length) {
                        break;
                    }
                    chSpace = str.charAt(i);
                } while (chSpace == ' ');
                sb.append(ch);
            } else if (Character.isDigit(ch)) {
                char chDigit;
                sb.append("_");
                do {
                    chDigit = str.charAt(i);
                    if (Character.isDigit(chDigit)) {
                        sb.append(chDigit);
                    } else {
                        break;
                    }
                    i++;
                    if (i >= length) {
                        break;
                    }
                } while (true);
                sb.append("_");
            } else {
                char chChar = (char) (ch - 32);
                sb.append(chChar);
                do {
                    i++;
                    if (i >= length) break;
                    chChar = str.charAt(i);
                    if ((chChar >= 'A' && chChar <= 'Z') || (chChar >= 'a' && chChar <= 'z')) {
                        sb.append(chChar);
                    } else {
                        break;
                    }
                } while (true);
            }
        }

        System.out.println(sb.toString());
        return sb.toString();
    }

    private void test2(String str) {
        int length = str.length();
        boolean prevSpace = false;
        boolean spaceAdded = false;
        boolean prevDigit = false;
        boolean isFirst = true;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char ch = str.charAt(i);
            if (' ' == ch) {
                isFirst = true;
                if (!prevSpace && !spaceAdded) {
                    spaceAdded = true;
                    sb.append(ch);
                }
                prevSpace = true;
                prevDigit = false;
            } else if (Character.isDigit(ch)) {
                isFirst = true;
                prevSpace = false;
                spaceAdded = false;
                if (!prevDigit) {
                    sb.append("_");
                }
                prevDigit = true;
                sb.append(ch);
            } else {
                if (prevDigit) {
                    sb.append("_");
                }
                if (isFirst) {
                    ch = (char) (ch - 32);
                }
                sb.append(ch);
                isFirst = false;
                prevDigit = false;
                prevSpace = false;
                spaceAdded = false;
            }
        }

        System.out.println(sb.toString());
    }


    private void test3(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        char prev = ' ';
        char cur = ' ';
        for (int i = 0; i < length; i++) {
            prev = cur;
            cur = str.charAt(i);

            if (' ' == cur) {
                if (' ' != prev) {
                    sb.append(' ');
                }
            } else if (Character.isDigit(cur)) {
                if (!Character.isDigit(prev)) {
                    sb.append('_');
                }
                sb.append(cur);
                if (i + 1 < length && !Character.isDigit(str.charAt(i + 1))) {
                    sb.append('_');
                }
            } else {
                if (!Character.isAlphabetic(prev)) {
                    cur = (char) (cur - 32);
                }
                sb.append(cur);
            }
        }

        System.out.println(sb);
    }
}
