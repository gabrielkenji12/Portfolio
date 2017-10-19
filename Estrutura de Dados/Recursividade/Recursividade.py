def inter_listas(L1,L2):
    lista1 = L1
    lista2= L2
    for i in range (len(lista1)):
        n1 = lista1[i]
        for j in range (len(lista2)):
            n2 = lista2[j]
        if n1 == n2 :
            return True
    return False

def lista_sub(L):
    lista = L
    lista2 = []
    for i in range (len(lista)):
        if type(lista[i]) == type([]):
            return lista[i]
    return lista2

def result(n):
    if n==1:
        return 2
    else:
        return 2*result(n-1)

def resultado(n):
    if n<=10:
        return n*2
    else:
        return resultado(resultado(n/3))

def potencia(n,pot):
    if pot == 0:
        return 1
    else:
        return n * potencia(n,pot-1)

def potenciaIterativo(n,pot):
    res = 1
    while pot > 0:
        res = (res*n)
        pot=pot-1
    return res

def buscaLinear(vet,n,i):
    if(vet[i] == n):
        return i
    else:
        return buscaLinear(vet,n,i+1)

def menorElemento(vet,i):
    if(i == len(vet)-1):
        return vet[i]
    else:
        x = menorElemento(vet,i+1)
        if x > vet[i]:
            return vet[i]
        else:
            return x

def somaElementos(vet,i):
    if(i == len(vet)):
        return 0
    else:
        soma = somaElementos(vet,i+1) + vet[i]
    return soma

def media(vet,i):
    if (i == len(vet)):
        return 0
    else:
        soma = somaElementos(vet, i + 1) + vet[i]
    return soma/(len(vet))

def fusc(n):
    if n <= 1:
        return 1
    if n%2 == 0:
        return fusc(n/2)
    else:
        return fusc((n-1)/2) + fusc((n+1)/2)

def mdcIteretivo(m,n):
    while n != 0:
        r = m % n
        m = n
        n = r
    return m

def mdc(m,n):
    if(n==0):
        return m
    r = m % n
    m = n
    n = r
    return mdc(m,n)

def produto(a,b):
    if b == 1:
        return a*b
    if b > 1:
        return produto(a,b-1) + a

def verificaMatriz(mat,n,i,j):
    if(mat[i][j] == n):
        return True
    if((j and i) == len(mat)):
        return False
    for i in range(len(mat)):
            return verificaMatriz(mat,n,i,j+1)

def main():
    vet = [52,[25,10],4]
    print(lista_sub(vet))
main()
