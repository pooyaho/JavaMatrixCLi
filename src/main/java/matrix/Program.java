package matrix;

import matrix.commands.*;
import matrix.token.Token;
import matrix.token.Tokenizer;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * User: e.amoli - pooya.hfp
 * Date: 1/26/13
 * Time: 11:25 AM
 */
public class Program {
    public static Map<String, AbstractCommand> commandMap = new HashMap<String, AbstractCommand>();

    private static void fillCommandMap() {

        commandMap.put("matrix", new CreateCommand());
        commandMap.put("set", new SetCommand());
        commandMap.put("save", new SaveCommand());
        commandMap.put("read", new LoadCommand());
        commandMap.put("show", new ShowCommand());
        commandMap.put("copy", new CopyCommand());
        commandMap.put("swap", new SwapCommand());
        commandMap.put("add", new AddCommand());
        commandMap.put("sub", new SubCommand());
        commandMap.put("mul", new MulCommand());
        commandMap.put("pow", new PowerCommand());
        commandMap.put("inv", new InvertCommand());
        commandMap.put("solve", new SolveEquationCommand());
        commandMap.put("trn", new TransposeCommand());
        commandMap.put("lu", new LuCommand());

    }

    public static void main(String[] args) {
        String curLine = "";
        fillCommandMap();
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
                x.printStackTrace();
            }
        }
    }
}