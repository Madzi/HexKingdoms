package ru.madzi.games.tools.graphics;



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
            texture.draw(x, y);
        }
    }

    @Override
    public Object clone() {
        return new Sprite(animation);
    }

}
