app.service('gameService', function ($rootScope) {
    this.gameState = {
        rows: [
            {
                cols: [
                    {
                        type: 'X',
                        win: false
                    },
                    {
                        type: 'X',
                        win: false
                    },
                    {
                        type: 'O',
                        win: true
                    }
                ]
            },
            {
                cols: [
                    {
                        type: 'X',
                        win: false
                    },
                    {
                        type: 'O',
                        win: true
                    },
                    {
                        type: 'X',
                        win: false
                    }
                ]
            },
            {
                cols: [
                    {
                        type: 'O',
                        win: true
                    },
                    {
                        win: false
                    },
                    {
                        win: false
                    }
                ]
            }

        ]
    };

    this.userValue = '0';

    this.setGameState = function (gameState) {
        this.gameState = gameState;
        checkGameFinished();
    };

    this.setUserValue = function (value) {
        this.userValue = value;
    };

    var checkGameFinished = function () {
        if (gameState.won) {
            $rootScope.$emit('game-finished', { winner: this.gameState.winner });
        }
    };
});