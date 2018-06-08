package spoon.support.compiler;


public class ProgressLogger implements spoon.support.compiler.SpoonProgress {
    private long stepTimer;

    private long timer;

    @java.lang.Override
    public void start(spoon.support.compiler.SpoonProgress.STEP step) {
        java.lang.System.out.println(("Start " + step));
        timer = getCurrentTimeInMillis();
        stepTimer = timer;
    }

    @java.lang.Override
    public void step(spoon.support.compiler.SpoonProgress.STEP step, java.lang.String element, int taskId, int nbTask) {
        spoon.support.compiler.jdt.JDTTreeBuilder.getLogger().trace((((((((((("Step " + step) + " ") + taskId) + "/") + nbTask) + " ") + element) + " in ") + ((getCurrentTimeInMillis()) - (timer))) + " ms"));
        timer = getCurrentTimeInMillis();
    }

    @java.lang.Override
    public void end(spoon.support.compiler.SpoonProgress.STEP step) {
        spoon.support.compiler.jdt.JDTTreeBuilder.getLogger().trace((((("End " + step) + " in ") + ((getCurrentTimeInMillis()) - (stepTimer))) + " ms"));
    }

    private long getCurrentTimeInMillis() {
        return new java.util.GregorianCalendar().getTimeInMillis();
    }
}

