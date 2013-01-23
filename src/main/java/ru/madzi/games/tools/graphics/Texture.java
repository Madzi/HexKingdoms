package ru.madzi.games.tools.graphics;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBindTexture;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;

public class Texture {

    private int target;

    private int textureID;

    private int width;

    private int height;

    private int texWidth;

    private int texHeight;

    private float widthRatio;

    private float heightRatio;

    public Texture(int target, int textureID) {
        this.target = target;
        this.textureID = textureID;
    }

    public void bind() {
        glBindTexture(target, textureID);
    }

    public Texture setWidth(int width) {
        this.width = width;
        setWidth();
        return this;
    }

    public Texture setHeight(int height) {
        this.height = height;
        setHeight();
        return this;
    }

    public int getImageWidth() {
        return width;
    }

    public int getImageHeight() {
        return height;
    }

    public float getWidth() {
        return widthRatio;
    }

    public float getHeight() {
        return heightRatio;
    }

    public void setTextureWidth(int texWidth) {
        this.texWidth = texWidth;
        setWidth();
    }

    public void setTextureHeight(int texHeight) {
        this.texHeight = texHeight;
        setHeight();
    }

    private void setWidth() {
        if (texWidth != 0) {
            widthRatio = ((float) width) / texWidth;
        }
    }

    private void setHeight() {
        if (texHeight != 0) {
            heightRatio = ((float) height) / texHeight;
        }
    }

    public void draw(float x, float y) {
        glPushMatrix();
        glBindTexture(target, textureID);
        glTranslatef(x, y, 0);
        glColor3f(1, 1, 1);
        glBegin(GL_QUADS);
        glTexCoord2f(0, 0);
        glVertex2f(0, 0);
        glTexCoord2f(0, heightRatio);
        glVertex2f(0, height);
        glTexCoord2f(widthRatio, heightRatio);
        glVertex2f(width, height);
        glTexCoord2f(widthRatio, 0);
        glVertex2f(width, 0);
        glEnd();
        glPopMatrix();
    }

}
