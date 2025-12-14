# Cookie Man
# Alara Yener and Nayla Trigueros Ortiz

Cookie Man is a twist on the traditional PacMan game, where a user-controlled character in a maze collects cookie-points while avoiding monsters.

To run Cookie Man, you must:
- Have Java 17/21 installed (required for Kilt Graphics).
- Have the Kilt Graphics library.
- Make sure that the image files are within this project's directory (pacman.png and pinkGhost.png).
- The main class is GameBoard.java; to play Cookie Man, run its main method. If using the command line:
                javac GameBoard.java
                java GameBoard

How Cookie Man works:
- Cookie Man will automatically open in a window of 900x900 pixels.
- Use the arrow keys to control Cookie Man and collect all cookies while avoiding the ghosts. 
- Objective: Reach 3200 points by collecting all cookies (10 points each) to win.
- You are given 3 lives; each collision with a ghost costs one life. There is a 1-second pause for re-start. The game ends when you run out of lives.
- There is a boost which appears as a green cookie that makes cookie man run faster for 10 seconds

For our characters, we imported images from a quick Google Search of: PacMan characters pixel. To create our cookies, win/lose logic, and key control, we took inspo from past COMP 127 homeworks, such as: Breakout, BubbleBlitz.

There are some limitations to our game:
- Display Issues: Score and lives are tracked internally but not displayed during gameplay. Players will see their final score only when the game ends (win or loss). Also, Cookie Man's circular shape may slightly overlap the game borders during movement.
- Movement Restrictions: Cookie Man follows an invisible grid aligned with the cookie positions. If Cookie Man gets too close to a wall and becomes misaligned with this grid, movement may be restricted. To resume normal movement, navigate back toward the visible cookie trail to realign with the grid.
- Re-start Constraint: When you lose a life, Cookie Man reappears at the starting position but the ghosts remain in their current locations. If a ghost is near the start point, you may lose another life immediately upon re-starting.

Some ethical considerations of Cookie Man to take into account are:
- Cookie Man has significant accessibility barriers. The game relies entirely on visual cues with no audio feedback or screen reader support, making it inaccessible to players who are blind or have low vision. It requires arrow key input with no alternative control options, excluding players with motor disabilities or those using assistive devices. The fast-paced gameplay may also be challenging for players with slower reaction times.
- While the color scheme has contrast, players with certain types of color blindness may struggle to distinguish the elements of the game. The game might be quick to discourage players due to the re-start constraint mentioned above by causing fast, repetitive life losses.
- On the positive side, Cookie Man avoids violent graphics, discriminatory content, and doesn't collect personal data, respecting user privacy as a simple offline game. Because of that, malicious use of Cookie Man is limited to compulsive playing, which seems a minimal risk.
- Some potential improvements for inclusivity could be: audio cues for the game, more accessible controllers that do not fully depend on a keyboard, adjustable difficulty, a more colorblind-friendly palette, and screen-reader compatibility, among others. Thinking bigger, we would also want to add different themes to our game to reach a broader audience as well.
