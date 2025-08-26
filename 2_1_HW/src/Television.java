public class Television {
    private int current_channel;
    private boolean working;
    public Television() {
        this.current_channel = 1;
        this.working=true;
    }
    public void setChannel(int newChannel) {

        this.current_channel = newChannel;
        if (this.current_channel > 10){
            this.current_channel = 1;
        }
        if (this.current_channel < 1){
            this.current_channel = 1;
        }
    }
    public int getChannel() {
        return current_channel;
    }
    public void setCurrentChannel(int newChannel) {

        setChannel(newChannel);
    }

    public void printWatchinChannel(){
        if (!isOn()) return;
        System.out.println("Watching channel "+ getChannel());
    }
    public void setNextChannel() {
        if (!isOn()) return;
        setCurrentChannel(getChannel()+1);
    }
    public void setPreviousChannel() {
        if (!isOn()) return;
        setCurrentChannel(getChannel()-1);
    }
    public boolean isOn(){
        return this.working;
    }
    public void setOn(){
        this.working=true;
    }
    public void setOff(){
        this.working=false;
    }
    public void pressOnOff(){
        this.working=!this.working;
    }



}
