app.service('playerService', function ($rootScope, $localStorage) {
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

                stompClient.subscribe('/game/public', function (newUser) {
                    $rootScope.$emit('newUser', { userName: newUser });

                    if (newUser === $localStorage.getItem('currentUser')) {
                        $rootScope.$emit('userCreated');
                    }
                });
            },
            function () {
                console.log('Disconnected player');
            }
        );
    };

    this.createNewUser = function (userName) {
        if (!connected) { return; }

        stompClient.send('/app/createNewUser', {}, userName);

        $localStorage.setItem('currentUser', userName);
    };

    init();
});