# Day12 JavaObject02-3

1. 结合多态发生的条件，及继承相关知识，自己总结并验证下，哪些方法无法实现多态效果。

2. 自己定义一个类，类中定义 3 个成员变量，这 3 个成员变量都被 final 修饰，请用 3 种不同方式，为这 3 个被 final 修饰的成员变量赋值。

3. 实现如下多态案例，分别定义 Person 类，SouthPerson（表示南方人），NorthPerson（表示北方人）。
    ```
    Person
    eat()

    SouthPerson
    eat()

    NorthPerson
    eat()
    ```
    写代码实现，eat 方法的多态效果：  
    1:人要吃饭  
    2:南方人吃炒菜和米饭  
    3:北方人吃烩菜和馒头  

答：  
1.   
父类中的 private 方法（不能被子类覆盖）  
父类中的构造方法（不能被子类继承）  
父类中的静态方法（不能被子类覆盖）  
父类中被 final 修饰的方法（不能被子类覆盖）  