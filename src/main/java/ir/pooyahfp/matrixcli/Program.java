/*
 * Copyright (c) 2013, Phsys and/or its affiliates. All rights reserved.
 *  Phsys PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */

package ir.pooyahfp.matrixcli;

import ir.pooyahfp.matrixcli.commands.AbstractCommand;
import ir.pooyahfp.matrixcli.tokenizer.Token;
import ir.pooyahfp.matrixcli.tokenizer.Tokenizer;
import org.jetbrains.annotations.NotNull;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.*;
import java.util.List;
import java.util.Map;

/**
 * @author : Pooya husseini
 *         Email : info@pooya-hfp.ir
 *         Date: 1/26/13
 *         Time: 11:25 AM
 */
public final class Program {

    private static PrintWriter writer;
    private static final String ERROR_MESSAGE = "An error occurred: ";

    private static Map<String, AbstractCommand> commandMap;

    public void runCommand(String line) throws InstantiationException, IllegalAccessException {
        List<Token> tokens = Tokenizer.createToken(line);
        for (Token token : tokens) {
            AbstractCommand abstractCommand = commandMap.get(token.getCommand());
            if (abstractCommand == null) {
                throw new IllegalArgumentException("Command not found!");
            }
            abstractCommand.execute(token.getParams(), token.getValues());
        }
    }

    private void start() {
        String curLine = "";
        writer.println("Enter a command (type 'quit' to exit): ");
        InputStreamReader converter = new InputStreamReader(System.in);
        BufferedReader in = new BufferedReader(converter);

        while (!curLine.equals("quit")) {
            try {
                curLine = in.readLine();
                if (!(curLine.equals("quit"))) {
                    runCommand(curLine);
                }
            } catch (Exception x) {

                writer.println(ERROR_MESSAGE + x.getMessage());
            }
        }
    }

    public void setWriter(PrintWriter writer) {
        Program.writer = writer;
        AbstractCommand.setWriter(writer);
    }

    public void setCommandMap(Map<String, AbstractCommand> commandMap) {
        Program.commandMap = commandMap;
    }

    public static void main(@NotNull String[] args) {
        new ClassPathXmlApplicationContext("classpath*:**/spring/spring-config.xml");
        Program program = new Program();
        if (args.length > 0) {
            program.loadCommandFile(args[0]);
        } else {
            program.start();
        }
    }

    /**
     * Opens a script file and reads each line and execute them
     *
     * @param path the path of the input
     */
    public void loadCommandFile(String path) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(path)));

            String line = "";
            while ((line = reader.readLine()) != null) {
                try {
                    runCommand(line);
                } catch (Exception e) {
                    writer.println(ERROR_MESSAGE + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            writer.println(ERROR_MESSAGE + e.getMessage());
        } catch (IOException e) {
            writer.println(ERROR_MESSAGE + e.getMessage());
        }
    }
}