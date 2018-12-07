package com.hp.bto.shr.dim.command;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/*This class is developed to shuffle and play songs. Also plays the song previous and next to any given input song id
It assumes that the playlist is populated by default with values 0 to 99 which are individually a song id.
*/
public class Playlist
{
    List<Integer> list=new ArrayList<>();//playlist of songs
    int size; //size of playlist

    List<Integer> indexesVisited=new ArrayList<Integer>(); //it stores the list of song ids which have already been played
    void initialize()
    { //initialize the list with 0 to 99 in sequence
        for(int i=0;i<100;i++)
        {
            list.add(i);

        }
    }
    void shuffle(){
        //Shuffle the songs by generating a random number which denotes song id
        int random=(int)(Math.random()*size);
        while(indexesVisited.contains(random))
        {
            //keep generating random number as long as the number is already in the played songs list
            random=(int)(Math.random()*size);
        }
        play(random);//plays the song
        indexesVisited.add(random); //update the list with song ids already played


    }
    void play(int index)
    {
        System.out.println("Playing song "+index);
    }
    void playPrevious(int index)
    {
        System.out.println("Playing previous of song "+index);
        int i=indexesVisited.indexOf(index);
        play(indexesVisited.get(--i));

    }
    void playNext(int index)
    {
        System.out.println("Playing next of song "+index);
        int i=indexesVisited.indexOf(index);
        play(indexesVisited.get(++i));
    }
    public static void main(String args[]) {
        Playlist playlist = new Playlist();
        System.out.println("Initializing the playlist sequentially with values from 0 to 99");
        playlist.initialize();
        playlist.size = playlist.list.size();
        System.out.println("Invoking shuffle() to shuffle and play the songs");
        for (int j = 0; j < 100; j++)
            playlist.shuffle();
        System.out.println("Played all 100 songs");
        System.out.println("Enter any  song number from 0 to 99 to play its previous song");
        Scanner scanner=new Scanner(System.in);
        int prev=scanner.nextInt();
        playlist.playPrevious(prev);
        System.out.println("Enter any  song number from 0 to 99 to play its next song");
        int next=scanner.nextInt();
        playlist.playNext(next);
    }

}

