import No
class ListaLigada:
  def __init__(self):
    self.ini = None

  # adicionando elementos no inicio da lista ligada
  def adicionaInicio(self, elemento):
      self.ini = No.No(elemento, self.ini)

  def adicionaOrdenado(self, elemento):
      aux = self.ini
      ant = None
      while aux != None and aux.elemento<elemento:
        ant = aux
        aux = aux.prox
      novo = No.No(elemento, aux)
      if ant == None:
        self.ini = novo
      else:
        ant.prox=novo

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

  def adicionaFimRecursivo(self,elemento,prox):
      aux = self.ini
      if aux == None:
          novo = No.No(elemento)
          aux.prox = novo
          return
      else:
          return self.adicionaFimRecursivo(elemento,aux.prox)


  def removeInicio(self):
      self.ini = self.ini.prox

  #def removeOrdenado(self,elemento):

  def removeFim(self):
    aux = self.ini
    ant = None
    while aux != None:
      ant = aux
      aux = aux.prox
    ant.prox = aux


  def remove(self,num):
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

  # def BUSCA
  def busca(self, num):
      aux = self.ini
      cont = 0
      while aux != None:
          if aux.elemento == num:
              return cont
          aux = aux.prox
          cont += 1

  def buscaElemento(self, num):
      aux = self.ini
      cont = 0
      while aux != None:
          if cont == num:
              return aux.elemento
          aux = aux.prox
          cont += 1

  def isEmpty(self):
      return self.ini == None

  # imprime a lista ligada
  def __str__(self):
      strLista = ""
      temp = self.ini

      while temp != None:
          strLista += str(temp) + ","
          temp = temp.prox

      return strLista
