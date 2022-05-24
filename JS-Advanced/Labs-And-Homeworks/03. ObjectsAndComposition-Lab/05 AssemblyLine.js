function createAssemblyLine() {
    let assemblyLine = {
        hasClima(object) {
            object.temp = 21,
                object['tempSettings'] = 21,
                object['adjustTemp'] = function () {
                    if (this.temp < this.tempSettings) {
                        this.temp += 1;
                    } else if (this.temp > this.tempSettings) {
                        this.temp -= 1;
                    }
                }
        },
        hasAudio(object) {
            object['currentTrack'] = {
                name: null,
                artist: null
            }
            object['nowPlaying'] = function () {
                if (this.currentTrack !== null) {
                    console.log(`Now playing '${this.currentTrack.name}' by ${this.currentTrack.artist}`)
                }
            }
        },
        hasParktronic(object) {
            object['checkDistance'] = function (distance) {
                if (distance < 0.1) {
                    console.log('Beep! Beep! Beep!');
                }
                else if (distance >= 0.1 && distance < 0.25) {
                    console.log('Beep! Beep!');
                }
                else if (distance >= 0.25 && distance < 0.5) {
                    console.log('Beep!');
                }
                else {
                    console.log(' ');
                }
            }
        }
    };

    return assemblyLine;
}