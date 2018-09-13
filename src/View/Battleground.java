package View;

import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

public class Battleground {
    private Display display = new Display();
    private Shell shell = new Shell(display, SWT.SHELL_TRIM | SWT.CENTER);

    public Battleground() {
        Color gray = display.getSystemColor(SWT.COLOR_DARK_GRAY);
        shell.setBackground(gray);
        shell.setText("Battleground");
        shell.setSize(1100, 890);
    }
}
