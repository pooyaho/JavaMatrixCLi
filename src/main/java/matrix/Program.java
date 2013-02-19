/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package matrix;

import matrix.commands.AbstractCommand;
import matrix.token.Token;
import matrix.token.Tokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 1/26/13
 *         Time: 11:25 AM
 */
public class Program {

    private Program() {
    }

    //    public static Map<String, AbstractCommand> commandMap = new HashMap<String, AbstractCommand>();
    @Autowired
    private Map<String, AbstractCommand> commandMap;

    private void start() {
        String curLine = "";
        System.out.println("Enter a command (type 'quit' to exit): ");
        InputStreamReader converter = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(converter);

        while (!curLine.equals("quit")) {
            try {
                curLine = in.readLine();
                if (!(curLine.equals("quit"))) {
                    List<Token> tokens = Tokenizer.createToken(curLine);
                    for (Token token : tokens) {
                        commandMap.get(token.getCommand()).execute(token.getParams());
                    }
                }
            } catch (Exception x) {
                System.err.println("An error occurred: " + x.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "classpath*:**/spring/spring-config.xml");

        Program program = new Program();
        program.commandMap = (Map<String, AbstractCommand>) context.getBean("commands");
        program.start();
    }
}