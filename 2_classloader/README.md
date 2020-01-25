```
 javac ./SplitClassLoader.java ./SomeClass.java ./Main.kt

 // Split class file in two so out class loader could join them together
 split -b 300 SomeClass.class

 // Rename split files
 mv xaa SomeClass_1.class
 mv xab SomeClass_2.class

 // run!
 java Main
 -> wow!

```
