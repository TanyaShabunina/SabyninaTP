public class AudioPlayer {
    private int volume;
    public void setVolume (int volume){
        this.volume = volume;
    }
    public Save save(){
        return new Save(volume);
    }
    public void load(Save save){
        volume = save.getVolume();
    }

    @Override
    public String toString() {
        return "AudioPlayer{" +
                "volume=" + volume +
                '}';
    }
}
