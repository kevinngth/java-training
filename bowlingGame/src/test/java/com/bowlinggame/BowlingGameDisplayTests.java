package com.bowlinggame;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BowlingGameDisplayTests {
    @Test
    void shouldDisplayHeader() {
        BowlingGame game = new BowlingGame();
        BowlingGameDisplay gameDisplay = new BowlingGameDisplay( game );
        assertThat( gameDisplay.display() ).contains( "Name     |   1   |   2   |   3   |  4    |   5   |  6    |   7   |   8   |   9   |    10     |" );
    }

    @Test
    void shouldDisplayBorder() {
        BowlingGame game = new BowlingGame();
        BowlingGameDisplay gameDisplay = new BowlingGameDisplay( game );
        assertThat( gameDisplay.display() ).contains( "----------------------------------------------------------------------------------------------" );
    }

    @Test
    void shouldDisplayTemplate() {
        BowlingGame game = new BowlingGame();
        BowlingGameDisplay gameDisplay = new BowlingGameDisplay(game);
        assertThat( gameDisplay.display() ).contains(
            "Name     |   1   |   2   |   3   |  4    |   5   |  6    |   7   |   8   |   9   |    10     |" + "\n" +
            "----------------------------------------------------------------------------------------------"
        );
    }

    @Test
    void shouldDisplayFrameScore() {
        BowlingGame game = new BowlingGame();
        Frame f1 = new Frame( 5, 2, null );
        game.roll( f1 );
        BowlingGameDisplay gameDisplay = new BowlingGameDisplay(game);
        assertThat( gameDisplay.display() ).contains(
            "Name     |   1   |   2   |   3   |  4    |   5   |  6    |   7   |   8   |   9   |    10     |" + "\n" +
            "----------------------------------------------------------------------------------------------" + "\n" +
            "Player 1 | 5 | 2 |"
        );
    }
//  2 | / | 8 | - | X | - | X | - | X | - | 2 | / | 5 | 2 | 4 | 2 | 2 | / | 2 |
//        assertThat( gameDisplay.display() ).contains( "" );
//         |   0   |   18  |  26   |  56   |  78   |  98   |  113  |  120  |  126  |    138    |
}
