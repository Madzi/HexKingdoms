package ru.madzi.games.tools.common;

/**
 * @author Dmitry Eliseev (deliseev@madzi.ru)
 */
public abstract class AbstractManager implements Managerable {

    protected boolean error = false;

    @Override
    public boolean hasError() {
        return error;
    }

}
