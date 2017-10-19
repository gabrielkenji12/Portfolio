class No:
    def __init__(self, elemento=None, prox=None):
        self.elemento = elemento
        self.prox = prox

    def __str__(self):
        return str(self.elemento)


class ListaLigada:
    def __init__(self):
        self.ini = None

    def adicionaInicio(self, elemento):
        self.ini = No(elemento, self.ini)

    def adicionaOrdenado(self, elemento):
        aux = self.ini
        ant = None
        while aux != None and aux. elemento <elemento:
            ant = aux
            aux = aux.prox
        novo = No.No(elemento, aux)
        if ant == None:
            self.ini = novo
        else:
            ant. prox =novo

    def adicionaFim(self, elemento):
        aux = self.ini
        ant = None
        while aux != None:
            ant = aux
            aux = aux.prox
        novo = No.No(elemento)
        if ant == None:
            self.ini = novo
        else:
            ant.prox = novo


    def removeInicio(self):
        self.ini = self.ini.prox

    def removeFim(self):
        aux = self.ini
        ant = None
        while aux != None:
            ant = aux
            aux = aux.prox
        ant.prox = aux

    def remove(self, num):
        aux = self.ini
        ant = None
        while aux != None:
            if self.ini.elemento == num:
                self.ini = aux.prox
                return
            elif aux.elemento == num:
                ant.prox = aux.prox
                return
            else:
                ant = aux
                aux = aux.prox

    def busca(self, num):
        aux = self.ini
        cont = 1
        while aux != None:
            if aux.elemento == num:
                return cont
            aux = aux.prox
            cont += 1

    def buscaElemento(self, num):
        aux = self.ini
        cont = 1
        while aux != None:
            if cont == num:
                return aux.elemento
            aux = aux.prox
            cont += 1

    def isEmpty(self):
        return self.ini == None

    def __str__(self):
        strLista = ""
        temp = self.ini

        while temp != None:
            strLista += str(temp) + ","
            temp = temp.prox

        return strLista



def descompacta():
    arquivoDescompactado = open('descompactado.txt','w')
    arquivoCompactado = open('compactado.txt','r')
    lista = ListaLigada()
    ler = ""
    indice = ""
    aux = ""
    palavra = ""
    while ler!="0":
        ler = (arquivoCompactado.readline()).rstrip()
        paragrafo = ler + "\n"
        for letra in paragrafo:
            if(letra.isalpha()):
                palavra = palavra + letra
            else:
                if(letra.isdigit()):
                    indice = indice + letra
                    if(indice == "0"):
                        arquivoDescompactado.write(letra)
                elif(aux.isdigit()):
                    palavraDescompactada = lista.buscaElemento(int(indice))
                    if(palavraDescompactada != None):
                        lista.remove(palavraDescompactada)
                        lista.adicionaInicio(palavraDescompactada)
                        arquivoDescompactado.write(palavraDescompactada)
                        arquivoDescompactado.write(letra)
                    indice = ""
                    palavra = ""
                elif len(palavra)== 0:
                    arquivoDescompactado.write(letra)
                else:
                    lista.adicionaInicio(palavra)
                    arquivoDescompactado.write(palavra)
                    arquivoDescompactado.write(letra)
                    palavra = ""
            aux = letra

def compacta():
    arquivo = open('arquivo.txt','r')
    arquivoCompactado = open('compactado.txt','w')
    paragrafo = ""
    ler = ""
    palavra = ""
    lista = ListaLigada()
    while ler!="0":
        ler = (arquivo.readline()).rstrip()
        paragrafo = ler + "\n"
        for letra in paragrafo:
            if(letra.isalpha()):
                palavra = palavra + letra

            else:
                if len(palavra)== 0:
                    arquivoCompactado.write(letra)

                elif(lista.busca(palavra) == None):
                    lista.adicionaInicio(palavra)
                    arquivoCompactado.write(palavra)
                    arquivoCompactado.write(letra)
                    palavra = ""
                else:
                    res = lista.busca(palavra)
                    lista.remove(palavra)
                    lista.adicionaInicio(palavra)
                    arquivoCompactado.write(str(res))
                    arquivoCompactado.write(letra)
                    palavra = ""


def main():
    print(" -------- COMPACTADOR/DESCOMPACTADOR DE ARQUIVOS -------- ")
    print("")
    print("Arquivo a ser compactado e descompactado : 'arquivo.txt'")
    compacta()
    print("Arquivo Compactado com sucesso : 'compactado.txt'")
    descompacta()
    print("Arquivos Descompactado com sucesso : 'descompactado.txt'")
main()