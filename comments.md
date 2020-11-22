### 完成度：
* 没有实现专门查询分组的接口

__Details:__

- \- 分组接口返回的组不包含组名

### 测试：
* 无测试

__Details:__



### 知识点：
* 使用了三层架构
* 需要了解Restful实践
* 了解下lombok的使用

__Details:__

- \- 构造函数注入时推荐添加final
- \- @CrossOrigin可以放在类上
- \- @GetMapping可以省略produces属性
- \- 没有使用泛型
- \- 违反Restful实践, url不合理
- \- 违反Restful实践, Post请求成功后应该返回201
- \- 可以使用lambda表达式简化代码
- \- 打乱顺序可以了解下Collections.shuffle()
- \- Repository应该命名为xxxRepository

### 工程实践：
* 注意单一职责，group和student应该有单独的Controller和Service
* 需要加强面向对象的意识

__Details:__

- \- 代码中应该保证List总不为null
- \- 长方法，建议抽子方法来提高可读性
- \- 应该创建专门的对象来表示Group
- \- Magic Number
- \- 不推荐使用数组
- \- 变量不表意
- \- 注意代码风格，需要适当的添加空格
- \- 计算id的方式不够健壮，可以使用字段保存最大id

### 综合：


__Details:__



