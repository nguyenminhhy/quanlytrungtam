/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;

public class CustomComponentModify {

    private static CustomComponentModify instance = null;

    private CustomComponentModify() {
    }

    public static CustomComponentModify getInstance() {
        if (instance == null) {
            instance = new CustomComponentModify();
        }
        return instance;
    }

    public static final Color PRIMARY = new Color(0, 123, 255);
    public static final Color SECONDARY = new Color(108, 117, 125);
    public static final Color SUCCESS = new Color(40, 167, 69);
    public static final Color DANGER = new Color(220, 53, 69);
    public static final Color WARNING = new Color(255, 193, 7);
    public static final Color INFO = new Color(23, 162, 184);
    public static final Color LIGHT = new Color(248, 249, 250);
    public static final Color DARK = new Color(0,102,153);
    public static final Color LINK = new Color(0, 123, 255);

    public static final Color HOVER_PRIMARY = new Color(0, 105, 217);
    public static final Color HOVER_SECONDARY = new Color(90, 98, 104);
    public static final Color HOVER_SUCCESS = new Color(33, 136, 56);
    public static final Color HOVER_DANGER = new Color(200, 35, 51);
    public static final Color HOVER_WARNING = new Color(224, 168, 0);
    public static final Color HOVER_INFO = new Color(19, 132, 150);
    public static final Color HOVER_LIGHT = new Color(226, 230, 234);
    public static final Color HOVER_DARK = new Color(35, 39, 43);
    public static final Color HOVER_LINK = new Color(0, 86, 179);

    public static final Color TRANSPARENT = new Color(0, 0, 0, 0);
    
    public static final Color THONGKE = new Color(0,204,106);
    public static final Color KHACHHANG = new Color(255,0,151);
    public static final Color LOPHOC = new Color(96,60,186);
    public static final Color CHUONGTRINHHOC = new Color(0,171,169);
    public static final Color TAIKHOAN = new Color(255,196,13);

    public static final String FONT_NOTO_SANS = "Noto Sans";
    public static final String FONT_NOTO_SERIF = "Noto Serif";

    public static enum buttonType {
        PRIMARY, SECONDARY, SUCCESS, DANGER, WARNING, INFO, LIGHT, DARK,
        OUTLINE_PRIMARY, OUTLINE_SECONDARY, OUTLINE_SUCCESS, OUTLINE_DANGER, OUTLINE_WARNING, OUTLINE_INFO, OUTLINE_LIGHT, OUTLINE_DARK
    };

    public void modifyButtonColor(JButton button, Color colorBgNormal, Color colorFgNormal, Color colorBorderNormal, Color colorBgHover, Color colorFgHover, Color colorBorderHover) {
        
        button.setBackground(colorBgNormal); 
        button.setForeground(colorFgNormal);
        button.setFocusPainted(false);
        
        
        if (button.getBorder() instanceof CustomInterfaceBorder) {
            ((CustomInterfaceBorder) button.getBorder()).setColor(colorBorderNormal);
        }


        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);

                button.setBackground(colorBgNormal);
                button.setForeground(colorFgNormal);

                if (button.getBorder() instanceof CustomInterfaceBorder) {
                    ((CustomInterfaceBorder) button.getBorder()).setColor(colorBorderNormal);
                }
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);

                button.setBackground(colorBgHover);
                button.setForeground(colorFgHover);

                if (button.getBorder() instanceof CustomInterfaceBorder) {
                    ((CustomInterfaceBorder) button.getBorder()).setColor(colorBorderHover);
                }
            }
        });
    }

    public void modifyButton(JButton button, buttonType type, Font font) {
        button.setFocusPainted(false);

        switch (type) {
            case PRIMARY:
                this.modifyButtonColor(button, PRIMARY, LIGHT, PRIMARY, HOVER_PRIMARY, HOVER_LIGHT, PRIMARY);
                break;
            case SECONDARY:
                this.modifyButtonColor(button, SECONDARY, LIGHT, SECONDARY, HOVER_SECONDARY, HOVER_LIGHT, SECONDARY);
                break;
            case SUCCESS:
                this.modifyButtonColor(button, SUCCESS, LIGHT, SUCCESS, HOVER_SUCCESS, HOVER_LIGHT, SUCCESS);
                break;
            case DANGER:
                this.modifyButtonColor(button, DANGER, LIGHT, DANGER, HOVER_DANGER, HOVER_LIGHT, DANGER);
                break;
            case WARNING:
                this.modifyButtonColor(button, WARNING, DARK, WARNING, HOVER_WARNING, HOVER_DARK, WARNING);
                break;
            case INFO:
                this.modifyButtonColor(button, INFO, LIGHT, INFO, HOVER_INFO, HOVER_LIGHT, INFO);
                break;
            case LIGHT:
                this.modifyButtonColor(button, LIGHT, DARK, LIGHT, HOVER_LIGHT, HOVER_DARK, LIGHT);
                break;
            case DARK:
                this.modifyButtonColor(button, DARK, LIGHT, DARK, HOVER_DARK, HOVER_LIGHT, DARK);
                break;
            case OUTLINE_PRIMARY:
                this.modifyButtonColor(button, LIGHT, PRIMARY, PRIMARY, HOVER_PRIMARY, HOVER_LIGHT, PRIMARY);
                break;
            case OUTLINE_SECONDARY:
                this.modifyButtonColor(button, LIGHT, SECONDARY, SECONDARY, HOVER_SECONDARY, HOVER_LIGHT, SECONDARY);
                break;
            case OUTLINE_SUCCESS:
                this.modifyButtonColor(button, LIGHT, SUCCESS, SUCCESS, HOVER_SUCCESS, HOVER_LIGHT, SUCCESS);
                break;
            case OUTLINE_DANGER:
                this.modifyButtonColor(button, LIGHT, DANGER, DANGER, HOVER_DANGER, HOVER_LIGHT, DANGER);
                break;
            case OUTLINE_WARNING:
                this.modifyButtonColor(button, LIGHT, WARNING, WARNING, HOVER_WARNING, HOVER_DARK, WARNING);
                break;
            case OUTLINE_INFO:
                this.modifyButtonColor(button, LIGHT, INFO, INFO, HOVER_INFO, HOVER_LIGHT, INFO);
                break;
            case OUTLINE_LIGHT:
                this.modifyButtonColor(button, LIGHT, LIGHT, LIGHT, HOVER_LIGHT, HOVER_DARK, LIGHT);
                break;
            case OUTLINE_DARK:
                this.modifyButtonColor(button, LIGHT, DARK, DARK, HOVER_DARK, HOVER_LIGHT, DARK);
                break;
        }

        button.setFont(font);
    }

    public void modifyButton(JButton button, buttonType type) {
        this.modifyButton(button, type, new Font("Tahoma", Font.BOLD, 16));
    }

    public void modifyButton(JButton button) {
        this.modifyButton(button, buttonType.PRIMARY);
    }
}
