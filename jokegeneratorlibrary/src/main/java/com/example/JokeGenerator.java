package com.example;

import java.util.Random;

public class JokeGenerator {

    String joke1 = "Today a man knocked on my door and asked for a small donation towards the local swimming pool. I gave him a glass of water.";
    String joke2 = "I find it ironic that the colors red, white, and blue stand for freedom until they are flashing behind you.";
    String joke3 = "Just read that 4,153,237 people got married last year, not to cause any trouble but shouldn't that be an even number?";
    String joke4 = "A recent study has found that women who carry a little extra weight live longer than the men who mention it.";
    String joke5 = "I want to die peacefully in my sleep, like my grandfather.. Not screaming and yelling like the passengers in his car.";

    String myStrings[] = new String[] { joke1, joke2, joke3, joke4, joke5 };

    public String getJoke(){
        Random ran = new Random();
        int x = ran.nextInt(4);
        return myStrings[x];
    }
}
