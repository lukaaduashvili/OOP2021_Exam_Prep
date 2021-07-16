package Sem09;

import java.io.IOException;

public class TerminalView extends BasicCalcView{
    @Override
    public void show() {
        while(true) {
            try {
                byte[] inp = System.in.readNBytes(1);
                if(inp.length >= 1)
                    notifyListeners((char) inp[0]);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void valueChanged(String value) {
        System.out.println(value);
    }
}
