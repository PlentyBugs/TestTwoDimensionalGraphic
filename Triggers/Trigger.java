package TestTwoDimensionalGraphic.Triggers;

public interface Trigger {
    boolean OnTriggerEnter();
    boolean OnTriggerQuit();
    void OnTriggerActionOnEnter();
    void OnTriggerActionOnQuit();
}
