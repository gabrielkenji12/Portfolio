class Pilha:
    # construtor
    def __init__(self, N):
        self.elementos = ['']*N
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



def calculaExpressao(expressao):
    ultimo = -1
    pilha = ['']*len(expressao)

    for i in range(len(expressao)):
        if expressao[i] == '(' or expressao[i] == '[':
            ultimo = ultimo + 1
            pilha[ultimo]=expressao[i]
        else:
            ultimoElemento = pilha[ultimo]
            ultimo = ultimo - 1
            if expressao[i] == ')' and ultimoElemento != '(':
                return False
            if expressao[i] == ']' and ultimoElemento != '[':
                return False

    return ultimo == -1

def bemformada(s):
    p = Pilha(len(s))
    for i in range(len(s)):
        if(s[i] == '(' or s[i] == '['):
            p.push(s[i])
        else:
            ultimo = p.pop()
            if s[i] == ')' and ultimo != '(':
                return False
            if s[i] == ']' and ultimo != '[':
                return False
    return p.isEmpty()

def main():
    print("------ Verifica Expressao ------ ")
    print("")
    expressao = input("Digite a expressão de teste(Por exemplo: [([])]) : ")

    resultado = (bemformada(expressao))
    if resultado == True:
        print("Expressao Bem formada")
    else:
        print("Expressao Mal formada")


main()