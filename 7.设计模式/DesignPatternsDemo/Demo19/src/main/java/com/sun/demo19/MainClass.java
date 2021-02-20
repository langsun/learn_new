package com.sun.demo19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * 解释器模式
 * <p>
 * 1) 在编译原理中，一个算术表达式通过词法分析器形成词法单元，而后这些词法单元再通过语法分析器构建语法分析树，最终形成一颗抽象的语法分析树。这里的词法分析器和语法分析器都可以看做是解释器
 * 2) 解释器模式(InterpreterPattern):是指给定一个语言(表达式)，定义它的文法的一种表示，并定义一个解释器，
 * 使用该解释器来解释语言中的句子(表达式) 3) 应用场景
 * -应用可以将一个需要解释执行的语言中的句子表示为一个抽象语法树
 * -一些重复出现的问题可以用一种简单的语言来表达
 * -一个简单语法需要解释的场景
 * 4) 这样的例子还有，比如编译器、运算表达式计算、正则表达式、机器人等
 * <p>
 * 角色
 * <p>
 * 1) Context: 是环境角色,含有解释器之外的全局信息.
 * 2) AbstractExpression: 抽象表达式， 声明一个抽象的解释操作,这个方法为抽象语法树中所有的节点所共享
 * 3) TerminalExpression: 为终结符表达式, 实现与文法中的终结符相关的解释操作
 * 4) NonTermialExpression: 为非终结符表达式，为文法中的非终结符实现解释操作.
 * 5) 说明:输入ContextheTerminalExpression信息通过Client输入即可
 * <p>
 * 注意事项
 * 1) 当有一个语言需要解释执行，可将该语言中的句子表示为一个抽象语法树，就可以考虑使用解释器模式，让程 序具有良好的扩展性
 * 2) 应用场景:编译器、运算表达式计算、正则表达式、机器人等
 * 3) 使用解释器可能带来的问题:解释器模式会引起类膨胀、解释器模式采用递归调用方法，将会导致调试非常复杂、效率可能降低.
 */
public class MainClass {
    public static void main(String[] args) throws IOException {
        String expStr = getExpStr(); // a+b
        HashMap<String, Integer> var = getValue(expStr);// var {a=10, b=20}
        Calculator calculator = new Calculator(expStr);
        System.out.println("运算结果:" + expStr + "=" + calculator.run(var));

    }

    // 获得表达式
    public static String getExpStr() throws IOException {
        System.out.print("请输入表达式:");
        return (new BufferedReader(new InputStreamReader(System.in))).readLine();
    }

    // 获得值映射
    public static HashMap<String, Integer> getValue(String expStr) throws IOException {
        HashMap<String, Integer> map = new HashMap<>();
        for (char ch : expStr.toCharArray()) {
            if (ch != '+' && ch != '-') {
                if (!map.containsKey(String.valueOf(ch))) {
                    System.out.print("请输入" + String.valueOf(ch) + "的值:");
                    String in = (new BufferedReader(new InputStreamReader(System.in))).readLine();
                    map.put(String.valueOf(ch), Integer.valueOf(in));
                }
            }
        }
        return map;
    }
}