import No
import Pilha

class ArvoreBinariaBusca:
    def __init__(self):
        self.raiz = None

    def adiciona(self, elemento):
        pai = None

        aux = self.raiz

        while aux != None:
            pai = aux
            if elemento < aux.elemento: #vai para sub-arvore da esquerda
                aux = aux.esq
            else: # elemento > aux.elemento vai para direita
                aux = aux.dir
       
        novo = No.No(elemento)
        #quando a arvore estah vazia pai == None
        if pai == None: #insere na raiz
            self.raiz = novo
        else:
            #verifica se serah adiciona a esquerda do pai ou a direita do pai
            if elemento < pai.elemento: 
                pai.esq = novo
            else: # elemento > pai.elemento vai para direita
                pai.dir  = novo


    def isEmpty(self):
        return self.raiz == None

    #imprime a arvore
    def mostraArvore(self):
        self.inOrdem(self.raiz)

    def inOrdem(self, p):
        if p != None:
            self.inOrdem(p.esq)
            print( p )
            self.inOrdem(p.dir)

    # InOrdem Iterativo
    def inOrdemI(self):
        p = self.raiz
        pilha = Pilha.Pilha(100)#cria uma pilha com 100 elementos pois
                                #nao sei o tamanho da arvore
        
        while p != None or not pilha.isEmpty():
            if p!=None:
                # pre ordem print(p)
                pilha.push(p)
                p = p.esq
            else:
                p = pilha.pop()
                print(p)
                p = p.dir

                
    def mostraArvorePre(self):
        self.PreOrdem(self.raiz)

    def PreOrdem(self, p):
        if p != None:
            print( p )#Visitar o nó corrente;
            self.PreOrdem(p.esq)#Percorrer sua subárvore esquerda recursivamente em Pré-Ordem; 
            self.PreOrdem(p.dir)#Percorrer sua subárvore direita recursivamente em Pré-Ordem; 

    def PreOrdemI(self):
        p = self.raiz
        pilha = Pilha.Pilha(100)
        while p != None or not pilha.isEmpty():
            if p != None:
                print(p)
                pilha.push(p)
                p = p.esq
            else:
                p = pilha.pop()
                p = p.dir

    def mostraArvorePos(self):
        self.PosOrdem(self.raiz)

    def PosOrdem(self, p):
        if p != None:
            self.PosOrdem(p.esq)#Percorrer sua subárvore esquerda recursivamente em Pos-Ordem; 
            self.PosOrdem(p.dir)#Percorrer sua subárvore direita recursivamente em Pos-Ordem;
            print( p )#Visitar o nó corrente;

    def Altura(self):
        h = self.AlturaRec(self.raiz)
        return h

    def AlturaRec(self, p):
        if p != None:
            hE = self.AlturaRec(p.esq)#Percorrer sua subárvore esquerda recursivamente em Pos-Ordem; 
            hD = self.AlturaRec(p.dir)#Percorrer sua subárvore direita recursivamente em Pos-Ordem;
            #Visitar o nó corrente;
            if hE > hD:
                return hE+1
            else:
                return hD+1
            
        return 0

            
    def mostraArvoreDeitada(self):
        self.ArvoreDeitada(self.raiz, 0)

    def ArvoreDeitada(self, p, col):
        if p != None:
            self.ArvoreDeitada(p.dir, col+3)#vai toda a direita
            print(" "*col,p )
            self.ArvoreDeitada(p.esq, col+3)#vai toda a esquerda
       


    #3)Faça uma versão iterativa do método busca
    #  funcao retorna o No se encontrar o elemento
    #  e None caso contrario
    def buscaIterativa(self, elemento):
        aux = self.raiz
        while aux != None:
            if elemento < aux.elemento:  # vai para sub-arvore da esquerda
                aux = aux.esq
            elif elemento > aux.elemento: # vai para direita
                aux = aux.dir
            else: # elemento ==  aux.elemento
                return aux

        return None

    # 4)Faça uma versão recursiva do método busca
    #  funcao retorna o No se encontrar o elemento
    #  e None caso contrario
    def buscaRecursiva(self, elemento):

        return self.buscaR(elemento, self.raiz)

    def buscaR(self, elemento, aux ):

        if aux == None:
            return None

        if elemento < aux.elemento:  # vai para sub-arvore da esquerda
            return self.buscaR( elemento, aux.esq )
        elif elemento > aux.elemento:  # vai para direita
            return self.buscaR(elemento, aux.dir)
        else:  # elemento ==  aux.elemento
            return aux

    #6) Implemente um método para remover um elemento na Árvore Binária
    # de Busca, quais casos precisamos testar ? (vale duas paçoquinha)
    def remove(self, elemento):
        self.removeRecursivo(elemento, self.raiz)

    def removeRecursivo(self, elemento, aux):

        if aux == None:
            return None

        if elemento < aux.elemento:  # vai para sub-arvore da esquerda
            aux.esq = self.removeRecursivo( elemento, aux.esq )
        elif elemento > aux.elemento:  # vai para direita
            aux.dir = self.removeRecursivo(elemento, aux.dir)
        else:  # elemento ==  aux.elemento
            # se achei o elemento retorna  None
            # isso funciona se for uma folha
            if aux.esq != None: #possui subarvore esquerda
                #procuro o maior na subarvore esquerda
                maior = self.MaiorSubarvore(aux.esq)
                # maior se torna aux
                aux.elemento = maior.elemento
                # remove o maior da subarvore esquerda
                aux.esq = self.removeRecursivo(aux.elemento, aux.esq)
            elif aux.dir != None: #possui subarvore direita
                #procuro o menor na subarvore direita
                menor = self.MenorSubarvore(aux.dir)
                # menor se torna aux
                aux.elemento = menor.elemento
                # remove o menor da subarvore direita
                aux.dir = self.removeRecursivo(aux.elemento, aux.dir)
            else:
                return None

        return aux

    def MaiorSubarvore(self, aux):
        while aux.dir != None:
            aux = aux.dir
        return aux

    def MenorSubarvore(self, aux):
        while aux.esq != None:
            aux = aux.esq
        return aux


