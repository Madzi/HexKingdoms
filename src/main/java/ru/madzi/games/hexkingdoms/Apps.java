package ru.madzi.games.hexkingdoms;

import ru.madzi.games.hexkingdoms.stage.Intro;
import ru.madzi.games.was.tools.common.Core;

/**
 * @author Dmitry Eliseev (deliseev@madzi.ru)
 */
public class Apps {

    public static void main(String[] args) {
        Core core = Core.getInstance();
        core.addStage(new Intro());
        core.run();
    }

}
