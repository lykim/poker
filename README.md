# Poker Game Simulation

This is a simulation of poker game written in Java

## Compile and Run 
copy all this folder and subfolders to your choice folder

## From eclipse
Just run the Main.java file in poker/poker-game/src/main/java/com/ruly/Main.java

### From console
compile java file with package options, you can do it from "poker/poker-game/src/main/java" folder, where this folder is copied, for example if you copy this folder in /Home/ruly then you can change directory to /Home/ruly/poker/poker-game/src/main/java.
after that you can compile it using this command javac -d classes com/ruly/Main.java com/ruly/card/Card.java com/ruly/player/Player.java com/ruly/table/Table.java com/ruly/utils/PlayerUtils.java com/ruly/utils/CardRankUtilities.java

```bash
javac -d classes com/ruly/Main.java com/ruly/card/Card.java com/ruly/player/Player.java com/ruly/table/Table.java com/ruly/utils/PlayerUtils.java com/ruly/utils/CardRankUtilities.java
```
to run it go to subfolder 'classes' that have been created, and type java com.ruly.Main
```bash
cd classes
java com.ruly.Main
```
## Usage

- the program will ask how many player, you can input how many player you want, maksimum is 10
- the program will ask about using default name for players, if you choose 'y' you will naming each player, if not the player will have name by sequence
- after that program will have give player cards and then ranking the player based by their cards, the winner is top most position.
- the program will print the ranking position, and end.
- thanks for playing
