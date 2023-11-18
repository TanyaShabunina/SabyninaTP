public class Main {
    public static void main(String[] args) {

        AudioPlayer audioPlayer = new AudioPlayer();
        GitHubRepo gitHubRepo = new GitHubRepo();
        audioPlayer.setVolume(25);
        System.out.println("Сейчас громкость " + audioPlayer);
        gitHubRepo.setSave(audioPlayer.save());
        audioPlayer.setVolume(50);
        System.out.println("Сейчас громкость" + audioPlayer);
        audioPlayer.load(gitHubRepo.getSave());
        System.out.println("Сейчас громкость" + audioPlayer);

    }
}