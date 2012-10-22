package ru.madzi.games.tools.common.swing;

import java.awt.Image;

import javax.swing.ImageIcon;

public class ResourceManager implements ru.madzi.games.tools.common.ResourceManager {

    public Image loadImage(String name) {
        return new ImageIcon(name).getImage();
    }

}
