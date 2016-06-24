package Filters;

import java.awt.Toolkit;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

public class NumberFilter extends DocumentFilter {

    private final int maxsize;
    private boolean dot;
    private boolean insertdot;
    private boolean isDecimal;

    public NumberFilter(boolean isDecimal,int size) {
        maxsize = size;
        dot = false;
        this.isDecimal=isDecimal;
    }

    private String insert(String str) {
        StringBuffer buffer = new StringBuffer(str);
        char c;
        insertdot=false;
        for (int i = buffer.length() - 1; i >= 0; i--) {
            c = buffer.charAt(i);
            if (c == '.' || c == ',') {
                if (!isDecimal||dot) {
                    buffer.deleteCharAt(i);
                } else {
                    dot = insertdot = true;
                }
            } else if (c < '0' || c > '9') {
                buffer.deleteCharAt(i);
            }
        }
        return buffer.toString();
    }

    @Override
    public void insertString(FilterBypass fb, int offs, String str, AttributeSet a)
            throws BadLocationException {
        char c;
        boolean sound = false;
        String newstr = insert(str);
        int x = dot ? 1 : 0;
        if (fb.getDocument().getLength() + newstr.length() - x > maxsize) {
            sound = true;
            if (insertdot)dot=false;
        } else {
            if (newstr.length() != str.length()) {
                sound = true;
            }

            super.insertString(fb, offs, newstr, a);
        }
        if (sound) {
            Toolkit.getDefaultToolkit().beep();
        }

    }

    @Override
    public void remove(FilterBypass fb, int offset, int length) throws
            BadLocationException {
        String text = fb.getDocument().getText(offset, length);
        if (text.contains(".") || text.contains(",")) {
            dot = false;
        }
        super.remove(fb, offset, length);
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String str, AttributeSet a)
            throws BadLocationException {
        boolean sound = false;
        String text = fb.getDocument().getText(offset, length);
        if (text.contains(".") || text.contains(",")) {
            dot = false;
        }
        String newstr = insert(str);
        int x = dot ? 1 : 0;
        if (fb.getDocument().getLength() + newstr.length() - length - x > maxsize) {
            sound = true;
            if (insertdot)dot=false;
        } else {
            if (newstr.length() != str.length()) {
                sound = true;
            }
            super.replace(fb, offset, length, newstr, a);
        }
        if (sound) {
            Toolkit.getDefaultToolkit().beep();
        }
    }
}
