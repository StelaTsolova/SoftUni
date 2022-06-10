function solve(request) {
    const methods = ['GET', 'POST', 'DELETE', 'CONNECT'];
    const patternUri = /^[.]*[\w]+[.\w]*$/g;
    const versions = ['HTTP/0.9', 'HTTP/1.0', 'HTTP/1.1', 'HTTP/2.0'];
    const patternMessage = /^[^<>\\&'"]*$/g;

    if (request.method == undefined || !methods.includes(request.method)) {
        throw Error('Invalid request header: Invalid Method');
    }

    if (request.uri == undefined || !patternUri.test(request.uri)) {
        throw Error('Invalid request header: Invalid URI');
    }

    if (request.version == undefined || !versions.includes(request.version)) {
        throw Error('Invalid request header: Invalid Version');
    }

    if (request.message == undefined || !patternMessage.test(request.message)) {
        throw Error('Invalid request header: Invalid Message');
    }

    return request;
}