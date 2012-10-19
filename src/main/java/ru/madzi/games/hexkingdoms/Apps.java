package ru.madzi.games.hexkingdoms;

import ru.madzi.games.hexkingdoms.stage.Intro;
import ru.madzi.games.tools.common.Core;
import ru.madzi.games.tools.common.Mode;

/**
 * @author Dmitry Eliseev (deliseev@madzi.ru)
 */
public class Apps {

    public static void main(String[] args) {
        Core core = new Core(Mode.SWING);
        core.addStage(new Intro());
        core.run();
    }

}
