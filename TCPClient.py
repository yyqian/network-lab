from socket import *
serverName = 'localhost'
serverPort = 12000
while True:
    clientSocket = socket(AF_INET, SOCK_STREAM)
    clientSocket.connect((serverName, serverPort))
    message = input('Input your message:')
    clientSocket.send(message.encode())
    modifiedMessage = clientSocket.recvfrom(2048)
    print(modifiedMessage)
    clientSocket.close()