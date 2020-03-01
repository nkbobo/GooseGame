# goose-game
The Goose Game Kata

## Compile game

JDK version 1.8 is required to build the game.
To compile and build the project follow this steps:

1. `git clone` the project in a directory.
2. `mvn clean package` on the project directory.

## Play game

To start game go to **dist** directory under project directory and execute `java -jar "GooseGame.jar"`

### Game commands

Available commands are:

1) add player <PLAYER_NAME> to add a player (e.g. add player pippo)
2) move <PLAYER_NAME> to automatically roll the dice for him (e.g. move pippo)
3) move <PLAYER_NAME> <N1>, <N2> to move him of the sum of those numbers (e.g. move pippo 2, 3)
4) exit to quit playing

**Have Fun!!** :smiley:
