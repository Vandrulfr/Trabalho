package Abstract;

import Home.Menu;

public abstract class View {

    public abstract void home();
    protected abstract void novo();
    protected void back(){
        Menu mainview = new Menu();
        mainview.home();
    }
    protected abstract void index();

    
}
