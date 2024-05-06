package Lab5;

public class task1 {
    public static void main(String[] args){
        Videoplayer videoplayer = new Videoplayer("Samsung BD-J7500","MP4");
        videoplayer.turnOn();
        videoplayer.start();
        videoplayer.start();
        videoplayer.stop();
        videoplayer.stop();
        videoplayer.turnOff();
    }
}

interface Technique{
    void turnOn();
    void turnOff();
}

abstract class Player implements Technique{
    protected String model;
    protected boolean isWorking;

    public abstract void start();
    public abstract void stop();

    Player(){
        this.model = "Undefined";
        this.isWorking = false;
    }
    Player(String name){
        this.model = name;
        this.isWorking = false;
    }

    public void setModel(String model){
        this.model = model;
    }
    public String getModel(){
        return this.model;
    }

    public boolean isWorking(){
        return this.isWorking;
    }

    @Override
    public void turnOn(){
        this.isWorking = true;
        System.out.printf("Плеер %s включен.\n",this.model);
    }
    @Override
    public void turnOff(){
        this.isWorking = false;
        System.out.printf("Плеер %s выключен.\n",this.model);
    }

}

class Videoplayer extends Player{
    private String videoFormat;
    private boolean isPlaying;

    Videoplayer(String model,String videoFormat){
        super(model);
        this.videoFormat = videoFormat;
        this.isPlaying = false;
    }
    @Override
    public void start() {
        if(this.isWorking()){
            if(!this.isPlaying){
                this.isPlaying = true;
                System.out.printf("Воспроизведение видео на плеере %s в формете %s.\n",this.model,this.videoFormat);
            }
            else{
                System.out.println("Видео уже воспроизводится.");
            }
        }
        else{
            System.out.println("Видеоплеер выключен. Включите плеер, чтобы начать воспроизведение видео.");
        }
    }
    @Override
    public void stop() {
        if(this.isPlaying){
            this.isPlaying = false;
            System.out.println("Воспроизведение видео остановлено.");
        }
        else{
            System.out.println("Видео уже остановлено.");
        }

    }
}