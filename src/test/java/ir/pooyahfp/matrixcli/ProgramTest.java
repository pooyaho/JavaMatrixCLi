/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 3/27/13
 *         Time: 6:20 PM
 */

public class ProgramTest {
    private static final Program program = new Program();

    static {
        new ClassPathXmlApplicationContext("classpath*:**/spring/spring-config.xml");
    }

    @Test
    public void testRunCommand() throws Exception {
        program.runCommand("matrix x 3 3");
    }

    @Test
    public void testSetWriter() throws Exception {
        program.setWriter(new PrintWriter(System.err));
        program.runCommand("matrix x 3 3");
        program.runCommand("show x");
    }

    @Test
    public void testLoadCommandFile() throws Exception {
        String path = "test.txt";
        BufferedWriter writer = new BufferedWriter(new FileWriter(new File(path)));
        writer.write("matrix x 3 3");
        writer.newLine();
        writer.write("show x");
        writer.flush();
        writer.close();

        program.loadCommandFile(path);
    }

}