package matrix.token;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * User: e.amoli and pooya.hfp
 * Date: 1/23/13
 * Time: 2:50 PM
 */
public class Tokenizer {

    public static List<Token> createToken(String s) {

        List<Token> temp = new ArrayList<Token>();

        if (!s.trim().endsWith(";"))
            throw new IllegalArgumentException("Statements should ends with ;");

        // این دستور خط به خط دستورات را می دهد
        StringTokenizer lines = new StringTokenizer(s, ";");


        while (lines.hasMoreElements()) {
            // این دستور هرکدام از اجزای دستور را میدهد
            StringTokenizer tokens = new StringTokenizer((String) lines.nextElement(), " {}");
            String command = (String) tokens.nextElement();
            List<String> params = new ArrayList<String>();
            while (tokens.hasMoreElements()) {
                params.add(((String) tokens.nextElement()).toLowerCase());
            }
            temp.add(new Token(command.toLowerCase(), params));
        }
        return temp;
    }

}