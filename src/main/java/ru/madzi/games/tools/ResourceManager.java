package ru.madzi.games.tools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Logger;

import static org.lwjgl.opengl.GL11.*;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class ResourceManager {

    private static final ResourceManager INSTANCE = new ResourceManager();

    private static final Logger _LOG = Logger.getLogger(ResourceManager.class.getName());

    private HashMap<String, Texture>textures = new HashMap<String, Texture>();

    public static ResourceManager getInstance() {
        return INSTANCE;
    }

    private ResourceManager() {}

    public Texture loadTexture(String ref) {
        Texture texture = textures.get(ref);
        if (texture == null) {
            try {
                File file = new File(ref);
                System.out.println(file.getAbsolutePath());
                texture = TextureLoader.getTexture("PNG", new FileInputStream(file), true, GL_LINEAR);
            } catch (FileNotFoundException e) {
                _LOG.warning("Texture " + ref + " not found.");
            } catch (IOException e) {
                _LOG.warning("Problem with loading texture " + ref);
            }
        }
        return texture;
    }

}
