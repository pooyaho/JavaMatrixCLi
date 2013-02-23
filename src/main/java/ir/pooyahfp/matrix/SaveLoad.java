/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrix;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;

/**
* @author : Pooya husseini
 * Email : info@pooya-hfp.ir
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