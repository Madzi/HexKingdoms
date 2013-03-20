package ru.madzi.games.hedgehog.stages;

import org.newdawn.slick.opengl.Texture;

import ru.madzi.games.hedgehog.tools.Resources;
import ru.madzi.games.tools.ResourceManager;
import ru.madzi.games.tools.config.Config;
import ru.madzi.games.tools.config.ConfigManager;
import ru.madzi.games.tools.graphics.Animation;
import ru.madzi.games.tools.graphics.Sprite;
import ru.madzi.games.tools.input.Action;
import ru.madzi.games.tools.input.InputManager;
import ru.madzi.games.tools.stages.Stage;

public class RecordsStage implements Stage {

    public static final String NAME = "_records";

    private Action selectAction = new Action("select");

    private boolean done;

    private Sprite background;

    private Config config = ConfigManager.getInstance().getConfig();

    private ResourceManager resourceManager = ResourceManager.getInstance();

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String getNextStageName() {
        return done ? MenuStage.NAME : null;
    }

    @Override
    public void start() {
        done = false;
        InputManager inputManager = InputManager.getInstance();
        inputManager.mapToKey(selectAction, config.getKeyFire());
    }

    @Override
    public void loadResources() {
        Animation animation = new Animation();
        Texture texture = resourceManager.loadTexture(Resources.IMAGE_RECORDS_BACKGROUND);
        animation.addFrame(texture, 10000);
        background = new Sprite(animation);

    }

    @Override
    public void update(long elapsedTime) {
        // TODO Auto-generated method stub

    }

    @Override
    public void draw() {
        background.draw();
    }

    @Override
    public void stop() {
        // TODO Auto-generated method stub

    }

}
