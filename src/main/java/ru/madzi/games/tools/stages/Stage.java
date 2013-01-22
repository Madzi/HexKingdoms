package ru.madzi.games.tools.stages;

public interface Stage {

    public String getName();

    public String getNextStageName();

    public void start();

    public void loadResources();

    public void update(long elapsedTime);

    public void draw();

    public void stop();

}
