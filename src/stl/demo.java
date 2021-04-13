package stl;

import org.junit.Test;

import java.util.*;

/**
 * ArrayList
 * Queue
 * stk
 * Deque  双端队列
 * Set
 * Map
 * BitSet
 * Pair
 * 位运算
 * 常用库函数：
 * 		翻转、去重、随机打乱、sort
 * 		lower_bound/upper_bound、nth_element
 */

public class demo {
    @Test
    public void test1(){
        //定义一个arraylist
        List<Integer> a = new ArrayList<>();
        // 定义一个初始容量为3
        List<Integer> b = new ArrayList<>(3);
        // 定义一个包含1，2，3 的ArrayList
        ArrayList<Integer> c = new ArrayList<>(Arrays.asList(1,2,3));

        // 遍历ArrayList
        for (int i = 0; i < c.size(); i++) {
            System.out.println(c.get(i));
        }
        for (int x: c
             ) {
            System.out.println(x);
        }


        //获取ArrayList 第一个和最后一个元素

        System.out.println(c.get(0));
        System.out.println(c.get(c.size() - 1));

        // 在ArrayList尾部添加、删除元素
        c.add(4);
        c.remove(c.size() -1 );
        c.remove(c.size() -1 );

        System.out.println(c.size());

        //清空 ArrayList
        c.clear();
        System.out.println(c.size()); //0

    }

    @Test
    public void test2(){
        // 定义队列
        Queue<Integer> q = new LinkedList<>();

        // 入队、出队
        q.add(4); //4
        q.add(3); // 4 3
        q.add(7);  // 4 3 7
        q.remove(); // 3 7
        //获取queue 队首的元素
        System.out.println(q.peek());  // 3

        //清楚队列
        q.clear();
        System.out.println(q.size()); //0
        System.out.println(q.isEmpty());  // true


        // 定义PriorityQueue
        System.out.println("=========优先队列============");
        Queue<Integer> a = new PriorityQueue<>(); //小根堆
        Queue<Integer> b = new PriorityQueue<>((((o1, o2) -> o2 -o1))); // 大根堆

        class Rec implements Comparable<Rec>{
            int x, y;

            public Rec(int x,int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public int compareTo(Rec o) {
                return this.x - o.x;
            }

            @Override
            public String toString() {
                return "Rec{" +
                        "x=" + x +
                        ", y=" + y +
                        '}';
            }
        }

        Queue<Rec> c = new PriorityQueue<>(); //此时为小根堆

        c.add(new Rec(1, 2));
        c.add(new Rec(6, 7));
        c.add(new Rec(5, 4));
        c.add(new Rec(3, 9));
        System.out.println(c.peek()); // 返回堆顶
        
    }


    @Test
    public void test03(){
        // 定义 stk堆栈
        Deque<Integer> stack = new ArrayDeque<>();
        // 入栈、出栈
        stack.push(20);
        stack.push(10);
        stack.push(30);

        int i = stack.pop(); // 弹出30
        System.out.println("第一个被弹出的："+ i);

        // 清空stack
        stack.clear();
        System.out.println(stack.size());
        System.out.println(stack.isEmpty());

    }

    @Test
    public void test04(){
        // 定义 deque
        Deque<Integer> d = new ArrayDeque<>();
        // 双端队列插入，删除元素
        d.addLast(20);  //尾部插入 20 , 10
        d.addLast(10);

        d.removeLast() ;; // 尾部弹出  10   (20)

        d.addFirst(40);
        d.addFirst(30); // (30 40 20)
        for (int x:
             d) {
            System.out.println(x);
        }
        
        // 返回头部和尾部元素
        System.out.println(d.getFirst());
        System.out.println(d.getLast());


        //
        d.clear();
        

    }

    @Test
    public void  test05(){
        /**
         * 有序的set： TreeSet
         * set 元素不重复，Treeset内部红黑树，保持有序
         */
        TreeSet<Integer> a = new TreeSet<>();
        class Rec implements Comparable<Rec>{
            int x , y;

            public Rec(int x, int y) {
                this.x = x;
                this.y = y;
            }

            @Override
            public int compareTo(Rec o) {
                return this.x - o.x;
            }

    }
        TreeSet<Rec> b = new TreeSet<>();    // set 中插入、删除元素
        a.add(20);
        a.add(3);
        a.add(1);
        a.remove(3);
        // 返回第一个和最后一个
        System.out.println(a.first()); // 1
        System.out.println(a.last());      //20
        // 遍历 set ，不能用fori遍历
        for (int x :
             a ) {
            System.out.println(x);
        }
        System.out.println("迭代器");
         for (Iterator<Integer> iterator = a.iterator(); iterator.hasNext(); ) {
//                    iterator.next();
             System.out.println(iterator.next());
}

         // set 是否存在某一元素
         System.out.println(a.contains(20));

         // ceiling /higher
         a.add(4);
         a.add(12); // a : 1, 4, 12 ,20
        System.out.println(a.ceiling(4)); // 返回大于等于4的最小元素：4
        System.out.println(a.higher(4)); // 返回大于4的最小元素：12


        // 补充 floor lower
        System.out.println("floor , lower");
        System.out.println(a.floor(4)); // 返回小于等于4的最大元素  ：4
        System.out.println(a.lower(4));    // 返回小于4的 ：1


        /**
         * 无序set:HashSet
         */

        System.out.println("==========无序hashset========================");
        //不重复，hashset内部是哈希表，不可以保持有序
        HashSet<Integer> hash = new HashSet<>();
        // set 中插入、删除元素
        hash.add(1); hash.add(2); hash.add(3); hash.add(4);
        hash.remove(2);
        // 遍历 set，不能使用fori进行遍历
        for (int x : hash) System.out.print(x + " ");
        System.out.println();
        // set 中判断某元素是否存在
        System.out.println(hash.contains(3));  // true
        // 清空 set
        hash.clear();
        System.out.println(hash.size());  // 0
        System.out.println(hash.isEmpty());  // true

    }



    @Test
    public void test06() {
        /**
         * 有序的map： TreeMap
         * map 不能重复
         */

        TreeMap<String, Integer> a = new TreeMap<>();
        // map 中插入，删除元素
        a.put("wxx", 21);
        a.put("hh", 18);
        a.put("other", 20);
        a.remove("other");

        // 返回第一个和最后一个元素

        System.out.println(a.firstEntry()); // hh = 18
        System.out.println(a.lastEntry()); // wxx = 21

        // 遍历map
        for (Map.Entry<String, Integer> p : a.entrySet()) {
            System.out.println(p);
        }

        for (String k : a.keySet()) {
            System.out.println(k);
        }


        System.out.println("迭代器遍历");

        Iterator<Map.Entry<String, Integer>> iterator = a.entrySet().iterator();//返回所有的entry实体
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> next1 = iterator.next();
            String key = next1.getKey();
            int value = next1.getValue();
            System.out.println(key + " " + value);
        }
        //通过键来遍历
        Iterator iterator1 = a.keySet().iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }
        //通过值来遍历
        Iterator iterator2 = a.values().iterator();
        while (iterator2.hasNext()) {
            System.out.println(iterator2.next());
        }
        // map 中判断某元素是否存在
        System.out.println(a.containsKey("wxx"));  // true
        // ceilingKey/higherKey
        a.put("c1", 2); a.put("c2", 4);  // a: {c1=2, c2=4, hh=18, wxx=21}
        System.out.println(a.ceilingKey("c1"));  // 返回大于等于"c1"的最小元素: c1
        System.out.println(a.higherKey("c1"));  // 返回大于"c1"的最小元素: c2
        // 补充：floorKey/lowerKey
        System.out.println(a.floorKey("c1"));  // 返回小于等于"c1"的最大元素: c1
        System.out.println(a.lowerKey("c1"));  // 返回小于"c1"的最大元素: null
        // 清空 set
        a.clear();
        System.out.println(a.size());  // 0
        System.out.println(a.isEmpty());  // tru

        // hashmap
        System.out.println("-------------hashMap---------------------------");
        HashMap<String,Integer> hash = new HashMap<>();
        // set 中插入、删除元素
        hash.put("wxx", 21); hash.put("hh", 18); hash.put("other", 20);
        hash.remove("other");
        // 遍历 set，不能使用fori进行遍历
        for (Map.Entry<String, Integer> p : hash.entrySet()) System.out.print(p + "\t");
        System.out.println();
        for (String k : hash.keySet()) System.out.print(k + ":" + hash.get(k) + "\t");
        System.out.println();
        // set 中判断某元素是否存在
        System.out.println(hash.containsKey("wxx"));  // true
        // 清空 set
        hash.clear();
        System.out.println(hash.size());  // 0
        System.out.println(hash.isEmpty());  // true


    }


            }