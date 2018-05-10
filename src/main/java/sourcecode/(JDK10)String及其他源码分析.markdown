#使用版本:JDK10.0.1

#首先是实现的接口

    public final class String implements java.io.Serializable, Comparable<String>, CharSequence

#
`Serializable` 实现这个接口可以使得对象序列化。

使用场景：
1. 像在使用MyBatis之类的映射时，我们往往需要让entity类实现这个接口。
2. 我们需要保存对象流时，就需要实现这个接口，然后通过以下代码实现

        FileOutputStream fileOutputStream=new FileOutputStream(".");
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
        objectOutputStream.write(Integer.parseInt(a));
> 应该注意实现序列化接口，不代表就能序列，首先这个类的属性也得是序列化，比如String就是属于序列化属性的，或者像我们数据类`abstract class Number implements java.io.Serializable`。

#
`Comparable<String>` 使得String对象可以有各种各样的操作。

`String`通过复写`int compareTo(T o)`实现比较操作：

    public int compareTo(String anotherString) {
            byte v1[] = value;
            byte v2[] = anotherString.value;
            if (coder() == anotherString.coder()) {
                return isLatin1() ? StringLatin1.compareTo(v1, v2)
                                  : StringUTF16.compareTo(v1, v2);
            }
            return isLatin1() ? StringLatin1.compareToUTF16(v1, v2)
                              : StringUTF16.compareToLatin1(v1, v2);
    }

#
`CharSequence` 提供可读序列元素接口

方法:
1. charAt()
2. chars()
3. toString()等等

#
`final` 每个String类都是不可变的，我们日常对它的操作只是对引用操作。

    String a="hello"
    a="world"
这里a引用指向world而已，而hello就废置了，等待GC回收

#未完待续······（2018年5月8日）
