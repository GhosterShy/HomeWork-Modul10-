 class TV {
    public void turnOn() {
        System.out.println("TV is turned on.");
    }

    public void turnOff() {
        System.out.println("TV is turned off.");
    }

    public void setChannel(int channel) {
        System.out.println("TV channel set to " + channel + ".");
    }
}


  class AudioSystem {
     public void turnOn() {
         System.out.println("Audio system is turned on.");
     }

     public void turnOff() {
         System.out.println("Audio system is turned off.");
     }

     public void setVolume(int level) {
         System.out.println("Audio volume set to " + level + ".");
     }
 }



 class DVDPlayer {
     public void play() {
         System.out.println("DVD player is playing.");
     }

     public void pause() {
         System.out.println("DVD player is paused.");
     }

     public void stop() {
         System.out.println("DVD player is stopped.");
     }
 }

  class GameConsole {
     public void turnOn() {
         System.out.println("Game console is turned on.");
     }

     public void playGame(String gameName) {
         System.out.println("Game '" + gameName + "' is starting.");
     }
 }


 class HomeTheaterFacade {
     private TV tv;
     private AudioSystem audioSystem;
     private DVDPlayer dvdPlayer;
     private GameConsole gameConsole;

     public HomeTheaterFacade(TV tv, AudioSystem audioSystem, DVDPlayer dvdPlayer, GameConsole gameConsole) {
         this.tv = tv;
         this.audioSystem = audioSystem;
         this.dvdPlayer = dvdPlayer;
         this.gameConsole = gameConsole;
     }

     public void startMovie() {
         System.out.println("Preparing to watch a movie...");
         tv.turnOn();
         tv.setChannel(1); // Assume channel 1 is for movies
         audioSystem.turnOn();
         audioSystem.setVolume(7);
         dvdPlayer.play();
         System.out.println("Movie started!");
     }

     public void stopMovie() {
         System.out.println("Stopping the movie...");
         dvdPlayer.stop();
         audioSystem.turnOff();
         tv.turnOff();
         System.out.println("Movie ended.");
     }

     public void startGame(String gameName) {
         System.out.println("Preparing to start a game...");
         tv.turnOn();
         tv.setChannel(3); // Assume channel 3 is for the game console
         audioSystem.turnOn();
         audioSystem.setVolume(5);
         gameConsole.turnOn();
         gameConsole.playGame(gameName);
         System.out.println("Game started!");
     }

     public void shutdownSystem() {
         System.out.println("Shutting down the home theater system...");
         dvdPlayer.stop();
         gameConsole.turnOn();
         audioSystem.turnOff();
         tv.turnOff();
         System.out.println("System is off.");
     }
 }




 public class Main {
    public static void main(String[] args) {
        TV tv = new TV();
        AudioSystem audio = new AudioSystem();
        DVDPlayer dvd = new DVDPlayer();
        GameConsole console = new GameConsole();


        HomeTheaterFacade homeTheater = new HomeTheaterFacade(tv, audio, dvd, console);


        homeTheater.startMovie();
        System.out.println();


        homeTheater.stopMovie();
        System.out.println();


        homeTheater.startGame("Super Mario");
        System.out.println();


        homeTheater.shutdownSystem();

    }
}


