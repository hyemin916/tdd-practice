package com.example.tddpractice;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallingTest {
    @Test
    @DisplayName("게임 스코어는 0에서 시작한다.")
    void gameScoreStartsAtZero() {
        final Game game = new Game();
        assertThat(game.score()).isEqualTo(0);
    }

    @Test
    @DisplayName("한번의 투구에 10개 초과의 핀을 쓰러트릴 수 없다.")
    void cannotKnockDownMoreThanTenPinsInOneRoll() {
        final Game game = new Game();
        assertThatThrownBy(() -> game.roll(11))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("한번의 투구에 0개 미만의 핀을 쓰러트릴 수 없다.")
    void cannotKnockDownLessThanZeroPinsInOneRoll() {
        final Game game = new Game();
        assertThatThrownBy(() -> game.roll(-1))
                .isExactlyInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @Disabled
    void example() {
        final Game game = new Game();
        game.roll(1);
        game.roll(4);

        assertThat(game.score()).isEqualTo(5);

        game.roll(4);
        game.roll(5);

        assertThat(game.score()).isEqualTo(14);

        game.roll(6);
        game.roll(4);

        assertThat(game.score()).isEqualTo(24);

        game.roll(5);
        game.roll(5);

        assertThat(game.score()).isEqualTo(39);

        game.roll(10);

        assertThat(game.score()).isEqualTo(59);

        game.roll(0);
        game.roll(1);
        assertThat(game.score()).isEqualTo(61);

        game.roll(7);
        game.roll(3);
        assertThat(game.score()).isEqualTo(71);

        game.roll(6);
        game.roll(4);

        assertThat(game.score()).isEqualTo(87);

        game.roll(10);

        assertThat(game.score()).isEqualTo(107);

        game.roll(2);
        game.roll(8);

        assertThat(game.score()).isEqualTo(127);

        game.roll(6);

        assertThat(game.score()).isEqualTo(133);

        assertThatThrownBy(() -> game.roll(1))
                .isExactlyInstanceOf(IllegalStateException.class);
    }

    private class Game {
        public void roll(final int i) {
            if (i > 10) {
                throw new IllegalArgumentException();
            }
        }

        public int score() {
            return 0;
        }
    }
}
