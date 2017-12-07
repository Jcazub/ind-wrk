/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.exercise.four.ifelse;

import java.util.Scanner;

/**
 *
 * @author Jesse
 */
public class MiniZork {
    public static void main(String[] args) {
         Scanner userInput = new Scanner(System.in);

        System.out.println("You are standing in an open field west of a white house,");
        System.out.println("With a boarded front door.");
        System.out.println("There is a small mailbox here.");
        System.out.print("Go to the house, or open the mailbox? ");

        String action = userInput.nextLine();

        if (action.equals("open the mailbox")) {
            System.out.println("You open the mailbox.");
            System.out.println("It's really dark in there.");
            System.out.print("Look inside or stick your hand in? ");
            action = userInput.nextLine();

            if (action.equals("look inside")) {
                System.out.println("You peer inside the mailbox.");
                System.out.println("It's really very dark. So ... so very dark.");
                System.out.print("Run away or keep looking? ");
                action = userInput.nextLine();

                if (action.equals("keep looking")) {
                    System.out.println("Turns out, hanging out around dark places isn't a good idea.");
                    System.out.println("You've been eaten by a grue.");
                } else if (action.equals("run away")) {
                    System.out.println("You run away screaming across the fields - looking very foolish.");
                    System.out.println("But you are alive. Possibly a wise choice.");
                }
            } else if (action.equals("stick your hand in")) {
                System.out.println("Something immediately grabs onto your hand!");
                System.out.println("You feel it gnawing at your hand, stripping the flesh away!");
                System.out.print("Take your hand out immediately or shake the mailbox up first?");
                action = userInput.nextLine();
                
                if (action.equals("take your hand out immediately")) {
                    System.out.println("You try to free your hand from the mailbox!");
                    System.out.println("Unfortunately, whatever is in there has a stronger grip.");
                    System.out.println("It rips your arms from its socket and you collapse on the ground");
                    System.out.println("You slowly die of blood loss. Tough luck.");
                    
                } else if (action.equals("shake the mailbox up first")) {
                    System.out.println("You shake the mailbox viciously.");
                    System.out.println("Whatever had your hand decides to let go.");
                    System.out.println("You run to the nearest hospital, where they are able to operate on your hand immediately.");
                    System.out.println("Unfortunately, you lost your entire hand in the process, but things could have turned our worse, right?");
                }
            }
        } else if (action.equals("go to the house")) {
            System.out.println("You walk up to the house slowly, the floorboards creeking with your every step.");
            System.out.println("You cautiously raise your hand to the doorknob, feeling your the cold brass against your skin");
            System.out.println("A voice suddenly whispers from within, 'It's polite to knock first before entering someone's home'");
            System.out.print("Answer the voice or run away?");
            action = userInput.nextLine();

            
            if (action.equals("answer the voice")) {
                System.out.println("You speak up sheepishly, 'So-sorry, I th-thought this place was abandoned.");
                System.out.println("The voice chuckles warmly. The door suddenly springs open, with the visage of an old, elegantly dressed woman displayed before you.");
                System.out.println("'Come inside' the old woman said. I was just preparing dinner. I wouldn't mind having a guest over for my feast.");
                System.out.print("Accept the invitation or try to walk away.");
                action = userInput.nextLine();
                
                if (action.equals("accept the invitation")) {
                    System.out.println("'Umm, ok, but I have to be home before dark.' you manage to squeak out.");
                    System.out.println("As you tour around the house, you realize it looks like it hasn't been touched in years.");
                    System.out.println("You round the corner to the dining room to discover the table hasn't been set and the stove is not on.");
                    System.out.println("'Wh-where's dinner?' you whimper. 'Why its just arrived!' the old woman screeches, as she turns into a giant bat creature and drains you dry.");
                } else if (action.equals("try to walk away")) {
                    System.out.println("'Uh, thanks but I got to get home now, or my mom will be worried sick', you stammer as you turn to walk away.");
                    System.out.println("'Oh, but you've come all this way', the old lady soothes.");
                    System.out.println("'And I'm just so hungry', she whines. A chill runs down your spine...");
                }
                
            } else if (action.equals("run away")) {
                System.out.println("The voice startles you, returing your common sense.");
                System.out.println("You turn on your heel quickly, and prepare to bolt.");
                System.out.println("As you break into a sprint, your shoelace snags on a fallen tree branch, and you tumble to the ground");
                System.out.println("As you turn your head, you see a giant bat-like creature towering above you.");
                System.out.print("Fight for your life or beg for mercy?");
                action = userInput.nextLine();
                
                if (action.equals("fight for your life")) {
                    System.out.println("You grab the nearest tree branch and start swinging away.");
                    System.out.println("You manage to catch the monster in the eye.");
                    System.out.println("With this newfound window of opportunity, you channel your inner Usain Bolt, taking off and never looking back");
                    System.out.println("You can hear the monster screech in the background, its cries fueling the adrenaline pumping throughout your body.");
                    System.out.println("You manage to marathon it all the way home, bolting the doors and pulling the blinds after you.");
                    System.out.println("No more late night exloring for you.");
                } else if (action.equals("beg for mercy")) {
                    System.out.println("You get up to your knees, clasp your hands and bow your head inches to the ground.");
                    System.out.println("'Please, please, please, please, please don't kill me.' you cry.");
                    System.out.println("You can feel what resembles a smile crack upon the monsters face.");
                    System.out.println("'And why should I do that?', the creature wails.");
                    System.out.println("'Be-because', the hamsters in your brain working on overdrive. 'I can bring you more!', you explode.");
                    System.out.println("You can sense the creature considering its options.");
                    System.out.println("'Alright', the creature slithers.");
                    System.out.println("ONE WEEK LATER");
                    System.out.println("'Hey guys, there's this really cool abandoned house up on Churchill...'");
                }
                
            }
                
        }
    }
}
