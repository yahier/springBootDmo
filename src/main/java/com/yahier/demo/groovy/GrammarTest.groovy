package com.yahier.demo.groovy

/**
 * groovy语法测试篇章 很像js和Python语法
 * create on 2018.12.21 by yahier
 * java代码基本都可以正常运行
 */
class GrammarTest {
    static void main(args) {
        test1()
        testPOJO()
        //testFileIO()
        testLambda()
    }

    static void test1() {
        //定义数组
        int[] arr = [1, 2, 3, 4]
        //定义区间
        def range = 4..7

        for (x in range)
            println x

        //定义插值字符串
        def name = 'yahier'
        println "hello $name" //打印hello yahier

        //定义列表 默认实现是ArrayList
        def list = [1, 2, 3, 4]

        //定义map 默认实现是LinkedHashMap
        def colors = [red: '#FF0000', green: '#00FF00', blue: '#0000FF']
        println colors['red']


    }

    /**
     * 测试POJO对象 很有意思
     */
    static void testPOJO() {
        Person person = new Person(name: '张三')
        def person1 = new Person()
        person1.setName("halo")
        //==和equals效果一样
        if (person.getName() == '张三') {
            println true
        } else {
            println false
        }

    }

    static void testFileIO() {
        String filePath = '/Users/yahier/Desktop/TEST.txt'
        //In Groovy
        new File(filePath).eachLine('UTF-8') {
            println it
        }
        println()
        println()
        println()

        //或者这样，更接近于Java的方式
        new File(filePath).withReader('UTF-8') { reader ->
            reader.eachLine {
                println it
            }
        }
        println()
        println()
        println()

        //如果只是为了读取并打印出文本的内容的话，下面是最简洁的方式
        print new File(filePath).text

    }


    static void testLambda() {
        println 'testLambda开始'
        List list = Arrays.asList('1', '2', '3')
        //groovy定义list
        def list2 = [1, 2, 3, 4]
        Runnable run = { println 'run' }
        list2.each { println it } // or list.each(this.&println)
    }

    static String testRetun1() {
        'testReturn'
    }

    public static def testRetun2() {
        'testReturn'
    }

}
