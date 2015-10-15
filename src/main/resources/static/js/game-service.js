app.service('gameService', function ($rootScope) {
    var sock,
        stompClient,
        connected;

    var init = function () {
        sock = new SockJS('/nextTurn');
        stompClient = Stomp.over(sock);

        stompClient.connect({},
            function (frame) {
                console.log('Connected to: ' + frame);
                connected = true;
            },
            function () {
                console.log('Disconnected player');
            }
        );
    };

    this.enterGame = function (roomId) {
        stompClient.subscribe('/game/' + roomId, function (gameState) {
            $rootScope.$emit('gameStateChanged', { gameState: gameState });
        });
    };

    this.sendMessage = function (message) {
        sock.send(message);
    };

    init();
});