#Pilha implementada como tipo abstrato de dados (TAD)
class Pilha:
    # construtor
    def __init__(self, N):
        self.elementos = [None]*N
        self.topo = -1 #topo da pilha, -1 nenhum elemento

    # metodos da classe
    def push(self,E):
        # incrementa o topo
        self.topo = self.topo + 1
        # empilha
        self.elementos[self.topo] = E
    def pop(self):
        #desempilha
        TopoPilha = self.elementos[self.topo]
        # descrementa o topo
        self.topo = self.topo - 1

        return TopoPilha

    def isEmpty(self):
        # se topo for igual -1 pilha vazia
        return self.topo == -1





