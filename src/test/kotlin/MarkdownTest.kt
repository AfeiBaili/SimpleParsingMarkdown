import kotlin.test.Test

class MarkdownTest {
    @Test
    fun test1() {
        val text = """
            小鲸鱼来推荐美食啦！(≧▽≦)/ 下面是几种常见食物的分类表格：

            | 食物类型   | 例子              | 特点                      | 推荐指数 |
            |------------|-------------------|--------------------------|----------|
            | 🍎 水果类   | 草莓、芒果、西瓜  | 富含维生素，清爽解渴      | ⭐⭐⭐⭐   |
            | 🥬 蔬菜类   | 菠菜、西兰花、胡萝卜 | 膳食纤维丰富，健康低卡    | ⭐⭐⭐⭐   |
            | 🍖 肉类     | 牛排、鸡胸肉、三文鱼 | 高蛋白质，饱腹感强        | ⭐⭐⭐    |
            | 🍚 主食类   | 米饭、全麦面包、燕麦 | 提供碳水化合物能量        | ⭐⭐⭐⭐   |
            | 🧀 乳制品   | 奶酪、酸奶、牛奶    | 钙质丰富，帮助骨骼生长    | ⭐⭐⭐⭐   |
            | 🍫 零食类   | 巧克力、薯片、饼干  | 快乐源泉但注意适量哦~     | ⭐⭐      |

            小鲸鱼提醒：均衡饮食最重要啦！(๑•̀ㅂ•́)و✧  
            想了解哪种食物的详细信息可以告诉小鲸鱼~ 🐳
        """.trimIndent()

        val markdown = Markdown()

        println(markdown.parsingText(text))
    }

    @Test
    fun test2() {
        val text = "| 你好 | 打    |  好滴       |"
        "(?<=\\|)\\s*([^|]*?)\\s*(?=\\|)".toRegex().findAll(text).forEach { println(it.groupValues[1]) }
    }

    @Test
    fun test3() {
        println("(?=\\d)".toRegex().containsMatchIn("aaa"))
    }
}