public class Timer {

    private ITime startTime;
    private ITime deltaTime;

    private IGui gui;
    private IDB db;

    public void start() {
        startTime = retrieveCurrentTime();
    }

    public void stop() {
        deltaTime = retrieveCurrentTime().minus(startTime);
    }

    public ITime getStartTime() {
        return startTime;
    }

    public void setStartTime(ITime startTime) {
        this.startTime = startTime;
    }

    public ITime getDeltaTime() {
        return deltaTime;
    }

    public void setDeltaTime(ITime deltaTime) {
        this.deltaTime = deltaTime;
    }

    public IGui getGui() {
        return gui;
    }

    public void setGui(IGui gui) {
        this.gui = gui;
    }

    public ITime retrieveCurrentTime() {
        return new Time();
    }

    public void showDeltaTime() {
        gui.showTime(deltaTime);
    }

    public void setDB(IDB db) {
        this.db = db;
    }

    public void storeDeltaTime() {
        db.storeTimeEntry(deltaTime);
    }
}