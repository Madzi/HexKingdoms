package ru.madzi.games.tools.stage;

import ru.madzi.games.tools.common.ResourceManager;
import ru.madzi.games.tools.graphics.ScreenManager;
import ru.madzi.games.tools.input.InputManager;

public interface Stage {

    public static final String EXIT = "_exit";

    public String getName();

    public String checkForStageChange();

    public void loadResources(ResourceManager resourceManager);

    public void start(InputManager inputManager);

    public void stop();

    public void update(long elapsedTime);

    public void draw(ScreenManager screenManager);

}
