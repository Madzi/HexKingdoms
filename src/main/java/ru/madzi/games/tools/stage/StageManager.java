package ru.madzi.games.tools.stage;

import ru.madzi.games.tools.common.ResourceManager;
import ru.madzi.games.tools.graphics.ScreenManager;
import ru.madzi.games.tools.input.InputManager;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dmitry Eliseev (deliseev@madzi.ru)
 */
public class StageManager {

    private Map<String, Stage> stages = new HashMap<String, Stage>();

    private Stage currentStage;

    private InputManager inputManager;

    private ResourceManager resourceManager;

    private boolean done;

    public StageManager(InputManager inputManager, ResourceManager resourceManager) {
        this.inputManager = inputManager;
        this.resourceManager = resourceManager;
    }

    public void addStage(Stage stage) {
        stages.put(stage.getName(), stage);
    }

    public Collection<Stage> getStages() {
        return stages.values();
    }

    public void loadAllResources() {
        for (Stage stage : stages.values()) {
            stage.loadResources(resourceManager);
        }
    }

    public boolean isDone() {
        return done;
    }

    public void setStage(String name) {
        if (currentStage != null) {
            currentStage.stop();
        }
        inputManager.clearAllMaps();
        if (Stage.EXIT.equals(name)) {
            done = true;
        } else {
            currentStage = stages.get(name);
            if (currentStage != null) {
                currentStage.start(inputManager);
            }
        }
    }

    public void update(long elapsedTime) {
        if (currentStage == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {}
        } else {
            String nextStage = currentStage.checkForStageChange();
            if (nextStage != null) {
                setStage(nextStage);
            } else {
                currentStage.update(elapsedTime);
            }
        }
    }

    public void draw(ScreenManager screenManager) {
        if (currentStage != null) {
            currentStage.draw(screenManager);
        }
    }

}
