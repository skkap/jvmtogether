import java.io.*;

public class SplitClassLoader extends ClassLoader {
    @Override
    public Class<?> findClass(String name) {
        final String name1 = name + "_1";
        final String name2 = name + "_2";
        final byte[] bytes = loadClassData(name1, name2);
        return defineClass(name, bytes, 0, bytes.length);
    }

    private byte[] loadClassData(String className1, String className2) {
        InputStream is1 = getClass().getClassLoader().getResourceAsStream(className1.replace(".", "/") + ".class");
        InputStream is2 = getClass().getClassLoader().getResourceAsStream(className2.replace(".", "/") + ".class");
        ByteArrayOutputStream byteSt = new ByteArrayOutputStream();
        SequenceInputStream fullInputStream = new SequenceInputStream(is1, is2);
        int len = 0;
        try {
            while ((len = fullInputStream.read()) != -1) {
                byteSt.write(len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteSt.toByteArray();
    }
}