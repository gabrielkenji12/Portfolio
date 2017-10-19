import math

class Pilha(object):

    def __init__(self):
        self.elementos = []

    def __repr__(self):
        return 'elementos {0}'.format(self.elementos)

    def adiciona(self, elemento):
        self.elementos.append(elemento)

    def retira(self):
        return self.elementos.pop()

def posfixa(s):
    p = Pilha()
    i = 0
    p.adiciona('(')
    res = []
    operadores = ('+','-','*','/','^')
    while i < len(s):
        if s[i] == '(':
            p.adiciona(s[i])
            i += 1
        elif s[i] == ')':
            op = ""
            while op != '(':
                op = p.retira()
                if op != '(':
                    res.append(op)
            i += 1
        elif(s[i] in operadores):
            t = p.retira()
            prioridade1 = prioridade(t)
            prioridade2 = prioridade(s[i])
            if (prioridade1 >= prioridade2):
                res.append(t)
                p.adiciona(s[i])
            if prioridade1 < prioridade2:
                p.adiciona(t)
                p.adiciona(s[i])
            i += 1
        else:
            res.append(s[i])
            i += 1

    if (len(p.elementos) != 0):
        while (len(p.elementos) != 0):
            a = p.retira()
            if a != '(':
                res.append(a)

    res = ''.join(res)
    return res

def prioridade(caracter):
    if(caracter == '('):
        return 1
    elif caracter == '+' or caracter == '-':
        return 2
    elif caracter == '*' or caracter == '/':
        return 3
    elif caracter == '^':
        return 4


def calcula(s):
    p = Pilha()
    res = 0
    i = 0
    resultado = 0
    operadores = ('+', '-', '*', '/', '^')

    while i < len(s):
        if s[i] in operadores:
            num1 = p.retira()
            num2 = p.retira()
            if(s[i] == '+'):
                res = int(num2) + int(num1)
                p.adiciona(res)
                i += 1
            elif s[i] == '-':
                res = int(num2) - int(num1)
                p.adiciona(res)
                i += 1
            elif s[i] == '*':
                res = int(num2) * int(num1)
                p.adiciona(res)
                i += 1
            elif s[i] == '/':
                res = (int(num2) / int(num1))
                p.adiciona(res)
                i += 1
            elif s[i] == '^':
                res = math.pow(int(num2),int(num1))
                p.adiciona(res)
                i += 1
        else:
            p.adiciona(s[i])
            i += 1

    resultado = p.retira()
    return resultado


def main():
    a = "5+2*3"
    b = "5*2-4/2"
    c = "4*(9/3+2)-1"
    d = "4^2*3-3+8/4/(1+1)"
    e = "(a+b)/(c–d)"
    f = "((a+b)*c-(d-e))^(f-g)"


    print("\t -------- CALCULADORA -------- \n")
    print("\tA Caluladora utiliza de entrada uma expressão em notacão infixa (Ex: 5+2*3)\n\te a transforma em pós-fixa(Ex: 523*+) e por fim calcula seu resultado.\n")
    print("Exemplos:\n'Expressão Infixa' => 'Expressão Pós-fixa' => 'Resultado'\n")
    pf = posfixa(a)
    res = calcula(pf)
    print(a,"=>",pf,"=>",res)

    pf = posfixa(b)
    res = calcula(pf)
    print(b,"=>",pf,"=>",res)

    pf = posfixa(c)
    res = calcula(pf)
    print(c, "=>", pf, "=>", res)

    pf = posfixa(d)
    res = calcula(pf)
    print(d, "=>", pf, "=>", res)

    pf = posfixa(f)
    print(f, "=>", pf, "=>", pf)


    print("")
    print("Para transforma uma expressão em Pós-fixa e calcular seu resultado")
    expressao = input("Digite: ")
    expressaoPF = posfixa(expressao)
    resultado = calcula(expressaoPF)
    print("")
    print(expressao,"=>",expressaoPF,"=>",resultado)
main()