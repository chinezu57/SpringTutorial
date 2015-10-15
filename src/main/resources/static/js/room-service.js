app.service('roomService', function ($rootScope) {
    var sock,
        stompClient,
        connected;

    var init = function () {
        sock = new SockJS('/getAllRooms');
        stompClient = Stomp.over(sock);

        stompClient.connect({},
            function (frame) {
                console.log('Connected to: ' + frame);

                connected = true;

                stompClient.subscribe('/game/allRooms', function (rooms) {
                    $rootScope.$emit('new-room', { rooms: rooms });
                });
            },
            function () {
                console.log('Disconnected player');
            }
        );
    };

    init();
});