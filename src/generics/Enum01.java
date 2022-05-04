package generics;
/*
 Enum is like a special class and used to store "public-static-final" variables
 Differences between ENUM and class
 a)you can not create object from enum
 b)in a class you can create every kind of variables but in en Enum
 you can create only public-static-final variables
 c)Enums cannot extend to any class but can implement interfaces
d)variable names are typed in uppercases(common practice)
e)if you use multiple variables put comma between them
f)In Enums do not use ";" when you complete a statement

 */
public enum Enum01 {
    CHROME,SAFARI,IE,FIREFOX
}
//mostly switch statement is used to use enums in a class