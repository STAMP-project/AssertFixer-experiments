package spoon.support.compiler;


public interface SpoonProgress {
    enum STEP {
        COMPILE, COMMENT, MODEL, IMPORT, PROCESS, PRINT;}

    void start(spoon.support.compiler.SpoonProgress.STEP step);

    void step(spoon.support.compiler.SpoonProgress.STEP step, java.lang.String element, int taskId, int nbTask);

    void end(spoon.support.compiler.SpoonProgress.STEP step);
}

