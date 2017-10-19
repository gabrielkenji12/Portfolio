class No:
  def __init__(self, elemento=None, esq=None, dir=None):
    self.elemento = elemento
    self.esq = esq
    self.dir = dir
    self.cont = 1

  def __str__(self):
    return str(self.elemento)
