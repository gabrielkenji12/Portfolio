import ArvoreBinariaBusca

arvore = ArvoreBinariaBusca.ArvoreBinariaBusca()

arvore.adiciona(10)
arvore.adiciona(5)
arvore.adiciona(15)
arvore.adiciona(17)
arvore.adiciona(9)
arvore.adiciona(3)
arvore.adiciona(11)
arvore.adiciona(12)
arvore.adiciona(13)
arvore.adiciona(14)
#print("altura da arvore=",arvore.Altura())

#print("mostra em In-Ordem-Recursivo")
#arvore.mostraArvore()
#print("mostra em In-Ordem-Iterativo")
#arvore.inOrdemI()

print("mostra em Pre-Ordem")
arvore.mostraArvorePre()
print("mostra em Pre-Ordem-Iterativo")
arvore.PreOrdemI()

#print("mostra arvore graficamente deitada")
#arvore.mostraArvoreDeitada()

#print("resposta da busca iterativa ",arvore.buscaIterativa(12))

#print("resposta da busca iterativa ",arvore.buscaRecursiva(12))
#print("removendo a raiz")
#arvore.remove(10)
#arvore.mostraArvore()
