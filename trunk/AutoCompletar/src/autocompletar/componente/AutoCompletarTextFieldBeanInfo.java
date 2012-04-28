/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package autocompletar.componente;

import java.awt.Image;
import java.beans.SimpleBeanInfo;

/**
 *
 * @author diego
 */
public class AutoCompletarTextFieldBeanInfo extends SimpleBeanInfo {

    Image icon;
    Image icon32;
    Image iconM;
    Image icon32M;

    public AutoCompletarTextFieldBeanInfo() {
        icon = loadImage("../iconos/Textfield-16.png");
        icon32 = loadImage("../iconos/Textfield-32.png");
        iconM = loadImage("../iconos/Textfield-16-inv.png");
        icon32M = loadImage("../iconos/Textfield-32-inv.png");
    }

    @Override
    public Image getIcon(int i) {
        switch (i) {
            case 1:
                return icon;

            case 2:
                return icon32;

            case 3:
                return iconM;

            case 4:
                return icon32M;
        }
        return null;
    }
}