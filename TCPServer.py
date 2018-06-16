from socket import *
serverPort = 12000
serverSocket = socket(AF_INET, SOCK_STREAM)
serverSocket.bind(('', serverPort))
serverSocket.listen(1)
print('The server is ready')
while True:
    connectionSocket, addr = serverSocket.accept()
    message = connectionSocket.recv(2048)
    modifiedMessage = message.upper()
    print('processed:', message)
    connectionSocket.send(modifiedMessage)
    connectionSocket.close()