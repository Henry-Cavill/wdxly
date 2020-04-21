# week2

本周学习任务：  
- 抽象类及接口
- 内部类，匿名内部类
- Java 常见 Object 及 String 类
- 异常、异常分类、异常处理、自定义异常
- 多线程概述、实现方案、线程调度和线程控制、线程生命周期、线程同步、线程锁、死锁问题、线程间通信、生产者消费者问题等
- Java 文件的常见操作

## 目录

- [抽象类及接口](#抽象类及接口)



## 抽象类及接口

### 抽象类

抽象类：在普通类的结构里面增加抽象方法的组成部分。  
抽象方法：没有方法体的方法。
- **抽象类和抽象方法必须用 abstract 关键字修饰。**
  ```java
  abstract class 类名 {}    // 抽象类
  public abstract void 方法名();    // 抽象方法
  ```  

- 抽象类不一定有抽象方法，有抽象方法的类一定是抽象类。

- 抽象类不能直接实例化，不过可以间接实例化：`抽象类类型 引用 = new 具体子类();`。  

- 抽象类的子类可以是抽象类，也可以是具体类。

抽象类的成员特点：  
- 构造方法：同普通类。

- 成员变量：同普通类。

- 成员方法：可以是抽象方法，也可以是非抽象方法。  
  一个不包含抽象方法的抽象类的意义：
  - 虽然不包含抽象方法，但是依然无法直接使用它（new 该类型的对象）。  
  - 如果别人使用你定义的抽象类，就必须自己定义一个子类继承抽象类。此时可能就会查看抽象类的定义，你在抽象类中的注释就会提示代码的使用者，哪些方法适用哪些场景。

注：代码中永远是通过多态调用子类覆盖抽象父类来使用 abstract 定义的抽象方法，而被 private，final，static 关键字修饰的方法都不能在子类中被覆盖，因此 private，final，static 这三个关键字不能和 abstract 共存。

### 接口

如果一个类只是由抽象方法和全局常量组成的，在这种情况下通常不会将其定义为一个抽象类，而是定义为接口。所以所谓的接口严格来讲就属于一个特殊的类，这个类里面只有抽象方法和全局常量。  
注：接口不是类！而是对类的一组需求描述，这些类要遵从接口描述的统一格式进行定义。  

接口用关键字 interface 定义，格式：`interface 接口名 {}`。  

在 Java 语言中 interface 也可以表示一种数据类型。
- 类和接口都可以用来表示数据类型（类和接口是地位对等的），只不过他们的侧重点不一样。

- 操作（行为）描述：  
  类定义的是一个数据集合基于这个数据集的一组操作（行为），类所描述的这一组行为，它们是有关系的（间接），都可以访问同一个数据集合。  

  接口表示数据类型，侧重于描述一组具有特殊功能的行为。这些行为可以完全没有任何关系。

类和接口可以有实现关系（类可以实现接口），这种实现关系其实是一种实质上的继承关系。  
类实现接口用 implements 表示，格式：`class 类名 implements 接口名 {}`。  

接口的原则：  
- 接口不能直接实例化。

- 接口的子类可以是抽象类也可以是具体类。

接口的特点：  
- 无构造方法。

- 成员变量：只能是常量，修饰符 public static final。

- 成员方法：只能是抽象方法，修饰符 public abstract。

- 接口与接口之间可以实现多重继承；  
  一个类也可以实现多个接口，一个考虑接口的比较完整的类定义语法：  
  ```java
  class 类名 extends 父类 implements 接口 1, 接口 2... {

  }
  ```

抽象类和接口的比较：
- 成员区别  
  抽象类：变量、抽象方法、非抽象方法；  
  接口：常量、抽象方法。  

- 关系区别  
  类与类：继承、单继承；  
  类与接口：实现、单实现、多实现；  
  接口与接口：继承、单继承、多继承。  

- 设计理念区别  
  抽象类：被继承体现的是共性功能。  
    - 抽象类可以被其他类继承，而且子类只能 extends 一个类
    - 抽象被子类继承之后，子类和抽象类的关系是「is a」。  
  
  接口：被实现体现的是扩展功能。  
    - 一个类可以同时多个接口。
    - 类实现接口之后，类和接口的关系用「like a」来描述。

从 JDK8 开始，接口中可以定义两种特殊的方法，这两种方法可以有方法体，默认的访问权限都是 public。
- 默认方法：它就是一种折中，通过添加默认方法的方式修改接口。不会对已经实现接口的其他类造成影响。

- 静态方法：作为工具方法来使用。  


## 内部类和匿名内部类

### 内部类

在 Java 语言中类可以嵌套定义。  
内部类：定义在其他类内部的类就称为内部类。约定：把包含内部类的类，称之为外部类。  
注：内部类之所以存在，是为了方便外部类的操作。

内部类的访问特点：  
- 内部类可以直接访问外部类的成员，包括私有。

- 外部类要访问内部类的成员，必须创建对象。

按照内部类在类中定义的位置不同，可以分为如下两种格式：  
- 成员位置（成员内部类）
- 局部位置（局部内部类） 

成员内部类
- 成员内部类的定义位置：外部类的成员位置。  
  如果将内部类看做一个整体，对于外部类而言成员内部类就类似于一个成员变量或成员方法的一个普通成员。所以成员内部类在静态上下文中也无法访问非静态的成员。

- 成员内部类对象的实例化语法：`外部类.内部类 对象 = 外部类().new 内部类();`。  

- 成员内部的常见修饰符：  
  - private：保证成员位置内部类只对其外部类可见
  
  - static：一旦被 static 修饰，那么整个成员内部类就有了静态的访问特征：  
    普通成员内部类依赖于外部类对象而存在。创建普通成员内部类的语法：`外部类.内部类 对象 = 外部类().new 内部类();`。  
    静态成员内部类作为外部类的一个静态成员，不再依赖于外部类对象而存在。创建静态成员内部类的语法：`外部类.内部类 对象 = new 外部类.内部类();`

局部内部类
- 局部内部类的定义位置：方法体内

- 局部内部类的特征：
  可以创建内部类对象，通过对象调用内部类方法，来使用局部内部类功能。  
  
  注：所以局部内部类可以访问方法体中局部变量。但是，被局部内部类对象访问的局部变量必须被 final 关键字修饰。  
  这是因为局部内部类对象与局部变量的生命周期冲突：  
  - 局部变量的生命周期，随着方法的执行结束，即栈帧销毁，其从内存中消失。

  - 局部内部类对象存储在堆上，对象的销毁和方法栈帧没有直接关系。  

  - 简单来说就是方法运行结束后，局部变量不存在了，但是对象还在。因此要想继续正常使用局部内部类对象，就要将被其访问的局部变量用 final 关键字修饰。


### 匿名内部类

不管是成员或局部位置内部类，要使用内部类都分成了 2 步：  
- 定义内部类
- 创建内部类对象

通过定义匿名内部类对象，可以将上面的 2 步变为 1 步。前提：存在一个类（可以是具体类也可以是抽象类）或者接口。    

匿名内部类语法：`new 类名或者接口名() {重写方法;}`

本质：是一个继承了类或者实现了接口的子类匿名对象。

特征：匿名内部类对象只能在被创建的时候被访问一次。


## Object类及String类

### Object

Object 类是所有类的父类，也就是说任何一个类在定义时如果没有明确地继承一个父类，那它就是 Object 类的子类。  
- 每个类都使用 Object 作为超类。  
  在设计代码时，如果不确定参数类型，可以使用 Object 类。因此它可以通过向上转型来接收全部类的对象。  

- 所有对象（包括数组）都有这个类的方法。

```java
// 构造方法
public Object();  // 因此所有类都会有一个默认的无参构造方法

// 成员方法
public final Class getClass();
public String toString(); // 取得对象信息
public boolean equals(Object obj);  // 对象比较
public int hashCode();  // 取得对象哈希码
protected Object clone();
protected void finalize();  // 了解即可
```

**（1）getClass()**  

getClass() 返回此 Object 的运行时类。返回的 Class 对象是由所表示类的 static synchronized 方法锁定的对象。   

每个类对应对应的字节码文件内容，被加载到方法区之后，就会创建一个 Class 对象（该对象的包含该类，类定义信息）。  
Class 对象代表一个类，表示的就是所有类的共性：
- 构造方法
- 成员变量
- 成员方法

**（2）toString()**  

toString() 返回该对象的字符串表示。  
通常 oString 方法会返回一个「以文本方式表示」此对象的字符串。结果应是一个简明但易于读懂的信息表达式。建议所有子类都重写此方法。  

该字符串由类名（对象是该类的一个实例）、标记符「@」和此对象哈希码的无符号十六进制表示组成。换句话说，该方法返回一个字符串，它的值等于：`getClass().getName() + '@' + Integer.toHexString(hashCode())`。