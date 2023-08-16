import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Album arjitAlbum = new Album("Arijit Singh","Arijit's Album");
        Album alanAlbum = new Album("Alan Walker","Walker's's Album");

        arjitAlbum.addSongToAlbum("Kesariya",3.1);
        arjitAlbum.addSongToAlbum("Tum Kya Mile",4.1);
        arjitAlbum.addSongToAlbum("Ye desh mere",3.5);

        alanAlbum.addSongToAlbum("Faded",3.1);
        alanAlbum.addSongToAlbum("Alone",4.1);
        alanAlbum.addSongToAlbum("Darkside",3.5);

        LinkedList<Song> myPlaylist = new LinkedList<>();
        System.out.println(arjitAlbum.addToPlaylistFromAlbum("Kesariya",myPlaylist));
        System.out.println(arjitAlbum.addToPlaylistFromAlbum(2,myPlaylist));
        System.out.println(arjitAlbum.addToPlaylistFromAlbum(5,myPlaylist));
        System.out.println(alanAlbum.addToPlaylistFromAlbum("Alone",myPlaylist));
        System.out.println(alanAlbum.addToPlaylistFromAlbum(3,myPlaylist));

        play(myPlaylist);

    }

    private static void play(LinkedList<Song> myPlaylist) {
        if(myPlaylist.size() == 0){
            System.out.println("Your playList is empty");
            return;
        }
        ListIterator<Song> itr = myPlaylist.listIterator();
        System.out.println("Currently playing : "+itr.next());

        Scanner sc= new Scanner(System.in);
        printMenu();
        boolean quit = false;
        while(!quit){
            System.out.println("Enter your choice");
            int choice = sc.nextInt();

            switch (choice){
                case 1:
                    printMenu();
                    break;
                case 2:
                    if(! itr.hasNext())
                        System.out.println("You have reached to the end of playlist");
                    else
                        System.out.println("Playing song "+itr.next());
                    break;
                case 3:
                    if(! itr.hasPrevious())
                        System.out.println("You have reached to the start of playlist");
                    else
                        System.out.println("Playing song "+itr.previous()1);
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    printSongs(myPlaylist);
                    break;
                case 7:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid Choice !!");

            }
        }
    }

    private static void printSongs(LinkedList<Song> myPlaylist) {
        for(Song song:myPlaylist){
            System.out.println(song);
        }
        return;
    }

    private static void printMenu() {
        System.out.println("1. Show the menu again");
        System.out.println("2. Play the next song");
        System.out.println("3. Play the previous song");
        System.out.println("4. Play the current song again");
        System.out.println("5. Delete current song from playList");
        System.out.println("6. List all songs from playList");
        System.out.println("7. Quit");
    }

}