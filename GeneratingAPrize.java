/*
    This program is for Lab 1 Generating a Prize(PSET1). It uses:
    JOptionPane for a popup window experience, the Random class to randomly 
    generate prizes, and a program loop that keeps looping through prizes/activities
    until prompted to exit when the user clicks 'quit'. For the html tag <br>, 
    I discussed using this with my classmate Yuni Lin and we both decided to use 
    the <br> tag in order to align the text to the bottom.
    D. McCrary
    09/05/2024
 */

import javax.swing.*;
import java.util.*;
import java.io.*;

public class GeneratingAPrize {
    
    public static void main(String[] args) {
        
        ImageIcon welcomeIcon = new ImageIcon("icons/prize.png");
        String[] welcomeOption = {"OK"};
        String welcomeMessage = """
                                \nWelcome to the Prize Generator! This program 
                                will randomly gift you a trip to a Carribean Island
                                along with a fun activity for you to enjoy while
                                you're there. In case you are not happy with your
                                prize, you are free to choose another one.
                                
                                Click the 'OK' button to view your prize!""";
        
        int WelcomeIntro = JOptionPane.showOptionDialog(null, welcomeMessage,
            "Welcome to the Prize Generator, Presented by Darcie McCrary",0,
            1, welcomeIcon, welcomeOption, welcomeOption[0]);
        
        while(true) {
            
            String[] islands = { "Bermuda", "Bahama", "Jamaica", "Aruba", 
                             "Martinique", "Antigua" };
        
            String[] activities = {"parasailing","surfing", "snorkeling", 
                     "DeepSeaFishing", "sailBoarding", "sharkSpotting", 
                     "JetSkiing","scubaing", "shipwreck"};
        
            Random randGen = new Random();
        
            int island = randGen.nextInt(islands.length);        
            int active = randGen.nextInt(activities.length);
        
            String activityFile = "icons/"+activities[active]+".png";   
        
            File iconFile = new File(activityFile);
            
            if ( ! iconFile.exists()) {
                System.out.println("\nCannot see the file - "+activityFile);
            }
            else {
                System.out.println("\nCAN see the file - "+activityFile);
            }
        
            ImageIcon icon = new ImageIcon(activityFile);
            String text = "<html><h1><br><br><br><br><br><br> on "+islands[island]+"</h1></html>";

       
            String[] options = {"Get Another trip!", "Quit"};
            int choice = JOptionPane.showOptionDialog(null, text,
                "Your Prize, presented by Darcie McCrary",0,
                1, icon, options, options[0]);
            
            if(choice == 1){
                
                String[] TerminationScreenButton = {"OK!"};
                ImageIcon terminationIcon = new ImageIcon("icons/Trip.png");
                String terminationMessage = "<html><br><br>Enjoy your prize!<br>"
                                            + "This program will now end.</html>";
                
                int terminationScreen = JOptionPane.showOptionDialog(null, terminationMessage,
                    "Have FUN! Presented by Darcie McCrary",0,
                    1, terminationIcon, TerminationScreenButton, TerminationScreenButton[0]);
                System.exit(0); 
            }
        }
    }  
}
   
        

