lectura = False
ciclo = True
alfabeto = "ab"
while (lectura == False):    
    print "Ingrese una cadena que solo contenga a o b"
    cadena = raw_input("-> ")
    for letra in cadena:
        if letra not in alfabeto:    
	    ciclo = False	
	    break
    if ciclo:
        lectura = True
    else:
        print """"la cadena que ingreso 
        no corresponde al alfabeto
        ingrese otra"""
        ciclo = True
qA = []
qA.append("1 ")#QA0
qA.append("1 ")#QA1
qA.append("3*")#QA2
qA.append("3*")#QA3
qA.append("4 ")#QA4
qB = []
qB.append("3*")#QA0
qB.append("2*")#QA1
qB.append("4 ")#QA2
qB.append("4 ")#QA3
qB.append("4 ")#QA4
indice = 0
#Recorrido del automata
for i in range(len(cadena)-1):
    if cadena[i] == "a":
	indice = int(qA[indice][0])
    elif cadena[i] == "b":
    	indice = int(qB[indice][0])
#Revisar si el ultimo caracter es -> a <- y
#comprobar si termina en estado final
if cadena[len(cadena)-1]  == "a":
    if qA[indice][1] == "*":
	print "Cadena aceptada"
    else:
	print "Cadena no aceptada"
#Revisar el ultimo caracter es -> b <- 
#y comprobar si termina en estado final
if cadena[len(cadena)-1] == "b":
    if qB[indice][1] == "*":
        print "Cadena aceptada"
    else:
        print "Cadena no aceptada"
