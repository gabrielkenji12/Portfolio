def lerArquivo(nomeArquivo,caracteres):
    texto = " "
    textoArquivo = []
    arq = open(nomeArquivo, "r")
    linhas = arq.readlines()
    for str in linhas:
        linha1 = str.rstrip().lower()
        if (linha1 != ''):
            textoArquivo.append(linha1)

    arq.close()

    textoArquivo = removeCaracteres(textoArquivo,caracteres)

    for i in range(len(textoArquivo)):
        texto = textoArquivo[i] + " " + texto
        dicionario = texto.split(" ")

    return dicionario


def QuickSort( p, r, v):
 if p < r:
    q = particao(p, r, v )

    QuickSort( p, q - 1, v)
    QuickSort( q + 1, r, v)



def particao( p, r, v):
    c = v[p]
    i = p+1
    j = r
    while i <= j:
        if v[i] <= c:
            i+=1 # sobe i, procurando o primeiro maior ou igual elemento em relacao ao pivo
        elif v[j] > c:
            j-=1 # desce j, procurando o primeiro menor elemento em relacao ao pivo
        else:
            # troca
            t = v[i]
            v[i] = v[j]
            v[j] = t
            i+=1
            j-=1
    # se chegamos aqui entao i == j+1
    v[p] = v[j]
    v[j]=c
    return j


def intercala(p, q, n, v):
    w = []  # vetor auxiliar

    i = p  # preserva o início do vetor
    j = q  # preserva o meio dos vetor

    while i < q and j < n:
        if v[i] <= v[j]:
            w.append(v[i])
            i += 1
        else:
            w.append(v[j])
            j += 1

            # testa caso resta algum elemento no vetores
    while i < q:
        w.append(v[i])  # coloca v[i] no final de w
        i += 1
    while j < n:
        w.append(v[j])  # coloca v[j] no final de w
        j += 1

    # varia o i de p até n-1
    j = 0  # inicio do vetor w
    for i in range(p, n):
        v[i] = w[j]
        j += 1

def MergeSort(p, n, v):
    # testa condicao de parada da recursao
    if p < n - 1:
        q = (p + n) // 2
        # parte esquerda
        MergeSort(p, q, v)
        # parte direita
        MergeSort(q, n, v)
        # intercala os dois subvetores
        intercala(p, q, n, v)


def removeCaracteres(palavrasArquivo,caracteres):
    for i in range(len(palavrasArquivo)):
        for j in range(len(caracteres)):
            if(caracteres[j] in palavrasArquivo[i]):
                texto = palavrasArquivo[i].replace(caracteres[j],'')
                del palavrasArquivo[i]
                palavrasArquivo.insert(i,texto)
    return palavrasArquivo

def removeElementosVazios(vet):
    vet2 = []
    for i in range(len(vet)):
        if vet[i] != '':
            vet2.append(vet[i])
    return vet2

def gravaArquivo(arquivo,dicionario):
    arq = open(arquivo,'w')
    for i in range(len(dicionario)):
        arq.write(dicionario[i]+ "\n")
    arq.close()

def main():
    caracteres = (".", ":", "!", "#", "*", "$", "%", "-", "+", "@", "\"", ".\"","(",")","(*$")

    dicionario = lerArquivo("entrada.txt",caracteres)
    MergeSort(0,len(dicionario),dicionario)
    dicionario = removeElementosVazios(dicionario)
    print(dicionario)
    gravaArquivo("merge.txt",dicionario)

    dicionario2 = lerArquivo("entrada.txt",caracteres)
    QuickSort(0,len(dicionario2)-1,dicionario2)
    dicionario2 = removeElementosVazios(dicionario2)
    print(dicionario2)
    gravaArquivo("quick.txt",dicionario2)

main()