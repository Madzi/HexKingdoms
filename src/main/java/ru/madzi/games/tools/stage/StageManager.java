package ru.madzi.games.tools.stage;

import java.util.Collection;

import ru.madzi.games.tools.graphics.ScreenManager;

public interface StageManager {

    public void addStage(Stage stage);

    public Collection<Stage> getStages();

    public void loadAllResources();

    public boolean isDone();

    public void setStage(String name);

    public void update(long elapsedTime);

    public void draw(ScreenManager screenManager);

}
