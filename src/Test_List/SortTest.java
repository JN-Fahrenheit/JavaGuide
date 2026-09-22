package Test_List;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class SortTest {
    // 定义一个全局成员集合，存储 User 用户对象；
    //初始赋值为null，此时只是引用，没有实际 ArrayList 容器
    List<User> userList = null;

    @Before
    public void setUp() throws Exception {
        // new ArrayList<>()，创建空的 ArrayList 容器，给全局 userList 分配内存，解决空指针风险
        userList = new ArrayList<>();
        userList.add(new User(1, "小明", 22, "北京"));
        userList.add(new User(2, "小红", 18, "上海"));
        userList.add(new User(3, "小花", 22, "广州"));
        userList.add(new User(4, "小刚", 33, "深圳"));
        // 打印集合 System.out.println(userList) 时，Java 会自动调用集合内每个对象的 toString()；
        // 如果你手动重写 toString()，会直接使用 Object 父类默认实现；如有重写，则使用当前重写后的结果
        System.out.println("原始数据是：" + userList.toString());
    }

    //待办：分析这里
    @Test
    /*
    comparing(Function keyExtractor)：通用版，接收包装类型（Integer/Long/String 等），返回 Comparator<T>；底层会自动装箱、拆箱，存在少量包装类开销。
    comparingInt(ToIntFunction keyExtractor)：专用基础 int 版本，接收原始基本类型 int，返回 Comparator<T>；全程无装箱拆箱，性能更好，专门针对 int 字段（age、id、金额）
    调用List 中的sort方法来排序，并直接改变 原list集合顺序
     */

    public void listSortTest() {
        userList.sort(Comparator.comparingInt(User::getAge));
        System.out.println("使用sort方法按照年龄排序ASC从小到大：" + userList);

        // 使用 Compator 方法按照单字段id做从大到小排序，reversed是做次序反转
        userList.sort(Comparator.comparing(User::getId).reversed());
        System.out.println("使用 Compator 方法：" + userList);
    }

    @Test
    public void listSortTest2() {
        // 多条件排序： 年龄asc，id DESC
        System.out.println("多条件排序： 年龄asc，id DESC：" + userList);
        userList.sort(Comparator.comparing(User::getAge));
        userList.sort(Comparator.comparing(User::getId).reversed());

        int max, min, sum = 0;

        max = userList.get(userList.size() - 1).getAge();
        min = userList.get(0).getAge();
        for (User user : userList) {
            sum += user.getAge();
        }
        System.out.println("获取最大age值" + max);
        System.out.println("获取最大age值" + min);
        System.out.println("获取最大age值" + sum);
    }

    @Test
    /*
    使用Stream中的sort方法排序
     */
    public void ListStramSortTest() {
        // stream方法按id排序，从大到小，把List转为流Stream，可以进行流式操作，最终收集流转为List集合
        List<User> collect = userList.stream().sorted(Comparator.comparing(User::getId).reversed()).collect(Collectors.toList());
        System.out.println("id按DESC排序从大到小" + collect);
        // stream方法，默认从小到大
        List<User> collect1 = userList.stream().sorted(Comparator.comparing(User::getAge)).collect(Collectors.toList());
        System.out.println("id按ASC排序从小到大" + collect1);
        //拿到age的最小值
        //int min = collect.stream().mapToInt(User::getAge).min().getAsInt();
        int min = collect.get(collect.size() - 1).getAge();
        int max = collect.get(0).getAge();
        int sum = 0;
        for (User c : collect) {
            sum += c.getAge();
        }
        System.out.println("最小值：" + min);
        System.out.println("最大值：" + max);
        System.out.println("年龄总和：" + sum);
        IntStream ageStream = collect.stream().mapToInt(User::getAge);
        ageStream.forEach(age -> System.out.println("当前每条年龄数据：" + String.valueOf(age)));
    }

    @Test

    @After
    public void tearDown() throws Exception {
        System.out.println("");
        System.out.println("输出完毕");
    }
}