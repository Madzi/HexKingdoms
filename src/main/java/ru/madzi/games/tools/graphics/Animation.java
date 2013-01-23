package ru.madzi.games.tools.graphics;

import java.util.ArrayList;
import java.util.List;

public class Animation {

    private List<AnimFrame> frames;

    private int currFrameIdx;

    private long animTime;

    private long totalDuration;

    public Animation() {
        frames = new ArrayList<AnimFrame>();
        totalDuration = 0;
        start();
    }

    public synchronized void addFrame(Texture texture, long duration) {
        totalDuration += duration;
        frames.add(new AnimFrame(texture, totalDuration));
    }

    private synchronized void start() {
        animTime = 0;
        currFrameIdx = 0;
    }

    public synchronized void update(long elapsedTime) {
        if (frames.size() > 1) {
            animTime += elapsedTime;
            if (animTime >= totalDuration) {
                animTime %= totalDuration;
                currFrameIdx = 0;
            }
            while (animTime > getFrame(currFrameIdx).endTime) {
                currFrameIdx++;
            }
        }
    }

    public synchronized Texture getTexture() {
        return frames.isEmpty() ? null : getFrame(currFrameIdx).texture;
    }

    private AnimFrame getFrame(int idx) {
        return frames.get(idx);
    }

    private class AnimFrame {

        Texture texture;

        long endTime;

        public AnimFrame(Texture texure, long endTime) {
            this.texture = texure;
            this.endTime = endTime;
        }

    }

}
