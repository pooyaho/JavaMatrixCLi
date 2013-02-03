package matrix.token;

import java.util.List;

/**
 * User: e.amoli and pooya.hfp
 * Date: 1/23/13
 * Time: 2:50 PM
 */
public class Token {
    private String command;
    private List<String> params;

    public Token() {
    }

    public Token(String command, List<String> params) {
        this.command = command;
        this.params = params;
    }

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public List<String> getParams() {
        return params;
    }

    public void setParams(List<String> params) {
        this.params = params;
    }
}
