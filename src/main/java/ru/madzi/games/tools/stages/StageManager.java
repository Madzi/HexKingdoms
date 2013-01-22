package ru.madzi.games.tools.stages;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import ru.madzi.games.tools.input.InputManager;

public class StageManager {

    public static final String EXIT = "_exit";

    private static final StageManager INSTANCE = new StageManager();

    private StageManager() {}

    public static StageManager getInstance() {
        return INSTANCE;
    }

    private InputManager inputManager = InputManager.getInstance();

    private Map<String, Stage> stages = new HashMap<String, Stage>();

    private Stage currentStage;

    private boolean done;

    public void init() {}

    public void addStage(Stage stage) {
        if (stage != null && !EXIT.equals(stage.getName())) {
            stages.put(stage.getName(), stage);
        }
    }

    public Collection<Stage> getStages() {
        return stages.values();
    }

    public void loadAllResources() {
        for (Stage stage: getStages()) {
            stage.loadResources();
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
        if (EXIT.equals(name)) {
            done = true;
        } else {
            currentStage = stages.get(name);
            if (currentStage != null) {
                currentStage.start();
            }
        }
    }

    public void update(long elapsedTime) {
        if (currentStage == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
        } else {
            String nextStage = currentStage.getNextStageName();
            if (nextStage != null) {
                setStage(nextStage);
            } else {
                currentStage.update(elapsedTime);
            }
        }
    }

    public void draw() {
        if (currentStage != null) {
            currentStage.draw();
        }
    }

    public void stop() {}

}
