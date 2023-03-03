package com.joguelimpo;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.Rectangle;

public class Trash {

    private Texture texture;
    private Rectangle bounds;
    private int type;
    private boolean isOutOfBounds;
    private boolean isCorrect;

    public Trash(int x, int y, int type, Texture texture) {
        this.type = type;
        this.texture = texture;
        bounds = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
    }

    public Trash(TextureAtlas.AtlasRegion texture) {
    }

    public void update(float delta) {
        bounds.y -= 200 * delta;
        if (bounds.y < 0) {
            isOutOfBounds = true;
        }
    }

    public void render(SpriteBatch batch) {
        batch.draw(texture, bounds.x, bounds.y);
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public int getType() {
        return type;
    }

    public boolean isOutOfBounds() {
        return isOutOfBounds;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public boolean isCorrect() {
        return isCorrect;
    }
}
