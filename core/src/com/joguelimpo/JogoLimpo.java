package com.joguelimpo;

import static com.badlogic.gdx.math.MathUtils.random;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.FitViewport;

import java.util.Iterator;

import jdk.nashorn.internal.runtime.regexp.joni.encoding.CharacterType;

public class JogoLimpo extends ApplicationAdapter implements InputProcessor {
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private TextureAtlas trashAtlas;
	private Array<TextureAtlas.AtlasRegion> trashTextures;
	private Array<Trash> trashItems;
	private Texture backgroundTexture;
	private TextureAtlas binAtlas;
	private Array<TextureAtlas.AtlasRegion> binTextures;
	private Array<Bin> bins;
	private int score;
	private BitmapFont font;
	private Sound correctSound;
	private Sound wrongSound;
	private int coins;
	private TextureAtlas characterAtlas;
	private Array<TextureAtlas.AtlasRegion> characterTextures;
	private Array<Character> characters;
	private int selectedCharacterIndex;

	@Override
	public void create() {
		camera = new OrthographicCamera();
		camera.setToOrtho(false, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

		batch = new SpriteBatch();

		// Load trash textures
		trashAtlas = new TextureAtlas(Gdx.files.internal("trash.atlas"));
		trashTextures = trashAtlas.getRegions();

		// Create trash items
		trashItems = new Array<Trash>();
		for (int i = 0; i < 10; i++) {
			TextureAtlas.AtlasRegion texture = trashTextures.random();
			Trash trash = new Trash(texture);
			trashItems.add(trash);
		}

		// Load background texture
		backgroundTexture = new Texture(Gdx.files.internal("background.png"));

		// Load bin textures
		binAtlas = new TextureAtlas(Gdx.files.internal("bins.atlas"));
		binTextures = binAtlas.getRegions();

		// Create bins
		bins = new Array<Bin>();
		bins.add(new Bin(binTextures.get(0),Trash.PAPEL));

		bins.add(new Bin(binTextures.get(1), Trash.PLASTIC));
		bins.add(new Bin(binTextures.get(2), Trash.GLASS));
		bins.add(new Bin(binTextures.get(3), Trash.METAL));
		bins.shuffle();

		// Load font
		font = new BitmapFont(Gdx.files.internal("font.fnt"));
		font.setColor(Color.WHITE);

		// Load sounds
		correctSound = Gdx.audio.newSound(Gdx.files.internal("correct.wav"));
		wrongSound = Gdx.audio.newSound(Gdx.files.internal("wrong.wav"));

		// Initialize coins
		coins = 0;

		// Load character textures
		characterAtlas = new TextureAtlas(Gdx.files.internal("characters.atlas"));
		characterTextures = characterAtlas.getRegions();

		// Create characters
		characters = new Array<Character>();
		characters.add(new Character(characterTextures.get(0), "Character 1"));
		characters.add(new Character(characterTextures.get(1), "Character 2"));
		characters.add(new Character(characterTextures.get(2), "Character 3"));

		// Set selected character to first character
		selectedCharacterIndex = 0;
	}

	@Override
	public void render() {
		batch.begin();
		batch.draw(backgroundTexture, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		batch.end();

		// Clear screen
		Gdx.gl.glClearColor(0, 0, 0, 1);


	}

	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(float amountX, float amountY) {
		return false;
	}
}
