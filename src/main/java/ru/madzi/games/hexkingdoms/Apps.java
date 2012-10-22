package ru.madzi.games.hexkingdoms;

import ru.madzi.games.hexkingdoms.stage.Intro;
import ru.madzi.games.tools.Core;
import ru.madzi.games.tools.common.Mode;
import ru.madzi.games.tools.stage.Stage;

/**
 * @author Dmitry Eliseev (deliseev@madzi.ru)
 */
public class Apps {

    public static void main(String[] args) {
        Core core = new Core(Mode.SWING);
        core.init();
        Stage intro = new Intro();
        core.addStage(intro);
        core.setStage(intro.getName());
        core.run();
        core.done();
    }

}
