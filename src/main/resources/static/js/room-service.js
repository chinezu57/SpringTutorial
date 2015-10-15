app.service('roomService', function ($rootScope) {
    this.getAllRooms = function () {
        var sock = new SockJS('/getAllRooms'),
            stompClient = Stomp.over(sock);

        stompClient.connect({},
            function (frame) {
                console.log('Connected to: ' + frame);

                stompClient.subscribe('/game/allRooms', function (rooms) {
                    $rootScope.$emit('newRoom', { rooms: rooms });
                });
            },
            function () {
                console.log('Disconnected ');
            }
        );
    };

    this.getNextTurn = function (roomId) {
        var sock = new SockJS('/nextTurn'),
            stompClient = Stomp.over(sock);

        stompClient.connect({},
            function (frame) {
                console.log('Connected to: ' + frame);

                stompClient.send('/app/nextTurn', {}, roomId);

                stompClient.subscribe('/game/' + roomId + '/nextTurn', function (gameState) {
                    $rootScope.$emit('nextTurn', { gameState: gameState });
                });
            },
            function () {
                console.log('Disconnected player');
            }
        );
    };

    this.createNewGame = function (roomId) {
        var sock = new SockJS('/createNewGame'),
            stompClient = Stomp.over(sock);

        stompClient.connect({},
            function (frame) {
                console.log('Connected to: ' + frame);

                stompClient.send('/app/createNewGame', {}, roomId);

                stompClient.subscribe('/game/' + roomId + '/newGame', function (roomId) {
                    stompClient.subscribe('/game/' + roomId + '/nextTurn', function (gameState) {
                        $rootScope.$emit('nextTurn', { gameState: gameState });
                    });
                });

                stompClient.disconnect();
            },
            function () {
                console.log('Room created');
            }
        );
    };

    this.joinGame = function (roomId) {
        var sock = new SockJS('/joinGame'),
            stompClient = Stomp.over(sock);

        stompClient.connect({},
            function (frame) {
                stompClient.send('/app/joinGame', {}, roomId);

                stompClient.subscribe('/game/' + roomId + '/joinGame', function (roomId) {
                    stompClient.subscribe('/game/' + roomId + '/nextTurn', function (gameState) {
                        $rootScope.$emit('nextTurn', { gameState: gameState });
                    });
                });
            },
            function () {
                console.log('Disconnected player');
            }
        );
    };

    this.rematch = function (roomId) {
        var sock = new SockJS('/rematch'),
            stompClient = Stomp.over(sock);

        stompClient.connect({},
            function (frame) {
                console.log('Connected to: ' + frame);

                stompClient.send('/app/rematch', {}, roomId);

                stompClient.subscribe('/game/' + roomId + '/rematch', function (gameState) {
                    $rootScope.$emit('newGameState', { gameState: gameState });
                });
            },
            function () {
                console.log('Disconnected player');
            }
        );
    };

    this.getAllRooms();
});