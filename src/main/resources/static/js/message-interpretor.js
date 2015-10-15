app.service('messageInterpretor', function (gameService) {
    var messageCallbacks = {
        'gameState': changeGameState,
        'userValue': changeUserValue
    };

    this.interpretMessage = function (message) {
        if (messageCallbacks[message.type]) {
            messageCallbacks[message.type](message.value);
        }
    };

    var changeGameState = function (gameState) {
        gameService.setGameState(gameState);
    };

    var changeUserValue = function (userValue) {
        gameService.setUserValue(userValue);
    };
});