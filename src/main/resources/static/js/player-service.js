app.service('playerService', function ($rootScope, $localStorage) {
    var sock,
        stompClient,
        connected;

    var init = function () {
        sock = new SockJS('/createNewUser');
        stompClient = Stomp.over(sock);

        stompClient.connect({},
            function (frame) {
                console.log('Connected to: createNewUser' + frame);

                connected = true;

                stompClient.subscribe('/game/public', function (message) {
                    var newUser = message.body;

                    if (newUser === $localStorage.currentUser) {
                        $rootScope.$emit('userCreated');
                    }
                });
            }
        );
    };

    this.createNewUser = function (userName) {
        if (!connected) { return; }

        stompClient.send('/app/createNewUser', {}, userName);

        $localStorage.currentUser = userName;
    };

    init();
});