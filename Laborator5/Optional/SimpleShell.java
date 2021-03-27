import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.StringTokenizer;

public class SimpleShell {
    private String commandLine;
    private List<String> commandLineTokens = new LinkedList<>();

    public SimpleShell() {
        System.out.println("Astept comanda");
        Scanner scanner = new Scanner(System.in);
        this.commandLine = scanner.nextLine();
        commandLineTokens = tokenizer(this.commandLine);
    }

    public void setCommandLine(String commandLine) {
        this.commandLine = commandLine;
    }

    public List<String> tokenizer(String commandLine) {
        StringTokenizer stringTokenizer = new StringTokenizer(commandLine, " ");
        while (stringTokenizer.hasMoreTokens()) {
            commandLineTokens.add(stringTokenizer.nextToken(" "));
        }
        return commandLineTokens;
    }

    public List<String> getCommandLineTokens() {
        return commandLineTokens;
    }

    public String getCommandLine() {
        return commandLine;
    }
}
