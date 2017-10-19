class No:
    def __init__(self, elemento=None, prox=None):
        self.elemento = elemento
        self.prox = prox

    #equivalente ao toString do Java
    def __str__(self):
        return str(self.elemento)
