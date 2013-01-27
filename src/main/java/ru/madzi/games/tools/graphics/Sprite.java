package ru.madzi.games.tools.graphics;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3f;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glPopMatrix;
import static org.lwjgl.opengl.GL11.glPushMatrix;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glTranslatef;
import static org.lwjgl.opengl.GL11.glVertex2f;

import org.newdawn.slick.opengl.Texture;

public class Sprite {

    private Animation animation;

    private float x;

    private float y;

    private float dx;

    private float dy;

    public Sprite(Animation animation) {
        this.animation = animation;
    }

    public void update(long elapsedTime) {
        x += dx * elapsedTime;
        y += dy * elapsedTime;
        animation.update(elapsedTime);
    }

    public float getX() {
        return x;
    }

    public Sprite setX(float x) {
        this.x = x;
        return this;
    }

    public float getY() {
        return y;
    }

    public Sprite setY(float y) {
        this.y = y;
        return this;
    }

    public float getWidth() {
        Texture texture = animation.getTexture();
        return texture != null ? texture.getWidth() : 0;
    }

    public float getHeight() {
        Texture texture = animation.getTexture();
        return texture != null ? texture.getHeight() : 0;
    }

    public Sprite setVelocityX(float dx) {
        this.dx = dx;
        return this;
    }

    public Sprite setVelocityY(float dy) {
        this.dy = dy;
        return this;
    }

    public Texture getTexture() {
        return animation.getTexture();
    }

    public void draw() {
        Texture texture = animation.getTexture();
        if (texture != null) {
            glPushMatrix();
            texture.bind();
            glTranslatef(x, y, 0);
            glColor3f(1, 1, 1);
            glBegin(GL_QUADS);
            glTexCoord2f(0, 0);
            glVertex2f(0, 0);
            glTexCoord2f(0, texture.getHeight());
            glVertex2f(0, texture.getImageHeight());
            glTexCoord2f(texture.getWidth(), texture.getHeight());
            glVertex2f(texture.getImageWidth(), texture.getImageHeight());
            glTexCoord2f(texture.getWidth(), 0);
            glVertex2f(texture.getImageWidth(), 0);
            glEnd();
            glPopMatrix();
        }
    }

    @Override
    public Object clone() {
        return new Sprite(animation);
    }

}
