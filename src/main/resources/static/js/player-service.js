app.service('playerService', function ($localStorage) {
    var sock,
        stompClient,
        connected;

    var init = function () {
        sock = new SockJS('/newUser');
        stompClient = Stomp.over(sock);

        stompClient.connect({},
            function (frame) {
                console.log('Connected to: ' + frame);

                connected = true;

                stompClient
            },
            function () {
                console.log('Disconnected player');
            }
        );
    };

    this.createNewUser = function (userName) {
        if (!connected) { return; }

        stompClient.send('/app/createNewUser', {}, userName);
    };

    init();
});