package matrix;

import java.io.*;

/**
 * User: e.amoli and pooya.hfp
 * Date: 1/26/13
 * Time: 11:24 AM
 */
public class SaveLoad {

    public static Object readObject(String path) throws Exception {
        FileInputStream f = new FileInputStream(path);
        ObjectInput s = new ObjectInputStream(f);
        Object o = s.readObject();
        s.close();
        f.close();
        return o;
    }

    public static void saveObject(String path, Object o) throws IOException {
        FileOutputStream f = new FileOutputStream(path);
        ObjectOutput s = new ObjectOutputStream(f);
        s.writeObject(o);
        s.flush();
        s.close();
        f.close();
    }

}