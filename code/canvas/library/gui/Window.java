package canvas.library.gui;

import canvas.Program;

import java.awt.event.WindowEvent;

public class Window extends java.awt.Frame
    implements java.awt.event.WindowListener
{
    private final Program program;

    public Window(String title, Program program) {
        super(title);

        this.program = program;

        super.addWindowListener(this);
    }



    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {
        this.program.pause();
        this.dispose();

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {

    }

    @Override
    public void windowDeiconified(WindowEvent e) {

    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
