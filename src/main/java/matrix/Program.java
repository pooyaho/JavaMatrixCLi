/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package matrix;

import matrix.commands.AbstractCommand;
import matrix.token.Token;
import matrix.token.Tokenizer;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 1/26/13
 *         Time: 11:25 AM
 */
public class Program {

    private static PrintWriter writer;

    private Program() {
    }

    private static Map<String, AbstractCommand> commandMap;

    private void start() {
        String curLine = "";
        writer.println("Enter a command (type 'quit' to exit): ");
        InputStreamReader converter = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(converter);
        AbstractCommand.setWriter(writer);
        while (!curLine.equals("quit")) {
            try {
                curLine = in.readLine();
                if (!(curLine.equals("quit"))) {
                    List<Token> tokens = Tokenizer.createToken(curLine);
                    for (Token token : tokens) {
                        AbstractCommand abstractCommand = commandMap.get(token.getCommand());
                        if (abstractCommand == null)
                            throw new IllegalArgumentException("Command not found!");
                        abstractCommand.execute(token.getParams());
                    }
                }
            } catch (Exception x) {
                writer.println("An error occurred: " + x.getMessage());
            }
        }
    }

    public void setWriter(PrintWriter writer) {
        Program.writer = writer;
    }

    public void setCommandMap(Map<String, AbstractCommand> commandMap) {
        Program.commandMap = commandMap;
    }

    public static void main(String[] args) {
        new ClassPathXmlApplicationContext("classpath*:**/spring/spring-config.xml");
        Program program = new Program();
        program.start();
    }
}