# Stracheship

- COMPILE

In order to compile the source code first place it in a local file/repository on your computer.Either 
maven or a local IDE can be used for this task.

- EXECUTE

After placing (and compiling) the source code, run SplashScreen.class using a local IDE,
or execute the Stracheship.jar file (also through command line using java -jar Stracheship.jar).

In case Stracheship.jar is executed normally, BUT sounds are unavailable (no music during menu or
the main game, no sounds effects etc.) and images cannot be loaded (jpg, png etc.), try placing
the Stracheship.jar app into a folder that contains all the resources (images and sound files) and
execute again.

ALSO, TRYING TO EXECUTE STRACHESHIP.JAR FROM OUR LATEST GITHUB RELEASE, THE USER WILL ENCOUNTER SOME
PROBLEMS. THE SOLUTION FOR THIS, IS TO DOWNLOAD THE "Source Code" ZIP AND EXECUTE STRACHESHIP.JAR FROM
THERE.

- HOW TO PLAY

The following instructions can also be found in the main menu of Stracheship (Press Help button 
and find the information about the game orginized, with button navigation)

Stracheship Presentation

Main idea

Stracheship is a competitive game, a variation of the known games of chess, ship naval battles. Basically it is a combination of those two games as the name shall clarify.

Stra from strategy that it should use

Ches from chess

And ship from naval battles.

In this game two players compete for the domination of the sea. Main goal is to destroy all the ships of the competitor.



Play area

Stracheship is taking place in two 10x10 tables. Each player has his own table.



FLEET

Each player is given a number of troops. Specifically each player has five ships each one of them with a different length and stamina.

They have one small ship which withholds two places in the  table and can endures two attacks of enemy troops.

Two normal ships with three places in the warzone and stamina of three lifes.

Two large ships with four places and stamina of 4 enemy attacks.



Movement

Ships can be placed either horizontally or vertically. If a ship is horizontally placed,

it can only move right or left. In the opposite, if it is placed vertically it can only move up or down by size of the table.




Deities

Players represent a god from Greek mythology. They choose the deity before the game starts. They cannot choose the same. Each one of them has different power of attack and defense accordingly his role in mythology. The deities they can choose is zeus , artemis , ares and Poseidon. More specifically :

Zeus

Attack = As the god of thunders in his attacks he chooses a ship of the enemy troops and

either he destroys it or only leaves it with one life. If the ship is small or normal it gets full destroyed, if it is large it is left with stamina of one hit.

His attacks ,however, cannot pass the defense of Poseidon but can go through the defense of Aris.

Defense = Being the father of all gods he can raise a ship that is destroyed back to life with       full stamina.



Artemis

Attack :

As the goddess of hunt she picks a line out of ten and throws an arrow among that line. Everything in the way of the arrow gets hit.



Defense:

Goddess of care and protector of children, she can pick a ship of hers which is not destroyed and full its stamina.



Ares

Attack:

God of war. His attack matches his role in mythology, every ship of the enemy gets hit one time losing one point on its stamina.



Defense:

Being the god of war he protects his warriors. He chooses a ship of his own and shields it. The enemy has to hit each block of the shield ship two times to destroy it.



Poseidon

Attack:

God of sea. He chooses a ship of the enemy. That ship appears in a new different table(10x10)/sea. Now the player knows the specific place of that ship. However the player cannot know how much life/stamina that ship contains.



Defense:

Picks coordinates x,y in the table. Those coordinates form the top left corner of a new 4x4 table which is created. Every ship in this table is being protected by enemy attacks for four rounds.



Game instructions



Each player has his own round. In this round the player has five available movements . He can choose in every move if he wants to move a ship of his or to hit in a block of the enemy table so as to hit enemy troops. When those five movements end player gets to choose either to give turn in enemy or to use god power . If he chooses god then he picks attack or defense accordingly to his plans. When god power ends he has to choose to give turn so he cannot see the table of his enemy. Also, player can win any time. Not all movements must be used.  

In case in which he hits an enemy ship a sound will be made so the player knows he actually hit a block that contains part of the ship.

Screen of the player contains his table(sea), ships. When he clicks in a ship it also shows its stamina and type of sea(small, normal, large).

All ships have the same color. For reasons of convenience the ship you click gets more dark.

Players also have a map of enemy table which shows the blocks he has hit with a black color.  So, every time he presses the button “hit” in his screen he knows his previous hits.

- REPOSITORY STRUCTURE

This repository's main structure is formed by apache maven (project Stracheship), this README.md file that is being read at the moment,
and an executable file named Stracheship.jar. Inside the main folder (Stracheship) , there is another folder named "src" and 5 files,

.editorconfig
.gitattributes
.gitignore
.travis.yml
.pom.xml

which are generated automatically by apache maven, each one with its unique perpose.

Following the path from folder "src" to the actual source code folder named "simplesoftware", the user will encounter all the .java files 
and also all the resources (images .jpg or.png and sounds .wav) ordered alphabetically.

This repository has a total of 422 commits, from 8 different users and was designed specifically for this project.


- Author : SimpleSoftware
- Game Designers : SimpleSoftware

- Team (SimpleSoftware):
@GrammatikakisDimitris (team leader)
@marsidmali
@Pant-Tri-aueb
@AkisPanagiotopoulos
@giormala
@demetres12
@filf13
@sergiloupa

