package infernoInfinity.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReader implements Reader{

    private BufferedReader bfr;

    public ConsoleReader() {
        this.bfr = null;
    }

    @Override
    public String inputReader() throws IOException {

        if (this.bfr == null){
            this.bfr = new BufferedReader(new InputStreamReader(System.in));
        }

        return this.bfr.readLine();
    }
}
