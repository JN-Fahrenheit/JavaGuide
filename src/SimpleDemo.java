import com.sun.xml.internal.bind.v2.runtime.output.StAXExStreamWriterOutput;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 交易实体类
class Trade {
    private Integer amount;
    // 构造方法：创建Trade对象时必须传入金额
    public Trade(Integer amount) { this.amount = amount; }
    // Getter方法：外部类获取私有amount的唯一入口
    public Integer getAmount() { return amount; }
}

public class SimpleDemo {
    public static void main(String[] args) {
        //初始化交易集合，快速生成固定长度 List，存放 4 笔交易
        List<Trade> list = Arrays.asList(
                new Trade(8000), new Trade(15000), new Trade(22000), new Trade(11000)
        );


        // 筛选+排序， 把普通List 转为流 Stream，开启流式链式操作（中间操作 + 终端操作）
        List<Trade> sortedList = list.stream()
                // 1. 过滤：只保留金额大于10000的交易
                .filter(t -> t.getAmount() > 10000)
                // 2. 排序：根据交易金额升序从小到大排
                .sorted(Comparator.comparingInt(Trade::getAmount))
                // 3. 收集流转回List集合
                .collect(Collectors.toList());

        // 遍历取最值总和
        int min = sortedList.get(0).getAmount();
        int max = sortedList.get(sortedList.size()-1).getAmount();
        int sum = 0;
        for(Trade t : sortedList) sum += t.getAmount();

        // Stream直接获取

        OptionalInt minStream = sortedList.stream().mapToInt(Trade::getAmount).min();
        System.out.println("最小值：" + minStream);
        OptionalInt maxStream = sortedList.stream().mapToInt(Trade::getAmount).max();
        System.out.println("最大值：" + maxStream);
        int sumStream = sortedList.stream().mapToInt(Trade::getAmount).sum();
        System.out.println("总和：" + sumStream);


    }

}
