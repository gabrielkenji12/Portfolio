import Pilha
def WcWr( S ):
    pilha = Pilha.Pilha(len(S))

    #coloca tudo na pilha ate achar o caracter c
    i = 0
    while S[i] != 'c':
        pilha.push(S[i])
        i+=1
       
    i+=1 # descarta c

    while i < len(S):
        topoPilha = pilha.pop()#desempilha
        if topoPilha != S[i]:
            return False
        i+=1
        
    return pilha.isEmpty() ## ao final a pilha deve estar vazia e cadeia finalizada
                            ## para funcionar o problema



#------ TESTAR PALAVRA PERTENCE A LINGUAGEM WcWr

print(WcWr("abcbb"))




