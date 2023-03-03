package com.joguelimpo;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;

public class Bin {

        private Texture texture;
        private Rectangle bounds;
        private int type;
    // Adicionando um novo tipo "PAPEL"
    public static final int PAPEL = 4;
        public Bin(int x, int y, int type, Texture texture) {
            this.type = type;
            this.texture = texture;
            bounds = new Rectangle(x, y, texture.getWidth(), texture.getHeight());
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
    }


