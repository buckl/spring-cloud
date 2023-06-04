ANNOTATION:注解
•	 What annotations are
        1、A note added by way of comment or explanation,通过使用注释或者解释的方式添加的一个便签
        2、是一个接口，定义抽象方法。不允许static方法和默认方法
        3、annotations is a special type of interface with some restrictions
        4、An annotation type cannot inherit from another annotation type
        5、Every annotation type implicitly inherits from the java.lang.annotation.Annotation interface
        6、只能使用自己定义的抽象方法的元素，不能使用继承Annotation的元素
        7、The Java creates a proxy class dynamically at runtime, which implements the annotation type
        8、生成的代理注解实例可以使用getClass()方法返回注解的Class类型
        9、注解中方法不能有参数
        10、element不能抛出异常
        11、返回值必须是String、Class<T>、enum、annotation、基本类型、数组不能是void
        12、不能覆盖、重写Object、Annotation中的方法
        13、element（签名）使用default值时候（compile-time constants），在使用注解是，未指定的element会使用默认值
        14、注解使用时，不能指定element为null，必须是编译时的常量（可以使用算数）,
            如果element是数组可以使用{}表示一个空数组，String也可以为empty，但不能是null
•	 How to declare annotations：modifier（修饰语）
         @interface  {
            //major是一个元素element 表示一个int类型的成员变量是 major 和 minor
            //当java代理生成注解变量后会调用element方法，用这个办法来描述注解中的变量
             int major();
             int minor() default 1;
             int[] num() default {1,2,3}
            }
•	 How to use annotations
        1、使用范围：a module, a package, a class, an interface,a field of a class, a local variable, a method, a parameter of a method, an enum, an annotation, a type parameter、in a generic type/method declaration
        2、@Version(major=10,minor=1),当element有默认值时，并且使用默认值时可以省略（）；
            当注解中只有一个element，并且其他element有默认值时，可以省略element的名称直接指定value，其他element使用默认值
        3、打上了注解标记意味着创建了一个注解的实例
        4、注解可以作为方法的返回值、另一个注解的element
        5、当注解中的使用了另一个element，使用当前注解时，需要创建它使用的的element的实例
            @DescriptionAnnotation(name = ("John"),
                    version = @VersionAnnotation(major = 1, minor = 2),
                    comments = "Just a test class")
            public class Test {

            }
•	 What meta-annotations are and how to use them
    Meta-annotation types are used to annotate other annotation type declarations；
    Meta-annotation types are part of the java.lang.annotation package
    @interface Native这个注解不是元注解，它用来annotate fields表示该字段可能引用native code
    •	 Target
         指明定义的annotation可以使用在那些地方（类、方法、字段、、、）
         只有一个element(签名) value() 返回一个枚举ElementTyp
    •	 Retention
         指明定义的annotation实例在那种级别可见
         element（签名）value 返回的是枚举RetentionPolicy
                •	 Source code only（注解的实例在代码中可见）
                •	 Class file only (the default)（注解的实例在编译期可见）
                •	 Class file and the runtime（注解的实例在运行期可见）
         如果不使用该元注解，默认在 Class file可见
         局部变量上使用注解，只能在Source code而无论使用何种RetentionPolicy（java反射不能访问局部变量）？
    •	 Inherited
         its instances are inherited by a subclass declaration
         当一个类使用了包含@Inherited的注解，那么该类的子类会继承该类上的注解
         意思就是注解可以传递给子类（前提是父类的注解有被元注解@Inherited修饰）
    •	 Documented
         the Javadoc tool will generate documentation 该文档会包含注解的信息
    •	 Repeatable
         相同的注解可以在同一个地方创建多个
         1、创建一个注解@T并用元注解@Repeatable(Another(注解类型).class)
         2、创建@Another注解，并指定一个元素value(),返回T[]
         这个时候@T类型注解就可以重复定义了
•	 Commonly used annotations that are used to deprecate APIs, to suppress named
     compile-time warnings, override methods, and declare functional interfaces
     JDK中定义的标准注解：
     •	 Deprecated 弃用
         @deprecated用于注释中，在javac中生成信息，@Deprecated用于描述注解类型，这两个注解建议同时使用
     •	 Override   重写
     •	 SuppressWarnings   抑制告警
     •	 FunctionalInterface    函数接口
•	 How to access annotations at runtime
        java.lang.reflect.AnnotatedElement 其中Class类实现了该接口，反射中很多类都实现了该接口
        注解必须有@Retention指明保持策略，并且该策略必须是runtime
        通过注解.class实例通过getAnnotation 、、、方法就可以获得运行时的注解信息
•	 How to process annotations in source code
        1、定义自己的annotation处理器（实现javax.annotation.processing.Processor）
        2、使用javac命令工具
        javac --processor-module-path <path> MySourceFile.java
GENERICS:泛型
•	 What generics are
      1、Generics let you write true polymorphic（多态） code that works with any type 将类型作为一个参数
      2、A type with type parameters in its declaration is called a generic type（声明中具有类型参数的类，称为泛型类型）
      3、<T>表示a type, <E> 表示a an element, <K> 表示 a key, <N> 表示 a number, <V> 表示a value
      4、在代码编写阶段就能指定具体的类型参数,T是一个形式参数 formal type parameter, 在创建对象使用时指定具体参数称为参数化类型（parameterized type）
         当在代码中使用参数化类型后就不用再进行类型转换了
      5、多态性：Polymorphism is about writing code in terms of a type that also works with many other types
      6、代码段  {
            Wrapper<String> wrapper = new Wrapper<>("Hello");
            wrapper.set("set a string");
            Wrapper<Object> objectWrapper = new Wrapper<>(new Object());
            objectWrapper.set(new Object());
            objectWrapper.set("set a string");
            wrapper  = objectWrapper;
            如果这个被允许，那么下面这个就会返回String，但是objectWrapper中存储的是Object，Object要转为String就会有类型转换异常
            String s = wrapper.get();
            }
      7、当泛型类，在声明变量时不使用泛型，编译器会生成一个警告  Wrapper wrapper = new Wrapper<>("Hello");
         这时这个raw type变量就可以和泛型变量相互赋值（=）
      8、对于泛型类，<?>就是用来表示raw type,意味着使用通配符的变量可以相互赋值
      9、The purpose of using generics is to have compile-time type-safety
      10、<?> 使用get返回object，set会编译错误，但是可以set(null)
      11、<? extends T> means anything that is of type T or its subclass is acceptable
          1、当变量的类型参数使用向上绑定时，如果类型参数具有继承关系可以多态赋值（variable1 = variable2 ）
          2、不能set T类型的变量更不能set T子类型的变量（set直接就完犊子除了set null）
            anything that  T  can hold values
      12、<? super T> means anything that is a supertype of T
         anything that can hold T values
      13、静态方法的泛型，在使用Class名称调用时其实是省略了静态方法上的<T>声明
•	 How to define generic types, methods, and constructors
•	 How to define bounds for type parameters
     泛型类，实例化不同的有继承关系的类型参数对象时，该实例化对象不能赋值（泛型类没有继承）
     ？表示任何类型但不是null，Object 可以为null。List<?> 是List<Integer> etc继承关系
•	 How to use wildcards as the actual type parameters
        These wildcards can be used when you want to relax the restrictions on a variable
        For example, say you want to write a method that works on List < Integer >, List < Double >, and List < Number >
        public static void add(List<? extends Number> list)
        say you want to write a method that works on List < Integer >,List < Number >
        public static void add(List<? super Integer> list)
•	 How the compiler infers the actual type parameters for generic type uses
    copy(src, dest) src is in and dest is out
    ？extends T  Upper bound wildcard − If a variable is of in category, use extends keyword with wildcard.
    ? super T    Lower bound wildcard − If a variable is of out category, use super keyword with wildcard.
    Unbounded wildcard − If a variable can be accessed using Object class method then use an unbound wildcard.
    No wildcard − If code is accessing variable in both in and out category then do not use wildcards.
•	 Generics and their limitations in array creations
•	 How the incorrect use of generics may lead to heap pollution
•    Advantages of Generics
     1、We can write a method/class/interface once and use it for any type we want.
     2、Generics make errors to appear compile time than at run time
     3、Individual Type Casting is not needed
     4、代码的重用性
     5、使用泛型的算法