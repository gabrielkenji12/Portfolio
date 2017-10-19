import random

def lerArquivo(nomeArquivo):
    rotasArquivo = []
    cont = 0
    arq = open(nomeArquivo,"r")
    linhas = arq.readlines()
    for linha in linhas:
        if(linha == "0 0"):
            break
        rotasArquivo.append(linha.rstrip())

    return rotasArquivo
    arq.close()

def gravaRotas(rotasArquivo, a):
    cont = 0
    col = 0
    lin = 0
    for i in rotasArquivo:
        if(cont >= 1):
            lin, col = (i.split(" "))
            x = int(lin)
            y = int(col)
            a[x][y] = 1
        cont += 1
    return a

def criarMatriz(lim):
    matriz1 = []
    n = lim+1
    m = lim+1
    for i in range(n):
        matriz1.append([])
        for j in range(m):
            matriz1[i].append(0)

    return matriz1

def printMatriz(matriz1):
    for i in range(len(matriz1)):
        for j in range(len(matriz1[i])):
            print(matriz1[i][j], end=" ")
        print("\n")

def calculaRota(i,matriz,resultado,incendio):
    cont = 1
    if i == incendio:
        print(resultado)
        return
    for j in range(len(matriz)):
        if matriz[i][j] == 1:
            resultado.append(j)
            calculaRota(j,matriz,resultado,incendio)
            resultado.pop() #tira o ultimo
            cont +=2
    return cont

def main():
    resultado = []
    #nomeArquivo = input("Digite o nome do arquivo: ")
    rotasArquivo = lerArquivo("entrada.txt")
    incendio = int(rotasArquivo[0])
    a = criarMatriz(incendio+1)
    a = gravaRotas(rotasArquivo,a)
    printMatriz(a)
    print("------- TESTE --------")
    resultado.append(1)
    cont = calculaRota(1,a,resultado,incendio)
    print("Existem", cont, "rotas do quartel de bombeiros até a esquina", incendio)

main()